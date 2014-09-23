import org.junit.*;
import static org.junit.Assert.*;

import com.blackhawks.Server;

public class ServerTest {

  @Test
  public void ItStartsASocket() {
    Mocket mocket = new Mocket();
    Server server = new Server(mocket);

    server.run();

    assertTrue(mocket.Started);
  }
}
