

public class Hotel {

	public final String nombre; //SERA DADO AL INICIO
	public final String pais; //SERA DADO AL INICIO
	public int[] torre1 = new int[3]; //3 VALORES PARA CONOCER LOS 3 TIPOS DE HABITACION
	public int[] torre2 = new int[3];
	public int[] modulos = new int[3];
	int codigoHabitacion = 0; //FUNCIONARÁ COMO EL CONTADOR DEL NUMERO DE HABITACIONES
	
	public Habitacion primera; //HOTEL FUNCIONA COMO UNA LISTA DE HABITACIONES (NODOS)
	
	public Hotel siguiente; //HOTEL A SU VEZ ES NODO DE LA LISTA VENTANA, AQUÍ EL SIGUIENTE NODO
	
	public Hotel(String nombre, String pais, Hotel siguiente, int[] torre1, int[] torre2, int[] modulos){
		
		this.nombre = nombre;
		this.pais = pais;
		this.torre1 = torre1;
		this.torre2 = torre2;
		this.modulos = modulos;
		
		creaHabitaciones(torre1, torre2, modulos);
				
		this.siguiente = siguiente;
		
		
	}
	
	
	public void creaHabitaciones(int[] torre1, int[] torre2, int[] modulos){
		
		int a = torre1[0];
		int b = torre1[1];
		int c = torre1[2];
		
		int d = torre2[0];
		int e = torre2[1];
		int f = torre2[2];
		
		int g = modulos[0];
		int h = modulos[1];
		int i = modulos[2];
		
		//AGREGANDO HABITACIONES A TORRE1
		do{	
			agregaHabitacion(codigoHabitacion, false, "Torre 1", 1);
			codigoHabitacion++;
			a = a-1;
		}while(a>0);
		
		do{
			agregaHabitacion(codigoHabitacion, false, "Torre 1", 2);
			codigoHabitacion++;
			b = b-1;
			
		}while(b>0);
			
		do{
			agregaHabitacion(codigoHabitacion, false, "Torre 1", 3);
			codigoHabitacion++;
			c = c-1;
		}while(c>0);


		//AGREGANDO HABITACIONES A TORRE 2
		do{
			agregaHabitacion(codigoHabitacion, false, "Torre 2", 1);
			codigoHabitacion++;
			d = d-1;
		}while(d>0);
			
		
		do{
			agregaHabitacion(codigoHabitacion, false, "Torre 2", 2);
			codigoHabitacion++;
			e = e-1;
		}while(e>0);

		
		do{
			agregaHabitacion(codigoHabitacion, false, "Torre 2", 3);
			codigoHabitacion++;
			f = f-1;
		}while(f>0);

		//AGREGANDO HABITACIONES A MODULOS
		do{
			agregaHabitacion(codigoHabitacion, false, "Modulos", 1);
			codigoHabitacion++;
			g = g-1;
		}while(g>0);

		
		do{
			agregaHabitacion(codigoHabitacion, false, "Modulos", 2);
			codigoHabitacion++;
			h = h-1;
		}while(h>0);

		
		do{
			agregaHabitacion(codigoHabitacion, false, "Modulos", 3);
			codigoHabitacion++;
			i = i-1;
			System.out.println("SEGUIMOS BIEN :3");
			System.out.println("El ultimo codigo de habitacion es" + primera.numeroHabitacion);
		}while(i>0);

		
	}
	
	
	public void agregaHabitacion(int codigoHabitacion, boolean ocupacion, String ubicacion, int tipo){
		
		if(primera == null){
			primera = new Habitacion(codigoHabitacion, ocupacion, ubicacion, tipo, null);
		}else{
			primera = new Habitacion(codigoHabitacion, ocupacion, ubicacion, tipo, primera);
		}
		
	}
	
	
	
}
