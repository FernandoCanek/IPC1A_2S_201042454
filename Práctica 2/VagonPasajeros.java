
public class VagonPasajeros extends Vagon{
	
	int numeroDeVagon;
	VagonPasajeros siguiente;
	final int tipo;
	boolean vagonLleno = false;
	
	public VagonPasajeros(VagonPasajeros anterior,int numeroDeVagon, VagonPasajeros siguiente, int tipo, int pasajeros){
		
		super(anterior, numeroDeVagon, siguiente);
		this.tipo = tipo;
	}
	

}
