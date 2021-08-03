package com.sensiblemetrics.api.alpenidos.pattern.feature_toggle.impl;

import com.sensiblemetrics.api.alpenidos.pattern.feature_toggle.model.User;
import com.sensiblemetrics.api.alpenidos.pattern.feature_toggle.model.UserGroup;

/**
 * This example of the Feature Toogle pattern shows how it could be implemented based on a {@link User}. Therefore
 * showing its use within a tiered application where the paying users get access to different content or
 * better versions of features. So in this instance a {@link User} is passed in and if they are found to be
 * on the {@link UserGroup#isPaid(User)} they are welcomed with a personalised message. While the other is more
 * generic. However this pattern is limited to simple examples such as the one below.
 *
 * @see Service
 * @see User
 * @see PropertiesFeatureToggleVersion
 * @see UserGroup
 */
public class TieredFeatureToggleVersion extends Service {

    /**
     * Generates a welcome message from the passed {@link User}. The resulting message depends on the group of the
     * {@link User}. So if the {@link User} is in the {@link UserGroup} then the enhanced version of the
     * welcome message will be returned where the username is displayed.
     *
     * @param user the {@link User} to generate the welcome message for, different messages are displayed if the user is
     *             in the {@link UserGroup#isPaid(User)} or {@link UserGroup}
     * @return Resulting welcome message.
     * @see User
     * @see UserGroup
     */
    @Override
    public String getWelcomeMessage(final User user) {
        if (UserGroup.isPaid(user)) {
            return "You're amazing " + user + ". Thanks for paying for this awesome software.";
        }
        return "I suppose you can use this software.";
    }

    /**
     * Method that checks if the welcome message to be returned is the enhanced version. For this instance as the logic
     * is driven by the user group. This method is a little redundant. However can be used to show that there is an
     * enhanced version available.
     *
     * @return Boolean value {@code true} if enhanced.
     */
    @Override
    public boolean isEnhanced() {
        return true;
    }
}
