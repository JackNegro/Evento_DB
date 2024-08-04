package Utils;

import java.util.ArrayList;

public class Listados {
    private ArrayList<String> departamentos;
    private ArrayList<String> decoraciones;
    private ArrayList<String> categorias;

    public void addElement(ArrayList<String> lista, String e){
        lista.add(e);
    }

    public ArrayList<String> getListado(int op){
        switch (op){
            case 1:
                return departamentos;
            case 2:
                return decoraciones;
            case 3:
                return categorias;
            default:
                System.out.println(op+ " Incorrect");
        }
        return null;
    }
}
