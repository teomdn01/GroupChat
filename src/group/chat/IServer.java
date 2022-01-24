package group.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public interface IServer{
    void closeServerSocket();
    Socket acceptConnection() throws IOException;
}
