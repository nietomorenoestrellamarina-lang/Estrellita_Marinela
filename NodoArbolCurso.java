public class NodoArbolCurso {
    Curso curso;
    NodoArbolCurso izquierdo;
    NodoArbolCurso derecho;

    public NodoArbolCurso(Curso curso) {
        this.curso = curso;
        this.izquierdo = null;
        this.derecho = null;
    }
}