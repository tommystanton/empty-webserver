package com.ericsmith;

public class Server {

    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args)
    {

    }

    public void run() {
        socket.start();
    }
}
