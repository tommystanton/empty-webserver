import com.blackhawks.PartialContent;
import org.junit.Test;
import static org.apache.commons.io.FilenameUtils.*;

import static org.junit.Assert.assertEquals;


public class FileContentTest {

    @Test
    public void testIfFileHasContents() throws Exception {

        String fixtureFilePath;
        fixtureFilePath = System.getProperty("user.dir");
        fixtureFilePath = concat(fixtureFilePath, "src/test/fixtures/partial_content.txt");
        fixtureFilePath = separatorsToSystem(fixtureFilePath);
        PartialContent pc = new PartialContent(fixtureFilePath, 9);
        System.out.println(pc.readFileIn().length());

        assertEquals(true, pc.readFileIn().length() > 0);
    }


    @Test
    public void testIfFileHasNoContents() throws Exception {

        String fixtureFilePath;
        fixtureFilePath = System.getProperty("user.dir");
        fixtureFilePath = concat(fixtureFilePath, "src/test/fixtures/partial_content_empty.txt");
        fixtureFilePath = separatorsToSystem(fixtureFilePath);
        PartialContent pc = new PartialContent(fixtureFilePath, 9);
        assertEquals(false, pc.readFileIn().length() > 0);
    }

}
