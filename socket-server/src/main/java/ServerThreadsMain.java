import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreadsMain {
	
	private static int TIME_OUT=10000;
	
	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(5001)) {

			while (true) {
				try (Socket socket = serverSocket.accept()) {
				
						ConnectionThread ct = new ConnectionThread(socket);
						new Thread(ct).start();						
						
						//Waiting to before closing the socket.
						try {
							Thread.sleep(TIME_OUT);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				} catch (IOException e) {
					System.out.println("Error in server. Getting the socket: " + e.getMessage());
				}
			}

		} catch (Exception e) {
			System.out.println("Exception in server: " + e.getMessage());
		}
	}
}
