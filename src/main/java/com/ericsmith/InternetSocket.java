package com.ericsmith;
import java.net.ServerSocket;

public class InternetSocket implements Socket {

    public InternetSocket(SocketHandler handler) {

    }

    @Override
    public void start() {
        try {
            java.net.ServerSocket socket = new java.net.ServerSocket(5000);
        }
        catch (Exception e) {

        }
    }
}
