import com.blackhawks.Socket;

import java.io.IOException;

public class Mocket implements Socket {
  public boolean Started;

  @Override
  public void start() {
    Started = true;
  }

    @Override
    public void close() throws IOException {

    }
}
