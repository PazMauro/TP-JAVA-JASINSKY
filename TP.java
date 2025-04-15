package tp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int opcion = 0;
        int contadorJuegos = 0;
        final int cantJuego = 80;
        final int cantDatos = 8;
        String juegos[][] = new String[cantJuego][cantDatos];

        do {
            opcion = mostrarMenuYElegirOpcion(S);
            contadorJuegos = generarAccion(juegos, S, opcion, contadorJuegos);
        } while (opcion != 11);
        S.close();
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
        switch (opcion) {
            case 1:
                contadorJuegos = ingresarJuego(juegos, S, contadorJuegos);
                break;
            case 2:
                consultarJuego(juegos, S, contadorJuegos);
                break;
            case 3:
                modificarJuego(juegos, S, contadorJuegos);
                break;
            case 4:
                eliminarJuego(juegos, S, contadorJuegos);
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

    public static int ingresarJuego(String[][] juegos, Scanner S, int cantJuegos) {
        if (cantJuegos >= juegos.length) {
            System.out.println("No se puede agregar más juegos");
            return cantJuegos;
        }

        System.out.println("Ingrese ID del juego (1000 a 9999): ");
        int id = ingresarEntero(S, 1000, 9999);
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
    
    public static void validarID(String juegos[][] ,int id, int contadorJuegos) {
    	String id1= String.valueOf(id);
    	
    	boolean encontrado=false;
    
    	for(int i=0;i<contadorJuegos;i++) {
    		if(juegos[i][0].equals(id1)) {
    			encontrado=true;
    		}
    	}
    	
    	if(encontrado) {
    		System.out.println("El ID ingresado ya existe");
    	} else {
    		System.out.println("El ID se ingreso correctamente");
    	}
    }
    
    public static void consultarJuego(String juegos[][], Scanner S, int contadorJuegos) {
        
    	System.out.println("ID del juego que querés consultar: ");
        int id = ingresarEntero(S, 1000, 9999);
        boolean encontrar = false;
        do {
        	
        
        for (int i = 0; i < contadorJuegos; i++) {
            if (juegos[i][0].equals(String.valueOf(id))) {
                System.out.println("Se encontró el juego, estos son los datos:");
                System.out.println("ID: " + juegos[i][0]);
                System.out.println("Título: " + juegos[i][1]);
                System.out.println("Desarrollador: " + juegos[i][2]);
                System.out.println("Género: " + juegos[i][3]);
                System.out.println("Clasificación: " + juegos[i][4]);
                System.out.println("Año: " + juegos[i][5]);
                System.out.println("Precio: " + juegos[i][6]);
                System.out.println("Calificación: " + juegos[i][7]);
                encontrar = true;
            }
        }
        if (!encontrar) {
            System.out.println("No existe ningún juego con esa ID.");
        }
        
    }while(encontrar);
        
    }

    public static void modificarJuego(String juegos[][], Scanner S, int contadorJuegos) {
        System.out.println("¿Qué juego querés modificar? Ingresá la ID:");
        int id = ingresarEntero(S, 1000, 9999);
        S.nextLine();
        for (int i = 0; i < contadorJuegos; i++) {
            if (juegos[i][0].equals(String.valueOf(id))) {
                System.out.println("Se encontró el juego. Ingresá los nuevos datos:");

                System.out.println("Nuevo ID:");
                juegos[i][0] = String.valueOf(ingresarEntero(S, 1000, 9999));

                System.out.println("Título:");
                juegos[i][1] = S.nextLine();

                System.out.println("Desarrollador:");
                juegos[i][2] = S.nextLine();

                System.out.println("Género:");
                juegos[i][3] = String.valueOf(ingresarEntero(S, 1, 6));

                System.out.println("Clasificación:");
                juegos[i][4] = String.valueOf(ingresarEntero(S, 1, 10));

                System.out.println("Año:");
                juegos[i][5] = String.valueOf(ingresarEntero(S, 1990, 2025));

                System.out.println("Precio:");
                juegos[i][6] = String.valueOf(ingresarEntero(S, 1, 200000));

                System.out.println("Calificación:");
                juegos[i][7] = String.valueOf(ingresarEntero(S, 1, 3));
                return;
            }
        }
        System.out.println("No se encontró ningún juego con esa ID.");
    }

    public static void eliminarJuego(String juegos[][], Scanner S, int contadorJuegos) {
        System.out.println("ID del juego a eliminar:");
        int id = ingresarEntero(S, 1000, 9999);
        S.nextLine();
        for (int i = 0; i < contadorJuegos; i++) {
            if (juegos[i][0].equals(String.valueOf(id))) {
                for (int j = i; j < contadorJuegos - 1; j++) {
                    juegos[j] = juegos[j + 1];
                }
                juegos[contadorJuegos - 1] = null;
                System.out.println("Juego eliminado.");
                return;
            }
        }
        System.out.println("No se encontró ningún juego con esa ID.");
    }

    public static void buscarJuego(String juegos[][], Scanner S, int contadorJuegos) {
        System.out.println("Buscar por (1) ID o (2) título:");
        int opcion = S.nextInt();
        S.nextLine();
        boolean encontrado = false;

        if (opcion == 1) {
            System.out.println("Ingrese ID:");
            int id = ingresarEntero(S, 1000, 9999);
            for (int i = 0; i < contadorJuegos; i++) {
                if (juegos[i][0].equals(String.valueOf(id))) {
                    System.out.println("Juego encontrado en la posición: " + i);
                    encontrado = true;
                }
            }
        } else if (opcion == 2) {
            System.out.println("Ingrese título:");
            String titulo = S.nextLine();
            for (int i = 0; i < contadorJuegos; i++) {
                if (juegos[i][1].equals(titulo)) {
                    System.out.println("Juego encontrado en la posición: " + i);
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Juego no encontrado.");
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
