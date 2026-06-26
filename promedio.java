public class promedio {
    public static void main(String[] args) {
        
        
        int[] notas = {80, 95, 70, 100};
        
        
        int suma = 0;
        
                System.out.println("Calificaciones guardadas:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota en el cuatrimestre [" + i + "]: " + notas[i]);
            
                       suma = suma + notas[i]; 
        }
        
        System.out.println("---------------------------------");
        
       
        System.out.println("La suma total de las notas es: " + suma);
        
                double promedio = (double) suma / notas.length;
        System.out.println("El promedio del estudiante es: " + promedio);
    }
}