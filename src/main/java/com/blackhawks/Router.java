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
        routes.put("/form", new FormRouteDefinition());
        routes.put("/hello", new HelloRouteDefinition());
        routes.put("/file1", new FileHandlerRouteDefinition("/file1"));
        routes.put("/file2", new FileHandlerRouteDefinition("/file2"));
        routes.put("/image.gif", new FileHandlerRouteDefinition("/image.gif"));
        routes.put("/image.jpeg", new FileHandlerRouteDefinition("/image.jpeg"));
        routes.put("/image.png", new FileHandlerRouteDefinition("/image.png"));
        routes.put("/partial_content.txt", new FileHandlerRouteDefinition("/partial_content.txt"));
        routes.put("/partial-content.txt", new FileHandlerRouteDefinition("/patch-content.txt"));
        routes.put("/text-file.txt", new FileHandlerRouteDefinition("/text-file.txt"));
    }

    public byte[] executeRoute(Request request) {
        RouteDefinition routeDefintion = routes.get(request.getPath());

        byte[] data = routeDefintion.execute(request);

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
