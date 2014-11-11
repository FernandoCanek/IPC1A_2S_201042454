//import java.awt.event.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;



public class Ventana extends JFrame implements ActionListener{
	
	//AGREGANDO LA CLASE HOTEL
	
	Hotel primero = null;
	Cliente primerCliente = null;
	public int codigoCliente = 1;
	
	//BARRA MENU PRINCIPAL Y MENUS
	JMenuBar barraMenuPrincipal;
	JMenu hoteles, clientes, habitaciones, servicios, reservaciones;
	
	//SUBMENUS EN ORDEN
	JMenuItem nuevoHotel, seleccionarHotel, nuevoCliente, verClientes;
	
	JMenu otrosServicios;
		
	JMenu piscinas;
	JMenuItem piscinaAguaDulce, piscinaAguaSalada;
	
	JMenu bares;
	JMenuItem barLobby, discoBar;
	
	JMenu restaurantes;
	JMenuItem restauranteMayanPalace, restauranteMayanNights,restauranteMayanGrill, restauranteItalianNoodles, restauranteMediterraneanFlavor;
		
	JMenuItem enfermeria, gimnasio, longue, anfiteatro, clubDeNiños, MonsterSnack;
	
	JMenuItem verReservasActuales, crearNuevaReserva, checkIN, checkOUT;
	
	
	//PANEL DONDE SE VERA LA INFORMACIÓN
	ContenedorPrincipal contenedorPrincipal;
	
	
	//PANEL DE CREACION DE NUEVO HOTEL
	JLabel nombreNuevoHotel;
	JTextField nombreDadoNuevoHotel;
	
	JLabel nombrePaisNuevoHotel;
			//String[] opcionesPaisNuevoHotel = new String[5];
    JComboBox<String> ubicacionNuevoHotel;
    JButton botonCrearNuevoHotel;
    
    JLabel torre1, torre2, modulos;
    
    JLabel preguntaHabitacionesSencilas, preguntaHabitacionesDobles, preguntaHabitacionesEspeciales;
    JTextField numeroHabsSencillasT1, numeroHabsSencillasT2, numeroHabsSencillasMod; 
	JTextField numeroHabsDoblesT1, numeroHabsDoblesT2, numeroHabsDoblesMod;
	JTextField numeroHabsEspT1, numeroHabsEspT2, numeroHabsEspMod;
    JLabel espacioBlanco1, espacioBlanco2, espacioBlanco3,espacioBlanco4, espacioBlanco5, espacioBlanco6;
    JLabel espacioBlanco7, espacioBlanco8, espacioBlanco9, espacioBlanco10, espacioBlanco11, espacioBlanco12,espacioBlanco15;
    
	JPanel formularioCrearNuevoHotel;
	
	//JLABEL QUE INDICA NOMBRE DEL HOTEL
	JLabel nombreHotelActivo;
	
	//TABLA QUE MUESTRA LISTA DE HOTELES Y LA DE HABITACIONES
	JTable tablaHoteles;
	JPanel contenedorTablaHoteles;
	
	JTable tablaHabitaciones;
	JPanel contenedorTablaHabitaciones;
	JMenuItem verTablaHabitaciones;
	
	//Menu INGRESAR NUEVO CLIENTE
	
	JPanel menuNuevoCliente;
	JLabel nombreNuevoCliente, edadNuevoCliente;
	JTextField nombreDadoNuevoCliente, edadDadaNuevoCliente;
	JButton botonOkNuevoCliente;
	
	//TABLA QUE MUESTRA LA LISTA DE CLIENTES
	JTable tablaClientes;
	JPanel contenedorTablaClientes;

	//MENU CHECKIN
	JPanel menuCheckIN;
	JLabel codClienteIngreso, tipoHabitacion, numeroDiasCheckIN;
	JTextField codClienteIngresado, tipoHabitacionIngresada, numeroDiasDeseados;
	JButton botonOkCheckIN;
	
	//MENU CHECKOUT
	JPanel menuCheckout;
	JLabel codClienteEgreso, codigoHabitacion;
	JTextField codClienteEgresado, codigoHabitacionEgresada;
	JButton botonOkCheckOUT;
	
	//MENU RESTURANTES
	
	JPanel menuRestaurantes;
	JLabel nombreRestaurantes;
	JTextArea descripcionRestaurante;
	JButton okRestaurantes;
	private JButton okRestauranteMP;
	private JTextArea descripcionRestauranteMP;
	private JLabel nombreRestauranteMP;
	private JPanel menuRestauranteMP;
	private Container menuRestauranteMN;
	private AbstractButton okRestauranteMN;
	private JTextComponent descripcionRestauranteMN;
	private JLabel nombreRestauranteMN;
	private JPanel menuRestauranteMG;
	private JLabel nombreRestauranteMH;
	private JTextArea descripcionRestauranteMG;
	private JButton okRestauranteMG;
	private JLabel nombreRestauranteMG;
	private JPanel menuRestauranteIT;
	private JLabel nombreRestauranteIT;
	private JTextComponent descripcionRestauranteIT;
	private JButton okRestauranteIT;
	private JTextComponent descripcionRestauranteMF;
	private JLabel nombreRestauranteMF;
	private JButton okRestauranteMF;
	private Container menuRestauranteMF;
	private JPanel menuCreaPAD;
	private JLabel precioPAD;
	private JTextField capacidadDadaPAD;
	private JLabel capacidadPAD;
	private JTextField precioDadoPAD;
	private JPanel menuCreaPAS;
	private JLabel precioPAS;
	private JTextField capacidadDadaPAS;
	private JLabel capacidadPAS;
	private JTextField precioDadoPAS;
	private JButton botonOkPAD;
	private JButton botonOkPAS;
	private int contadorPiscinasPAD = 1;
	private int contadorPiscinasPAS = 1;
	
	public Ventana(){//------------------------------------------>>>INICIO DEL CONSTRUCTOR<<<------------
		
		super("Hoteles de Centro America - Sistema de Control");
		
		
		//INICIALIZANDO COMPONENTES DEL MENU
		barraMenuPrincipal = new JMenuBar();
		hoteles = new JMenu("Hoteles");
		clientes = new JMenu ("Clientes");
		habitaciones = new JMenu("Habitaciones");
		servicios = new JMenu ("Servicios");
		reservaciones = new JMenu("Reservaciones");
		
		
		nuevoHotel = new JMenuItem ("Crear nuevo hotel");
		seleccionarHotel = new JMenuItem ("Ver hoteles");
		verTablaHabitaciones = new JMenuItem("Control de Habitaciones");
		
		nuevoCliente = new JMenuItem("Cliente Nuevo");
		verClientes = new JMenuItem(" Clientes actuales");
		
		otrosServicios = new JMenu("Otros Servicios");
			
		piscinas = new JMenu("Piscinas");
		piscinaAguaDulce = new JMenuItem("Agua Dulce");
		piscinaAguaDulce.addActionListener(this);
		piscinaAguaSalada = new JMenuItem("Agua Salada");
		piscinaAguaSalada.addActionListener(this);
		
		bares = new JMenu("Bares");
		barLobby = new JMenuItem("Bar del Lobby");
		discoBar = new JMenuItem("Discoteca Bar");
		//RESTAURANTES-----------------------------------------------------------
		restaurantes = new JMenu("Restaurantes");
		restauranteMayanPalace = new JMenuItem("Mayan Palace");
		restauranteMayanPalace.addActionListener(this);
		
		restauranteMayanNights = new JMenuItem("Mayan Nights");
		restauranteMayanNights.addActionListener(this);

		restauranteMayanGrill = new JMenuItem("Mayan Grill");
		restauranteMayanGrill.addActionListener(this);

		restauranteItalianNoodles = new JMenuItem("Italian Noodles");
		restauranteItalianNoodles.addActionListener(this);

		restauranteMediterraneanFlavor = new JMenuItem("Mediterranean FLavor");
		restauranteMediterraneanFlavor.addActionListener(this);

		
		
		
		enfermeria = new JMenuItem("Enfermería");
		gimnasio = new JMenuItem("Gimnasio");
		longue = new JMenuItem("Longue");
		anfiteatro = new JMenuItem("Anfiteatro");
		clubDeNiños = new JMenuItem("Club de niños");
		MonsterSnack = new JMenuItem("Monster Snack");
		
		checkIN = new JMenuItem("Check - In");
		checkOUT = new JMenuItem("Check - Out");
		crearNuevaReserva = new JMenuItem("Crear una nueva Reservación");
		verReservasActuales = new JMenuItem("Consultar Reservaciones Actuales");

		
		//INICIA AGREGANDO LOS ELEMENTOS DE MENU
		hoteles.add(nuevoHotel);
		hoteles.add(seleccionarHotel);
		hoteles.add(verTablaHabitaciones);
		barraMenuPrincipal.add(hoteles);
		
		
		clientes.add(nuevoCliente);
		clientes.add(verClientes);
		barraMenuPrincipal.add(clientes);
		
		piscinas.add(piscinaAguaDulce);
		piscinas.add(piscinaAguaSalada);
		servicios.add(piscinas);
		
		bares.add(barLobby);
		bares.add(discoBar);
		servicios.add(piscinas);
		
		restaurantes.add(restauranteMayanPalace);
		restaurantes.add(restauranteMayanNights);
		restaurantes.add(restauranteMayanGrill);
		restaurantes.add(restauranteItalianNoodles);
		restaurantes.add(restauranteMediterraneanFlavor);
		servicios.add(restaurantes);
		
		otrosServicios.add(enfermeria);
		otrosServicios.add(gimnasio);
		otrosServicios.add(longue);
		otrosServicios.add(anfiteatro);
		otrosServicios.add(clubDeNiños);
		otrosServicios.add(MonsterSnack);
		servicios.add(otrosServicios);
		
		barraMenuPrincipal.add(servicios);
		
		reservaciones.add(checkIN);
		reservaciones.add(checkOUT);
		reservaciones.add(crearNuevaReserva);
		reservaciones.add(verReservasActuales);
		barraMenuPrincipal.add(reservaciones);
		
		//
		
		
		setJMenuBar(barraMenuPrincipal);
		
		contenedorPrincipal = new ContenedorPrincipal("/fondo.jpg");
		//contenedorPrincipal.setLayout(new );
		
		//AGREGANDO EVENTOS DEL MENU
			
		nuevoHotel.addActionListener(this);
		seleccionarHotel.addActionListener(this);
		verTablaHabitaciones.addActionListener(this);
		nuevoCliente.addActionListener(this);
		verClientes.addActionListener(this);
		checkIN.addActionListener(this);
		//CREANDO PANEL NUEVO HOTEL
		
		formularioCrearNuevoHotel = new JPanel();
		formularioCrearNuevoHotel.setLayout(new GridLayout(7, 6, 10, 10));
		
		nombreNuevoHotel = new JLabel("¿NOMBRE DEL NUEVO HOTEL?");
		nombreDadoNuevoHotel = new JTextField();
		
		nombrePaisNuevoHotel = new JLabel("¿PAIS?");
		String[] opcionesPaisNuevoHotel = {"Guatemala", "El Salvador", "Honduras", "Costa Rica", "Panama"};
	    ubicacionNuevoHotel = new JComboBox<String>(opcionesPaisNuevoHotel);
	    
	    espacioBlanco1 = new JLabel();
	    espacioBlanco2 = new JLabel();
	    espacioBlanco3 = new JLabel();
	    espacioBlanco4 = new JLabel();
	    espacioBlanco5 = new JLabel();
	    espacioBlanco6 = new JLabel();
	    espacioBlanco7 = new JLabel();
	    espacioBlanco8 = new JLabel();
	    espacioBlanco9 = new JLabel();
	    espacioBlanco10 = new JLabel();
	    espacioBlanco11 = new JLabel();
	    espacioBlanco12 = new JLabel();   
	    
	    torre1 = new JLabel("Torre 1 (250 totales)");
	    torre2 = new JLabel("Torre 2 (250 totales)");
	    modulos = new JLabel("Modulos (50 totales)");
	    torre1.setToolTipText("Torre numero 1 del hotel, cuenta con 250 espacios, escriba el numero de habitaciones sencillas, dobles y especiales que desea");	    
	    torre2.setToolTipText("Torre numero 2 del hotel, cuenta con 250 espacios, escriba el numero de habitaciones sencillas, dobles y especiales que desea");
	    modulos.setToolTipText("Los modulos son 17, y en total hay 50 espacios, escriba el numero de habitaciones sencillas, dobles y especiales que desea");
	    
	    preguntaHabitacionesSencilas = new JLabel("Numero habitaciones sencillas");
	    numeroHabsSencillasT1 = new JTextField(2);
	    numeroHabsSencillasT2 = new JTextField(2);
	    numeroHabsSencillasMod = new JTextField(2);
	    	    
	    preguntaHabitacionesDobles = new JLabel("Numero habitaciones dobles");
	    numeroHabsDoblesT1 = new JTextField(2);
	    numeroHabsDoblesT2 = new JTextField(2);
	    numeroHabsDoblesMod = new JTextField(2);
	    
	    preguntaHabitacionesEspeciales = new JLabel("Numero habitaciones especiales");
	    numeroHabsEspT1 = new JTextField(2);
	    numeroHabsEspT2 = new JTextField(2);
	    numeroHabsEspMod = new JTextField(2);  	    
	    
	    botonCrearNuevoHotel = new JButton("Crear el Nuevo Hotel");
	    botonCrearNuevoHotel.addActionListener(this);
		
		formularioCrearNuevoHotel.add(nombreNuevoHotel);
		formularioCrearNuevoHotel.add(nombreDadoNuevoHotel);
		formularioCrearNuevoHotel.add(espacioBlanco1);
		formularioCrearNuevoHotel.add(espacioBlanco2);
		formularioCrearNuevoHotel.add(espacioBlanco3);
		formularioCrearNuevoHotel.add(nombrePaisNuevoHotel);
		formularioCrearNuevoHotel.add(ubicacionNuevoHotel);
		formularioCrearNuevoHotel.add(espacioBlanco4);
		formularioCrearNuevoHotel.add(espacioBlanco5);		
		formularioCrearNuevoHotel.add(espacioBlanco6);
		formularioCrearNuevoHotel.add(espacioBlanco7);
		//formularioCrearNuevoHotel.add(espacioBlanco8);
		formularioCrearNuevoHotel.add(torre1);
		formularioCrearNuevoHotel.add(torre2);
		formularioCrearNuevoHotel.add(modulos);
		formularioCrearNuevoHotel.add(espacioBlanco9);
		formularioCrearNuevoHotel.add(preguntaHabitacionesSencilas);
		formularioCrearNuevoHotel.add(numeroHabsSencillasT1);
		formularioCrearNuevoHotel.add(numeroHabsSencillasT2);
		formularioCrearNuevoHotel.add(numeroHabsSencillasMod);	
		formularioCrearNuevoHotel.add(espacioBlanco10);
		formularioCrearNuevoHotel.add(preguntaHabitacionesDobles);
		formularioCrearNuevoHotel.add(numeroHabsDoblesT1);
		formularioCrearNuevoHotel.add(numeroHabsDoblesT2);
		formularioCrearNuevoHotel.add(numeroHabsDoblesMod);
		formularioCrearNuevoHotel.add(espacioBlanco11);
		formularioCrearNuevoHotel.add(preguntaHabitacionesEspeciales);
		formularioCrearNuevoHotel.add(numeroHabsEspT1);
		formularioCrearNuevoHotel.add(numeroHabsEspT2);
		formularioCrearNuevoHotel.add(numeroHabsEspMod);
		formularioCrearNuevoHotel.add(espacioBlanco12);
		formularioCrearNuevoHotel.add(botonCrearNuevoHotel);
		formularioCrearNuevoHotel.setVisible(false);
		
		contenedorPrincipal.add(formularioCrearNuevoHotel);
		nombreHotelActivo = new JLabel();
		contenedorPrincipal.add(nombreHotelActivo);

		//TABLA DE HOTELES Y HABITACIONES
		
		contenedorTablaHoteles = new JPanel();
		tablaHoteles = new JTable();
		contenedorPrincipal.add(tablaHoteles);
		contenedorTablaHoteles.setVisible(false);
		contenedorPrincipal.add(contenedorTablaHoteles);
		
		contenedorTablaHabitaciones = new JPanel();
		tablaHabitaciones = new JTable();
		contenedorPrincipal.add(tablaHabitaciones);
		contenedorTablaHabitaciones.setVisible(false);
		contenedorPrincipal.add(contenedorTablaHabitaciones);
		
		
		//MENU INGRESO NUEVO CLIENTE
		menuNuevoCliente = new JPanel();
		menuNuevoCliente.setLayout(new GridLayout(4, 2, 10, 10));
		JLabel tituloMenuNuevoCliente = new JLabel("INGRESE LOS DATOS DEL NUEVO CLIENTE");
		botonOkNuevoCliente = new JButton("OK");
		botonOkNuevoCliente.addActionListener(this);
		nombreNuevoCliente = new JLabel("Nombre");
		edadNuevoCliente = new JLabel("Edad");
		nombreDadoNuevoCliente = new JTextField();
		edadDadaNuevoCliente = new JTextField();
		espacioBlanco15 = new JLabel();
		
		menuNuevoCliente.add(tituloMenuNuevoCliente);
		menuNuevoCliente.add(espacioBlanco15);
		menuNuevoCliente.add(nombreNuevoCliente);
		menuNuevoCliente.add(nombreDadoNuevoCliente);
		menuNuevoCliente.add(edadNuevoCliente);
		menuNuevoCliente.add(edadDadaNuevoCliente);
		menuNuevoCliente.add(botonOkNuevoCliente);
		
		menuNuevoCliente.setVisible(false);
		contenedorPrincipal.add(menuNuevoCliente);
		
		//TABLA DE CLIENTES
		contenedorTablaClientes = new JPanel();
		tablaClientes = new JTable();
		contenedorPrincipal.add(tablaClientes);
		contenedorTablaHoteles.setVisible(false);
		contenedorPrincipal.add(contenedorTablaClientes);
		
		//MENU INGRESO CHECKIN
		menuCheckIN = new JPanel();
		menuCheckIN.setLayout(new GridLayout(3, 2, 10, 10));
		
		codClienteIngreso = new JLabel("Codigo cliente a ingresar");
		tipoHabitacion = new JLabel("tipo de habitacion deseada");
		numeroDiasCheckIN = new JLabel("Dias de estancia");
		
		codClienteIngresado = new JTextField();
		tipoHabitacionIngresada = new JTextField();
		numeroDiasDeseados = new JTextField();;
		botonOkCheckIN = new JButton("OK");
		botonOkCheckIN.addActionListener(this);
		
		menuCheckIN.add(codClienteIngreso);
		menuCheckIN.add(codClienteIngresado);
		menuCheckIN.add(tipoHabitacion);
		menuCheckIN.add(tipoHabitacionIngresada);
		menuCheckIN.add(numeroDiasCheckIN);
		menuCheckIN.add(numeroDiasDeseados);
		menuCheckIN.add(botonOkCheckIN);
		menuCheckIN.setVisible(false);
		contenedorPrincipal.add(menuCheckIN);
		
		
		//MENU INGRESO CHECKOUT
				menuCheckout = new JPanel();
				menuCheckout.setLayout(new GridLayout(3, 2, 10, 10));
				
				codClienteEgreso = new JLabel("Codigo cliente a egresar");
				codigoHabitacion = new JLabel("tipo de habitacion usada");
								
				codClienteEgresado = new JTextField();
				codigoHabitacionEgresada = new JTextField();
				
				botonOkCheckOUT = new JButton("OK");
				botonOkCheckOUT.addActionListener(this);
				
				menuCheckIN.add(codClienteEgreso);
				menuCheckIN.add(codClienteEgresado);
				menuCheckIN.add(codigoHabitacion);
				menuCheckIN.add(codigoHabitacionEgresada);
				menuCheckIN.add(botonOkCheckOUT);
				menuCheckIN.setVisible(false);
				contenedorPrincipal.add(menuCheckout);
				
				
		//INGRESO MENU RESTAURANTES MP
				
				menuRestauranteMP = new JPanel();
				menuRestauranteMP.setLayout(new GridLayout(3,1, 10, 10));
				

				nombreRestauranteMP = new JLabel("RESTAURANTE MAYAN PALACE");
				nombreRestauranteMP.setBounds(getWidth()/2, getHeight()/2, 50, 50);
				
				descripcionRestauranteMP = new JTextArea("Ofrece desayunos, almuerzos y cenas internacionales tipo buffet en una estructurav "
						+ "+abierta de dos pisos mirando hacia la piscina principal y el Océano Pacífico. La influencia Maya es evidente "
						+ "en las lámparas artesanas y la estatua maya de 2 pisos de alto en el centro de dicho espacio");
				descripcionRestauranteMP.setEditable(false);
				
				okRestauranteMP = new JButton("OK");
				okRestauranteMP.addActionListener(this);
				
				menuRestauranteMP.add(nombreRestauranteMP);
				menuRestauranteMP.add(descripcionRestauranteMP);
				menuRestauranteMP.add(okRestauranteMP);
				menuRestauranteMP.setVisible(false);
				contenedorPrincipal.add(menuRestauranteMP);
				
				
				//INGRESO MENU RESTAURANTES MN
				
				menuRestauranteMN = new JPanel();
				menuRestauranteMN.setLayout(new GridLayout(3,1, 10, 10));
				

				nombreRestauranteMN = new JLabel("RESTAURANTE MAYAN NIGHTS");
				
				descripcionRestauranteMN = new JTextArea("Ofrece deliciosas cenas Thai a la carta bajo los murales mayas cerca del mar");
				descripcionRestauranteMN.setEditable(false);
				
				okRestauranteMN = new JButton("OK");
				okRestauranteMN.addActionListener(this);
				
				menuRestauranteMN.add(nombreRestauranteMN);
				menuRestauranteMN.add(descripcionRestauranteMN);
				menuRestauranteMN.add(okRestauranteMN);
				menuRestauranteMN.setVisible(false);
				contenedorPrincipal.add(menuRestauranteMN);
				
				
				//INGRESO MENU RESTAURANTES MG
				
				menuRestauranteMG = new JPanel();
				menuRestauranteMG.setLayout(new GridLayout(3,1, 10, 10));
				

				nombreRestauranteMG = new JLabel("RESTAURANTE MAYAN GRILLS");
				
				descripcionRestauranteMG = new JTextArea("Se especializa en carnes y otros elementos a la parrilla. Ubicados a un costado de la"
						+ "playa, Mayan Grill ofrece tanto aperitivos como un completo menú de cenas a la carta");
				descripcionRestauranteMG.setEditable(false);
				
				okRestauranteMG = new JButton("OK");
				okRestauranteMG.addActionListener(this);
				
				menuRestauranteMG.add(nombreRestauranteMG);
				menuRestauranteMG.add(descripcionRestauranteMG);
				menuRestauranteMG.add(okRestauranteMG);
				menuRestauranteMG.setVisible(false);
				contenedorPrincipal.add(menuRestauranteMG);
				
				//INGRESO MENU RESTAURANTES IT
				
				menuRestauranteIT = new JPanel();
				menuRestauranteIT.setLayout(new GridLayout(3,1, 10, 10));
				

				nombreRestauranteIT = new JLabel("RESTAURANTE ITALIAN NOODLES");
				
				descripcionRestauranteIT = new JTextArea("Ofrece un auténtico y único menú de pastas con un toque jamaiquino");
				descripcionRestauranteIT.setEditable(false);
				
				okRestauranteIT = new JButton("OK");
				okRestauranteIT.addActionListener(this);
				
				menuRestauranteIT.add(nombreRestauranteIT);
				menuRestauranteIT.add(descripcionRestauranteIT);
				menuRestauranteIT.add(okRestauranteIT);
				menuRestauranteIT.setVisible(false);
				contenedorPrincipal.add(menuRestauranteIT);
				
				
				//INGRESO MENU RESTAURANTES MF
				
				menuRestauranteMF = new JPanel();
				menuRestauranteMF.setLayout(new GridLayout(3,1, 10, 10));
				

				nombreRestauranteMF = new JLabel("RESTAURANTE MEDITERRANEAN FLAVOR");
				
				descripcionRestauranteMF = new JTextArea("Se encuentra entre los frondosos jardines cerca del lobby principal del hotel. "
						+ "Losmenús mezclan los sabores Mediterráneos con una variedad de otros sabores internacionales");
				descripcionRestauranteMF.setEditable(false);
				
				okRestauranteMF = new JButton("OK");
				okRestauranteMF.addActionListener(this);
				
				menuRestauranteMF.add(nombreRestauranteMF);
				menuRestauranteMF.add(descripcionRestauranteMF);
				menuRestauranteMF.add(okRestauranteMF);
				menuRestauranteMF.setVisible(false);
				contenedorPrincipal.add(menuRestauranteMF);
				contenedorPrincipal.add(menuRestauranteMF);

				//INGRESO MENU RESTAURANTES PISCINAS AGUA DULCE
				
				menuCreaPAD = new JPanel();
				capacidadPAD = new JLabel("Capacidad");
				precioPAD = new JLabel("Precio");
				capacidadDadaPAD = new JTextField();
				precioDadoPAD = new JTextField();
				botonOkPAD = new JButton("OK");
				botonOkPAD.addActionListener(this);
				menuCreaPAD.setLayout(new GridLayout(3,2,10,10));
				menuCreaPAD.add(capacidadPAD);
				menuCreaPAD.add(capacidadDadaPAD);
				menuCreaPAD.add(precioPAD);
				menuCreaPAD.add(precioDadoPAD);
				menuCreaPAD.add(botonOkPAD);
				menuCreaPAD.setVisible(false);
				contenedorPrincipal.add(menuCreaPAD);
				
				//INGRESO MENU RESTAURANTES PISCINAS AGUA SALADA
				
				menuCreaPAS = new JPanel();
				capacidadPAS = new JLabel("Capacidad");
				precioPAS = new JLabel("Precio");
				capacidadDadaPAS = new JTextField();
				precioDadoPAS = new JTextField();
				botonOkPAS = new JButton("OK");
				botonOkPAS.addActionListener(this);
				menuCreaPAS.setLayout(new GridLayout(3,2,10,10));
				menuCreaPAS.add(capacidadPAS);
				menuCreaPAS.add(capacidadDadaPAS);
				menuCreaPAS.add(precioPAS);
				menuCreaPAS.add(precioDadoPAS);
				menuCreaPAS.add(botonOkPAS);
				menuCreaPAS.setVisible(false);
				contenedorPrincipal.add(menuCreaPAS);
				
		setContentPane(contenedorPrincipal);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] a){
		Ventana v = new Ventana();
		v.pack();
		v.setSize(600,480);
		v.setVisible(true);
		
	}



	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==nuevoHotel){
			
			formularioCrearNuevoHotel.setVisible(true);			
			
			System.out.println("SI FUNCIONA!!!");
			
		}else if(e.getSource()==botonCrearNuevoHotel){
			
			System.out.println("sigue funcionando :3");
			
			int [] T1 = new int[3];
			int [] T2 = new int[3];
			int [] Mod = new int[3];
			
			T1[0] = Integer.parseInt(numeroHabsSencillasT1.getText());
			T1[1] = Integer.parseInt(numeroHabsDoblesT1.getText());
			T1[2] = Integer.parseInt(numeroHabsEspT1.getText());
			
			T2[0] = Integer.parseInt(numeroHabsSencillasT2.getText());
			T2[1] = Integer.parseInt(numeroHabsDoblesT2.getText());
			T2[2] = Integer.parseInt(numeroHabsEspT2.getText());
			
			Mod[0] = Integer.parseInt(numeroHabsSencillasMod.getText());
			Mod[1] = Integer.parseInt(numeroHabsDoblesMod.getText());
			Mod[2] = Integer.parseInt(numeroHabsEspMod.getText());
			
			
			String nombre = nombreDadoNuevoHotel.getText();
			String pais = String.valueOf(ubicacionNuevoHotel.getSelectedItem());
			
			if(primero == null){
				primero = new Hotel(nombre, pais, null, T1, T2, Mod);
			}else{
				primero = new Hotel(nombre, pais, primero, T1, T2, Mod);
			}
			
			//System.out.println("su nombre es " + primero.nombre + "Y SU PAIS ES " +primero.pais);
			
			formularioCrearNuevoHotel.setVisible(false);
			
			nombreHotelActivo.setText("Hotel actual: " + primero.nombre +" --- Ubicación: "+primero.pais);
	
		}else if(e.getSource()==seleccionarHotel){
			
			muestraHoteles();
			contenedorTablaHoteles.setVisible(true);
			
		}else if(e.getSource() == verTablaHabitaciones){//COMENTAR ESTE PEQUEÑO PROBLEMA
			
				muestraHabitaciones();
				contenedorTablaHabitaciones.setVisible(true);
			
		}else if(e.getSource()==nuevoCliente){
			menuNuevoCliente.setVisible(true);
		
		}else if(e.getSource() == botonOkNuevoCliente){
			
			creaNuevoCliente();
			
		}else if(e.getSource() == verClientes){
			
			muestraClientes();
			contenedorTablaClientes.setVisible(true);
			
		}else if(e.getSource()==checkIN){
			
			menuCheckIN.setVisible(true);
		}else if(e.getSource()==botonOkCheckIN){
			
			int codigoCliente = Integer.parseInt(codClienteIngresado.getText());
			int tipoHabitacion = Integer.parseInt(tipoHabitacionIngresada.getText());
			int numeroDias = Integer.parseInt(numeroDiasDeseados.getText());
			
			ingresaCliente(codigoCliente, tipoHabitacion, numeroDias);
			
			Cliente tmp1 = primerCliente;
			Habitacion tmp2 = primero.primera;
			
			
			for(int i = 0; i<codigoCliente;i++){
				if(i==tmp1.codigoCliente){
					for(int j= 0; j<tipoHabitacion; j++){
						if(j==tmp2.tipo){
							tmp2.ocupacion = true;
							int factura = tmp1.cuenta(numeroDias, tmp2.precio);
							JOptionPane.showMessageDialog(null, "La cuenta es "+factura);
						}else{
							tmp2 = tmp2.siguiente;
						}
					}
				}else{
					tmp1= tmp1.siguiente;
				}
			}
			
			menuCheckIN.setVisible(false);
			
		}else if(e.getSource()==menuCheckout){
			
			int codigoCliente = Integer.parseInt(codClienteEgresado.getText());
			int tipoHabitacion = Integer.parseInt(codigoHabitacionEgresada.getText());
						
			//egresaCliente(codigoCliente, codigoHabitacion);
			menuCheckout.setVisible(false);
		}else if(e.getSource()==restauranteMayanPalace){
			
			menuRestauranteMP.setVisible(true);
			
		}else if(e.getSource()==restauranteMayanNights){
			
			menuRestauranteMN.setVisible(true);

			
		}else if(e.getSource()==restauranteMayanGrill){
			
			menuRestauranteMG.setVisible(true);

			
		}else if(e.getSource()==restauranteItalianNoodles){
			
			menuRestauranteIT.setVisible(true);

			
		}else if(e.getSource()==restauranteMediterraneanFlavor){
			
			menuRestauranteMF.setVisible(true);

			
		}else if(e.getSource()==okRestauranteMP){
			menuRestauranteMP.setVisible(false);
		}else if(e.getSource()==okRestauranteMN){
			menuRestauranteMF.setVisible(false);
		}else if(e.getSource()==okRestauranteMG){
			menuRestauranteMG.setVisible(false);
		}else if(e.getSource()==okRestauranteIT){
			menuRestauranteIT.setVisible(false);
		}else if(e.getSource()==okRestauranteMF){
			menuRestauranteMF.setVisible(false);
		}else if(e.getSource() == piscinaAguaDulce){
			menuCreaPAD.setVisible(true);
		}else if(e.getSource()==piscinaAguaSalada){
			menuCreaPAS.setVisible(true);
		}else if(e.getSource()==botonOkPAD){
			menuCreaPAD.setVisible(false);
			JOptionPane.showMessageDialog(null, "Nueva Piscina de Agua Dulce numero "+contadorPiscinasPAD+"\nCapacidad " +capacidadDadaPAS.getText()+"\nPrecio" +precioDadoPAS.getText());
			contadorPiscinasPAD++;
		}else if(e.getSource()==botonOkPAS){
			menuCreaPAS.setVisible(false);
			JOptionPane.showMessageDialog(null, "Nueva Piscina de Agua Dulce numero "+contadorPiscinasPAS+"\nCapacidad " +capacidadDadaPAS.getText()+"\nPrecio" +precioDadoPAS.getText());
			contadorPiscinasPAS++;
		}
		
		
		
	}
	
	
	public void creaNuevoCliente(){
		
		String nombre = nombreDadoNuevoCliente.getText();
		int edad = Integer.parseInt(edadDadaNuevoCliente.getText());
			
		if(primerCliente == null){
			
			primerCliente = new Cliente(nombre, edad, codigoCliente, 1, null);
			
			
		}else{
			
			primerCliente = new Cliente(nombre, edad, codigoCliente, 1, primerCliente);
			
		}
		codigoCliente++;
		
		menuNuevoCliente.setVisible(false);
		String mensaje ="NUEVO CLIENTE INGRESADO "+"\nNombre: " + primerCliente.nombre+
				"\nEdad: "+primerCliente.edad + "\nCodigo: "+primerCliente.codigoCliente
				+"\nEstado: "+primerCliente.estado;
		
		
		
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void ingresaCliente(int codigoCliente, int tipoHabitacion, int numeroDias){
		
		
		
		
		Cliente tmp1 = primerCliente;
		Hotel tmp2 = primero;
		Habitacion tmp3 = tmp2.primera;
		
		/**while(tmp1 != null){
			
			if(tmp1.codigoCliente == codigoCliente){
				while(tmp3 != null){
					if(tmp3.tipo == tipoHabitacion){
						tmp3.ocupacion = true;
					}else{
						tmp3 = tmp3.siguiente;
					}
				}
				//JOptionPane.showMessageDialog(null, "Usuario ingresado, la cuenta total es: "+String.valueOf(tmp1.cuenta(numeroDias, tmp3.precio)));
				
			}else{
				tmp1 = tmp1.siguiente;
			}
			
		}**/
		
		
		for(int i = 0; i<codigoCliente;i++){
			if(i==tmp1.codigoCliente){
				for(int j= 0; j<tipoHabitacion; j++){
					if(j==tmp3.tipo){
						tmp3.ocupacion = true;
						int factura = tmp1.cuenta(numeroDias, tmp3.precio);
						JOptionPane.showMessageDialog(null, "La cuenta es "+factura);
					}
				}
			}
		}
	}
	
	public void egresaCliente(int codigoClienteEgresado, int codigoHabitacion){
		JOptionPane.showMessageDialog(null, "usuario egresado");
	}
	
	public void muestraHoteles(){
		
		DefaultTableModel modelo = new DefaultTableModel();
		tablaHoteles.setModel(modelo);
		
		modelo.addColumn("No.");
		modelo.addColumn("Nombre");
		modelo.addColumn("Pais");
		modelo.addColumn("Detalles");
		
		
		int cont = 1;
		Hotel tmp = primero;
		
		while(tmp != null){
			
			Object[] objetos = new Object[4];
			objetos[0] = String.valueOf(cont);
			objetos[1] = tmp.nombre;
			objetos[2] = tmp.pais;
			objetos[3] = "Detalles";
			modelo.addRow(objetos);
			cont = cont + 1;
			tmp = tmp.siguiente;
			
		}
		
		
	}

	public void muestraHabitaciones(){
		
		DefaultTableModel modelo = new DefaultTableModel();
		tablaHoteles.setModel(modelo);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Ubicacion");
		modelo.addColumn("Precio");
		modelo.addColumn("Ocupacion");
		
		
		int cont = 1;
		Hotel tmp = primero;
		Habitacion temp = tmp.primera;
		
		while(temp != null){
			
			Object[] objetos = new Object[4];
			objetos[0] = temp.numeroHabitacion;
			objetos[1] = temp.ubicacion;
			objetos[2] = temp.precio;
			objetos[3] = temp.ocupacion;
			modelo.addRow(objetos);
			cont=cont+1;
			temp = temp.siguiente;
			
		}
		
		
	}
	
	public void muestraClientes(){
		
		DefaultTableModel modelo = new DefaultTableModel();
		tablaHoteles.setModel(modelo);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Edad");
		modelo.addColumn("Estado");
		modelo.addColumn("Saldo de Cuenta");
		
		
		int cont = 1;
		Cliente tmp = primerCliente;
				
		while(tmp != null){
			
			Object[] objetos = new Object[5];
			objetos[0] = tmp.codigoCliente;
			objetos[1] = tmp.nombre;
			objetos[2] = tmp.edad;
			objetos[3] = tmp.estado;
			objetos[4] = tmp.cuenta;
			modelo.addRow(objetos);
			cont=cont+1;
			tmp = tmp.siguiente;
			
		}
	}
	
}


class ContenedorPrincipal extends JPanel{
	
	ImageIcon imagenFondo;
	String nombre;
	
	public ContenedorPrincipal(String nombre){
		
		this.nombre = nombre;
		
	}
	
	public void paint(Graphics g){
		Dimension tamanio = getSize();
		imagenFondo = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paint(g);
	}
	
	
}





