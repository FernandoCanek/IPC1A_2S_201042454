
public class Empresa {

	public final String nombre = "Hoteles de CentroAmérica";
	public Hotel primero;
	public Hotel ultimo;
	
	public Empresa(){
		
		primero = ultimo = null;
		
	}
	/**
	public void insertarNuevoHotel(String nombreNuevoHotel, String pais){
	

		if(primero == null){
			
			primero = ultimo = new Hotel(nombreNuevoHotel, pais, null);
			
		}else{
			
			ultimo = ultimo.siguiente = new Hotel(nombreNuevoHotel, pais, null);
		}
		
	}**/
	
	
	
}
	
	
