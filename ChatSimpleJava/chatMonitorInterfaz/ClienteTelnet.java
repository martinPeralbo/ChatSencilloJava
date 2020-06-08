package chatMonitorInterfaz;

import java.io.IOException;
import java.net.Socket;

public class ClienteTelnet {
	String host;
	int puerto;
	public ClienteTelnet(String host, int puerto) {
		this.host=host;
		this.puerto=puerto;
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteTelnet cliente = new ClienteTelnet("localhost",8000);
		cliente.conectarseA(cliente.host,cliente.puerto);
	}
	private void conectarseA(String host,int puerto) {
		// TODO Auto-generated method stub
		try {
			
			
			VistaChat vChat = new VistaChat();
			
			ControladorVentanaChat cChat= new ControladorVentanaChat(vChat);
			
			
			vChat.registrarEventos(cChat);
			Socket tcp = new Socket(host, puerto);
			
			HiloEntrada hiloEntrada = new HiloEntrada(tcp.getInputStream(),vChat);
			HiloSalida hiloSalida = new HiloSalida(tcp.getOutputStream(),vChat,cChat);
			hiloEntrada.start();
			hiloSalida.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
