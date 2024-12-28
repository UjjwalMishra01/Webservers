# Single Threaded Client-Server Application

This folder contains the implementation of a simple single-threaded client-server model in Java. The server listens on a specified port, receives connections from a single client, and processes the client's requests. The client sends a file to the server and receives a response.

## File Structure
- **Client.java**: Implements the single-threaded client logic.
- **Server.java**: Implements the single-threaded server logic.

---

## Requirements
- Java Development Kit (JDK) 8 or higher.
- A text editor or IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).

---

## How It Works
### Client
1. The client establishes a connection to the server on the specified port (default: 8080).
2. It sends a file (in this case, a PDF) to the server.
3. The file content is transmitted over the socket, and the client waits for a response.
4. The server processes the file and sends a response message.

### Server
1. The server starts and listens for incoming connections on the specified port.
2. Upon receiving a connection, it reads data from the client and prints the received message.
3. It sends a response message back to the client.

---

## Usage Instructions
### Running the Server
1. Navigate to the directory containing the `Server.java` file.
2. Compile the server code using the command:
   ```bash
   javac Single_Threaded/Server.java
   ```
3. Run the server:
   ```bash
   java Single_Threaded.Server
   ```
   The server will start listening on port 8080.

### Running the Client
1. Navigate to the directory containing the `Client.java` file.
2. Compile the client code using the command:
   ```bash
   javac Single_Threaded/Client.java
   ```
3. Run the client:
   ```bash
   java Single_Threaded.Client
   ```
   Ensure the file path for the file to be sent (`DECLARATION FORM.pdf`) is correctly specified in the client code.

---

## Code Highlights
### Client Code
- Establishes a connection to the server using a `Socket` object.
- Sends a file to the server using a `DataOutputStream`.
- Handles exceptions during file transmission.

### Server Code
- Accepts connections from a client using a `ServerSocket`.
- Reads data from the client using a `BufferedReader`.
- Sends a response message to the client.

---

## Example Output
### Server
```plaintext
Server listening on port: 8080
Connection request received from client: /127.0.0.1
Message received from client: [file content]
Response sent to client: Hello from the single-threaded server!
```

### Client
```plaintext
File sent successfully: DECLARATION FORM.pdf
Response from the server: Hello from the single-threaded server!
```

---

## Notes
- The server has a timeout of 100 seconds for incoming connections.
- Ensure the file path in the client code exists and points to the correct file.
- This implementation is for educational purposes and is not suitable for production use.

---

## Future Enhancements
- Add support for multiple clients using a multi-threaded server.
- Implement error handling for invalid file formats or corrupted files.
- Extend the client-server protocol to include more functionalities (e.g., file downloads, status codes).
