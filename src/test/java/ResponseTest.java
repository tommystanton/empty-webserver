import com.blackhawks.Request;
import com.blackhawks.Router;
import org.junit.*;
import static org.junit.Assert.*;

import com.blackhawks.Response;

public class ResponseTest {
    @Test
    public void itCanHandle404() throws Exception
    {
        Request request = new Request("GET /foobar HTTP/1.1");
        Response response = new Response(request, new Router());
        assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine());
    }

    @Test
    public void itCanHandle200() throws Exception
    {
        Request request = new Request("GET / HTTP/1.1");
        Response response = new Response(request, new Router());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
    }

    @Test
    public void itCanHandleGetWithParams() throws Exception
    {
        Request request = new Request("GET /?name=Bob HTTP/1.1");
        Response response = new Response(request, new Router());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
    }

    @Test
    public void itCanHandlePost() throws Exception
    {
        Request request = new Request("POST /form HTTP/1.1");
        Response response = new Response(request, new Router());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
    }
}