package com.blackhawks;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  private static ServerSocket serverSocket;
  private static Socket clientSocket;

  public static void start() throws Exception
  {
    serverSocket = new ServerSocket(5000);
  }

  public static void stop() throws Exception {
    serverSocket.close();
  }

  public static void main(String[] args) throws Exception
  {
    start();
    stop();
  }
}
