import com.blackhawks.ParameterDecode;
import com.blackhawks.ContentType;
import com.blackhawks.ProcessRequest;
import com.blackhawks.Request;
import org.junit.*;
import static org.junit.Assert.*;

import com.blackhawks.Server;

import java.net.URL;


/**
 * Created by devuser on 9/24/2014.
 */
public class ParameterDecodeTest {

    @Test
    public void testParamDecoding() throws Exception
    {
        URL url = new URL("http://localhost:9090/parameters?variable_1=Operators%20%3C%2C%20%3E%2C%20%3D%2C%20!%3D%3B%20%2B%2C%20-%2C%20*%2C%20%26%2C%20%40%2C%20%23%2C%20%24%2C%20%5B%2C%20%5D%3A%20%22is%20that%20all%22%3F&variable_2=stuff");
        ParameterDecode pd;
        pd = new ParameterDecode( url );
        assertEquals("stuff", pd.getNewQueryParam("variable_2"));

    }


}
