package chatMonitorInterfaz;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.Action;

public class HiloSalida extends Thread  {
	OutputStream outputStream;
	 VistaChat vChat;
	 ControladorVentanaChat cChat;
	public HiloSalida( OutputStream outputStream, VistaChat vChat,ControladorVentanaChat cChat) {
		// TODO Auto-generated constructor stub
		this.outputStream=outputStream;
		this.vChat=vChat;
		this.cChat=cChat;
	}
	@Override
	public void run() {
		PrintStream ps = new PrintStream(outputStream);
		String linea="";
		
			
			do {try {
				sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				if(cChat.botonEnviarPulsado) {
					System.out.println("envio");
					//linea=vChat.mensaje.getText() +"\n";
					linea=vChat.mensaje.getText();
					ps.println(linea);
					cChat.botonEnviarPulsado=false;
					vChat.mensaje.setText("");
				}	
				try {
					sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cChat.botonEnviarPulsado=false;
			}while(linea!="adios");
		
	}	
	

}
