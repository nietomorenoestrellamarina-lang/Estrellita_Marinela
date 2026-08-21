public class edades {
    public static void main(String[] args) {
        
        
        int[] edades = {14, 25, 17, 30, 12, 18};
        
        
        int cantidadMayores = 0;
        int cantidadMenores = 0;
        
                for (int i = 0; i < edades.length; i++) {
            
            
            if (edades[i] >= 18) {
                cantidadMayores++;             } else {
                cantidadMenores++;             }
        }
        
        
        System.out.println("EN MI FAMILIA SOMOS:");
        System.out.println("Total de personas: " + edades.length);
        System.out.println("Cantidad de mayores de edad : " + cantidadMayores);
        System.out.println("Cantidad de menores de edad  : " + cantidadMenores);
    }
}