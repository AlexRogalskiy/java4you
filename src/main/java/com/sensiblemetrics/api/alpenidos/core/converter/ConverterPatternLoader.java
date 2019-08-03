package com.sensiblemetrics.api.alpenidos.core.converter;

import com.google.common.collect.Lists;
import com.sensiblemetrics.api.alpenidos.core.converter.impl.Converter;
import com.sensiblemetrics.api.alpenidos.core.converter.impl.UserConverter;
import com.sensiblemetrics.api.alpenidos.core.converter.model.User;
import com.sensiblemetrics.api.alpenidos.core.converter.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * The Converter pattern is a behavioral design pattern which allows a common way of bidirectional
 * conversion between corresponding types (e.g. DTO and domain representations of the logically
 * isomorphic types). Moreover, the pattern introduces a common way of converting a collection of
 * objects between types.
 */
@Slf4j
public class ConverterPatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        final Converter<UserDto, User> userConverter = new UserConverter();
        final UserDto dtoUser = new UserDto("John", "Doe", true, "whatever[at]wherever.com");
        final User user = userConverter.convertFromDto(dtoUser);
        log.debug("Entity converted from DTO: {}", user);

        log.info("Domain entities:");
        final List<User> users = Lists.newArrayList(
            new User("Camile", "Tough", false, "124sad"),
            new User("Marti", "Luther", true, "42309fd"),
            new User("Kate", "Smith", true, "if0243"));
        log.info("Users: {}", StringUtils.join(users, "|"));

        log.info("DTO entities converted from domain:");
        final List<UserDto> dtoEntities = userConverter.createFromEntities(users);
        log.info("User DTOs: {}", StringUtils.join(dtoEntities, "|"));
    }
}
