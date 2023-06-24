package pl.umk.mat.jakuburb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Kalkulator {

    private Tree tree;

    private ArrayList<String> argumenty;

    public Kalkulator(String dane) throws Exception {
        dane = dane.trim();

        String[] tab = dane.split(" ");

        for(int i=0;i<tab.length; i++){
            if("&#8722;".equals(tab[i])){
                tab[i] = "-";
            }
        }

        argumenty = new ArrayList<>(List.of(tab));

        argumenty.removeIf(""::equals);

        Collections.reverse(argumenty);

        initTree();
    }

    public Ulamek wynik() throws Exception {
        return wynik(tree);
    }

    public Ulamek wynik(Tree tree) throws Exception {
        switch (tree.getOperation()) {
            case DODAJ:
                return dodaj(wynik(tree.getLeftTree()), wynik(tree.getRightTree()));
            case ODEJMIJ:
                return odejmij(wynik(tree.getLeftTree()), wynik(tree.getRightTree()));
            case RAZY:
                return pomnurz(wynik(tree.getLeftTree()), wynik(tree.getRightTree()));
            case PODZIEL:
                return podziel(wynik(tree.getLeftTree()), wynik(tree.getRightTree()));
            case VALUE:
                return tree.getValue();
        }

        throw new Exception("Bledne dane :<");
    }

    private void initTree() throws Exception {
        tree = Tree.getTree(argumenty.get(0));
        argumenty.remove(0);

        for(String s: argumenty){
            Tree t = Tree.getTree(s);
            if(!tree.addToTree(t)){
                throw new Exception("Zle dane :<");
            }
        }

        argumenty.clear();

        if(tree.checkTree()==false) throw new Exception("Zle dane :<");
    }

    private Ulamek dodaj(Ulamek a, Ulamek b){
        return Ulamek.dodaj(a,b);
    }

    private Ulamek odejmij(Ulamek a, Ulamek b){
        return Ulamek.odejmij(a,b);
    }

    private Ulamek podziel(Ulamek a, Ulamek b){
        return Ulamek.podziel(a,b);
    }

    private Ulamek pomnurz(Ulamek a, Ulamek b){
        return Ulamek.pomnurz(a,b);
    }
}
