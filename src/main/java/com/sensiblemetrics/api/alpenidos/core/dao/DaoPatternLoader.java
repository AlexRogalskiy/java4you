package com.sensiblemetrics.api.alpenidos.core.dao;

import com.sensiblemetrics.api.alpenidos.core.dao.config.JpaEntityManagerFactory;
import com.sensiblemetrics.api.alpenidos.core.dao.iface.Dao;
import com.sensiblemetrics.api.alpenidos.core.dao.model.User;
import com.sensiblemetrics.api.alpenidos.core.dao.repository.JpaUserDao;

import java.util.List;
import java.util.Optional;

public class DaoPatternLoader {

    private static JpaUserDao jpaUserDao;

    public static void main(final String[] args) {
        final User user1 = getUser(1);
        System.out.println(user1);
        updateUser(user1, new String[]{"John", "john@domain.com"});
        saveUser(new User("Monica", "monica@domain.com"));
        deleteUser(getUser(2));
        getAllUsers().forEach(user -> System.out.println(user.getName()));
    }

    private static class JpaUserDaoHolder {
        private static final JpaUserDao jpaUserDao = new JpaUserDao(new JpaEntityManagerFactory().getEntityManager());
    }

    public static Dao getJpaUserDao() {
        return JpaUserDaoHolder.jpaUserDao;
    }

    public static User getUser(long id) {
        Optional<User> user = getJpaUserDao().get(id);
        return user.orElseGet(() -> {
            return new User("non-existing user", "no-email");
        });
    }

    public static List<User> getAllUsers() {
        return getJpaUserDao().getAll();
    }

    public static void updateUser(final User user, final String[] params) {
        getJpaUserDao().update(user, params);
    }

    public static void saveUser(final User user) {
        getJpaUserDao().save(user);
    }

    public static void deleteUser(final User user) {
        getJpaUserDao().delete(user);
    }
}
