package module;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cliente{
	public static void main(String[] args) throws IOException {
		Socket connection = new Socket("127.1.1.1", 12345);
		System.out.println("Cliente: Conectado a porta 12345");
		
		ObjectOutputStream exit = new ObjectOutputStream(connection.getOutputStream());
		
		Mensagem mensagem = new Mensagem();
		
		do {
			String texto = "Cliente: " + JOptionPane.showInputDialog("Mensagem");
			mensagem.setMensagem(texto);
			exit.writeObject(mensagem.getMensagem());
			exit.flush();
		} while (!mensagem.getMensagem().equals("CLIENTE: TERMINATE"));
		
		
		exit.close();
		connection.close();
		System.out.println("Cliente encerrado");
		
	}oao
