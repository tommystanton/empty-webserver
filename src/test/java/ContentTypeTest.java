import com.blackhawks.ContentType;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ContentTypeTest {

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
