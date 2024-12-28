package Single_Threaded;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Single_Threaded_Client {
    public void run() throws Exception {
        int port = 8080; // Port number
        InetAddress inetAddress = InetAddress.getLocalHost();

        try (Socket socket = new Socket(inetAddress, port);
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send file to the server
            sendFile("F:\\Study\\Projects\\Multithreaded Web Server\\DECLARATION FORM.pdf", dataOutputStream);

            // Read and print the server response
            String response = fromServer.readLine();
            System.out.println("Response from the server: " + response);
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void sendFile(String filePath, DataOutputStream dataOutputStream) throws IOException {
        File file = new File(filePath);

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            // Send the file size
            dataOutputStream.writeLong(file.length());

            // Send file content
            byte[] buffer = new byte[4 * 1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                dataOutputStream.write(buffer, 0, bytesRead);
                dataOutputStream.flush();
            }

            System.out.println("File sent successfully: " + file.getName());
        } catch (IOException e) {
            System.err.println("Error while sending file: " + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        Single_Threaded_Client client = new Single_Threaded_Client();
        try {
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
