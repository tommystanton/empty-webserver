import com.blackhawks.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestTest {


    @Test
    public void itCanParse200() throws Exception
    {
        Request request = new Request("GET / HTTP/1.1");

        assertEquals("GET", request.getHttpMethod());
        assertEquals("/", request.getResource());
    }
}
