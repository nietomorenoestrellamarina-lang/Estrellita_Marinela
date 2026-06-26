import java.util.LinkedList;
import java.util.Queue;

public class Filadepersonas {
    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();

        fila.add("Ana");
        fila.add("Luis");
        fila.add("Pedro");
        fila.add("María");
        fila.add("Carlos");

        System.out.println("Frente de la fila: " + fila.peek());

        System.out.println("Atendiendo a: " + fila.poll());
        System.out.println("Atendiendo a: " + fila.poll());

        System.out.println("Cola restante: " + fila);
    }
}