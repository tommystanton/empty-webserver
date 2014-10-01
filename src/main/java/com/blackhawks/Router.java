package com.blackhawks;

import com.blackhawks.routes.*;

import java.util.HashMap;

public class Router implements RoutingTable {

    private HashMap<String, RouteDefinition> routes;

    public Router() {
        this.routes = new HashMap<>();
        setRoutes();
    }

    private void setRoutes() {
        routes.put("/", new EmptyRouteDefinition());
        routes.put("/form", new EmptyRouteDefinition());
        routes.put("/hello", new HelloRouteDefinition());
        routes.put("/file1", new File1RouteDefinition());
    }

    public byte[] executeRoute(String path) { // add exception or try/catch and throw custom message
        RouteDefinition routeDefintion = routes.get(path);
        byte[] data = routeDefintion.execute();
        return data;
    }

    @Override
    public boolean isResourceExistent(String path) {

        if(routes.containsKey(path)) {
            return true;
        }

        return false;
    }
}
