
public class Cliente {
	
	public String nombre;
	public int edad;
	public int codigoCliente;
	public int cuenta;
	
	public final int LIBRE = 1;
	public final int HOSPEDADO = 2;
	public final int RESERVADO = 3;
	
	public int estado;
	
	Cliente siguiente;
	
	public Cliente(String nombre, int edad, int codigoCliente, int estadoCliente, Cliente siguiente){
		
		this.nombre = nombre;
		this.edad = edad;
		this.codigoCliente = codigoCliente;
		
		switch(estadoCliente){
		case 1:
			this.estado = LIBRE;
			break;
		case 2:
			this.estado = HOSPEDADO;
			break;
		case 3:
			this.estado = RESERVADO;
			break;
			
		}
		
		
		this.siguiente = siguiente;
		
		
		
	}
	
	public int cuenta(int numeroDias, int precio){
		
		this.cuenta = numeroDias*precio;
		return cuenta;
		
	}
	
	
	

}
