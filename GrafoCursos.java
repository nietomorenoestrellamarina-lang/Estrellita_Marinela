public class GrafoCursos {

    private Curso[] cursos;
    private int[][] matriz;
    private int cantidad;

    public GrafoCursos(int capacidad) {
        cursos = new Curso[capacidad];
        matriz = new int[capacidad][capacidad];
        cantidad = 0;
    }

    // Agregar un curso como vértice
    public void agregarCurso(Curso curso) {

        if (cantidad >= cursos.length) {
            System.out.println("El grafo está lleno.");
            return;
        }

        cursos[cantidad] = curso;
        cantidad++;

        System.out.println("Curso agregado al grafo.");
    }

    // Crear una relación entre dos cursos
    public void crearRelacion(int idCursoA, int idCursoB) {

        int posicionA = buscarPosicion(idCursoA);
        int posicionB = buscarPosicion(idCursoB);

        if (posicionA == -1 || posicionB == -1) {
            System.out.println(
                    "Uno o ambos cursos no existen en el grafo.");
            return;
        }

        matriz[posicionA][posicionB] = 1;

        System.out.println(
                "Relación creada correctamente.");
    }

    // Buscar la posición de un curso
    private int buscarPosicion(int idCurso) {

        for (int i = 0; i < cantidad; i++) {

            if (cursos[i].getIdCurso() == idCurso) {
                return i;
            }
        }

        return -1;
    }

    // Mostrar la matriz de adyacencia
    public void mostrarMatriz() {

        if (cantidad == 0) {
            System.out.println(
                    "No existen cursos en el grafo.");
            return;
        }

        System.out.println("\n===== MATRIZ DE ADYACENCIA =====");

        System.out.print("     ");

        for (int i = 0; i < cantidad; i++) {
            System.out.print(
                    cursos[i].getIdCurso() + "   ");
        }

        System.out.println();

        for (int i = 0; i < cantidad; i++) {

            System.out.print(
                    cursos[i].getIdCurso() + "    ");

            for (int j = 0; j < cantidad; j++) {
                System.out.print(
                        matriz[i][j] + "   ");
            }

            System.out.println();
        }
    }
}
