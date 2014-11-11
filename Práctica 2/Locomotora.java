import java.util.Scanner;


public class Locomotora {

	//CONSTANTES NUMERICAS PARA EL TIPO DE VAGON DE PASAJEROS QUE SERÁ ENVIANDO COMO ARGUMENTO
	final int PRIMERACLASE = 1;
	final int TERCERACLASE = 2;
	
	public VagonPasajeros vagonPasajerosInicio = null, vagonPasajerosFinal = null;
	public VagonCarbon vagonCarbonInicio = null, vagonCarbonFinal = null;
	
	public int numeroDeVagon = 0;
	Scanner entrada = new Scanner(System.in);
	
	public Locomotora(){
		
	}
	
	//METODO PARA CARGAR LA LOCOMOTORA
	
	public void cargaLocomotora(int pasajerosPrimeraClase, int pasajerosTerceraClase, int distanciaKM){
		do{
			agregaVagonCarbonAlInicio(numeroDeVagon);
			numeroDeVagon++;
		}while((distanciaKM/100) > 0);
		
		do{
			agregaVagonPasajerosPrimeraAlInicio(pasajerosPrimeraClase);
			pasajerosPrimeraClase = pasajerosPrimeraClase - 10;
			numeroDeVagon++;
		}while((pasajerosPrimeraClase/10) > 0);
		
		do{
			agregaVagonPasajerosTerceraInicio(pasajerosTerceraClase);
			pasajerosTerceraClase = pasajerosTerceraClase - 30;
			numeroDeVagon++;
		}while((pasajerosTerceraClase/30)>0);
	}
	
	//INICIAN METODOS AGREGAR AL INICIO Y AGREGAR AL FINAL
		
	//VAGONES DE CARBON	
	public void agregaVagonCarbonAlInicio(int numeroDeVagon){ 
		
		if(vagonCarbonInicio == null){
			vagonCarbonInicio = vagonCarbonFinal = new VagonCarbon(null, numeroDeVagon, null);
		}else{
			vagonCarbonInicio = new VagonCarbon(null, numeroDeVagon, vagonCarbonInicio);
		}
	}
	
	public void agregarVagonCarbonAlFinal (int numeroDeVagon){
		
		if(vagonCarbonInicio == null){
			vagonCarbonInicio = vagonCarbonFinal = new VagonCarbon(null, numeroDeVagon, null);
		}else{
			vagonCarbonFinal = vagonCarbonFinal.siguiente = new VagonCarbon (vagonCarbonFinal, numeroDeVagon, null);
		}
		
	}
	
	//VAGONES DE PRIMERA Y TERCERA CLASE
	
	//Primera Clase
	public void agregaVagonPasajerosPrimeraAlInicio(int numeroPasajerosP){ 
		
		if(vagonPasajerosInicio == null){
			vagonPasajerosInicio = vagonPasajerosFinal = new VagonPasajeros(null, numeroDeVagon, null, PRIMERACLASE, numeroPasajerosP);
		}else{
			vagonPasajerosInicio = new VagonPasajeros(null, numeroDeVagon, vagonPasajerosInicio, PRIMERACLASE, numeroPasajerosP);
		}
	}
	
	public void agregaVagonPasajerosPrimeraAlFinal (int numeroPasajerosP){
		
		if(vagonPasajerosInicio == null){
			vagonPasajerosInicio = vagonPasajerosFinal = new VagonPasajeros(null, numeroDeVagon, null, PRIMERACLASE, numeroPasajerosP);
		}else{
			vagonPasajerosFinal = vagonPasajerosFinal.siguiente = new VagonPasajeros(vagonPasajerosFinal, numeroDeVagon, null, PRIMERACLASE, numeroPasajerosP);
		}
		
	}
	
	//Tercera clase
	public void agregaVagonPasajerosTerceraInicio(int numeroPasajerosT){ 
		
		if(vagonPasajerosInicio == null){
			vagonPasajerosInicio = vagonPasajerosFinal = new VagonPasajeros(null, numeroDeVagon, null, TERCERACLASE, numeroPasajerosT);
		}else{
			vagonPasajerosInicio = new VagonPasajeros(null, numeroDeVagon, vagonPasajerosInicio, TERCERACLASE, numeroPasajerosT);
		}
	}
	
	public void agregaVagonPasajerosTerceraAlFinal (int numeroPasajerosT){
		
		if(vagonPasajerosInicio == null){
			vagonPasajerosInicio = vagonPasajerosFinal = new VagonPasajeros(null, numeroDeVagon, null, TERCERACLASE, numeroPasajerosT);
		}else{
			vagonPasajerosFinal = vagonPasajerosFinal.siguiente = new VagonPasajeros(vagonPasajerosFinal, numeroDeVagon, null, TERCERACLASE, numeroPasajerosT);
		}
		
	}//FIN DE METODOS PARA AGREGAR AL INICIO Y AL FINAL
	
	
	//METODO PARA CONOCER EL TAMAÑO DE LA LISTA, RETORNA VALOR NUMERICO
	public int tamañoLista(){
		
		if((vagonCarbonInicio == null)||(vagonPasajerosFinal == null)){
			return 0;
		}else{
			int numeroVagonesCarbon = 0;
			int numeroVagonesPasajeros = 0;
			int vagonesTotal;
			
			VagonCarbon actual = vagonCarbonInicio;
			VagonPasajeros actual2 = vagonPasajerosInicio;
			
			while(actual != null){
				numeroVagonesCarbon = numeroVagonesCarbon +1;
				actual = actual.siguiente;
			}
			
			while(actual2 != null){
				numeroVagonesPasajeros = numeroVagonesPasajeros +1;
				actual2 = actual2.siguiente;
			}
			
			vagonesTotal = numeroVagonesCarbon + numeroVagonesPasajeros;
			return vagonesTotal;
		}
				
	}//FIN DE METODO PARA CONOCER TAMAÑO DE LA LISTA
	
	
	//METODO PARA BUSCAR UNA POSICIÓN EN BASE AL NUMERO DE VAGON ENVIADO COMO ARGUMENTO
	public String buscaPosicion(int numeroVagonBuscado, boolean eliminar){
		
		String texto = null;
		
		VagonCarbon actual = vagonCarbonInicio;
		VagonPasajeros actual2 = vagonPasajerosInicio;
		
		while(actual != null){
			if(actual.numeroDeVagon == numeroVagonBuscado){
				texto =  "El vagon buscado en orden de entrada es un vagon de carbon";
				actual = null;
			}else{
				texto = "El vagon buscado en orden de entrada es un vagon de carbon";
			}
			actual = actual.siguiente;
		}
		
		while(actual2 != null){
			if(actual2.numeroDeVagon == numeroVagonBuscado){
				texto = "El vagon buscado es un vagon de pasajeros de " + String(ValueOf(actual2.tipo));
				actual2 = null;
			}else{
				texto = "El vagon buscado es un vagon de pasajeros de " + actual2.tipo;
			}
			actual2 = actual2.siguiente;
		}
		
		
		
		return texto;
				
	}//FIN METODO BUSCAR ELEMENTO
	
	
	//METODO PARA ELIMINAR UNA POSICIÓN EN BASE AL NUMERO DE VAGON ENVIADO COMO ARGUMENTO
		public void eliminaPosicion(int numeroVagonBuscado){
			
			
			VagonCarbon actual = vagonCarbonInicio;
			VagonPasajeros actual2 = vagonPasajerosInicio;
			
			while(actual != null){
				
				if(actual.numeroDeVagon == numeroVagonBuscado){
					actual.anterior.siguiente = actual.siguiente;
				}else{
					
				}
				actual = actual.siguiente;
				
			}
			
			while(actual2 != null){
				
				if(actual2.numeroDeVagon == numeroVagonBuscado){
					actual2.anterior.siguiente = actual2.siguiente;
				}else{
					
				}
				
				actual2 = actual2.siguiente;
			}
					
		}//FIN METODO ELIMINAR ELEMENTO
	
		public static void main (String[] a){
			Scanner entrada = new Scanner(System.in);
			Locomotora l = new Locomotora();
			
			int pasajerosPrimera, pasajerosTercera, km, posicionBuscada;
			System.out.println("ingresa Pasajeros primera");
			
			pasajerosPrimera = entrada.nextInt();
			pasajerosTercera = entrada.nextInt();
			km = entrada.nextInt();
			
			l.cargaLocomotora(pasajerosPrimera, pasajerosTercera, km);
			System.out.println("ingrese vagon a buscar");
			posicionBuscada = entrada.nextInt();
			
			String texto = l.buscaPosicion(posicionBuscada, false);
			System.out.println(texto);
			
		}
					
		
	
	
	
}


