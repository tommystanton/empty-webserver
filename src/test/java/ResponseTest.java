import com.blackhawks.Request;
import com.blackhawks.RequestHandler;
import com.blackhawks.Response;
import com.blackhawks.Router;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ResponseTest {
    @Test
    public void itCanHandle404() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("GET /foobar HTTP/1.1");
        Response response = handler.respond(request);

        assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine());
    }

    @Test
    public void itCanHandle200() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("GET / HTTP/1.1");
        Response response = handler.respond(request);

        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
    }

    @Test
    public void itCanHandleGetWithParams() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("GET /?name=Bob HTTP/1.1");
        Response response = handler.respond(request);

        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
    }

    @Test
    public void itCanHandlePost() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("POST /form HTTP/1.1");
        Response response = handler.respond(request);

        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
    }

    @Test
    public void itRespondsWithABodySayingHello() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("GET /hello HTTP/1.1");
        Response response = handler.respond(request);

        byte[] body = response.getBody();

        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertArrayEquals("hello".getBytes(), body);
    }
}