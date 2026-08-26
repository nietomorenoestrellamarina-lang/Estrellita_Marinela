import java.util.ArrayList;

public class Ordenamientos {

    public static void bubbleSortDirecto(ArrayList<Curso> cursos) {
        int n = cursos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (cursos.get(j).getIdCurso() > cursos.get(j + 1).getIdCurso()) {
                    Curso temp = cursos.get(j);
                    cursos.set(j, cursos.get(j + 1));
                    cursos.set(j + 1, temp);
                }
            }
        }
        System.out.println("Cursos ordenados por Bubble Sort Directo (por ID).");
    }

    public static void bubbleSortInverso(ArrayList<Curso> cursos) {
        int n = cursos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (cursos.get(j).getIdCurso() < cursos.get(j + 1).getIdCurso()) {
                    Curso temp = cursos.get(j);
                    cursos.set(j, cursos.get(j + 1));
                    cursos.set(j + 1, temp);
                }
            }
        }
        System.out.println("Cursos ordenados por Bubble Sort Inverso (por ID).");
    }

    public static void insercionDirecta(ArrayList<Curso> cursos) {
        int n = cursos.size();
        for (int i = 1; i < n; ++i) {
            Curso key = cursos.get(i);
            int j = i - 1;
            while (j >= 0 && cursos.get(j).getIdCurso() > key.getIdCurso()) {
                cursos.set(j + 1, cursos.get(j));
                j = j - 1;
            }
            cursos.set(j + 1, key);
        }
        System.out.println("Cursos ordenados por Insercion Directa (por ID).");
    }

    public static void seleccionDirecta(ArrayList<Curso> cursos) {
        int n = cursos.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (cursos.get(j).getIdCurso() < cursos.get(minIdx).getIdCurso()) {
                    minIdx = j;
                }
            }
            Curso temp = cursos.get(minIdx);
            cursos.set(minIdx, cursos.get(i));
            cursos.set(i, temp);
        }
        System.out.println("Cursos ordenados por Seleccion Directa (por ID).");
    }
}