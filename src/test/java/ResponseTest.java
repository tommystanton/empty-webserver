import org.junit.*;
import static org.junit.Assert.*;

import com.blackhawks.Response;

public class ResponseTest {
    @Test
    public void itCanHandle404() throws Exception
    {
        Response response = new Response();
        assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine(404));
    }

    @Test
    public void itCanHandle200() throws Exception
    {
        Response response = new Response();
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine(200));
    }
}