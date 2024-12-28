package ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final ExecutorService threadPool;

    public Server(int poolSize) {
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    // Handle individual client connection
    public void handleClient(Socket clientSocket) {
        try (BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // Read HTTP request header
            String requestLine = fromClient.readLine();
            System.out.println("Request received: " + requestLine);

            if (requestLine.startsWith("GET")) {
                handleFileSending(toClient);
            } else if (requestLine.startsWith("POST")) {
                handleFileReceiving(fromClient);
            } else {
                toClient.println("HTTP/1.1 400 Bad Request\r\n");
                System.out.println("Unsupported request.");
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }

    // Handle sending files to the client
    private void handleFileSending(PrintWriter toClient) {
        try {
            File file = new File("server_files/sample.txt"); // Replace with your file path
            if (!file.exists()) {
                toClient.println("HTTP/1.1 404 Not Found\r\n");
                System.out.println("File not found: " + file.getName());
                return;
            }

            toClient.println("HTTP/1.1 200 OK\r\n");
            toClient.println("Content-Type: text/plain\r\n");
            toClient.println("Content-Length: " + file.length() + "\r\n");
            toClient.println();

            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = fileReader.readLine()) != null) {
                toClient.println(line);
            }
            fileReader.close();
            System.out.println("File sent successfully: " + file.getName());
        } catch (IOException e) {
            System.err.println("Error sending file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Handle receiving files from the client
    private void handleFileReceiving(BufferedReader fromClient) {
        try {
            String fileName = "received_file.txt"; // Name of the file to save
            File file = new File("server_files/" + fileName);
            try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {
                String line;
                while ((line = fromClient.readLine()) != null && !line.isEmpty()) {
                    fileWriter.write(line);
                    fileWriter.newLine();
                }
                System.out.println("File received successfully: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error receiving file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Main method to start the server
    public static void main(String[] args) {
        int port = 8080;
        int poolSize = 100;
        Server server = new Server(poolSize);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            // Add shutdown hook for graceful termination
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down server...");
                server.threadPool.shutdown();
            }));

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    server.threadPool.execute(() -> server.handleClient(clientSocket));
                } catch (IOException e) {
                    System.err.println("Error accepting connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server encountered an error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
