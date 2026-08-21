public class Busquedas {

    // Búsqueda secuencial
    public static Curso busquedaSecuencial(
            Curso[] cursos, int cantidad, int idBuscado) {

        for (int i = 0; i < cantidad; i++) {

            if (cursos[i].getIdCurso() == idBuscado) {
                return cursos[i];
            }
        }

        return null;
    }

    // Búsqueda binaria
    public static Curso busquedaBinaria(
            Curso[] cursos, int cantidad, int idBuscado) {

        int inicio = 0;
        int fin = cantidad - 1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            int idMedio = cursos[medio].getIdCurso();

            if (idMedio == idBuscado) {
                return cursos[medio];
            }

            if (idBuscado < idMedio) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        return null;
    }

    // Mostrar resultado de búsqueda
    public static void mostrarResultado(
            Curso curso, String tipoBusqueda) {

        if (curso != null) {

            System.out.println(
                    "\nCurso encontrado mediante "
                    + tipoBusqueda + ":");

            System.out.println(curso);

        } else {

            System.out.println(
                    "\nNo se encontró el curso.");
        }
    }
}