import org.junit.*;
import com.blackhawks.*;
import com.blackhawks.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import static org.junit.Assert.assertEquals;

public class InternetSocketTest {

  private InetAddress host;
  private EchoHandler handler;
  private Socket socket;
  private java.net.Socket client;

  @Before
  public void setup() throws IOException {
    host = InetAddress.getLocalHost();
    handler = new EchoHandler();
    socket = new InternetSocket(handler);

    new Thread() {
      public void run() {
        socket.start();
      }
    }.start();

    client = new java.net.Socket(host.getHostName(), 5000);
  }

  @After
  public void done() throws IOException {
    client.close();
  }

  @Test
  public void StartsTheSocket() throws Exception
  {
    PrintWriter out = new PrintWriter(client.getOutputStream());
    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

    out.println("Test\n");
    out.flush();

    assertEquals("Test", in.readLine());
  }
}
