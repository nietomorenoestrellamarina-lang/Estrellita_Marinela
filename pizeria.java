public class pizeria{
    static void main(){
        int tipoPizza=7;
        char ingrediente='a';
        switch(tipoPizza){
            case 1:
                System.out.println("a.Pimiento b.Tofu");
                break;
            case 2:
                System.out.println("a.Peperoni b.Jamon c.Salmon");
                break;
            default:
                System.out.println("Tipo de pizza no disponible")
            ;
        }
    }
}