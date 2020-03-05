package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import controller.CalculatorController;
import model.Model;


public class CalculatorView extends JFrame implements Observer {
    JTextField result=new JTextField("0",13);
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five= new JButton("5");
    JButton six= new JButton("6");
    JButton seven= new JButton("7");
    JButton eight= new JButton("8");
    JButton nine= new JButton("9");
    JButton sum=new JButton("+");
    JButton rest=new JButton("-");
    JButton mult=new JButton("*");
    JButton divis=new JButton("/");
    JButton equal=new JButton("=");
    JButton white=new JButton(" ");
    Model model;
    CalculatorController controller;

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalculatorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculatorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculatorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculatorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculatorView().setVisible(true);
            }
        });
    }

    public CalculatorView() {
        super("Calculator MVC");
        setSize(190, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setName("Form");
        one.setName("one");
        two.setName("two");
        three.setName("three");
        four.setName("four");
        five.setName("five");
        six.setName("six");
        seven.setName("seven");
        eight.setName("eight");
        nine.setName("nine");

        pane.add(result);
        pane.add(one);
        pane.add(two);
        pane.add(three);
        pane.add(four);
        pane.add(five);
        pane.add(six);
        pane.add(seven);
        pane.add(eight);
        pane.add(nine);
        pane.add(sum);
        pane.add(rest);
        pane.add(divis);
        pane.add(mult);
        pane.add(equal);
        pane.add(white);
        add(pane);
        System.out.println("Constructor del View");
        Model b=new Model();
        CalculatorController  a1=new CalculatorController(b,this);
        //setController(controller);
        //setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public void setModel(Model model){
        this.model=model;
        model.addObserver(this);
    }

    public void setController(CalculatorController controller){
        this.controller = controller;

        result.addKeyListener(controller);

       // b0.addMouseListener(controller);
        one.addMouseListener(controller);
        two.addMouseListener(controller);
        three.addMouseListener(controller);
        four.addMouseListener(controller);
        five.addMouseListener(controller);
        six.addMouseListener(controller);
        seven.addMouseListener(controller);
        eight.addMouseListener(controller);
        nine.addMouseListener(controller);

        
        sum.addActionListener(controller);
        rest.addActionListener(controller);
        mult.addActionListener(controller);
        divis.addActionListener(controller);
        equal.addActionListener(controller);
    }

    public void update(Observable updatedModel,Object param){
        this.result.setText(model.getCurrent());
    }


}