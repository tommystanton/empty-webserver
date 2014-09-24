import com.blackhawks.ContentType;
import com.blackhawks.ProcessRequest;
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

    @Test
    public void return404() throws Exception
    {
        String req = "/foobar";
        ContentType ct = new ContentType();

        assertEquals("404 error", ct.returnType(req));
    }

    @Test
    public void returnImage() throws Exception
    {
        String req = "thisisimage.gif";
        ContentType ct = new ContentType();

        assertEquals("image/gif", ct.returnType(req));
    }
}
