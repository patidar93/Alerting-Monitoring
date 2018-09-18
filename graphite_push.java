import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.net.SocketFactory;

public class GraphiteWriter {
   public static void main(String[] args) throws IOException {

       InetSocketAddress address = new InetSocketAddress("$server-address", 2020);
       Socket socket = SocketFactory.getDefault().createSocket(address.getAddress(), address.getPort());
       Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
       String time = String.valueOf(System.currentTimeMillis() / 1000);
       writer.write(
               "$path 1 "
                       + time + "\n");
       writer.flush();

       writer.close();
   }
}
