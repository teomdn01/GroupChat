package group.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

public interface IClient {
    void sendUsername();
    void listenToMessage();
    void closeEverything(Socket socket, BufferedReader reader, BufferedWriter writer);
    void changeGroupPicture();
    void changePictureWithReceivedPath(String path);
    void changeGroupTitle(String title);
    void getNewGroupTitle();
}
