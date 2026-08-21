import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Curso> listaCursos = new ArrayList<>();

    static ArbolCursos arbol = new ArbolCursos();

    static GrafoCursos grafo = new GrafoCursos(50);

    static HistorialAcciones historial =
            new HistorialAcciones();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {

                case 1:
                    agregarCurso();
                    break;

                case 2:
                    mostrarCursos();
                    break;

                case 3:
                    eliminarCurso();
                    break;

                case 4:
                    inscribirEstudiante();
                    break;

                case 5:
                    darDeBajaEstudiante();
                    break;

                case 6:
                    insertarCursosArbol();
                    break;

                case 7:
                    buscarCursoArbol();
                    break;

                case 8:
                    arbol.inorden();
                    break;

                case 9:
                    crearRelacion();
                    break;

                case 10:
                    grafo.mostrarMatriz();
                    break;

                case 11:
                    ordenarBubbleDirecto();
                    break;

                case 12:
                    ordenarBubbleInverso();
                    break;

                case 13:
                    ordenarInsercion();
                    break;

                case 14:
                    ordenarSeleccion();
                    break;

                case 15:
                    busquedaSecuencial();
                    break;

                case 16:
                    busquedaBinaria();
                    break;

                case 17:
                    historial.mostrarHistorial();
                    break;

                case 18:
                    System.out.println(
                            "Saliendo del sistema...");
                    break;

                default:
                    System.out.println(
                            "Opción no válida.");
            }

        } while (opcion != 18);

        scanner.close();
    }

    // =========================
    // MENÚ
    // =========================

    public static void mostrarMenu() {

        System.out.println();
        System.out.println(
                "===== SISTEMA DE GESTIÓN DE CURSOS UTC 3.0 =====");

        System.out.println("1. Agregar curso");
        System.out.println("2. Mostrar cursos");
        System.out.println("3. Eliminar curso");
        System.out.println("4. Inscribir estudiante");
        System.out.println("5. Dar de baja estudiante");
        System.out.println("6. Insertar cursos en árbol binario");
        System.out.println("7. Buscar curso en árbol binario");
        System.out.println("8. Mostrar recorrido inorden del árbol");
        System.out.println("9. Crear relación entre cursos (grafo)");
        System.out.println("10. Mostrar grafo o matriz de adyacencia");
        System.out.println("11. Ordenar cursos con Bubble Sort directo");
        System.out.println("12. Ordenar cursos con Bubble Sort inverso");
        System.out.println("13. Ordenar cursos con inserción directa");
        System.out.println("14. Ordenar cursos con selección directa");
        System.out.println("15. Búsqueda secuencial");
        System.out.println("16. Búsqueda binaria");
        System.out.println("17. Mostrar historial de acciones");
        System.out.println("18. Salir");

        System.out.println();
    }

    // =========================
    // AGREGAR CURSO
    // =========================

    public static void agregarCurso() {

        int id = leerEntero("ID del curso: ");

        if (buscarPorId(id) != null) {
            System.out.println(
                    "Error: el ID ya existe.");
            return;
        }

        System.out.print("Clave del curso: ");
        String clave = scanner.nextLine();

        if (buscarPorClave(clave) != null) {
            System.out.println(
                    "Error: la clave ya existe.");
            return;
        }

        System.out.print("Nombre del curso: ");
        String nombre = scanner.nextLine();

        System.out.print("Docente: ");
        String docente = scanner.nextLine();

        int cupo = leerEntero(
                "Cupo máximo: ");

        int inscritos = leerEntero(
                "Número de inscritos: ");

        if (inscritos < 0 || inscritos > cupo) {
            System.out.println(
                    "Cantidad de inscritos no válida.");
            return;
        }

        Curso curso = new Curso(
                id,
                clave,
                nombre,
                docente,
                cupo,
                inscritos
        );

        listaCursos.add(curso);

        grafo.agregarCurso(curso);

        historial.registrar(
                "Curso agregado: " + nombre);

        System.out.println(
                "Curso agregado correctamente.");
    }

    // =========================
    // MOSTRAR CURSOS
    // =========================

    public static void mostrarCursos() {

        if (listaCursos.isEmpty()) {
            System.out.println(
                    "No existen cursos registrados.");
            return;
        }

        System.out.println(
                "\n===== CURSOS REGISTRADOS =====");

        for (Curso curso : listaCursos) {
            System.out.println(curso);
        }
    }

    // =========================
    // ELIMINAR CURSO
    // =========================

    public static void eliminarCurso() {

        int id = leerEntero(
                "ID del curso a eliminar: ");

        Curso curso = buscarPorId(id);

        if (curso == null) {
            System.out.println(
                    "Curso no encontrado.");
            return;
        }

        listaCursos.remove(curso);

        historial.registrar(
                "Curso eliminado: " + curso.getNombre());

        System.out.println(
                "Curso eliminado correctamente.");
    }

    // =========================
    // INSCRIBIR ESTUDIANTE
    // =========================

    public static void inscribirEstudiante() {

        int id = leerEntero(
                "ID del curso: ");

        Curso curso = buscarPorId(id);

        if (curso == null) {
            System.out.println(
                    "Curso no encontrado.");
            return;
        }

        if (curso.getNumeroInscritos()
                >= curso.getCupoMaximo()) {

            System.out.println(
                    "No se puede inscribir: el curso está lleno.");

            return;
        }

        curso.setNumeroInscritos(
                curso.getNumeroInscritos() + 1);

        historial.registrar(
                "Estudiante inscrito en: "
                + curso.getNombre());

        System.out.println(
                "Estudiante inscrito correctamente.");
    }

    // =========================
    // DAR DE BAJA
    // =========================

    public static void darDeBajaEstudiante() {

        int id = leerEntero(
                "ID del curso: ");

        Curso curso = buscarPorId(id);

        if (curso == null) {
            System.out.println(
                    "Curso no encontrado.");
            return;
        }

        if (curso.getNumeroInscritos() == 0) {

            System.out.println(
                    "No se puede realizar la baja: "
                    + "el curso tiene cero inscritos.");

            return;
        }

        curso.setNumeroInscritos(
                curso.getNumeroInscritos() - 1);

        historial.registrar(
                "Estudiante dado de baja de: "
                + curso.getNombre());

        System.out.println(
                "Baja realizada correctamente.");
    }

    // =========================
    // ÁRBOL
    // =========================

    public static void insertarCursosArbol() {

        if (listaCursos.isEmpty()) {

            System.out.println(
                    "No existen cursos registrados.");

            return;
        }

        for (Curso curso : listaCursos) {
            arbol.insertar(curso);
        }

        historial.registrar(
                "Cursos insertados en el árbol binario.");

        System.out.println(
                "Cursos insertados en el árbol.");
    }

    public static void buscarCursoArbol() {

        int id = leerEntero(
                "ID del curso a buscar: ");

        Curso curso = arbol.buscar(id);

        if (curso != null) {

            System.out.println(
                    "Curso encontrado:");

            System.out.println(curso);

            historial.registrar(
                    "Búsqueda en árbol: ID " + id);

        } else {

            System.out.println(
                    "Curso no encontrado.");
        }
    }

    // =========================
    // GRAFO
    // =========================

    public static void crearRelacion() {

        int idA = leerEntero(
                "ID del curso origen: ");

        int idB = leerEntero(
                "ID del curso destino: ");

        grafo.crearRelacion(idA, idB);

        historial.registrar(
                "Relación creada: "
                + idA + " -> " + idB);
    }

    // =========================
    // ORDENAMIENTOS
    // =========================

    public static Curso[] convertirArray() {

        return listaCursos.toArray(
                new Curso[0]);
    }

    public static void ordenarBubbleDirecto() {

        Curso[] cursos = convertirArray();

        Ordenamientos.bubbleSortDirecto(
                cursos,
                cursos.length);

        Ordenamientos.mostrarCursos(
                cursos,
                cursos.length);

        historial.registrar(
                "Bubble Sort directo ejecutado.");
    }

    public static void ordenarBubbleInverso() {

        Curso[] cursos = convertirArray();

        Ordenamientos.bubbleSortInverso(
                cursos,
                cursos.length);

        Ordenamientos.mostrarCursos(
                cursos,
                cursos.length);

        historial.registrar(
                "Bubble Sort inverso ejecutado.");
    }

    public static void ordenarInsercion() {

        Curso[] cursos = convertirArray();

        Ordenamientos.insercionDirecta(
                cursos,
                cursos.length);

        Ordenamientos.mostrarCursos(
                cursos,
                cursos.length);

        historial.registrar(
                "Inserción directa ejecutada.");
    }

    public static void ordenarSeleccion() {

        Curso[] cursos = convertirArray();

        Ordenamientos.seleccionDirecta(
                cursos,
                cursos.length);

        Ordenamientos.mostrarCursos(
                cursos,
                cursos.length);

        historial.registrar(
                "Selección directa ejecutada.");
    }

    // =========================
    // BÚSQUEDA SECUENCIAL
    // =========================

    public static void busquedaSecuencial() {

        int id = leerEntero(
                "ID del curso a buscar: ");

        Curso curso =
                Busquedas.busquedaSecuencial(
                        listaCursos.toArray(
                                new Curso[0]),
                        listaCursos.size(),
                        id);

        Busquedas.mostrarResultado(
                curso,
                "búsqueda secuencial");

        historial.registrar(
                "Búsqueda secuencial: ID " + id);
    }

    // =========================
    // BÚSQUEDA BINARIA
    // =========================

    public static void busquedaBinaria() {

        if (listaCursos.isEmpty()) {

            System.out.println(
                    "No existen cursos registrados.");

            return;
        }

        Curso[] cursos = convertirArray();

        Ordenamientos.insercionDirecta(
                cursos,
                cursos.length);

        int id = leerEntero(
                "ID del curso a buscar: ");

        Curso curso =
                Busquedas.busquedaBinaria(
                        cursos,
                        cursos.length,
                        id);

        Busquedas.mostrarResultado(
                curso,
                "búsqueda binaria");

        historial.registrar(
                "Búsqueda binaria: ID " + id);
    }

    // =========================
    // BUSCAR POR ID
    // =========================

    public static Curso buscarPorId(int id) {

        for (Curso curso : listaCursos) {

            if (curso.getIdCurso() == id) {
                return curso;
            }
        }

        return null;
    }

    // =========================
    // BUSCAR POR CLAVE
    // =========================

    public static Curso buscarPorClave(
            String clave) {

        for (Curso curso : listaCursos) {

            if (curso.getClave()
                    .equalsIgnoreCase(clave)) {

                return curso;
            }
        }

        return null;
    }

    // =========================
    // LEER ENTERO
    // =========================

    public static int leerEntero(
            String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Integer.parseInt(
                        scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Ingresa un número válido.");
            }
        }
    }
}