package com.sensiblemetrics.api.alpenidos.core.data_transfer_object;

import com.sensiblemetrics.api.alpenidos.core.data_transfer_object.impl.CustomerResource;
import com.sensiblemetrics.api.alpenidos.core.data_transfer_object.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * The Data Transfer Object pattern is a design pattern in which an data transfer object is used to serve related
 * information together to avoid multiple call for each piece of information.
 * <p>
 * In this example, ({@link DataTransferPatternLoader}) as as customer details consumer i.e. client to request for
 * customer details to server.
 * <p>
 * CustomerResource ({@link CustomerResource}) act as server to serve customer information.
 * And The CustomerDto ({@link CustomerDto} is data transfer object to share customer information.
 */
@Slf4j
public class DataTransferPatternLoader {

    /**
     * Method as act client and request to server for details.
     *
     * @param args program argument.
     */
    public static void main(String[] args) {
        final List<CustomerDto> customers = new ArrayList<>();
        final CustomerDto customerOne = new CustomerDto("1", "Kelly", "Brown");
        final CustomerDto customerTwo = new CustomerDto("2", "Alfonso", "Bass");
        customers.add(customerOne);
        customers.add(customerTwo);

        final CustomerResource customerResource = new CustomerResource(customers);

        log.info("All customers:-");
        List<CustomerDto> allCustomers = customerResource.getAllCustomers();
        printCustomerDetails(allCustomers);

        log.info("----------------------------------------------------------");
        log.info("Deleting customer with id {1}");
        customerResource.delete(customerOne.getId());
        allCustomers = customerResource.getAllCustomers();
        printCustomerDetails(allCustomers);

        log.info("----------------------------------------------------------");
        log.info("Adding customer three}");
        final CustomerDto customerThree = new CustomerDto("3", "Lynda", "Blair");
        customerResource.save(customerThree);
        allCustomers = customerResource.getAllCustomers();
        printCustomerDetails(allCustomers);
    }

    private static void printCustomerDetails(final List<CustomerDto> allCustomers) {
        allCustomers.forEach(customer -> log.info(customer.getFirstName()));
    }
}
