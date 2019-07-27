package com.sensiblemetrics.api.alpenidos.core.chain.processor;

import com.sensiblemetrics.api.alpenidos.core.chain.iface.AuthenticationProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AuthenticationProcessor {

    public final AuthenticationProcessor nextProcessor;

    public abstract boolean isAuthorized(final AuthenticationProvider authProvider);
}
