package model;

import java.util.Observable;


public class Model extends Observable{
    String current;
    int memory;
    char operation;

    public Model() {
        current = "0";
        memory=0;
        operation=' ';
    }
    public String getCurrent() {
        return current;
    }
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(null);
    }
    public void digit(char d){
        current = ((current.equals("0"))? "" : current) + d;
        this.setChanged();
        this.notifyObservers(null);
    }

    public void clear(){
        current="0";
        setChanged();
        notifyObservers(null);
    }

    public void operation(char o){
        memory=Integer.parseInt(current);
        current="0";
        operation=o;
        setChanged();
        notifyObservers(null);
    }

    public void compute(){
        switch(operation){
            case '+':
                memory = memory + Integer.parseInt(current);
                break;
            case '-':
                memory = memory - Integer.parseInt(current);
                break;
            case '*':
                memory = memory * Integer.parseInt(current);
                break;
            case '/':
                memory = memory / Integer.parseInt(current);
                break;
        }
        current=""+memory;
        operation=' ';
        setChanged();
        notifyObservers(null);
    }

}
