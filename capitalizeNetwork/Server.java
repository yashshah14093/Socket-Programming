import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    
    public static void main(String[] args) throws IOException{
        
        try(ServerSocket listener = new ServerSocket(60000)){
            
            System.out.println("Server running...");
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
            
            while(true)
                executor.execute(new Capitalize(listener.accept()));
            
            
        }
    }
    
    
    private static class Capitalize implements Runnable{
        
        private Socket socket;

        Capitalize(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run(){
            try{
                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                
                while(in.hasNextLine())
                    out.println(in.nextLine().toUpperCase());    
            }
            catch(Exception e){
                System.out.println("Error: "+socket + " with an Exception-> " + e);
            }
            finally{
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error while closing: "+socket+" with an exception-> "+e);
                }
            }
        }
    }

}
