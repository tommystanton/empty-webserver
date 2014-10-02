package com.blackhawks.routes;

import com.blackhawks.Request;
import com.blackhawks.RouteDefinition;

import java.io.File;

public class EmptyRouteDefinition implements RouteDefinition {



    @Override
    public byte[] execute(Request request) {
        return displayFiles();
    }

    public byte[] displayFiles(){
        StringBuilder sb = new StringBuilder();
        File[] fileNames;
        File file=new File("./public/");
        if(file.isDirectory()){
            fileNames= file.listFiles();
            sb.append("<html><body>");
            for(File temp:fileNames){
                sb.append("<a href='");
                sb.append(temp.getName());
                sb.append("'>");
                sb.append(temp.getName());
                sb.append("</a>");
                sb.append("<br>");
            }
            sb.append("</html></body>");

        }
        return sb.toString().getBytes();
    }
}
