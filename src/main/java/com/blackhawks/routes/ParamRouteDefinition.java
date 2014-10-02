package com.blackhawks.routes;

import com.blackhawks.Request;
import com.blackhawks.Response;
import com.blackhawks.RouteDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParamRouteDefinition implements RouteDefinition {

    @Override
    public byte[] execute(Request request, Response response) {
        StringBuilder body = new StringBuilder();
        Map<String, String> params = request.getParams();
        List<String> paramsToReport = new ArrayList<String>(params.keySet());

        for(String paramName : paramsToReport){
            body.append(paramName);
            body.append(" = ");
            body.append(params.get(paramName));
            body.append("\n");
        }

        return body.toString().getBytes();
    }
}
