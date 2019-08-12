package com.sensiblemetrics.api.alpenidos.core.test.oauth2.service


import com.sensiblemetrics.api.alpenidos.core.oauth2.model.Role
import com.sensiblemetrics.api.alpenidos.core.oauth2.model.User
import com.sensiblemetrics.api.alpenidos.core.oauth2.repository.UserRepository
import com.sensiblemetrics.api.alpenidos.core.oauth2.service.RoleService
import com.sensiblemetrics.api.alpenidos.core.oauth2.service.UserService
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification

class UserServiceSpec extends Specification {
    private UserService userService
    private UserRepository userRepository
    private RoleService roleService
    private PasswordEncoder passwordEncoder

    def setup() {
        this.roleService = Mock(RoleService)
        this.userRepository = Mock(UserRepository)
        this.passwordEncoder = Mock(PasswordEncoder)
        this.userService = new UserService(userRepository, passwordEncoder, roleService)
    }

    def "when user exists, then returns null"() {
        given:
        final String email = "wat@wot.com"
        final User user = Mock(User)
        when:
        User createdUser = userService.createUser(email, "password")
        then:
        createdUser == null
        1 * this.userRepository.findByEmail(email) >> user
        0 * this.userRepository.save(_)
    }

    def "when user doesn't exist, then creates user and returns user"() {
        given:
        final String email = "wat@wot.com"
        final String password = "password"
        final String hashedPassword = "hashedPassword"
        final Role role = new Role(UserService.ROLE_USER)
        when:
        final User createdUser = this.userService.createUser(email, password)
        then:
        createdUser.email == email
        createdUser.password == hashedPassword
        1 * this.userRepository.findByEmail(email) >> null
        1 * this.passwordEncoder.encode(password) >> hashedPassword
        1 * this.roleService.findByRole(UserService.ROLE_USER) >> role
        0 * this.roleService.saveRole(UserService.ROLE_USER)
        1 * this.userRepository.save(_)
    }

    def "when user doesn't exist and role doesn't exist, then creates user, role and returns user"() {
        given:
        final String email = "wat@wot.com"
        final String password = "password"
        final String hashedPassword = "hashedPassword"
        final Role role = null
        when:
        User createdUser = userService.createUser(email, password)
        then:
        createdUser.email == email
        createdUser.password == hashedPassword
        1 * this.userRepository.findByEmail(email) >> null
        1 * this.passwordEncoder.encode(password) >> hashedPassword
        1 * this.roleService.findByRole(UserService.ROLE_USER) >> role
        1 * this.roleService.saveRole(UserService.ROLE_USER) >> new Role(UserService.ROLE_USER)
        1 * this.userRepository.save(_)
    }
}
