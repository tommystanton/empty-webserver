package com.blackhawks;

import java.util.HashMap;

public class Router {

    private HashMap<String, Boolean> routes;

    public Router() {
        this.routes = new HashMap<>();
        setRoutes();
    }

    private void setRoutes() {
        routes.put("/", true);
        routes.put("/form", true);
    }

    public boolean isResourceExistent(String resource) {

        if(routes.containsKey(resource)) {
            return routes.get(resource);
        }

        return false;
    }
}
