
public class Habitacion {

	public final int numeroHabitacion;
	public boolean ocupacion = false;
	public final int capacidad = 4;//EN EL ENUNCIADO DECIA QUE INDEPENDIENTE DEL TIPO DE HABITACION, SIEMPRE ES PARA 4 PERSONAS
	public final String ubicacion;
	
	final int SENCILLA = 1;
	final int DOBLE = 2;
	final int ESPECIAL = 3;
	
	public final int numeroCamas = 4;
	public int precio;
	public int tipo;
	
	public Habitacion siguiente; //Nodo que la conecta con el siguiente;
	
	
	public Habitacion(int numeroHabitacion, boolean ocupacion, String ubicacion, int tipo, Habitacion siguiente){
		
		this.numeroHabitacion = numeroHabitacion;
		this.ocupacion = ocupacion;
		this.ubicacion = ubicacion;
		
		switch(tipo){//PRECIO SEGUN EL TIPO, VARIARÁ SEGUN LAS PROMOCIONES
			
			case SENCILLA:
				this.precio = 250;
				this.tipo = SENCILLA;
				break;	
			
			case DOBLE:
				this.precio = 350;
				this.tipo = DOBLE;
				break;
		
			case ESPECIAL:
				this.precio = 500;
				this.tipo = ESPECIAL;
				break;
		}
		
		this.siguiente = siguiente;
	}
	
	
}
