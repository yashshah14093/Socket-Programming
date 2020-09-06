
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;



public class Server {

    public static void main(String[] args) throws IOException{
        
        try(ServerSocket Listener = new ServerSocket(60000)){
            
            System.out.println("Listening to clients...");
            
            while(true){
                
                try(Socket socket = Listener.accept()){
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                    out.println(new Date().toString());
                }
                
            }
        }
        
    }
    
}
