
public class Vagon {

	int numeroDeVagon;
	Vagon siguiente, anterior;
	
	public Vagon(Vagon anterior, int numeroDeVagon, Vagon siguiente){
		
		this.anterior = anterior;
		this.numeroDeVagon = numeroDeVagon;
		this.siguiente = siguiente;
		
	}
	
}
