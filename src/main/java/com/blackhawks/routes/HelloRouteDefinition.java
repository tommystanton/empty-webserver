package com.blackhawks.routes;

import com.blackhawks.RouteDefinition;

public class HelloRouteDefinition implements RouteDefinition {

    @Override
    public byte[] execute() {
        return "hello".getBytes();
    }

}
