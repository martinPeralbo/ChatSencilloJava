package chatMonitorInterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorVentanaChat implements ActionListener {

	VistaChat v;
	boolean botonEnviarPulsado;
	
	public ControladorVentanaChat(VistaChat v){
		this.v =v;
		botonEnviarPulsado=false;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String orden=e.getActionCommand();
		if(orden.equals("Enviar")) {
			if(v.mensaje.getText().equals("")) {
				JOptionPane.showMessageDialog(v.frame, "No se puede enviar un mensaje vacio");
			}else {
				
//				if(v.mensaje.getText().equals("adios")) {
//					v.mensaje.setEnabled(false);
//					v.enviar.setEnabled(false);
//				}
				botonEnviarPulsado=true;
				
				
			}
			
		}
	}
	
}
