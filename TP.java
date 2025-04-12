package tp;

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
			return S.nextInt();
			
			
	}
	
	public static int generarAccion (String[][] juegos, Scanner S, int opcion, int contadorJuegos) {
		
		switch(opcion) {
		
			case 1:
				contadorJuegos = ingresarJuego(juegos, S, contadorJuegos);
				break;
			case 2:
				//Consultar juego
				break;
			case 3:
				//Modificar juego
				break;
			case 4:
				//Eliminar juego
				break;
			case 5:
				//Listar todo los juegos
				break;
			case 6:
				//Buscar juegos por género
				break;	
			case 7:
				//Buscar juegos por desarrollador
				break;
			case 8:
				//Buscar juegos mejor/peor calificados
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
		int id = S.nextInt(); 
		S.nextLine();
		juegos[cantJuegos][0]= String.valueOf(id);
		
		System.out.println("Ingrese titulo del juego: ");
		juegos[cantJuegos][1] = S.nextLine();
		
		
		System.out.println("Ingrese desarrolador del juego: ");
		juegos[cantJuegos][2] = S.nextLine();

		
		System.out.println("Ingrese género del juego (1-accion, 2-aventura, 3-estrategia, 4-rpg, 5-deportes, 6-simulación): ");
		int genero = S.nextInt();
		juegos[cantJuegos][3] = String.valueOf(genero);
		S.nextLine();
		
		System.out.println("Ingrese clasificacion del juego: ");
		int clasificacion = S.nextInt();
		juegos[cantJuegos][4] = String.valueOf(clasificacion);
		S.nextLine();
		
		System.out.println("Ingrese año de lanzamiento del juego: ");
		int anio = S.nextInt();
		juegos[cantJuegos][5] = String.valueOf(anio);
		S.nextLine();
		
		System.out.println("Ingrese el precio del juego: ");
		int precio = S.nextInt();
		juegos[cantJuegos][6] = String.valueOf(precio);
		S.nextLine();
		
		System.out.println("Ingrese la calificacion del juego: ");
		int calificacion = S.nextInt();
		juegos[cantJuegos][7] = String.valueOf(calificacion);
		S.nextLine();
		
		
		return cantJuegos+1;
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

	public static void buscarJuegosPorGenero(String juegos[][]) {
		Scanner S= new Scanner (System.in);
		
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
	
	public static void buscarJuegosPorDesarrollador(String juegos[][]) {
		Scanner S= new Scanner (System.in);
		
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
	
	public static void consultarJuego (String juegos[][]) {
	
	
	}

}
