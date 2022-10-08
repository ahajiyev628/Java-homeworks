package TCP_practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        readAsString();
        //readAsByte();
    }

    public static void readAsString() throws Exception {
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        /*
        by using try-catch statement, we can check whether the defined port is available or not
        if the below port is working with another application at a time,
        we can move to another port
        */
        while (true) {
            System.out.println("Waiting for new Socket...");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("New connection was established.");
            System.out.println("Getting the message from the client...");
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            while (true) {
                String clientSentence = br.readLine();
                if (clientSentence == null) {
                    break;
                } else {
                    System.out.println(clientSentence);
                }
            }
            System.out.println();
        }
    }
    public static void readAsByte() throws Exception {
        ServerSocket ourFirstServerSocket = new ServerSocket(6789); //localhost or 127.0.0.1

        while (true) {
            System.out.println("Waiting for new Socket...");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("New connection was established.");
            System.out.println("Getting the image from the client...");

            DataInputStream ds = new DataInputStream(connection.getInputStream());

            byte[] arr = readMessage(ds);
            System.out.println("message length2 = " + arr.length);

            Files.write(Paths.get("/home/ufaz/Downloads/3x4sekil.jpg"), arr);
            System.out.println();
        }
    }

    public static byte[] readMessage(DataInputStream din) throws Exception {
        int msgLen = din.readInt();
        System.out.println("message length1 = " + msgLen);
        byte[] msg = new byte[msgLen];

        din.readFully(msg);
        return msg;
    }
}

