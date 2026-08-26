public class Curso {
    private int idCurso;
    private String clave;
    private String nombre;
    private String docente;
    private int cupoMaximo;
    private int numeroInscritos;

    public Curso(int idCurso, String clave, String nombre, String docente, int cupoMaximo) {
        this.idCurso = idCurso;
        this.clave = clave;
        this.nombre = nombre;
        this.docente = docente;
        this.cupoMaximo = cupoMaximo;
        this.numeroInscritos = 0;
    }

    public int getIdCurso() { return idCurso; }
    public void setIdCurso(int idCurso) { this.idCurso = idCurso; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDocente() { return docente; }
    public void setDocente(String docente) { this.docente = docente; }

    public int getCupoMaximo() { return cupoMaximo; }
    public void setCupoMaximo(int cupoMaximo) { this.cupoMaximo = cupoMaximo; }

    public int getNumeroInscritos() { return numeroInscritos; }
    public void setNumeroInscritos(int numeroInscritos) { this.numeroInscritos = numeroInscritos; }

    @Override
    public String toString() {
        return "ID: " + idCurso + " | Clave: " + clave + " | Nombre: " + nombre + 
               " | Docente: " + docente + " | Cupo: " + numeroInscritos + "/" + cupoMaximo;
    }
}