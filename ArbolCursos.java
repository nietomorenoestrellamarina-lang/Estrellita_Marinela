public class ArbolCursos {
    private NodoArbolCurso raiz;

    public ArbolCursos() {
        this.raiz = null;
    }

    public void insertar(Curso curso) {
        raiz = insertarRec(raiz, curso);
    }

    private NodoArbolCurso insertarRec(NodoArbolCurso actual, Curso curso) {
        if (actual == null) {
            return new NodoArbolCurso(curso);
        }
        if (curso.getIdCurso() < actual.curso.getIdCurso()) {
            actual.izquierdo = insertarRec(actual.izquierdo, curso);
        } else if (curso.getIdCurso() > actual.curso.getIdCurso()) {
            actual.derecho = insertarRec(actual.derecho, curso);
        } else {
            System.out.println("El ID de curso ya existe en el arbol.");
        }
        return actual;
    }

    public Curso buscar(int idCurso) {
        return buscarRec(raiz, idCurso);
    }

    private Curso buscarRec(NodoArbolCurso actual, int idCurso) {
        if (actual == null || actual.curso.getIdCurso() == idCurso) {
            return actual != null ? actual.curso : null;
        }
        if (idCurso < actual.curso.getIdCurso()) {
            return buscarRec(actual.izquierdo, idCurso);
        }
        return buscarRec(actual.derecho, idCurso);
    }

    public void mostrarInorden() {
        if (raiz == null) {
            System.out.println("El arbol binario esta vacio.");
            return;
        }
        System.out.println("\n--- RECORRIDO INORDEN (ARBOL DE CURSOS) ---");
        inordenRec(raiz);
    }

    private void inordenRec(NodoArbolCurso actual) {
        if (actual != null) {
            inordenRec(actual.izquierdo);
            System.out.println(actual.curso);
            inordenRec(actual.derecho);
        }
    }
}