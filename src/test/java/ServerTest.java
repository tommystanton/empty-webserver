import com.blackhawks.Request;
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

  @Test
  public void ItParsesRequest() throws Exception {
    String req = "GET / HTTP/1.1";
    Request request = new Request(req);

    assertEquals("GET", request.getHttpMethod());
    assertEquals("/", request.getUrl());
    assertEquals("HTTP/1.1", request.getHttpVersion());
  }


}
