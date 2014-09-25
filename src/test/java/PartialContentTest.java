import com.blackhawks.PartialContent;
import org.junit.Test;
import com.blackhawks.ParameterDecode;
import com.blackhawks.ContentType;
import com.blackhawks.ProcessRequest;
import com.blackhawks.Request;
import org.junit.*;


import static org.apache.commons.io.FilenameUtils.*;

import static org.junit.Assert.*;

public class PartialContentTest {

    @Test
    public void testByteStream() throws Exception {

        String fixtureFilePath = separatorsToSystem("src/test/fixtures/partial_content.txt");

        PartialContent pc = new PartialContent(fixtureFilePath, 9);

        assertEquals("FIRSTWORD", pc.getByteStreamByCount());
    }

    @Test
    public void testForFileNotFoundException() throws Exception
    {
        String fixtureFilePath = separatorsToSystem("src/test/fixtures/partial_content-noexist.txt");
        PartialContent pc = new PartialContent(fixtureFilePath, 9);

        assertEquals("404 File Not Found", pc.getByteStreamByCount());
    }

}
