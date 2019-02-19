import java.net.*;
import java.io.*;

public class HTTPEcho{
  public static void main( String[] args) throws IOException{

    ServerSocket initSocket = new ServerSocket(Integer.parseInt(args[0]));
    String HTTPHeader = "HTTP/1.1 200 OK\r\n\r\n";
    while(true){

      Socket connection = initSocket.accept();
      BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      DataOutputStream output = new DataOutputStream(connection.getOutputStream());
      StringBuilder sb = new StringBuilder(HTTPHeader);
      String s = "";

      while((s = input.readLine()) != null && s.length() != 0){
        sb.append(s + "\n");
      }
      output.writeBytes(sb.toString());
      connection.close();
    }
  }
}
