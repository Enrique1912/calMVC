package controller;

import model.Model;
import view.CalculatorView;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;


public class CalculatorController implements MouseListener, KeyListener, ActionListener {
    Model model;
    CalculatorView view;

    public CalculatorController(Model model, CalculatorView view) {
        System.out.println("Ingreso al controller");
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    // MouseListener Interface
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton digit =(JButton)e.getSource();
        model.digit(digit.getText().charAt(0));
        //actionPerformed(MouseEvent e);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(("0123456789".indexOf(e.getKeyChar())>=0)){
            model.digit(e.getKeyChar());
        }
        e.consume();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        switch(evt.getActionCommand()){
            case "sum":
                model.operation('+');
                break;
            case "rest":
                model.operation('-');
                break;
            case "mult":
                model.operation('*');
                break;
            case "divis":
                model.operation('/');
                break;
            case "equal":
                model.compute();
                break;
        }
    }
}