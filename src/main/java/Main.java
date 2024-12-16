import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {
  public static void main(String[] args) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");

    // Uncomment this block to pass the first stage

     try {
       ServerSocket serverSocket = new ServerSocket(4221);

       // Since the tester restarts your program quite often, setting SO_REUSEADDR
       // ensures that we don't run into 'Address already in use' errors
       serverSocket.setReuseAddress(true);

       Socket clinetSocket = serverSocket.accept(); // Wait for connection from client.
       System.out.println("accepted new connection");

       // need to add outputstream to respond with HTTP status code
         // The \r\n\r\n separates HTTP headers from the body, with the first \r\n ending
         // the last header and the second \r\n indicating the start of the body.
       String httpResponse = "HTTP/1.1 200 OK\r\n\r\n";
       clinetSocket.getOutputStream().write(httpResponse.getBytes(StandardCharsets.UTF_8));
     } catch (IOException e) {
       System.out.println("IOException: " + e.getMessage());
     }
  }
}
