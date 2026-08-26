import java.util.Stack;

public class HistorialAcciones {
    private Stack<String> pilaHistorial;

    public HistorialAcciones() {
        this.pilaHistorial = new Stack<>();
    }

    public void registrarAccion(String accion) {
        pilaHistorial.push(accion);
    }

    public void mostrarHistorial() {
        if (pilaHistorial.isEmpty()) {
            System.out.println("No hay acciones registradas en el historial.");
            return;
        }
        System.out.println("\n--- HISTORIAL DE ACCIONES (STACK) ---");
        for (int i = pilaHistorial.size() - 1; i >= 0; i--) {
            System.out.println("- " + pilaHistorial.get(i));
        }
    }
}