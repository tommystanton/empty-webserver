import com.blackhawks.Request;
import com.blackhawks.RequestHandler;
import com.blackhawks.Response;
import com.blackhawks.Router;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResponseTest {
    @Test
    public void itCanHandle404() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("GET /foobar HTTP/1.1");
        Response response = handler.respond(request);

        byte[] statusLine = response.getStatusLine();
        byte[] body = response.getBody();

        assertEquals("HTTP/1.1 404 Not Found", new String(statusLine));
        assertEquals("", new String(body));
    }

    @Test
    public void itCanHandle200() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("GET / HTTP/1.1");
        Response response = handler.respond(request);

        byte[] statusLine = response.getStatusLine();
        byte[] body = response.getBody();

        assertEquals("HTTP/1.1 200 OK", new String(statusLine));
        assertTrue(new String(body).matches(".*file1.*"));
    }

    @Test
    public void itCanHandleGetWithParams() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("GET /?name=Bob HTTP/1.1");
        Response response = handler.respond(request);

        byte[] statusLine = response.getStatusLine();
        byte[] body = response.getBody();

        assertEquals("HTTP/1.1 200 OK", new String(statusLine));
        assertTrue(new String(body).matches(".*<a href='file1'>file1</a>.*"));
        assertTrue(new String(body).matches(".*<a href='file2'>file2</a>.*"));


    }

    @Test
    public void itCanHandlePost() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("POST /form HTTP/1.1");
        Response response = handler.respond(request);

        byte[] statusLine = response.getStatusLine();
        byte[] body = response.getBody();

        assertEquals("HTTP/1.1 200 OK", new String(statusLine));
        assertEquals("", new String(body));
    }

    @Test
    public void itRespondsWithABodySayingHello() throws Exception
    {
        RequestHandler handler = new RequestHandler(new Router());

        Request request = new Request("GET /hello HTTP/1.1");
        Response response = handler.respond(request);

        byte[] statusLine = response.getStatusLine();
        byte[] body = response.getBody();

        assertEquals("HTTP/1.1 200 OK", new String(statusLine));
        assertEquals("hello", new String(body));
    }
}