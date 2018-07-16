import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Calculadora complejos fundamentos de ingenieria de software
 * @author Luis Palomino
 * creado: 29/10/2017
 */
public class Calculadora extends JFrame{

    private JButton[] btnNumbers, btnOperands;
    private JButton erase, solve;
    private JTextArea equation;
    private int state;
    private String operand1Real, operand1Imag, operand2Real, operand2Imag, operator;
    
    /**
     * Create the application.
     */
    public Calculadora() {
        super();
        this.setBounds(100, 100, 500, 457);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#5e5d5d"));
        
        this.state = 0;
        this.operand1Real = "";
        this.operand2Real = "";
        this.operand1Imag = "";
        this.operand2Imag = "";
        this.operator = "";
        
        // 10 numeros de calculadora
        this.btnNumbers = new JButton[12];
        
        int cont = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(cont >= 10){
                    break;
                }
                this.btnNumbers[cont] = new JButton((cont == 9)? "0":cont+1+"");
                this.btnNumbers[cont].setBounds(40 +j*62, 130+i*62, 60, 60);
                this.btnNumbers[cont].setFont(new Font("normal", Font.BOLD, 18));
                this.btnNumbers[cont].setBackground(Color.decode("#424141"));
                this.btnNumbers[cont].setForeground(Color.white);
                this.btnNumbers[cont].setFocusPainted(false);
                this.btnNumbers[cont].addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        switch(Calculadora.this.state){
                        case 0:
                            Calculadora.this.operand1Real = ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.operand1Real);
                            Calculadora.this.state = 2;
                            break;
                        case 1:
                            Calculadora.this.operand1Real += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.operand1Real);
                            Calculadora.this.state = 2;
                            break;
                        case 2:
                            Calculadora.this.operand1Real += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.operand1Real);
                            break;
                        case 3:
                            Calculadora.this.operand1Real += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.operand1Real);
                            break;
                        case 4:
                            Calculadora.this.operand1Imag = ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + Calculadora.this.operand1Imag);
                            Calculadora.this.state = 6;
                            break;
                        case 5:
                            Calculadora.this.operand1Imag += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ((JButton) e.getSource()).getText());
                            Calculadora.this.state = 6;
                            break;
                        case 6:
                            Calculadora.this.operand1Imag += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ((JButton) e.getSource()).getText());
                            break;
                        case 7:
                            Calculadora.this.operand1Imag += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ((JButton) e.getSource()).getText());
                            break;
                        case 8:
                            Calculadora.this.operand2Real = ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + Calculadora.this.operand2Real);
                            Calculadora.this.state = 10;
                            break;
                        case 9:
                            Calculadora.this.operand2Real += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ((JButton) e.getSource()).getText());
                            Calculadora.this.state = 10;
                            break;
                        case 10:
                            Calculadora.this.operand2Real += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ((JButton) e.getSource()).getText());
                            break;
                        case 11:
                            Calculadora.this.operand2Real += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ((JButton) e.getSource()).getText());
                            break;
                        case 12:
                            Calculadora.this.operand2Imag = ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + Calculadora.this.operand2Imag);
                            Calculadora.this.state = 14;
                            break;
                        case 13:
                            Calculadora.this.operand2Imag += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ((JButton) e.getSource()).getText());
                            Calculadora.this.state = 14;
                            break;
                        case 14:
                            Calculadora.this.operand2Imag += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ((JButton) e.getSource()).getText());
                            break;
                        case 15:
                            Calculadora.this.operand2Imag += ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ((JButton) e.getSource()).getText());
                            break;
                        }
                    }
                });
                this.getContentPane().add(this.btnNumbers[cont++]);
            }
        }
        
        // Aniadir el punto
        this.btnNumbers[cont] = new JButton(".");
        this.btnNumbers[cont].setBounds(102, 316, 60, 60);
        this.btnNumbers[cont].setFont(new Font("normal", Font.BOLD, 18));
        this.btnNumbers[cont].setBackground(Color.decode("#424141"));
        this.btnNumbers[cont].setForeground(Color.white);
        this.btnNumbers[cont].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                switch(Calculadora.this.state){
                case 0:
                    Calculadora.this.operand1Real = ".";
                    Calculadora.this.equation.setText(Calculadora.this.operand1Real);
                    Calculadora.this.state = 3;
                    break;
                case 1:
                    Calculadora.this.operand1Real += ".";
                    Calculadora.this.equation.setText(Calculadora.this.operand1Real);
                    Calculadora.this.state = 3;
                    break;
                case 2:
                    Calculadora.this.operand1Real += ".";
                    Calculadora.this.equation.setText(Calculadora.this.operand1Real);
                    Calculadora.this.state = 3;
                    break;
                case 4:
                    Calculadora.this.operand1Imag = ".";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + Calculadora.this.operand1Imag);
                    Calculadora.this.state = 7;
                    break;
                case 5:
                    Calculadora.this.operand1Imag += ".";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ".");
                    Calculadora.this.state = 7;
                    break;
                case 6:
                    Calculadora.this.operand1Imag += ".";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ".");
                    Calculadora.this.state = 7;
                    break;
                case 8:
                    Calculadora.this.operand2Real = ".";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + Calculadora.this.operand2Real);
                    Calculadora.this.state = 11;
                    break;
                case 9:
                    Calculadora.this.operand2Real += ".";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ".");
                    Calculadora.this.state = 11;
                    break;
                case 10:
                    Calculadora.this.operand2Real += ".";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ".");
                    Calculadora.this.state = 11;
                    break;
                case 12:
                    Calculadora.this.operand2Imag = ".";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + Calculadora.this.operand2Imag);
                    Calculadora.this.state = 15;
                    break;
                case 13:
                    Calculadora.this.operand2Imag += ".";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ".");
                    Calculadora.this.state = 15;
                    break;
                case 14:
                    Calculadora.this.operand2Imag += ".";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + ".");
                    Calculadora.this.state = 15;
                    break;
                }
            }
        });
        this.getContentPane().add(this.btnNumbers[cont++]);
        
        // Aniadir la i
        this.btnNumbers[cont] = new JButton("i");
        this.btnNumbers[cont].setBounds(164, 316, 60, 60);
        this.btnNumbers[cont].setFont(new Font("normal", Font.BOLD, 18));
        this.btnNumbers[cont].setBackground(Color.decode("#424141"));
        this.btnNumbers[cont].setForeground(Color.white);
        this.btnNumbers[cont].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                switch(Calculadora.this.state){
                case 0:
                    Calculadora.this.equation.setText("i");
                    Calculadora.this.state = 4;
                    break;
                case 3:
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + " + i");
                    Calculadora.this.state = 4;
                    break;
                case 2:
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + " + i");
                    Calculadora.this.state = 4;
                    break;
                case 8:
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + "i");
                    Calculadora.this.state = 12;
                    break;
                case 10:
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + " + i");
                    Calculadora.this.state = 12;
                    break;
                case 11:
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + " + i");
                    Calculadora.this.state = 12;
                    break;
                }
            }
        });
        this.getContentPane().add(this.btnNumbers[cont]);
        
        
        // Botones de operador de la calculadora
        this.btnOperands = new JButton[4];
        this.btnOperands[0] = new JButton("*");
        this.btnOperands[1] = new JButton("/");
        this.btnOperands[2] = new JButton("+");
        this.btnOperands[3] = new JButton("-");
        
        cont = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){
                if(cont >= this.btnOperands.length){
                    break;
                }
                this.btnOperands[cont].setBounds(300 +j*62, 192+i*62, 60, 60);
                this.btnOperands[cont].setBackground(Color.decode("#424141"));
                this.btnOperands[cont].setFont(new Font("normal", Font.BOLD, 18));
                this.btnOperands[cont].setForeground(Color.white);
                this.btnOperands[cont].setFocusPainted(false);
                this.btnOperands[cont].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        switch(Calculadora.this.state){
                        case 2:
                            Calculadora.this.operator = ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + " " + Calculadora.this.operator + " ");
                            Calculadora.this.state = 8;
                            break;
                        case 3:
                            Calculadora.this.operator = ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + " " + Calculadora.this.operator + " ");
                            Calculadora.this.state = 8;
                            break;
                        case 6:
                            Calculadora.this.operator = ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + " " + Calculadora.this.operator + " ");
                            Calculadora.this.state = 8;
                            break;
                        case 7:
                            Calculadora.this.operator = ((JButton) e.getSource()).getText();
                            Calculadora.this.equation.setText(Calculadora.this.equation.getText() + " " + Calculadora.this.operator + " ");
                            Calculadora.this.state = 8;
                            break;
                        }
                    }
                });
                this.getContentPane().add(this.btnOperands[cont++]);
            }
        }
        
        // Evento del -
        this.btnOperands[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch(Calculadora.this.state){
                case 0:
                    Calculadora.this.operand1Real = "-";
                    Calculadora.this.equation.setText(Calculadora.this.operand1Real);
                    Calculadora.this.state = 1;
                    break;
                case 4:
                    Calculadora.this.operand1Imag = "-";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + Calculadora.this.operand1Imag);
                    Calculadora.this.state = 5;
                    break;
                case 8:
                    Calculadora.this.operand2Real = "-";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + Calculadora.this.operand2Real);
                    Calculadora.this.state = 10;
                    break;
                case 12:
                    Calculadora.this.operand2Imag = "-";
                    Calculadora.this.equation.setText(Calculadora.this.equation.getText() + Calculadora.this.operand2Imag);
                    Calculadora.this.state = 13;
                    break;
                }
            }
        });
        
        // Botones borrar y resolver
        this.erase = new JButton("AC");
        this.erase.setBounds(362, 130, 60, 60);
        this.erase.setBackground(Color.decode("#424141"));
        this.erase.setFont(new Font("normal", Font.BOLD, 18));
        this.erase.setForeground(Color.white);
        this.erase.setFocusPainted(false);
        this.erase.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent arg0) {
                // Borrar contenido
                Calculadora.this.operand1Imag = "";
                Calculadora.this.operand2Imag = "";
                Calculadora.this.operand1Real = "";
                Calculadora.this.operand2Real = "";
                Calculadora.this.equation.setText("");
                Calculadora.this.state = 0;
            }
        });
        this.getContentPane().add(this.erase);
        
        this.solve = new JButton("=");
        this.solve.setBounds(362, 316, 60, 60);
        this.solve.setFont(new Font("normal", Font.BOLD, 18));
        this.solve.setBackground(Color.decode("#424141"));
        this.solve.setForeground(Color.white);
        this.solve.setFocusPainted(false);
        this.solve.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                if(Calculadora.this.state == 10 || Calculadora.this.state == 11 || Calculadora.this.state == 14 || Calculadora.this.state == 15){
                    String result = "";
                    try{
                        result = Calculadora.this.solveExpression() + "";
                    }catch(IllegalArgumentException ex){
                        result = "MATH ERROR";
                    }
                    Calculadora.this.equation.setText(result);
                    Calculadora.this.operand1Imag = "";
                    Calculadora.this.operand2Imag = "";
                    Calculadora.this.operand1Real = "";
                    Calculadora.this.operand2Real = "";
                    Calculadora.this.state = 0;
                }
            }
        });
        this.getContentPane().add(this.solve);
        
        
        // Representación de la ecuacion
        this.equation = new JTextArea();
        this.equation.setBounds(43, 25, 400, 85);
        this.equation.setBackground(Color.decode("#ffffff"));
        this.equation.setFont(new Font("normal", Font.BOLD, 28));
        getContentPane().add(this.equation);
        this.equation.setEditable(false);
        
        this.setVisible(true);
    }
    
    private ComplexNumber solveExpression(){
        /*
         * Asumimos que se inicializo todo correctamente
         */
        double oper1Real, oper1Imag, oper2Real, oper2Imag;
         
        try{
            oper1Real = Double.parseDouble(this.operand1Real);
        }catch(NumberFormatException ex){
            oper1Real = 0;
        }
        try{
            oper1Imag = Double.parseDouble(this.operand1Imag);
        }catch(NumberFormatException ex){
            oper1Imag = 0;
        }
        try{
            oper2Real = Double.parseDouble(this.operand2Real);
        }catch(NumberFormatException ex){
            oper2Real = 0;
        }
        try{
            oper2Imag = Double.parseDouble(this.operand2Imag);
        }catch(NumberFormatException ex){
            oper2Imag = 0;
        }
        
        ComplexNumber operand1 = new ComplexNumber(oper1Real, oper1Imag);
        ComplexNumber operand2 = new ComplexNumber(oper2Real, oper2Imag);
        switch(this.operator){
        case "+":
            return operand1.sum(operand2);
        case "-":
            return operand1.subtract(operand2);
        case "*":
            return operand1.multiply(operand2);
        case "/":
            return operand1.divide(operand2);
        default:
            return null;
        }
    }
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        new Calculadora();
    }
}
