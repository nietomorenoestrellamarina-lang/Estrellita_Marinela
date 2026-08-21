public class Ordenamientos {

    // Bubble Sort directo
    public static void bubbleSortDirecto(Curso[] cursos, int cantidad) {

        for (int i = 0; i < cantidad - 1; i++) {

            for (int j = 0; j < cantidad - 1 - i; j++) {

                if (cursos[j].getIdCurso() >
                    cursos[j + 1].getIdCurso()) {

                    Curso temporal = cursos[j];
                    cursos[j] = cursos[j + 1];
                    cursos[j + 1] = temporal;
                }
            }
        }

        System.out.println(
                "Cursos ordenados con Bubble Sort directo.");
    }

    // Bubble Sort inverso
    public static void bubbleSortInverso(
            Curso[] cursos, int cantidad) {

        for (int i = 0; i < cantidad - 1; i++) {

            for (int j = 0; j < cantidad - 1 - i; j++) {

                if (cursos[j].getIdCurso() <
                    cursos[j + 1].getIdCurso()) {

                    Curso temporal = cursos[j];
                    cursos[j] = cursos[j + 1];
                    cursos[j + 1] = temporal;
                }
            }
        }

        System.out.println(
                "Cursos ordenados con Bubble Sort inverso.");
    }

    // Inserción directa
    public static void insercionDirecta(
            Curso[] cursos, int cantidad) {

        for (int i = 1; i < cantidad; i++) {

            Curso actual = cursos[i];
            int j = i - 1;

            while (j >= 0 &&
                   cursos[j].getIdCurso() >
                   actual.getIdCurso()) {

                cursos[j + 1] = cursos[j];
                j--;
            }

            cursos[j + 1] = actual;
        }

        System.out.println(
                "Cursos ordenados con inserción directa.");
    }

    // Selección directa
    public static void seleccionDirecta(
            Curso[] cursos, int cantidad) {

        for (int i = 0; i < cantidad - 1; i++) {

            int posicionMenor = i;

            for (int j = i + 1; j < cantidad; j++) {

                if (cursos[j].getIdCurso() <
                    cursos[posicionMenor].getIdCurso()) {

                    posicionMenor = j;
                }
            }

            Curso temporal = cursos[i];
            cursos[i] = cursos[posicionMenor];
            cursos[posicionMenor] = temporal;
        }

        System.out.println(
                "Cursos ordenados con selección directa.");
    }

    // Mostrar cursos
    public static void mostrarCursos(
            Curso[] cursos, int cantidad) {

        if (cantidad == 0) {
            System.out.println(
                    "No existen cursos registrados.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println(cursos[i]);
        }
    }
}
