package com.sensiblemetrics.api.alpenidos.pattern.monostate;

import com.sensiblemetrics.api.alpenidos.pattern.monostate.impl.LoadBalancer;
import com.sensiblemetrics.api.alpenidos.pattern.monostate.model.Request;

/**
 * The MonoState pattern ensures that all instances of the class will have the same state. This can
 * be used a direct replacement of the Singleton pattern.
 *
 * <p>
 * In the following example, The {@link LoadBalancer} class represents the app's logic. It contains
 * a series of Servers, which can handle requests of type {@link Request}. Two instances of
 * LoadBalacer are created. When a request is made to a server via the first LoadBalancer the state
 * change in the first load balancer affects the second. So if the first LoadBalancer selects the
 * Server 1, the second LoadBalancer on a new request will select the Second server. If a third
 * LoadBalancer is created and a new request is made to it, then it will select the third server as
 * the second load balancer has already selected the second server.
 * <p>
 * .
 */
public class MonostatePatternLoader {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        final LoadBalancer loadBalancer1 = new LoadBalancer();
        final LoadBalancer loadBalancer2 = new LoadBalancer();

        loadBalancer1.serverRequest(new Request("Hello"));
        loadBalancer2.serverRequest(new Request("Hello World"));
    }
}
