public class ArbolCursos {

    private NodoArbolCurso raiz;

    public ArbolCursos() {
        raiz = null;
    }

    // Insertar un curso en el árbol
    public void insertar(Curso curso) {
        raiz = insertarRecursivo(raiz, curso);
    }

    private NodoArbolCurso insertarRecursivo(
            NodoArbolCurso nodo, Curso curso) {

        if (nodo == null) {
            return new NodoArbolCurso(curso);
        }

        if (curso.getIdCurso() < nodo.curso.getIdCurso()) {
            nodo.izquierda =
                    insertarRecursivo(nodo.izquierda, curso);

        } else if (curso.getIdCurso() > nodo.curso.getIdCurso()) {
            nodo.derecha =
                    insertarRecursivo(nodo.derecha, curso);

        } else {
            System.out.println(
                    "Error: ya existe un curso con ese ID.");
        }

        return nodo;
    }

    // Buscar un curso por ID
    public Curso buscar(int idCurso) {
        NodoArbolCurso resultado =
                buscarRecursivo(raiz, idCurso);

        if (resultado != null) {
            return resultado.curso;
        }

        return null;
    }

    private NodoArbolCurso buscarRecursivo(
            NodoArbolCurso nodo, int idCurso) {

        if (nodo == null) {
            return null;
        }

        if (idCurso == nodo.curso.getIdCurso()) {
            return nodo;
        }

        if (idCurso < nodo.curso.getIdCurso()) {
            return buscarRecursivo(
                    nodo.izquierda, idCurso);
        }

        return buscarRecursivo(
                nodo.derecha, idCurso);
    }

    // Recorrido inorden
    public void inorden() {
        if (raiz == null) {
            System.out.println(
                    "El árbol no tiene cursos registrados.");
            return;
        }

        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(NodoArbolCurso nodo) {

        if (nodo != null) {

            inordenRecursivo(nodo.izquierda);

            System.out.println(nodo.curso);

            inordenRecursivo(nodo.derecha);
        }
    }
}