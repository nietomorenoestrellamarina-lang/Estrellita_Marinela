import java.util.ArrayList;

public class GrafoCursos {
    private ArrayList<Curso> vertices;
    private int[][] matrizAdyacencia;
    private int capacidadMax;

    public GrafoCursos(int capacidadMax) {
        this.capacidadMax = capacidadMax;
        this.vertices = new ArrayList<>();
        this.matrizAdyacencia = new int[capacidadMax][capacidadMax];
    }

    public void agregarVertice(Curso curso) {
        if (vertices.size() < capacidadMax) {
            vertices.add(curso);
        }
    }

    public void agregarArista(int idOrigen, int idDestino, int peso) {
        int indexOrigen = obtenerIndicePorId(idOrigen);
        int indexDestino = obtenerIndicePorId(idDestino);

        if (indexOrigen != -1 && indexDestino != -1) {
            matrizAdyacencia[indexOrigen][indexDestino] = peso;
            System.out.println("Relacion creada correctamente (Peso/Dificultad: " + peso + ").");
        } else {
            System.out.println("Uno o ambos cursos no fueron encontrados en el sistema.");
        }
    }

    private int obtenerIndicePorId(int idCurso) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getIdCurso() == idCurso) {
                return i;
            }
        }
        return -1;
    }

    public void mostrarMatriz() {
        if (vertices.isEmpty()) {
            System.out.println("No hay cursos registrados en el grafo.");
            return;
        }
        System.out.println("\n--- MATRIZ DE ADYACENCIA (GRAFO) ---");
        System.out.print("\t");
        for (Curso c : vertices) {
            System.out.print("[ID:" + c.getIdCurso() + "]\t");
        }
        System.out.println();

        for (int i = 0; i < vertices.size(); i++) {
            System.out.print("[ID:" + vertices.get(i).getIdCurso() + "]\t");
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizAdyacencia[i][j] + "\t");
            }
            System.out.println();
        }
    }
}