package com.blackhawks;

import java.io.IOException;

public interface Socket {
    void start();
    void close() throws IOException;
}
