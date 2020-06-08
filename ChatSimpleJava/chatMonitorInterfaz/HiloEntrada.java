package chatMonitorInterfaz;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JTextArea;

public class HiloEntrada extends Thread{
	InputStream inputStream;
	
	VistaChat vChat;
	
	public HiloEntrada(InputStream inputStream, VistaChat vChat) {
		// TODO Auto-generated constructor stub
		this.inputStream=inputStream;
		
		this.vChat=vChat;
	}
	
	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		JTextArea chat = vChat.chat;
		String textoChat="";
		String linea=null;
		try {
	
			do {
				
				linea=br.readLine();
				if(linea!=null ) {
				textoChat=textoChat + "\n"+linea;
				chat.setText(textoChat);
				}	
			//}while(linea!=null);
			}while(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	

	

}
