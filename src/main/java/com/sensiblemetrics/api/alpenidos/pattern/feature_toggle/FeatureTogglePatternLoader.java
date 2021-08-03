package com.sensiblemetrics.api.alpenidos.pattern.feature_toggle;

import com.sensiblemetrics.api.alpenidos.pattern.feature_toggle.impl.PropertiesFeatureToggleVersion;
import com.sensiblemetrics.api.alpenidos.pattern.feature_toggle.impl.Service;
import com.sensiblemetrics.api.alpenidos.pattern.feature_toggle.impl.TieredFeatureToggleVersion;
import com.sensiblemetrics.api.alpenidos.pattern.feature_toggle.model.User;
import com.sensiblemetrics.api.alpenidos.pattern.feature_toggle.model.UserGroup;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * The Feature Toggle pattern allows for complete code executions to be turned on or off with ease. This allows features
 * to be controlled by either dynamic methods just as {@link User} information or by {@link Properties}. In the FeatureTogglePatternLoader
 * below there are two examples. Firstly the {@link Properties} version of the feature toggle, where the enhanced
 * version of the welcome message which is personalised is turned either on or off at instance creation. This method
 * is not as dynamic as the {@link User} driven version where the feature of the personalised welcome message is
 * dependant on the {@link UserGroup} the {@link User} is in. So if the user is a memeber of the
 * {@link UserGroup#isPaid(User)} then they get an ehanced version of the welcome message.
 * <p>
 * Note that this pattern can easily introduce code complexity, and if not kept in check can result in redundant
 * unmaintained code within the codebase.
 */
@Slf4j
public class FeatureTogglePatternLoader {

    /**
     * Block 1 shows the {@link PropertiesFeatureToggleVersion} being run with {@link Properties} setting the feature
     * toggle to enabled.
     * <p>
     * Block 2 shows the {@link PropertiesFeatureToggleVersion} being run with {@link Properties} setting the feature
     * toggle to disabled. Notice the difference with the printed welcome message the username is not included.
     * <p>
     * Block 3 shows the {@link TieredFeatureToggleVersion} being
     * set up with two users on who is on the free level, while the other is on the paid level. When the
     * {@link Service#getWelcomeMessage(User)} is called with the paid {@link User} note that the welcome message
     * contains their username, while the same service call with the free tier user is more generic. No username is
     * printed.
     *
     * @see User
     * @see UserGroup
     * @see Service
     * @see PropertiesFeatureToggleVersion
     * @see TieredFeatureToggleVersion
     */
    public static void main(final String[] args) {
        final Properties properties = new Properties();
        properties.put("enhancedWelcome", true);

        final Service service = new PropertiesFeatureToggleVersion(properties);
        final String welcomeMessage = service.getWelcomeMessage(new User("Jamie No Code"));
        log.info(welcomeMessage);

        // ---------------------------------------------
        final Properties turnedOff = new Properties();
        turnedOff.put("enhancedWelcome", false);
        final Service turnedOffService = new PropertiesFeatureToggleVersion(turnedOff);
        final String welcomeMessageturnedOff = turnedOffService.getWelcomeMessage(new User("Jamie No Code"));
        log.info(welcomeMessageturnedOff);
        // --------------------------------------------

        final Service service2 = new TieredFeatureToggleVersion();
        final User paidUser = new User("Jamie Coder");
        final User freeUser = new User("Alan Defect");

        UserGroup.addUserToPaidGroup(paidUser);
        UserGroup.addUserToFreeGroup(freeUser);

        final String welcomeMessagePaidUser = service2.getWelcomeMessage(paidUser);
        final String welcomeMessageFreeUser = service2.getWelcomeMessage(freeUser);
        log.info(welcomeMessageFreeUser);
        log.info(welcomeMessagePaidUser);
    }
}
