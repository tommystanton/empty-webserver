import com.blackhawks.Request;
import com.blackhawks.RequestHandler;
import com.blackhawks.Response;
import com.blackhawks.Router;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class ReadFilesTest {

  @Test
  public void readTextFile() throws Exception
  {
    String expected = new String("file1 contents");
    Path path = Paths.get("./public/file1");
    byte[] data = Files.readAllBytes(path);
    assertEquals(expected, new String(data));

  }

  @Test
  public void readFile1() throws Exception
  {
    String expected = new String("file1 contents");

    RequestHandler handler = new RequestHandler(new Router());

    Request request = new Request("GET /file1 HTTP/1.1");
    Response response = handler.respond(request);

    assertEquals(expected, new String(response.getBody()));

  }
}
