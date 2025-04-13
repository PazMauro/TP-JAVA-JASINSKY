package tp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner S = new Scanner (System.in);
		
		int opcion = 0;
		
		int contadorJuegos = 0;
		
		final int cantJuego = 80;
		
		final int cantDatos = 8;
		
		String juegos [][] = new String [cantJuego][cantDatos];
	
		do{
		opcion = mostrarMenuYElegirOpcion (S);
		contadorJuegos = generarAccion (juegos, S, opcion, contadorJuegos);
		}while(opcion != 11);
		S.close();
	}
	
	public static int mostrarMenuYElegirOpcion (Scanner S) {
		
			System.out.println("------------------------ Menú --------------------------------");
			System.out.println("(1) Agregar juego");
			System.out.println("(2) Consultar juego");
			System.out.println("(3) Modificar juego");
			System.out.println("(4) Eliminar juego");
			System.out.println("(5) Listar todos los juego");
			System.out.println("(6) Buscar juegos por genero");
			System.out.println("(7) Buscar juegos por desarrollador");
			System.out.println("(8) Buscar juegos mejor/peor calificados");
			System.out.println("(9) Buscar juegos por rango de precios");
			System.out.println("(10) Calcular estadisticas de la plataforma");
			System.out.println("(11) Salir");
			System.out.println("--------------------------------------------------------------");

			System.out.println("Ingrese una opcion: ");	
			int opcion= ingresarEntero(S,1,11);
			return opcion;
			
	}
	
	public static int generarAccion (String[][] juegos, Scanner S, int opcion, int contadorJuegos) {
		switch(opcion) {
			case 1:
				contadorJuegos = ingresarJuego(juegos, S, contadorJuegos);
				break;
			case 2:
				consultarJuego(juegos,S);
				break;
			case 3:
				modificarJuego(juegos,S);
				break;
			case 4:
				eliminarJuego(juegos,S);
				break;
			case 5:
				listarJuegos(contadorJuegos, juegos);//Listar todo los juegos
				break;
			case 6:
				buscarJuegosPorGenero(juegos,S);
				break;	
			case 7:
				buscarJuegosPorDesarrollador(juegos,S);
				break;
			case 8:
				buscarJuegosCalificacion(juegos,S,contadorJuegos);
				break;
			case 9:
				//Buscar juegos por rango de precio
				break;
			case 10:
				//Calcular estadísticas de la plataforma
				break;
			case 11:
				//salir
				break;
	}
		return contadorJuegos;

			
	}
	
	public static int ingresarJuego(String[][] juegos,Scanner S,int cantJuegos) {
		if(cantJuegos >= juegos.length) {
			System.out.println("No se puede agregar mas juegos");
			return cantJuegos;
		}
		
		System.out.println("Ingrese ID del juego (1000 a 9999): ");
		int id=ingresarEntero(S, 1000, 9999);
		juegos[cantJuegos][0]= String.valueOf(id);
		
		System.out.println("Ingrese titulo del juego: ");
		juegos[cantJuegos][1] = S.nextLine();
		
		System.out.println("Ingrese desarrolador del juego: ");
		juegos[cantJuegos][2] = S.nextLine();

		System.out.println("Ingrese género del juego (1-accion, 2-aventura, 3-estrategia, 4-rpg, 5-deportes, 6-simulación): ");
		int genero = ingresarEntero(S, 1, 6);
		juegos[cantJuegos][3] = String.valueOf(genero);
		
		System.out.println("Ingrese clasificacion del juego: ");
		int clasificacion = ingresarEntero(S, 1, 10);
		juegos[cantJuegos][4] = String.valueOf(clasificacion);
		
		System.out.println("Ingrese año de lanzamiento del juego: ");
		int anio = ingresarEntero(S, 1990, 2025);
		juegos[cantJuegos][5] = String.valueOf(anio);
		
		System.out.println("Ingrese el precio del juego: ");
		int precio =  ingresarEntero(S, 0, 10000000);
		juegos[cantJuegos][6] = String.valueOf(precio);
		
		System.out.println("Ingrese la calificacion del juego: (1 para E (Para todos), 2 para T (Teen), 3 para M (Mature)");
		int calificacion = ingresarEntero(S, 1, 3);
		juegos[cantJuegos][7] = String.valueOf(calificacion);
		
		return cantJuegos+1;
	}
	
	public static int ingresarEntero(Scanner S, int min, int max) {
	    boolean valido = false;
	    int entero = 0;

	    do {
	        try {
	            entero = S.nextInt();
	            if (entero >= min && entero <= max) {
	                valido = true;
	            } else {
	                System.out.println("El numero ingresado esta fuera del rango. Intente nuevamente: ");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Eso no es un numero valido. intenta nuevamente: ");
	        }
	        S.nextLine();
	    } while (!valido);

	    return entero;
	}

	
	public static void consultarJuego (String juegos[][],Scanner S) {
		int id;
	System.out.println("Que juego queres consultar decime la id: ");
		id = S.nextInt();
		boolean encontrar = false;
		int posjuego;
			for (int i = 0;i<juegos.length;i++) {
				if (juegos[i][0] != null && juegos[i][0].equals(String.valueOf(id))) {
				encontrar = true;
				posjuego = i;
				System.out.println("se encontro la id del juego estos son los datos: ");
				
				System.out.println("la id es: " + juegos[posjuego][0]);
				System.out.println("la titulo es: " + juegos[posjuego][1]);
				System.out.println("la desarrollador es: " + juegos[posjuego][2]);
				System.out.println("la género es: " + juegos[posjuego][3]);
				System.out.println("la clasificacion es: " + juegos[posjuego][4]);
				System.out.println("la año es: " + juegos[posjuego][5]);
				System.out.println("la precio es: " + juegos[posjuego][6]);
				System.out.println("la calificacion es: " + juegos[posjuego][7]);
				}
				
			
			}
				if (encontrar != true) {
				System.out.println("el juego no se encontro por esa id: ");
				}
	}
	
	public static void modificarJuego (String juegos[][],Scanner S) {
		boolean buscar = false;
		int id,posjuego;
		System.out.println("que juego queres modificar?:(escribe la id del juego) ");
		id = S.nextInt();
			for (int i = 0;i<juegos.length;i++) {
				if (juegos[i][0] != null && juegos[i][0].equals(String.valueOf(id))) {
					buscar = true;
				posjuego = i;
				System.out.println("se encontro la id del juego que queres modificar");
				System.out.println("Ingrese ID del juego (1000 a 9999): ");
				int id2 = S.nextInt(); 
				S.nextLine();
				juegos[posjuego][0]= String.valueOf(id2);
				
				System.out.println("Ingrese titulo del juego: ");
				juegos[posjuego][1] = S.nextLine();
				
				
				System.out.println("Ingrese desarrolador del juego: ");
				juegos[posjuego][2] = S.nextLine();
				
				
				System.out.println("Ingrese género del juego (1-accion, 2-aventura, 3-estrategia, 4-rpg, 5-deportes, 6-simulación): ");
				int genero = S.nextInt();
				juegos[posjuego][3] = String.valueOf(genero);
				S.nextLine();
				
				System.out.println("Ingrese clasificacion del juego: ");
				int clasificacion = S.nextInt();
				juegos[posjuego][4] = String.valueOf(clasificacion);
				S.nextLine();
				
				System.out.println("Ingrese año de lanzamiento del juego: ");
				int anio = S.nextInt();
				juegos[posjuego][5] = String.valueOf(anio);
				S.nextLine();
				
				System.out.println("Ingrese el precio del juego: ");
				int precio = S.nextInt();
				juegos[posjuego][6] = String.valueOf(precio);
				S.nextLine();
				
				System.out.println("Ingrese la calificacion del juego: ");
				int calificacion = S.nextInt();
				juegos[posjuego][7] = String.valueOf(calificacion);
				S.nextLine();
				
				
				}
			}
			if (buscar == false) {
				System.out.println("no se encontro la id proba de nuevo con la misma opcion");
			}
			
	}
	
	public static void eliminarJuego(String juegos[][], Scanner S) {
	    System.out.print("ID del juego a eliminar: ");
	    int id = S.nextInt();
	    S.nextLine();

	    for (int i = 0; i < juegos.length; i++) {
	        if (juegos[i][0] != null && juegos[i][0].equals(String.valueOf(id))) {

	            for (int j = i; j < juegos.length - 1; j++) {
	                juegos[j] = juegos[j + 1];
	            }

	            juegos[juegos.length - 1] = null;

	            System.out.println("Juego eliminado.");
	            return;
	        }
	    }

	    System.out.println("No se encontró ningún juego con ese ID.");
	}
	
	public static void buscarJuego(String juegos[][], Scanner S) {
		
		
		int opcion2=0;
		int id;
		String titulo;
		int posjuego;
		System.out.println("Como deseas realizar la busqueda por ID o el titulo del juego:(1 si es por id 2 si es por titulo ) ");
		opcion2=S.nextInt();
		
		S.nextLine();
		
		boolean encontrado = false;
		
		if (opcion2==1) {
			System.out.println("decime que id queres buscar y yo te digo en que posicion esta: ");
			id = S.nextInt();
			for(int i=0; i<juegos.length; i++) {
				if (juegos[i][0] != null && juegos[i][0].equals(String.valueOf(id))) {
					encontrado = true;
					posjuego = i;
				System.out.println("se encontro el juego que estabas buscando y esta en la posicion"+ posjuego);
				}
			
			}
			
		}
		
		if (opcion2==2) {
			for (int i = 0;i<juegos.length;i++) {
				System.out.println("decime que titulo de juego queres buscar: ");
				titulo = S.nextLine();
			if (juegos[i][1] != null && juegos[i][1].equals(titulo)) {
				encontrado = true;
			posjuego = i;
			System.out.println("el juego fue encontrado y esta en la posicion"+ posjuego);	
			}
			
				
			}
			if (encontrado != false) {
				System.out.println("no se encontro el juego volvelo a intentar");
			}
		}
		
	}

	public static void buscarJuegosPorGenero(String juegos[][],Scanner S) {
		
		int ValorBuscado=0;
		
		System.out.println("Ingrese el genero que deseas buscar: ");
		
		ValorBuscado=S.nextInt();
		
		S.nextLine();
		
			boolean encontrado=false;
		
		for(int i =0; i<juegos.length; i++) {
				if(juegos[i][3]!=null && juegos[i][3].equals(String.valueOf(ValorBuscado))) {
					System.out.println("El juego " + juegos[i][1] +" "+ "es de genero : " + ValorBuscado);
					encontrado=true;
				}
				}
		if(encontrado==false){
			System.out.println("No se encontro ningun juego con ese genero");
			}
	}
	
	public static void buscarJuegosPorDesarrollador(String juegos[][],Scanner S) {
		
		String ValorBuscadoG;
		
		System.out.println("Ingrese el desarrolador que deseas buscar: ");
		
		ValorBuscadoG=S.nextLine();
		
			boolean encontrado = false;
		
		for(int i =0; i<juegos.length; i++) {
			
				if(juegos[i][2] != null && juegos[i][2].equalsIgnoreCase(ValorBuscadoG)) {
					
					System.out.println("El juego " + juegos[i][1] +" "+ "es desarrolado por: " + ValorBuscadoG);
					encontrado = true;
				}
				
				}
		if (!encontrado) {
		    System.out.println("No se encontró ningún juego con ese desarrollador.");
		}
		
	}
	
	public static void listarJuegos (int cantJuegos, String juegos[][]) {
		
		for(int i=0; i<cantJuegos; i++) {
			
			System.out.println(juegos[i][1]);
		}
		
	
	}
	
	public static void sugerirJuegosSimilares(Scanner S, int cantJuegos, String juegos[][]) {
		System.out.println("Ingrese a que juego quiere buscarle sus parecidos: ");
		String jueg = S.nextLine();
		
		String gen=null;
		String des=null;
		
		boolean encontrar = false;
		
		for(int i=0; i<cantJuegos; i++) {
			
			if(juegos[i][1].equals(jueg)) {
				
				 des = juegos[i][2];
				 gen = juegos[i][3];
			
				 encontrar=true;
			}
		}
		
		if(!encontrar) {
			System.out.println("no se encontro un juego similar");
		}
		
		System.out.println("los juegos similares a este son: \n");
		for(int i=0; i<cantJuegos; i++) {
			if(juegos[i][2].equals(des) || juegos[i][3].equals(gen)) {
				System.out.println("\n" + juegos[i][1]);
			}
		}
	}
	
	public static void buscarJuegosCalificacion (String juegos[][],Scanner S,int contadorJuegos) {
		int peor = 9999,mejor = 0,calificacion,posjuego,calificacionmax = 0,calificacionmin = 0;
		boolean encontrar = false;
		System.out.println("inglrese la calificacion que queres buscar: ");
		calificacion = S.nextInt();
		
			for (int i = 0 ; i < contadorJuegos;i++) {
				if (juegos[i][7] != null && juegos[i][7].equals(String.valueOf(calificacion))) {
				encontrar = true;
				posjuego = i;
				System.out.println("el numero de juego que estas buscando con esa calificacion es el juego"+ posjuego);
				}
				
			}
			if (!encontrar) {
				System.out.println("no se encontro el juego con esa calificacion");
			}
				for (int i = 0;i<contadorJuegos;i++) {
					calificacionmax = Integer.parseInt(juegos[i][7]);
					if (mejor < calificacionmax) {
						mejor = calificacionmax;
					}
				}
					for (int i = 0;i<contadorJuegos;i++) {
					calificacionmin = Integer.parseInt(juegos[i][7]);
						if (peor > calificacionmin) {
						peor = calificacionmin;
						}
						
					}
					System.out.println("la peor calificacion es: "+ peor);
					System.out.println("la mejor calificacion es: "+ mejor);
	}

}
