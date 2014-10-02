package com.blackhawks.routes;

import com.blackhawks.Request;
import com.blackhawks.RouteDefinition;

import java.util.Map;

public class ParamRouteDefinition implements RouteDefinition {

    @Override
    public byte[] execute(Request request) {
        StringBuilder body = new StringBuilder();
        String[] paramsToReport = new String[] {"variable_1", "variable_2"};

        Map<String, String> params = request.getParams();

        for(String paramName : paramsToReport){
            body.append(paramName);
            body.append(" = ");
            body.append(params.get(paramName));
            body.append("\n");
        }

        return body.toString().getBytes();
    }
}
