package com.sensiblemetrics.api.alpenidos.pattern.chain.processor;

import com.sensiblemetrics.api.alpenidos.pattern.chain.provider.UsernamePasswordProvider;
import com.sensiblemetrics.api.alpenidos.pattern.chain.iface.AuthenticationProvider;

import java.util.Objects;

public class UsernamePasswordAuthenticationProcessor extends AuthenticationProcessor {

    public UsernamePasswordAuthenticationProcessor(final AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(final AuthenticationProvider authProvider) {
        if (authProvider instanceof UsernamePasswordProvider) {
            return Boolean.TRUE;
        } else if (Objects.nonNull(this.nextProcessor)) {
            return this.nextProcessor.isAuthorized(authProvider);
        }
        return Boolean.FALSE;
    }
}
