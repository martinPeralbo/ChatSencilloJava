package chatMonitorInterfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorPeticionChat extends Thread {
	BufferedReader entrada;
	PrintWriter salida;
	Socket cliente;
	PrintStream pantalla;
	String linea;
	int numeroCliente;
	
	public ManejadorPeticionChat(Socket cliente,int numeroCliente) {
		this.cliente=cliente;
		this.numeroCliente=numeroCliente;
		
	}
	
	@Override
	public void run() {
		System.out.println("cliente " + numeroCliente);
		try {
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			pantalla = new PrintStream(cliente.getOutputStream());
			pantalla.println("Bienvenido al chat eres el cliente nÂº " + numeroCliente);
			pantalla.println("Debes de teclear 'adios' para salir del chat \n");
			pantalla.println("¿Como te llamas?");
			System.out.println("Antes de recibir");
			
			String nombre = entrada.readLine();
			System.out.println("despues de recibir");
			ChatMain.difundir(nombre, nombre +" se ha unido al chat");
			do {
				 linea = entrada.readLine();
				if(!linea.equals("adios")) {
					ChatMain.difundir(nombre, nombre+" : "+linea);
				}else {
					//ServidorChat.difundir(nombre, nombre+" abandona el chat");
					
					
					ChatMain.eliminar(cliente,nombre);
					
				}
			}while(!linea.equals("adios"));
			cliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
