import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException{
        
        if(args.length != 1){
            System.err.println("Server IP as the sole command line arguement");
            return;
        }
        
        try(Socket socket = new Socket(args[9)){}
        
    }
    
}
