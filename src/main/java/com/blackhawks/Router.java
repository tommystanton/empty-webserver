package com.blackhawks;

public class Router {

    public boolean isResourceExistent(String resource){
        if(resource.equals("/") || resource.equals("/form")) {
            return true;
        }

        return false;
    }
}
