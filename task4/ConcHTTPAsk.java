import java.net.*;
import java.io.*;
import tcpclient.TCPClient;

public class ConcHTTPAsk {
  public static void main( String[] args) throws IOException{

    //Initiate server socket
    ServerSocket initSocket = new ServerSocket(Integer.parseInt(args[0]));

    while(true){
      //Initiate connection to client and send it to a new thread
      Socket connection = initSocket.accept();
      Runnable r = new MyRunnable(connection);
      new Thread(r).start();
    }
  }
}
