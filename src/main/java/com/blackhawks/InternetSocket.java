package com.blackhawks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;

public class InternetSocket implements Socket {
    private SocketHandler handler;
    private java.net.Socket socket;
    private Response response;

    public InternetSocket(SocketHandler handler) {
        this.handler = handler;
    }

    @Override
    public void start() {
        ServerSocket serverSocket = null;
        while(true) {
            try {
                serverSocket = new ServerSocket(5000);
                socket = serverSocket.accept();

                OutputStream out = socket.getOutputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input = in.readLine();

                RequestHandler handler = new RequestHandler(new Router());
                Request request = new Request(input);
                response = handler.respond(request);

                // HTTP response: status line + header fields
                out.write(response.getStatusLine());
                out.write("\r\n".getBytes());
                out.write(response.getResponseHeaderFields());

                // HTTP response: blank line (required)
                out.write("\r\n".getBytes());

                // HTTP response: body (optional)
                out.write("\r\n".getBytes());
                out.write(response.getBody());

                out.flush();

                socket.close();
            } catch (Exception e) {
                if (serverSocket != null)
                    try {
                        serverSocket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
            }
        }
    }
}
