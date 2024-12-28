package Single_Threaded;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Single_Threaded_Server {

    public void run() throws IOException {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(100000); // Timeout after 100 seconds
            System.out.println("Server listening on port: " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Connection request received from client: " + clientSocket.getRemoteSocketAddress());

                    // Read message from the client
                    String clientMessage = fromClient.readLine();
                    System.out.println("Message received from client: " + clientMessage);

                    // Respond to the client
                    String response = "Hello from the single-threaded server!";
                    toClient.println(response);
                    System.out.println("Response sent to client: " + response);

                } catch (IOException e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Single_Threaded_Server server = new Single_Threaded_Server();
        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
