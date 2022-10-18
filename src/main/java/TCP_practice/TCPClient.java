package TCP_practice;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TCPClient {
    public static void main(String[]args) throws Exception {
        Socket socket = new Socket("localhost",6789);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        // send a text
        String output = "Hello, Server!";
        dos.writeBytes(output);
        // dos.writeBytes("HTTP/1.1 200 OK");

        // send an image
//        byte[] bytes = Files.readAllBytes(Paths.get("/home/ufaz/Downloads/3x4sekil.jpg"));
//        dos.writeInt(bytes.length);
//        dos.write(bytes);
        socket.close();
    }
}
