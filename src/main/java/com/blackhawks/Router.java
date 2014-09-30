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

    public boolean isResourceExistent(String path) {

        if(routes.containsKey(path)) {
            return routes.get(path);
        }

        return false;
    }
}
