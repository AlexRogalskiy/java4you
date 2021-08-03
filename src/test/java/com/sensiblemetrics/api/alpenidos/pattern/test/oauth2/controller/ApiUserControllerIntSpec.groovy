package com.sensiblemetrics.api.alpenidos.pattern.test.oauth2.controller


import com.sensiblemetrics.api.alpenidos.core.oauth2.controller.ApiUserController
import com.sensiblemetrics.api.alpenidos.core.oauth2.model.User
import com.sensiblemetrics.api.alpenidos.core.oauth2.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.JacksonJsonParser
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@SpringBootTest
@ActiveProfiles(["test"])
class ApiUserControllerIntSpec extends Specification {

    @Autowired
    private WebApplicationContext context

    @Autowired
    private ApiUserController controller

    private UserService userService
    private MockMvc mockMvc

    def setup() {
        this.userService = Mock(UserService)
        this.controller.userService = userService
        this.mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(springSecurity())
            .build()
    }

    def "when requesting resource without a token, then returns 403 UNAUTHORIZED"() {
        when:
        def response = mockMvc.perform(get("/api/v1/user").contentType(MediaType.APPLICATION_JSON)).andReturn().response
        then:
        response.status == HttpStatus.UNAUTHORIZED.value()
        response.contentAsString == "{\"error\":\"unauthorized\",\"error_description\":\"Full authentication is required to access this resource\"}"
    }

    def "when requesting with a invalid token, then returns 403 UNAUTHORIZED"() {
        when:
        def response = mockMvc.perform(get("/api/v1/user")
            .header(HttpHeaders.AUTHORIZATION, "Bearer whatever")
            .contentType(MediaType.APPLICATION_JSON)).andReturn().response
        then:
        response.status == HttpStatus.UNAUTHORIZED.value()
        response.contentAsString == "{\"error\":\"invalid_token\",\"error_description\":\"Invalid access token: whatever\"}"
    }

    def "when requesting with a correct access_token, then returns 200 OK with responseBody"() {
        given:
        final User user = new User(id: 2l, email: "wat@wot.com", password: "passwordHash")
        final String accessToken = getAccessToken("dummyUser", "dummyPassword")
        when:
        def response = mockMvc.perform(get("/api/v1/user")
            .header("Authorization", "Bearer " + accessToken))
            .andReturn()
            .response
        then:
        1 * this.userService.getCurrentUser() >> user
        response.status == HttpStatus.OK.value()
        response.contentAsString == "{\"id\":2,\"email\":\"wat@wot.com\",\"passwordHash\":\"passwordHash\"}"
    }

    private String getAccessToken(String username, String password) {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>()
        params.add("grant_type", "password")
        params.add("username", username)
        params.add("password", password)
        params.add("scope", "ledger")
        final String base64ClientCredentials = Base64.getEncoder().encodeToString("user:password".getBytes())

        def response = mockMvc.perform(post("/oauth/token")
            .params(params)
            .header(HttpHeaders.AUTHORIZATION, "Basic " + base64ClientCredentials)
            .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .response

        final String resultString = response.contentAsString
        final JacksonJsonParser jsonParser = new JacksonJsonParser()
        return jsonParser.parseMap(resultString).get("access_token").toString()
    }

}
