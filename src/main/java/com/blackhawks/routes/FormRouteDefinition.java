package com.blackhawks.routes;

import com.blackhawks.Request;
import com.blackhawks.Response;
import com.blackhawks.RouteDefinition;

public class FormRouteDefinition implements RouteDefinition {

    @Override
    public byte[] execute(Request request, Response response) {

        return "".getBytes();
    }

}
