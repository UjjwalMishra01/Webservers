# Web Servers Repository

<p align="center">
  <img src="https://raw.githubusercontent.com/UjjwalMishra01/Webservers/main/assets/webserver.png" alt="Web Servers Banner" width="800">
</p>

Welcome to the **Web Servers Repository**! 🚀 This repository contains implementations of both **Single-Threaded** and **Multithreaded** web servers in Java. Each server demonstrates key concepts in socket programming, concurrency, and HTTP communication, making it a great resource for learning or showcasing your skills.

---

## Features

### Single-Threaded Web Server
- Processes one client request at a time.
- Demonstrates basic socket programming concepts.
- Includes file sending and receiving capabilities.

### Multithreaded Web Server
- Handles multiple client requests concurrently.
- Optimized with a **Thread Pool** for enhanced performance.
- Implements basic HTTP protocol for GET and POST requests.
- Supports file upload and download operations.

---

## Repository Structure

```plaintext
Webservers/
├── Single_Threaded/       # Single-threaded server implementation
│   ├── Client.java        # Single-threaded client code
│   └── Server.java        # Single-threaded server code
├── Multithreaded Web-Server/
│   ├── Client.java        # Multithreaded client code
│   ├── Server.java        # Multithreaded server code
│   └── ThreadPool/        # Optimized thread pool server
│       └── Server.java    # Server with thread pool implementation
└── assets/                # Images and assets for the repository
```

---

## Getting Started

### Prerequisites
- **Java Development Kit (JDK) 8 or higher**
- Basic knowledge of Java and networking concepts

### Cloning the Repository
To get started, clone the repository using the following command:

```bash
git clone https://github.com/UjjwalMishra01/Webservers.git
cd Webservers
```

---

## How to Run

### Single-Threaded Web Server
#### Server
1. Navigate to the `Single_Threaded` directory:
   ```bash
   cd Single_Threaded
   ```
2. Compile and run the server:
   ```bash
   javac Server.java
   java Server
   ```

#### Client
1. In a new terminal, compile and run the client:
   ```bash
   javac Client.java
   java Client
   ```

### Multithreaded Web Server
#### Server
1. Navigate to the `Multithreaded Web-Server` directory:
   ```bash
   cd "Multithreaded Web-Server"
   ```
2. Compile and run the server:
   ```bash
   javac Server.java
   java Server
   ```

#### Client
1. In a new terminal, compile and run the client:
   ```bash
   javac Client.java
   java Client
   ```

---

## Example Output

### Single-Threaded Server
```plaintext
Server listening on port: 8080
Connection request received from client: /127.0.0.1
File received successfully: received_file.txt
```

### Multithreaded Server with Thread Pool
```plaintext
Server listening on port: 8080
Accepted connection from: /127.0.0.1
File sent successfully: sample.txt
```

### Client
```plaintext
Response from the server: Hello from server /127.0.0.1
```

---

## Future Enhancements
- Add file encryption and decryption during transfers.
- Extend HTTP support to include DELETE and PUT methods.
- Implement logging for better debugging and tracking.
- Include support for larger files with chunked transfer encoding.

---

## Contributing
Contributions are welcome! Feel free to fork the repository, make changes, and submit a pull request. For major changes, please open an issue first to discuss what you would like to change.

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Author
👨‍💻 **Ujjwal Mishra**  
Connect with me on [LinkedIn](https://www.linkedin.com/in/ujjwalm01) or visit my [GitHub Profile](https://github.com/UjjwalMishra01).

<p align="center">
  Thank you for visiting the Web Servers Repository! ⭐ Let's build the future together.
</p>
