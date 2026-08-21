public class Perro {

    // Atributos
    String nombre;
    String raza;
    int edad;

    // Constructor
    public Perro(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    // Método ladrar
    public void ladrar() {
        System.out.println("¡Guau guau!");
    }

    // Método presentarse
    public void presentarse() {
        System.out.println("Hola, soy " + nombre +
                ", de raza " + raza +
                " y tengo " + edad + " años.");
    }

    // Método principal
    public static void main(String[] args) {

        Perro perro1 = new Perro("El Huesos", "Xoloitzcuintle", 15);

        perro1.presentarse();
        perro1.ladrar();
    }
}