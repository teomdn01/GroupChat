package group.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

public interface IClientHandler {
    void broadcastMessage(String messageToSend);
    void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter);
    void removeClientHandler();
}
