package com.blackhawks;

public interface RouteDefinition {
    byte[] execute(Request request, Response response);
}
