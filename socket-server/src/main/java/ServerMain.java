import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(5001)) {

			while (true) {
				try (Socket socket = serverSocket.accept()) {
					
					InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					String input = bufferedReader.readLine();
					System.out.println("Read in Server: " + input);					
					socket.getOutputStream().write("OK.".getBytes());
					
					if ("exit".equals(input)) {
						System.out.println("Exiting...");
						break;
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
