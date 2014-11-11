
public class VagonCarbon extends Vagon{
	
	int numeroDeVagon;
	VagonCarbon siguiente;
	
	public VagonCarbon(VagonCarbon anterior, int numeroDeVagon, VagonCarbon siguiente){
		super(anterior, numeroDeVagon, siguiente);
	}

}
