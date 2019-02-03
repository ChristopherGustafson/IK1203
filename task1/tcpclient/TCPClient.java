package tcpclient;
import java.net.*;
import java.io.*;

public class TCPClient {

    public static String askServer(String hostname, int port, String ToServer) throws  IOException {

      Socket client = new Socket(hostname, port);
      client.setSoTimeout(5000);

      DataOutputStream output = new DataOutputStream(client.getOutputStream());
      BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));

      output.writeBytes(ToServer + "\n");

      return input.readLine();
    }

    public static String askServer(String hostname, int port) throws  IOException {

      Socket client = new Socket(hostname, port);
      client.setSoTimeout(5000);

      DataOutputStream output = new DataOutputStream(client.getOutputStream());
      BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));

      output.writeBytes("\n");

      return input.readLine();
    }
}
