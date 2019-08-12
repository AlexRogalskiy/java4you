package com.sensiblemetrics.api.alpenidos.core.test.spring_boot2

import com.sensiblemetrics.api.alpenidos.core.spring_boot2.config.ConfigParams
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.dao.FollowedRepository
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.service.FollowService
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.service.FollowingAmountService
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.service.MailingService
import spock.lang.Specification

class FollowServiceSpec extends Specification {
    private FollowService service
    private FollowedRepository followedRepository
    private FollowingAmountService followingAmountService
    private MailingService mailingService
    private ConfigParams configParams

    def setup() {
        followedRepository = Mock(FollowedRepository)
        followingAmountService = Mock(FollowingAmountService)
        mailingService = Mock(MailingService)
        configParams = Mock(ConfigParams)
        service = new FollowService(followedRepository, followingAmountService, mailingService, configParams)
    }

    def "when, then"() {
        when:
        int result = service.add(1, 2)
        then:
        result == 3
    }
}
