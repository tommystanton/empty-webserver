import com.blackhawks.PartialContent;
import org.junit.Test;
import static org.apache.commons.io.FilenameUtils.*;

import static org.junit.Assert.assertEquals;


public class FileContentTest {

    @Test
    public void testIfFileHasContents() throws Exception {

        String fixtureFilePath = separatorsToSystem("src/test/fixtures/partial_content.txt");
        PartialContent pc = new PartialContent(fixtureFilePath, 9);
        assertEquals(true, pc.readFileIn().length() > 0);
    }


    @Test
    public void testIfFileHasNoContents() throws Exception {

        String fixtureFilePath = separatorsToSystem("src/test/fixtures/partial_content_empty.txt");
        PartialContent pc = new PartialContent(fixtureFilePath, 9);
        assertEquals(false, pc.readFileIn().length() > 0);
    }

}
