package tdontTrusr;

import java.util.ArrayList;
import java.util.List;

public class Son extends Papa {
    private final List cashe = new ArrayList();
    {System.out.println("initializer Son"); }
    static {System.out.println("static Son"); }
    Son() {System.out.println("constructor Son"); }
    @Override
    public void papaMethod(){cashe.add(1); }
}