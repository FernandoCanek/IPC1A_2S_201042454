import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;




public class Ventana {
	JFrame frame= new JFrame();
	
	JMenuBar menubar= new JMenuBar();
	JMenu menu= new JMenu("Menu");
	JMenuItem abrir= new JMenuItem("Abrir");
	JMenuItem guardar= new JMenuItem("Guardar");
	JMenuItem salir= new JMenuItem("Salir");
	JTextArea texto= new JTextArea("");
	
	JTextArea textarea= new JTextArea();
	JLabel nombretext= new JLabel();
	
	public  Ventana()
	{
		frame.setTitle("Train Simulator 1885");   
		frame.setSize(1000, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(textarea);
		frame.add(nombretext);
		frame.add(menubar);
		textarea.setVisible(false);
		textarea.setBounds(10, 50, 900, 250);
		nombretext.setVisible(true);
		nombretext.setBounds(25, 30, 900, 10);

		
		menubar.add(menu);
		menubar.setBounds(0, 0, 1000, 20);
		menu.add(abrir=new JMenuItem("Abrir"));
		menu.add(guardar=new JMenuItem("Guardar"));
		menu.add(salir= new JMenuItem("Salir"));
		
		
		Abrir open=new Abrir();
		abrir.addActionListener(open);
		Guardar save= new Guardar();
		guardar.addActionListener(save);
		Salir exit=new Salir();
		salir.addActionListener(exit);
		
	}
	
	private class Abrir implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			JFileChooser seleccionar = new JFileChooser();
			seleccionar.setCurrentDirectory(new java.io.File("."));
			seleccionar.setDialogTitle("Directorio");
			seleccionar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			seleccionar.setAcceptAllFileFilterUsed(false);
			
			if (seleccionar.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				//System.out.println("Directorio: " + seleccionar.getCurrentDirectory());
				nombretext.setText(seleccionar.getSelectedFile()+"");
				textarea.setVisible(true);		
				String ruta1="";
				ruta1=nombretext.getText();
				
				String infor="";
				try{
					String line;
					FileInputStream is = new FileInputStream(ruta1);
					DataInputStream ds =new DataInputStream(is);
					while((line=ds.readLine())!=null){
						infor=infor+line+"\n";
						
					}
					ds.close();
					is.close();
					}
				catch(IOException evr){
					System.out.println("Error de archivo "+evr);
				}
				textarea.setText(infor);
				} else {
				textarea.setVisible(false);
		}
		
	}
		
 }
	//Metodo Guardar
	private class Guardar implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String ruta2;
			String agregar;
			agregar=textarea.getText();
			ruta2=nombretext.getText();
			try{
			FileOutputStream os= new FileOutputStream(ruta2);
			os.write(agregar.getBytes());
			os.close();
		   }catch(IOException ev){
				System.out.println("Error de Archivo "+ ev);
				
			}
			
		}
			
		}
		
	
	//Metodo Salir
	private class Salir implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		e = (JButton) e.getSource();
		
	}*/
 
}
