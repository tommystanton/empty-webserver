import com.blackhawks.ContentType;
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

        assertEquals("HTTP/1.0 404 Not Found", ct.returnType(req));
    }

    @Test
    public void returnImageGif() throws Exception
    {
        String req = "thisisimage.gif";
        ContentType ct = new ContentType();

        assertEquals("image/gif", ct.returnType(req));
    }
    @Test
    public void returnImagePng() throws Exception
    {
        String req = "thisisimage.png";
        ContentType ct = new ContentType();

        assertEquals("image/png", ct.returnType(req));
    }
    @Test
    public void returnImageJpeg() throws Exception
    {
        String req = "thisisimage.jpeg";
        ContentType ct = new ContentType();

        assertEquals("image/jpeg", ct.returnType(req));
    }
}
