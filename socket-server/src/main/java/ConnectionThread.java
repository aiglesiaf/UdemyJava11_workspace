import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionThread implements Runnable{

	private Socket socket;
		
	public ConnectionThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String input = bufferedReader.readLine();
			
			System.out.println("Read in Thread: " + input);					
			socket.getOutputStream().write("OK.".getBytes());

		
		} catch (IOException e) {
			System.out.println("Error in thread. "+Thread.currentThread().getName()+" "+e.getMessage());
		}		
		
	}
	
	
	

}
