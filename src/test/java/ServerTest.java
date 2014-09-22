import org.junit.*;

import com.blackhawks.Server;

import java.net.Socket;

public class ServerTest
{
  @Test
  public void ItOpensASocketOnTheExpectedPort() throws Exception
  {
    Server server = new Server();
    Server.start();

    Socket socket = new Socket("127.0.0.1", 5000);

    Server.stop();
  }
}