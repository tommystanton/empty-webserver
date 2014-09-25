import java.net.Socket;

public class Mocket {
  private Socket socket;
  private boolean closed;

  public Mocket() {
    socket = new Socket();
  }
  public Socket getSocket() {
    return socket;
  }
  public boolean isClosed() {
    return socket.isClosed();
  }
}
