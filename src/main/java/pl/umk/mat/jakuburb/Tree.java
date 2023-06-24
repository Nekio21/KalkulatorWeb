package pl.umk.mat.jakuburb;

public class Tree{
    private Tree leftTree;
    private Tree rightTree;

    private Operation operation;
    private Ulamek value;


    private Tree(Operation operation){
        this.operation = operation;
    }

    private Tree(Ulamek value){
        operation = Operation.VALUE;
        this.value = value;
    }

    public static Tree getTree(String s) throws Exception {
        int i = 0;

        switch(s){
            case "+":
                return new Tree(Operation.DODAJ);
            case "-":
                return new Tree(Operation.ODEJMIJ);
            case "*":
            case "x":
                return new Tree(Operation.RAZY);
            case "/":
                return new Tree(Operation.PODZIEL);
        }

        try {
            i = Integer.parseInt(s);
        }catch(Exception e){
            throw new Exception("Zle dane :<");
        }

        return new Tree(new Ulamek(i,1));
    }

    //lewy prawy
    public boolean addToTree(Tree tree){
        boolean wynik = false;

        if(operation != Operation.VALUE) {

            if (rightTree == null) {
                rightTree = tree;
                return true;
            } else if (rightTree.operation != Operation.VALUE) {
                wynik = rightTree.addToTree(tree);
                if(wynik) return true;
            }

            if (leftTree == null) {
                leftTree = tree;
                return true;
            } else if (leftTree.operation != Operation.VALUE) {
                wynik = leftTree.addToTree(tree);
                if(wynik) return true;
            }
        }

        return false;
    }

    public boolean checkTree(){

        System.out.println("[");

        if((operation == Operation.VALUE) && (leftTree == null) && (rightTree == null)){
            System.out.print("[" + value + "]");
            return true;
        }

        if((operation != Operation.VALUE) && (leftTree != null) && (rightTree != null)){
            System.out.print(operation.name() + "->");
            return leftTree.checkTree() && rightTree.checkTree();
        }

        System.out.println("]");


        return false;
    }

    public void setRightTree(Tree rightTree){
        this.rightTree = rightTree;
    }

    public void setLeftTee(Tree leftTree){
        this.leftTree = leftTree;
    }

    public Tree getLeftTree(){
        return leftTree;
    }

    public Tree getRightTree(){
        return rightTree;
    }

    public void setLeftTree(Tree leftTree) {
        this.leftTree = leftTree;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Ulamek getValue() {
        return value;
    }

    public void setValue(Ulamek value) {
        this.value = value;
    }
}

