package module;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("Server aberto: 12345");
		
		Socket connection = server.accept();
		System.out.println("SERVER: conectado" + connection.getInetAddress().getHostAddress());
		
		ObjectInputStream entry = new ObjectInputStream(connection.getInputStream());
		
		Mensagem mensagem = new Mensagem();
		
		do {
			mensagem.setMensagem((String) entry.readObject());
			System.out.println(mensagem);
		} while (!mensagem.getMensagem().equals("Cliente : Terminate"));
		
		entry.close();
		server.close();
		System.out.println("Server encerrado!");
	}
}
