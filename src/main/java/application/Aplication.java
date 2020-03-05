package application;

import controller.CalculatorController;
import model.Model;
import view.CalculatorView;


class Application {


    public static void main(String[] args) {
        Model model=new Model() ;
        CalculatorView view = new CalculatorView();
        CalculatorController a1=new CalculatorController(model, view);
        view.setVisible(true);
    }

}