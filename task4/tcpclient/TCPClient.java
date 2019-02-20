package tcpclient;
import java.net.*;
import java.io.*;

public class TCPClient {

    public static String askServer(String hostname, int port, String ToServer) throws  IOException {

      if(ToServer == null){
        return askServer(hostname, port);
      }
      //Create client socket and set timeout to 5s
      Socket client = new Socket(hostname, port);
      client.setSoTimeout(5000);

      String s;
      StringBuilder sb = new StringBuilder("");

      //Initiate maxLine variables
      int count = 0;
      int maxLineCount = 100;


      try{
        //Create output and input streams
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //Write user input to server
        output.writeBytes(ToServer + "\n");

        //Read lines from server until null is read or the max line count is reached
        while(((s = input.readLine()) != null) && count <= maxLineCount){
          sb.append(s + '\n');
          count++;
        }

        //Close socket and return string representation of the StringBuilder
        client.close();
        return sb.toString();
      }
      // If a error occurs (like a timeout), close the socket and return what we have recieved thus far
      catch(IOException e){
        client.close();
        return sb.toString();
      }
    }

    public static String askServer(String hostname, int port) throws  IOException {

      //Create client socket and set timeout to 5s
      Socket client = new Socket(hostname, port);
      client.setSoTimeout(5000);

      String s;
      StringBuilder sb = new StringBuilder("");

      //Initiate maxLine variables
      int count = 0;
      //int maxLineCount = 100;

      try{

        //Create output and input streams
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        //Read lines from server and append to StringBuilder until null is read or the max line count is reached
        while(((s = input.readLine()) != null)/* && count <= maxLineCount*/){
          sb.append(s + '\n');
          //count++;
        }

        //Close socket and return string representation of the StringBuilder
        client.close();
        return sb.toString();
      }
      // If a error occurs (like a timeout), close the socket and return what we have recieved thus far
      catch(IOException e){
        client.close();
        return sb.toString();
      }
    }
}
