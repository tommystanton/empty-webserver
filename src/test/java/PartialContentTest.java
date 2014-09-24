import com.blackhawks.PartialContent;
import org.junit.Test;
import com.blackhawks.ParameterDecode;
import com.blackhawks.ContentType;
import com.blackhawks.ProcessRequest;
import com.blackhawks.Request;
import org.junit.*;

import java.io.Reader;

import static org.junit.Assert.*;

public class PartialContentTest {

    @Test
    public void testByteStream() throws Exception {

        String content = "C:\\Users\\devuser\\partial_content.txt";
        PartialContent pc = new PartialContent(content, 9);

        assertEquals("FIRSTWORD", pc.getByteStreamByCount());
    }

}
