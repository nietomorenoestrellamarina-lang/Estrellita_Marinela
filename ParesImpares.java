import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ParesImpares {
    public static void main(String[] args) {

        Queue<Integer> numeros = new LinkedList<>();
        Queue<Integer> pares = new LinkedList<>();
        Queue<Integer> impares = new LinkedList<>();

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int num = random.nextInt(100) + 1;
            numeros.add(num);

            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }

        System.out.println("Cola original: " + numeros);
        System.out.println("Cola de pares: " + pares);
        System.out.println("Cola de impares: " + impares);
    }
}