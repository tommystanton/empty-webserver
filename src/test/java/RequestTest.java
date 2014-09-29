import com.blackhawks.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestTest {

    @Test
    public void itCanParseAGetRequest() throws Exception
    {
        Request request = new Request("GET / HTTP/1.1");

        assertEquals("GET", request.getHttpMethod());
        assertEquals("/", request.getResource());
        assertEquals("HTTP/1.1", request.getHttpVersion());
    }

    @Test
    public void itCanParseAPostRequest() throws Exception
    {
        Request request = new Request("POST /data HTTP/1.1");

        assertEquals("POST", request.getHttpMethod());
        assertEquals("/data", request.getResource());
        assertEquals("HTTP/1.1", request.getHttpVersion());
    }
}
