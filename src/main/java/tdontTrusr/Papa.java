package tdontTrusr;

public class Papa {
    {
        System.out.println("initializer Papa");
    }
    static { System.out.println("static Papa"); }
    Papa() {
        System.out.println("constructor Papa");
        papaMethod();
    }
    public void papaMethod(){
        System.out.println("Save the world");
    }
}