package com.blackhawks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class InternetSocket implements Socket {
    private SocketHandler handler;
    private java.net.Socket socket;

    public InternetSocket(SocketHandler handler) {
        this.handler = handler;
    }

    @Override
    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input = in.readLine();
            out.println(input);
            out.flush();
        }
        catch (Exception e)
        {
            if (serverSocket != null)
                try {
                    serverSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }
    }
}
