import com.ericsmith.*;
import com.ericsmith.Socket;
import org.junit.Test;

import java.net.*;

public class InternetSocketTest {

    @Test
    public void StartsTheSocket() throws Exception {

        Socket socket = new InternetSocket();

        socket.start();

        java.net.Socket client = new java.net.Socket("localhost", 5000);


    }
}
