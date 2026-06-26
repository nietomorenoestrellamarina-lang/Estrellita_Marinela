public class Fibonacci {
    public static void main(String[] args) {
        
        long a = 0;
        long b = 1;

        System.out.println("Los primeros 50 números de la sucesión de Fibonacci:");

        for (int i = 1; i <= 50; i++) {
            // Imprimimos la posición y el número actual
            System.out.println(i + ": " + a);

            
            long temporal = a;
            
            
            a = b;
            b = temporal + b;
        }
    }
}