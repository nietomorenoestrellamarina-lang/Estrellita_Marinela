import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Curso> listaCursos = new ArrayList<>();
        ArbolCursos arbolCursos = new ArbolCursos();
        GrafoCursos grafoCursos = new GrafoCursos(20);
        HistorialAcciones historial = new HistorialAcciones();

        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE GESTION DE CURSOS UTC 3.0 =====");
            System.out.println("1. Agregar curso");
            System.out.println("2. Mostrar cursos");
            System.out.println("3. Eliminar curso");
            System.out.println("4. Inscribir estudiante");
            System.out.println("5. Dar de baja estudiante");
            System.out.println("6. Insertar cursos en arbol binario");
            System.out.println("7. Buscar curso en arbol binario");
            System.out.println("8. Mostrar recorrido inorden del arbol");
            System.out.println("9. Crear relacion entre cursos (grafo)");
            System.out.println("10. Mostrar grafo o matriz de adyacencia");
            System.out.println("11. Ordenar cursos con Bubble Sort directo");
            System.out.println("12. Ordenar cursos con Bubble Sort inverso");
            System.out.println("13. Ordenar cursos con insercion directa");
            System.out.println("14. Ordenar cursos con seleccion directa");
            System.out.println("15. Busqueda secuencial");
            System.out.println("16. Busqueda binaria");
            System.out.println("17. Mostrar historial de acciones");
            System.out.println("18. Funcionalidad Adicional: Comparar pasos (Secuencial vs Binaria)");
            System.out.println("19. Salir");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del curso (numerico unico): ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    
                    boolean repetido = false;
                    for (Curso c : listaCursos) {
                        if (c.getIdCurso() == id) { repetido = true; break; }
                    }
                    if (repetido) {
                        System.out.println("Error: Ya existe un curso con ese ID.");
                        break;
                    }

                    System.out.print("Clave del curso: ");
                    String clave = scanner.nextLine();
                    System.out.print("Nombre del curso: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Docente asignado: ");
                    String docente = scanner.nextLine();
                    System.out.print("Cupo maximo: ");
                    int cupo = scanner.nextInt();

                    Curso nuevoCurso = new Curso(id, clave, nombre, docente, cupo);
                    listaCursos.add(nuevoCurso);
                    grafoCursos.agregarVertice(nuevoCurso);
                    historial.registrarAccion("Agrego el curso: " + nombre);
                    System.out.println("Curso registrado exitosamente.");
                    break;

                case 2:
                    if (listaCursos.isEmpty()) {
                        System.out.println("No existen cursos registrados.");
                    } else {
                        System.out.println("\n--- LISTA DE CURSOS ---");
                        for (Curso c : listaCursos) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 3:
                    if (listaCursos.isEmpty()) {
                        System.out.println("No existen cursos registrados.");
                        break;
                    }
                    System.out.print("Ingrese el ID del curso a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    Curso cEliminar = null;
                    for (Curso c : listaCursos) {
                        if (c.getIdCurso() == idEliminar) { cEliminar = c; break; }
                    }
                    if (cEliminar != null) {
                        listaCursos.remove(cEliminar);
                        historial.registrarAccion("Elimino el curso ID: " + idEliminar);
                        System.out.println("Curso eliminado correctamente.");
                    } else {
                        System.out.println("No se encontro ningun curso con ese ID.");
                    }
                    break;

                case 4:
                    if (listaCursos.isEmpty()) {
                        System.out.println("No existen cursos registrados.");
                        break;
                    }
                    System.out.print("Ingrese el ID del curso para inscribir estudiante: ");
                    int idInsc = scanner.nextInt();
                    boolean inscritoExito = false;
                    for (Curso c : listaCursos) {
                        if (c.getIdCurso() == idInsc) {
                            if (c.getNumeroInscritos() < c.getCupoMaximo()) {
                                c.setNumeroInscritos(c.getNumeroInscritos() + 1);
                                historial.registrarAccion("Inscribio alumno en curso: " + c.getNombre());
                                System.out.println("Estudiante inscrito con exito.");
                            } else {
                                System.out.println("El curso esta lleno (cupo maximo alcanzado).");
                            }
                            inscritoExito = true;
                            break;
                        }
                    }
                    if (!inscritoExito) System.out.println("Curso no encontrado.");
                    break;

                case 5:
                    if (listaCursos.isEmpty()) {
                        System.out.println("No existen cursos registrados.");
                        break;
                    }
                    System.out.print("Ingrese el ID del curso para dar de baja estudiante: ");
                    int idBaja = scanner.nextInt();
                    boolean bajaExito = false;
                    for (Curso c : listaCursos) {
                        if (c.getIdCurso() == idBaja) {
                            if (c.getNumeroInscritos() > 0) {
                                c.setNumeroInscritos(c.getNumeroInscritos() - 1);
                                historial.registrarAccion("Dio de baja alumno en curso: " + c.getNombre());
                                System.out.println("Estudiante dado de baja correctamente.");
                            } else {
                                System.out.println("El curso tiene cero inscritos, no se puede dar de baja.");
                            }
                            bajaExito = true;
                            break;
                        }
                    }
                    if (!bajaExito) System.out.println("Curso no encontrado.");
                    break;

                    case 6:
                       if (listaCursos.isEmpty()) {
                       System.out.println("No existen cursos para insertar en el arbol.");
                       break;
                           }
                         for (Curso c : listaCursos) {
                         arbolCursos.insertar(c);
                          }
                         historial.registrarAccion("Inserto todos los cursos en el Arbol Binario");
                         System.out.println("Cursos volcados e insertados en el Arbol Binario de Busqueda.");
                        break;

                case 7:
                    System.out.print("Ingrese el ID del curso a buscar en el arbol: ");
                    int idArbol = scanner.nextInt();
                    Curso encontradoArbol = arbolCursos.buscar(idArbol);
                    if (encontradoArbol != null) {
                        System.out.println("Curso encontrado en el arbol: " + encontradoArbol);
                    } else {
                        System.out.println("Busqueda sin resultados en el arbol binario.");
                    }
                    break;

                case 8:
                    arbolCursos.mostrarInorden();
                    break;

                case 9:
                    if (listaCursos.size() < 2) {
                        System.out.println("Se requieren al menos 2 cursos para crear relaciones (grafo).");
                        break;
                    }
                    System.out.print("ID del Curso Origen: ");
                    int ori = scanner.nextInt();
                    System.out.print("ID del Curso Destino: ");
                    int des = scanner.nextInt();
                    System.out.print("Peso / Nivel de dificultad (ej. 1 al 5): ");
                    int peso = scanner.nextInt();
                    grafoCursos.agregarArista(ori, des, peso);
                    historial.registrarAccion("Creo relacion en grafo entre ID " + ori + " y ID " + des);
                    break;

                case 10:
                    grafoCursos.mostrarMatriz();
                    break;

                case 11:
                    if (listaCursos.isEmpty()) { System.out.println("No hay cursos."); break; }
                    Ordenamientos.bubbleSortDirecto(listaCursos);
                    historial.registrarAccion("Ordeno cursos con Bubble Sort Directo");
                    break;

                case 12:
                    if (listaCursos.isEmpty()) { System.out.println("No hay cursos."); break; }
                    Ordenamientos.bubbleSortInverso(listaCursos);
                    historial.registrarAccion("Ordeno cursos con Bubble Sort Inverso");
                    break;

                case 13:
                    if (listaCursos.isEmpty()) { System.out.println("No hay cursos."); break; }
                    Ordenamientos.insercionDirecta(listaCursos);
                    historial.registrarAccion("Ordeno cursos con Insercion Directa");
                    break;

                case 14:
                    if (listaCursos.isEmpty()) { System.out.println("No hay cursos."); break; }
                    Ordenamientos.seleccionDirecta(listaCursos);
                    historial.registrarAccion("Ordeno cursos con Seleccion Directa");
                    break;

                case 15:
                    if (listaCursos.isEmpty()) { System.out.println("No hay cursos."); break; }
                    System.out.print("Ingrese ID a buscar (Secuencial): ");
                    int idSec = scanner.nextInt();
                    Curso resSec = Busquedas.busquedaSecuencial(listaCursos, idSec);
                    if (resSec != null) System.out.println("Encontrado: " + resSec);
                    else System.out.println("Busqueda sin resultados.");
                    break;

                case 16:
                    if (listaCursos.isEmpty()) { System.out.println("No hay cursos."); break; }
                    System.out.println("Nota: Asegurese de haber ordenado los cursos previamente.");
                    System.out.print("Ingrese ID a buscar (Binaria): ");
                    int idBin = scanner.nextInt();
                    Curso resBin = Busquedas.busquedaBinaria(listaCursos, idBin);
                    if (resBin != null) System.out.println("Encontrado: " + resBin);
                    else System.out.println("Busqueda sin resultados.");
                    break;

                case 17:
                    historial.mostrarHistorial();
                    break;

                case 18:
                    if (listaCursos.isEmpty()) { 
                        System.out.println("No hay cursos."); 
                        break; 
                    }
                    System.out.print("Ingrese el ID de curso a buscar para comparar algoritmos: ");
                    int idComp = scanner.nextInt();
                    System.out.println("\n--- COMPARATIVA DE BUSQUEDA ---");
                    Busquedas.busquedaSecuencial(listaCursos, idComp);
                    ArrayList<Curso> copiaOrdenada = new ArrayList<>(listaCursos);
                    Ordenamientos.insercionDirecta(copiaOrdenada);
                    Busquedas.busquedaBinaria(copiaOrdenada, idComp);
                    break;

                case 19:
                    System.out.println("Saliendo del sistema de gestion de cursos. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (opcion != 19);
        scanner.close();
    }
}