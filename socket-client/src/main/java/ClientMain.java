import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {

		try (Socket socket = new Socket("localhost", 5001)) {
			Scanner sc = new Scanner(System.in);
			while (true) {
				String input = sc.nextLine();
				System.out.println("Read: " + input);

				// socket.getOutputStream().write(input.getBytes());
				BufferedReader readFromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writeToSocket = new PrintWriter(socket.getOutputStream(), true);
				writeToSocket.println(input);

				// String response = readFromSocket.readLine();
				System.out.println("Response in Client: " + readFromSocket.readLine());

			}

		} catch (IOException e) {
			System.out.println("Exception in client: " + e.getMessage());
		}

	}

}
