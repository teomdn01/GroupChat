package group.chat;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements IServer {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }


    /**
     * Closes the server connection
     */
    @Override
    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    @Override
    public Socket acceptConnection() throws IOException {
        return serverSocket.accept();
    }

//    public static void main(String[] args) {
//        //our server will be listening for clients that are making a connection to this port number
//        try {
//            ServerSocket serverSocket = new ServerSocket(1234);
//            Server server = new Server(serverSocket);
//            server.runServer();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Am reusit sa ajungem aici");
//    }
}
