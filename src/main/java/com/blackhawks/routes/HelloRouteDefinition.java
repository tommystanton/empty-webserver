package com.blackhawks.routes;

import com.blackhawks.Request;
import com.blackhawks.Response;
import com.blackhawks.RouteDefinition;

import java.util.Map;

public class HelloRouteDefinition implements RouteDefinition {

    @Override
    public byte[] execute(Request request, Response response) {
        Map<String, String> params = request.getParams();

        String body = "Hello " + params.get("name") + "!";

        return body.getBytes();
    }

}
