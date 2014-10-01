package com.blackhawks.routes;

import com.blackhawks.RouteDefinition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File1RouteDefinition implements RouteDefinition {
    @Override
    public byte[] execute() {

      byte[] data = new byte[100];

      Path path = Paths.get("./file1");
      try {
        data = Files.readAllBytes(path);
      }
      catch (IOException e){
        return null;
      }
      return data;
    }

}
