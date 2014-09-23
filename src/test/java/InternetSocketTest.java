import com.ericsmith.*;
import com.ericsmith.Socket;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import static org.junit.Assert.assertEquals;

public class InternetSocketTest {

    @Test
    public void StartsTheSocket() throws Exception
    {
        EchoHandler handler = new EchoHandler();
        Socket socket = new InternetSocket(handler);

        socket.start();

        java.net.Socket client = new java.net.Socket("localhost", 5000);
        try {
            PrintWriter out = new PrintWriter(client.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            out.println("Test");

            assertEquals("Test", in.readLine());
        }
        finally {
            client.close();
        }

    }
}
