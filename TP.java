package tp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opcion,i = 0;
		String juegos [][] = new String [80][8];
	
		do{
		opcion = mostrarMenuYElegirOpcion ();	
		i = generarAccion (opcion,juegos,i);

			
		}while(opcion != 11);
		
	}
	
	public static int mostrarMenuYElegirOpcion () {
		int opcion;
			
		
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

			Scanner S = new Scanner (System.in);
			System.out.println("ingrese una opcion: ");	
			opcion = S.nextInt();	
			
		return opcion;
	}
	
	public static int ingresarJuego(String juegos[][],int i) {
		Scanner S = new Scanner (System.in);
		
	
		int id;
		int precio;
		int calificacion;
		int genero;
		int anio;
		int clasificacion;
		
		System.out.println("ingrese id del juego dentro del rango 1000 a 9999: " + i);
		int max = 9999;
		int min = 1000;
		id = S.nextInt();
		juegos[i][0] = String.valueOf(id);
		S.nextLine();
		/*parametro(id, min, max);*/
		
		System.out.println("ingrese titulo del juego: ");
		juegos[i][1] = S.nextLine();
		
		
		System.out.println("ingrese desarrolador del juego: ");
		juegos[i][2] = S.nextLine();

		
		System.out.println("ingrese genero del juego: (1-accion 2-aventura 3-estrategia 4-rpg 5-deportes 6-simulacion)");
		genero = S.nextInt();
		juegos[i][3] = String.valueOf(genero);
		S.nextLine();
		
		System.out.println("ingrese clasificacion del juego: ");
		clasificacion = S.nextInt();
		juegos[i][4] = String.valueOf(clasificacion);
		S.nextLine();
		
		System.out.println("ingrese año de lanzamiento del juego: ");
		anio = S.nextInt();
		juegos[i][5] = String.valueOf(anio);
		S.nextLine();
		
		System.out.println("ingrese el precio del juego: ");
		precio = S.nextInt();
		juegos[i][6] = String.valueOf(precio);
		S.nextLine();
		
		System.out.println("ingrese la calificacion del juego: ");
		calificacion = S.nextInt();
		juegos[i][7] = String.valueOf(calificacion);
		S.nextLine();
		
		i++;
	
		
		
		return i;
		
	}
	
	public static int generarAccion (int opcion,String juegos[][],int i) {
		switch(opcion) {
		case 1:
			i = ingresarJuego(juegos,i);
	
			break;
		case 2:
			/*int minGen = 1; 
			int maxGen=5;
			buscarJuegosPorGenero();
			parametro(juegos [][], minGen, maxGen);
			//Consultar juego*/

			break;
		case 3:
			Scanner S = new Scanner (System.in);
			//Modificar juego
			modificarJuego(juegos,S);
			S.close();
			break;
		case 4:
			/*Scanner S = new Scanner (System.in);
			//Eliminar juego
			eliminarJuego(juegos,S);
			*/	
			break;
		case 5:
				//Listar todo los juegos
				
			break;
		case 6:
			buscarJuegosPorGenero(juegos);
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
			return i;

			
	}

	public static void buscarJuegosPorGenero(String juegos[][]) {
		Scanner S= new Scanner (System.in);
		int ValorBuscado;
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
		if(encontrado=false){
			System.out.println("No se encontro ningun juego con ese genero");
			}
		}
	
	public static void parametro (String juegos[][], int min, int max) {

		
	
		boolean error = true;
		
		do {
			try {
				
				if (juegos[i][0] >= min && juegos[i][0] <= max) {
					System.out.println("Numero valido");
					error=false;
				}
				else {
					System.out.println("Numero no valido");
					error=true;
				}
			}
			catch(NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresá un número.");
             }
			
		}while(!error);
		
	}
	public static void modificarJuego(String juegos[][], Scanner S) {
			System.out.println("Que numero de juego desea modificar");
			int numJuego = S.nextInt();
			S.nextLine();
			ingresarJuego(juegos, numJuego);
	}
	
	/*public static void eliminarJuego(String juegos[][], Scanner S){
		System.out.println("Que numero de juego desea eliminar");
		int numJuego = S.nextInt();
		S.nextLine();
		for(int i=0; i<7; i++) {
			juegos[numJuego][i] = null;
		}
	}*/
}
