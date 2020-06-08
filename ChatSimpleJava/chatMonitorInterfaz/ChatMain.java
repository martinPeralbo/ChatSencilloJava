package chatMonitorInterfaz;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatMain {

	static ListaEnlazada lista;
	static PrintStream pantalla;
	static int contClientes;
	static int idCliente;
	//Main
	public static void main(String[] args) {
		try {
			
			idCliente=1;
			 lista =new ListaEnlazada();
			 contClientes=1;
			ServerSocket escuchador = new ServerSocket(8000);
			ManejadorPeticionChat manejadorPeticiones;
			while(true) {
				Socket cliente = escuchador.accept();
				lista.insertarPrincipio(cliente);
				System.out.println("Un nuevo cliente se une al chat.Total clientes: " + contClientes);
				manejadorPeticiones= new ManejadorPeticionChat(cliente, idCliente);
				manejadorPeticiones.start();
				
				
				contClientes++;
				idCliente++;
				System.out.println(contClientes);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param nombrePersona
	 * @param mensaje
	 */
	 static synchronized void difundir(String nombrePersona,String mensaje) {
		
		
		for(lista.irPrincipio();!lista.finLista();lista.irSiguienteNodo())
        {	Socket cliente = (Socket) lista.getActual();
            try {
				pantalla= new PrintStream(cliente.getOutputStream());
				pantalla.println(mensaje);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	/**
	 * 
	 * @param socket
	 * @return true si lo ha eliminado,false si no ha podido 
	 * eliminarse correctamente
	 */
	/*
	 * Falta por informar al resto de usuarios que 
	 * x persona ha abandonado el chat
	 */
	 static synchronized boolean eliminar(Socket socket,String nombre) {
		if(!lista.listaVacia()) {
			Socket cliente=(Socket)lista.busquedaFor(socket).info;
			boolean eliminado=lista.eliminar(cliente);
			difundir(nombre, nombre + " ha abandonado el chat");
			if(eliminado) {
				contClientes--;
				return true;
			}
			else
				return false;
		}
		else {
			System.out.println("Lista vacia no se puede eliminar");
			return false;
		}
	}
}
