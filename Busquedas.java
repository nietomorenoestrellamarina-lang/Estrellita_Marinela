import java.util.ArrayList;

public class Busquedas {

    public static Curso busquedaSecuencial(ArrayList<Curso> cursos, int idBuscado) {
        int pasos = 0;
        for (Curso c : cursos) {
            pasos++;
            if (c.getIdCurso() == idBuscado) {
                System.out.println("[Busqueda Secuencial] Pasos realizados: " + pasos);
                return c;
            }
        }
        System.out.println("[Busqueda Secuencial] Pasos realizados: " + pasos);
        return null;
    }

    public static Curso busquedaBinaria(ArrayList<Curso> cursos, int idBuscado) {
        int inicio = 0;
        int fin = cursos.size() - 1;
        int pasos = 0;

        while (inicio <= fin) {
            pasos++;
            int medio = inicio + (fin - inicio) / 2;
            Curso cMedio = cursos.get(medio);

            if (cMedio.getIdCurso() == idBuscado) {
                System.out.println("[Busqueda Binaria] Pasos realizados: " + pasos);
                return cMedio;
            }
            if (cMedio.getIdCurso() < idBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        System.out.println("[Busqueda Binaria] Pasos realizados: " + pasos);
        return null;
    }
}