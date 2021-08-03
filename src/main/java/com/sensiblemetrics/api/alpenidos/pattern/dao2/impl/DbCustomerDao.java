package com.sensiblemetrics.api.alpenidos.pattern.dao2.impl;

import com.sensiblemetrics.api.alpenidos.pattern.dao2.exception.CustomException;
import com.sensiblemetrics.api.alpenidos.pattern.dao2.iface.CustomerDao;
import com.sensiblemetrics.api.alpenidos.pattern.dao2.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * An implementation of {@link CustomerDao} that persists customers in RDBMS.
 */
@Slf4j
@RequiredArgsConstructor
public class DbCustomerDao implements CustomerDao {
    private final DataSource dataSource;

    /**
     * @return a lazily populated stream of customers. Note the stream returned must be closed to
     * free all the acquired resources. The stream keeps an open connection to the database till
     * it is complete or is closed manually.
     */
    @Override
    public Stream<Customer> getAll() throws Exception {
        Connection connection;
        try {
            connection = getConnection();
            final PreparedStatement statement = connection.prepareStatement("SELECT * FROM CUSTOMERS"); // NOSONAR
            final ResultSet resultSet = statement.executeQuery(); // NOSONAR
            return StreamSupport.stream(new Spliterators.AbstractSpliterator<Customer>(Long.MAX_VALUE, Spliterator.ORDERED) {
                @Override
                public boolean tryAdvance(final Consumer<? super Customer> action) {
                    try {
                        if (!resultSet.next()) {
                            return false;
                        }
                        action.accept(createCustomer(resultSet));
                        return true;
                    } catch (SQLException e) {
                        throw new RuntimeException(e); // NOSONAR
                    }
                }
            }, false).onClose(() -> this.mutedClose(connection, statement, resultSet));
        } catch (SQLException e) {
            throw new CustomException(e.getMessage(), e);
        }
    }

    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    private void mutedClose(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            log.info("Exception thrown " + e.getMessage());
        }
    }

    private Customer createCustomer(final ResultSet resultSet) throws SQLException {
        return new Customer(
            resultSet.getInt("ID"),
            resultSet.getString("FNAME"),
            resultSet.getString("LNAME")
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Customer> getById(final int id) throws Exception {
        ResultSet resultSet = null;
        try (final Connection connection = this.getConnection();
             final PreparedStatement statement = connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE ID = ?")) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(createCustomer(resultSet));
            }
            return Optional.empty();
        } catch (SQLException ex) {
            throw new CustomException(ex.getMessage(), ex);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(final Customer customer) throws Exception {
        if (this.getById(customer.getId()).isPresent()) {
            return false;
        }
        try (final Connection connection = this.getConnection();
             final PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMERS VALUES (?,?,?)")) {
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.execute();
            return true;
        } catch (SQLException ex) {
            throw new CustomException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean update(final Customer customer) throws Exception {
        try (final Connection connection = this.getConnection();
             final PreparedStatement statement = connection.prepareStatement("UPDATE CUSTOMERS SET FNAME = ?, LNAME = ? WHERE ID = ?")) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setInt(3, customer.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new CustomException(ex.getMessage(), ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(final Customer customer) throws Exception {
        try (final Connection connection = this.getConnection();
             final PreparedStatement statement = connection.prepareStatement("DELETE FROM CUSTOMERS WHERE ID = ?")) {
            statement.setInt(1, customer.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new CustomException(ex.getMessage(), ex);
        }
    }
}
