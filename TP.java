package tp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static final boolean MODO_PRUEBA = true;

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int opcion = 0;
        int contadorJuegos = 0;
        final int cantJuego = 80;
        final int cantDatos = 8;
        String juegos[][] = new String[cantJuego][cantDatos];
        
        if (MODO_PRUEBA) {
        	contadorJuegos = cargarDatosPrueba(juegos);
        	System.out.println("Modo prueba activado");
        }

        do {
            opcion = mostrarMenuYElegirOpcion(S);
            contadorJuegos = generarAccion(juegos, S, opcion, contadorJuegos);
        } while (opcion != 11);
        S.close();
    }
    
    public static int cargarDatosPrueba(String[][] juegos) {
    	String[][] juegosPrueba = {
    			{"1001", "Elden Ring", "FromSoftware", "4", "3", "2022", "8999", "9"},
                {"1002", "FIFA 23", "EA Sports", "5", "1", "2022", "5999", "7"},
                {"1003", "The Legend of Zelda", "Nintendo", "2", "1", "2017", "4999", "10"},
                {"1004", "Civilization VI", "Firaxis Games", "3", "2", "2016", "2999", "8"},
                {"1005", "God of War", "Santa Monica Studio", "1", "3", "2018", "6999", "9"},
                {"1006", "Minecraft", "Mojang", "6", "1", "2011", "1999", "9"},
                {"1007", "The Sims 4", "Maxis", "6", "2", "2014", "3999", "6"},
                {"1008", "NBA 2K24", "2K Sports", "5", "3", "2023", "6499", "7"},
                {"1009", "Hollow Knight", "Team Cherry", "2", "2", "2017", "2599", "9"},
                {"1010", "Starcraft II", "Blizzard", "3", "2", "2010", "3499", "8"}
    	};
    	
    	for (int i = 0; i < juegosPrueba.length; i++) {
    		for (int j = 0; j < juegosPrueba[i].length; j++) {
    			juegos[i][j] = juegosPrueba[i][j];
    		}
    	}
    	return juegosPrueba.length;
    }

    public static int mostrarMenuYElegirOpcion(Scanner S) {
        System.out.println("------------------------ Menú --------------------------------");
        System.out.println("(1) Agregar juego");
        System.out.println("(2) Consultar juego");
        System.out.println("(3) Modificar juego");
        System.out.println("(4) Eliminar juego");
        System.out.println("(5) Listar todos los juegos");
        System.out.println("(6) Buscar juegos por genero");
        System.out.println("(7) Buscar juegos por desarrollador");
        System.out.println("(8) Buscar juegos mejor/peor calificados");
        System.out.println("(9) Buscar juegos por rango de precios");
        System.out.println("(10) Calcular estadisticas de la plataforma");
        System.out.println("(11) Salir");
        System.out.println("--------------------------------------------------------------");

        System.out.println("Ingrese una opcion: ");
        return ingresarEntero(S, 1, 11);
    }

    public static int generarAccion(String[][] juegos, Scanner S, int opcion, int contadorJuegos) {
    	int pos;
        switch (opcion) {
            case 1:
                contadorJuegos = ingresarJuego(juegos, S, contadorJuegos);
                break;
            case 2:
                pos = buscarJuego(juegos, S, contadorJuegos);
                if (pos != -1) consultarJuego(juegos, pos);
                break;
            case 3:
                pos = buscarJuego(juegos, S, contadorJuegos);
                if (pos != -1) modificarJuego(juegos, S, pos);
                break;
            case 4:
                pos = buscarJuego(juegos, S, contadorJuegos);
                if (pos != -1) eliminarJuego(juegos, pos, contadorJuegos);
                break;
            case 5:
                listarJuegos(contadorJuegos, juegos);
                break;
            case 6:
                buscarJuegosPorGenero(juegos, S, contadorJuegos);
                break;
            case 7:
                buscarJuegosPorDesarrollador(juegos, S, contadorJuegos);
                break;
            case 8:
                buscarJuegosCalificacion(juegos, S, contadorJuegos);
                break;
            case 9:
            	rangoPrecio(juegos,S,contadorJuegos);
            	break;
            case 10:
			calcularEstadisticas (juegos,contadorJuegos);
            	break;
            case 11:
            System.out.println("se salio del programa correctamente: ");	
            	break;
        }
        return contadorJuegos;
    }

    public static int buscarJuego(String[][] juegos, Scanner S, int contadorJuegos) {
        System.out.println("¿Cómo desea buscar el juego?\n(1) ID\n(2) Título");
        int opcion = ingresarEntero(S, 1, 2);

        if (opcion == 1) {
            System.out.print("Ingrese ID del juego: ");
            int id = ingresarEntero(S, 1000, 9999);
            for (int i = 0; i < contadorJuegos; i++) {
                if (juegos[i][0].equals(String.valueOf(id))) {
                    return i;
                }
            }
        } else {
            System.out.print("Ingrese título del juego: ");
            String titulo = S.nextLine();
            for (int i = 0; i < contadorJuegos; i++) {
                if (juegos[i][1].equalsIgnoreCase(titulo)) {
                    return i;
                }
            }
        }
        System.out.println("Juego no encontrado.");
        return -1;
    }

    public static boolean validarID(String[][] juegos, int id, int contadorJuegos) {
        if (id < 1000 || id > 9999) return false;
        for (int i = 0; i < contadorJuegos; i++) {
            if (juegos[i][0].equals(String.valueOf(id))) return false;
        }
        return true;
    }
    
    public static void consultarJuego(String[][] juegos, int pos) {
        System.out.println("Se encontró el juego, estos son los datos:");
        System.out.println("ID: " + juegos[pos][0]);
        System.out.println("Título: " + juegos[pos][1]);
        System.out.println("Desarrollador: " + juegos[pos][2]);
        System.out.println("Género: " + juegos[pos][3]);
        System.out.println("Clasificación: " + juegos[pos][4]);
        System.out.println("Año: " + juegos[pos][5]);
        System.out.println("Precio: " + juegos[pos][6]);
        System.out.println("Calificación: " + juegos[pos][7]);
    }

    public static void modificarJuego(String[][] juegos, Scanner S, int pos) {
        System.out.println("Se encontró el juego. Ingresá los nuevos datos:");
        int nuevoId;
        do {
        	System.out.println("Nuevo ID:");
        	nuevoId = ingresarEntero(S, 1000, 9999);
        	if (!validarID(juegos, nuevoId, pos)) {
        		System.out.println("El ID ya existe o no es valido, intenta denuevo");
        	}
        } while (!validarID(juegos, nuevoId, pos));
        juegos[pos][0] = String.valueOf(nuevoId);

        System.out.println("Título:");
        juegos[pos][1] = S.nextLine();

        System.out.println("Desarrollador:");
        juegos[pos][2] = S.nextLine();

        System.out.println("Género:");
        juegos[pos][3] = String.valueOf(ingresarEntero(S, 1, 6));

        System.out.println("Clasificación:");
        juegos[pos][4] = String.valueOf(ingresarEntero(S, 1, 10));

        System.out.println("Año:");
        juegos[pos][5] = String.valueOf(ingresarEntero(S, 1990, 2025));

        System.out.println("Precio:");
        juegos[pos][6] = String.valueOf(ingresarEntero(S, 1, 200000));

        System.out.println("Calificación:");
        juegos[pos][7] = String.valueOf(ingresarEntero(S, 1, 3));
    }

    public static void eliminarJuego(String[][] juegos, int pos, int contadorJuegos) {
        for (int i = pos; i < contadorJuegos - 1; i++) {
            juegos[i] = juegos[i + 1];
        }
        juegos[contadorJuegos - 1] = null;
        System.out.println("Juego eliminado.");
    }

    public static int ingresarJuego(String[][] juegos, Scanner S, int cantJuegos) {
        if (cantJuegos >= juegos.length) {
            System.out.println("No se puede agregar más juegos");
            return cantJuegos;
        }

        int id;
        do {
        	System.out.println("Ingrese ID del juego (1000 a 9999): ");
        	id = ingresarEntero(S, 1000, 9999);
        	if (!validarID(juegos, id, cantJuegos)) {
        		System.out.println("El ID ya existe o no es valido, intenta denuevo");
        	}
        } while (!validarID(juegos, id, cantJuegos));
        juegos[cantJuegos][0] = String.valueOf(id);

        System.out.println("Ingrese título del juego: ");
        juegos[cantJuegos][1] = S.nextLine();

        System.out.println("Ingrese desarrollador del juego: ");
        juegos[cantJuegos][2] = S.nextLine();

        System.out.println("Ingrese género del juego (1-acción, 2-aventura, 3-estrategia, 4-RPG, 5-deportes, 6-simulación): ");
        int genero = ingresarEntero(S, 1, 6);
        juegos[cantJuegos][3] = String.valueOf(genero);

        System.out.println("Ingrese clasificación del juego: ");
        int clasificacion = ingresarEntero(S, 1, 10);
        juegos[cantJuegos][4] = String.valueOf(clasificacion);

        System.out.println("Ingrese año de lanzamiento del juego: ");
        int anio = ingresarEntero(S, 1990, 2025);
        juegos[cantJuegos][5] = String.valueOf(anio);

        System.out.println("Ingrese el precio del juego: ");
        int precio = ingresarEntero(S, 1, 200000);
        juegos[cantJuegos][6] = String.valueOf(precio);

        System.out.println("Ingrese la calificación del juego: ");
        int calificacion = ingresarEntero(S, 1, 3);
        juegos[cantJuegos][7] = String.valueOf(calificacion);

        return cantJuegos + 1;
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
                    System.out.println("El número ingresado está fuera del rango. Intente nuevamente: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número válido. Intente nuevamente: ");
            }
            S.nextLine();
        } while (!valido);

        return entero;
    }
    
    public static void rangoPrecio(String juegos[][], Scanner S,int contadorJuegos) {
    	
    	 System.out.println("Ingrese el primer valor del rango de precios: ");
    	    int precio1 = S.nextInt();

    	    System.out.println("Ingrese el segundo valor del rango de precios: ");
    	    int precio2 = S.nextInt();
    	    
    	    int min = Math.min(precio1, precio2);
    	    int max = Math.max(precio1, precio2);
    	    
    	    
    	boolean encontrar = false;
    	
    		
    		for(int i=0;i<contadorJuegos;i++) {
    			int preciojuego = Integer.valueOf(juegos[i][6]);
    			
    			if(preciojuego>=min && preciojuego<=max) {
    				System.out.println("Título del juego que esta entre esos rangos de precio " + juegos[i][1]);
    				encontrar=true;
    			}
    		}
    		if(!encontrar) {
    			System.out.println("no existe ningun juego entre ese rango de precio");
    		}
    	
    }

    public static void buscarJuegosPorGenero(String juegos[][], Scanner S, int contadorJuegos) {
        System.out.println("Ingrese el género a buscar:");
        int genero = S.nextInt();
        S.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < contadorJuegos; i++) {
            if (juegos[i][3].equals(String.valueOf(genero))) {
                System.out.println("Juego: " + juegos[i][1]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron juegos con ese género.");
        }
    }

    public static void buscarJuegosPorDesarrollador(String juegos[][], Scanner S, int contadorJuegos) {
        System.out.println("Ingrese el desarrollador a buscar:");
        String dev = S.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < contadorJuegos; i++) {
            if (juegos[i][2].equalsIgnoreCase(dev)) {
                System.out.println("Juego: " + juegos[i][1]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron juegos de ese desarrollador.");
        }
    }

    public static void buscarJuegosCalificacion(String juegos[][], Scanner S, int contadorJuegos) {
        System.out.println("Ingrese calificación a buscar (1 = E, 2 = T, 3 = M):");
        int cal = S.nextInt();
        boolean encontrado = false;
        int mejor = 0, peor = 9999;

        for (int i = 0; i < contadorJuegos; i++) {
            if (juegos[i][7].equals(String.valueOf(cal))) {
                System.out.println("Juego con esa calificación: " + juegos[i][1]);
                encontrado = true;
            }

            int val = Integer.parseInt(juegos[i][7]);
            if (val > mejor) mejor = val;
            if (val < peor) peor = val;
        }

        if (!encontrado) {
            System.out.println("No se encontraron juegos con esa calificación.");
        }

        System.out.println("Mejor calificación: " + mejor);
        System.out.println("Peor calificación: " + peor);
    }

    public static void listarJuegos(int contadorJuegos, String juegos[][]) {
        for (int i = 0; i < contadorJuegos; i++) {
            System.out.println(juegos[i][1]);
        }
    }
        public static void calcularEstadisticas (String juegos[][],int contadorJuegos) {
    	float accion = 0,aventura = 0,estrategia = 0,RPG = 0,deportes = 0, simulacion = 0;
    	float poraccion,poraventura,porestrategia,porRPG,pordeportes,porsimulacion;
    	float todos = 0,Teen = 0,Mature = 0,portodos,porteen,pormature;
    	float acumprecio = 0,promedioj,promediocal,acumcalificacion = 0;
    	int conversion,conversion2;
    		for (int i = 0; i < contadorJuegos;i++) {
    			
    				if (juegos[i][3].equals(String.valueOf(1))) {
    				accion++;
    				}
    				if (juegos[i][3].equals(String.valueOf(2))) {
        				aventura++;
        				}
    				if (juegos[i][3].equals(String.valueOf(3))) {
        				estrategia++;
        				}
    				if (juegos[i][3].equals(String.valueOf(4))) {
        				RPG++;
        				}
    				if (juegos[i][3].equals(String.valueOf(5))) {
        				deportes++;
        				}
    				if (juegos[i][3].equals(String.valueOf(6))) {
						simulacion++;
        				}
    		}
    		poraccion = accion*100/contadorJuegos;
    		poraventura = aventura*100/contadorJuegos;
    		porestrategia = estrategia*100/contadorJuegos;
    		porRPG = RPG*100/contadorJuegos;
    		pordeportes = deportes*100/contadorJuegos;
    		porsimulacion = simulacion*100/contadorJuegos;
    			for (int i = 0; i < contadorJuegos;i++) {
    				if (juegos[i][4].equals(String.valueOf(1))) {
        				todos++;
        				}
    				if (juegos[i][4].equals(String.valueOf(2))) {
    					Teen++;
        				}
    				if (juegos[i][4].equals(String.valueOf(3))) {
    					Mature++;
        				}
    				
    				
    			}
    			portodos =  todos*100/contadorJuegos;
    			porteen = Teen*100/contadorJuegos;
    			pormature = Mature*100/contadorJuegos;
    			
    			for (int i = 0; i < contadorJuegos;i++) {
    				conversion = Integer.parseInt(juegos[i][6]);
    				acumprecio += conversion; 
    				

    			}
    			promedioj = acumprecio/contadorJuegos;
    			
	for (int i = 0; i < contadorJuegos;i++) {
		conversion2 = Integer.parseInt(juegos[i][7]);
			conversion2 += acumcalificacion; 
    				

    			}
    			promediocal = acumcalificacion/contadorJuegos;
    			 System.out.println("----- Porcentaje por género -----");
    			    System.out.printf("Acción: %.2f%%\n", poraccion);
    			    System.out.printf("Aventura: %.2f%%\n", poraventura);
    			    System.out.printf("Estrategia: %.2f%%\n", porestrategia);
    			    System.out.printf("RPG: %.2f%%\n", porRPG);
    			    System.out.printf("Deportes: %.2f%%\n", pordeportes);
    			    System.out.printf("Simulación: %.2f%%\n", porsimulacion);

    			    System.out.println("\n----- Porcentaje por clasificación -----");
    			    System.out.printf("Todos: %.2f%%\n", portodos);
    			    System.out.printf("Teen: %.2f%%\n", porteen);
    			    System.out.printf("Mature: %.2f%%\n", pormature);

    			    System.out.println("\n----- Promedios -----");
    			    System.out.printf("Precio promedio: $%.2f\n", promedioj);
    			    System.out.printf("Calificación promedio: %.2f\n", promediocal);			
    }
}
