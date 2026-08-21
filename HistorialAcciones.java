import java.util.ArrayList;

public class HistorialAcciones {

    private ArrayList<String> historial;

    public HistorialAcciones() {
        historial = new ArrayList<>();
    }

    // Registrar una acción
    public void registrar(String accion) {
        historial.add(accion);
    }

    // Mostrar historial
    public void mostrarHistorial() {

        if (historial.isEmpty()) {

            System.out.println(
                    "No hay acciones registradas.");

            return;
        }

        System.out.println(
                "\n===== HISTORIAL DE ACCIONES =====");

        for (int i = 0; i < historial.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + historial.get(i));
        }
    }
}