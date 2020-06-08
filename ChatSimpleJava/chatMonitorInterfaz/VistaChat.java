package chatMonitorInterfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VistaChat {
	
	/*
	 * Falta hacer la interfaz de iniciar sesion en el chat y despues desarrollar el controlador
	 */
	JFrame frame;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	Container container;
	JTextArea chat;
	JTextArea mensaje;
	JButton enviar;
	GridBagConstraints c;
	public VistaChat() {
		inicializar();
		colocar();
		
		
	}
	void registrarEventos(ControladorVentanaChat c) {
		enviar.addActionListener(c);
	}
	private void colocar() {
		// TODO Auto-generated method stub
		panel1.add(chat);
		panel2.add(mensaje);
		
		panel2.add(enviar);
		container.add(panel1);
		container.add(panel2);
		//container.add(panel3);
	}
	private void inicializar() {
		// TODO Auto-generated method stub
		frame= new JFrame("CHAT");
		frame.setLayout(new GridLayout(2, 1));
		
		frame.setBounds(400,100, 600, 400);
		
		
		container =frame.getContentPane();
		
		panel1= new JPanel();
		panel2=new JPanel(new FlowLayout());
		Color c = new Color(77, 183, 240);
		panel1.setBackground(c);
		panel2.setBackground(c);
		//panel3= new JPanel(new FlowLayout());
		enviar= new JButton("Enviar");
		chat= new JTextArea(200, 50);
		mensaje= new JTextArea(2,50);
		mensaje.setText("");
		mensaje.setTabSize(0);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
