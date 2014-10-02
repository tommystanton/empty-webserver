package com.blackhawks.routes;

import com.blackhawks.Request;
import com.blackhawks.Response;
import com.blackhawks.RouteDefinition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandlerRouteDefinition implements RouteDefinition {
    private String filePath;

    public FileHandlerRouteDefinition(String filePathName){
        filePath = filePathName;
    }

    @Override
    public byte[] execute(Request request, Response response) {
        // XXX If image, set media type to image/png, etc

        byte[] data = new byte[100];

        Path path = Paths.get("./public/" + filePath);
        try {
            data = Files.readAllBytes(path);
        }
        catch (IOException e){
            return null;
        }
        return data;
    }

}
