import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class queryServer {

    public static void main(String[] args) throws IOException{
        
        try(ServerSocket listener = new ServerSocket(60000)){
            
            System.out.println("Server running...");
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
            
            while(true)
                executor.execute(new clientResponse(listener.accept()));
            
        
    }}
    
    private static class clientResponse implements Runnable{
        
        private Socket socket;

        clientResponse(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run(){
                try{
                    Scanner in = new Scanner(socket.getInputStream());
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                        
                    int query = in.nextInt();
                    if(query == 0){
                        out.println("CLOSE");
                    }
                    else if(query == 1){
                        String num = in.nextLine();
                        int sum = sumOdd(num);
                        out.println("From Server: "+sum);
                    }
                    else if(query == 2){
                        String str = in.nextLine();
                        int count = countVowel(str);
                        out.println("From Server: "+count);
                    }
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
    
        public int sumOdd(String num){
            int sn = 0;
            for(int i=1;i<num.length();i++){
                int val = Integer.parseInt(String.valueOf(num.charAt(i)));
                if(val%2 == 1)
                    sn += val;
            }
            return sn;
        }
    
        public int countVowel(String str){
            int count = 0 ;
            for(int i=0;i<str.length();i++){
                Character c = str.charAt(i);
                String vowel = "aeiouAEIOU";
                for(int j=0;j<vowel.length();j++)
                    if(c.equals(vowel.charAt(j)) == true){
                        count += 1;
                    }
            }
            return count;
        }
    
    }
    
}



