package com.blackhawks.routes;

import com.blackhawks.RouteDefinition;

public class EmptyRouteDefinition implements RouteDefinition {

    @Override
    public byte[] execute() {
        return "".getBytes();
    }
}
