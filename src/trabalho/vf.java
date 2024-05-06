package trabalho;

import trabalho.Filla01.Fila;
import trabalho.Filla01.FilaVetor;

import javax.swing.*;
import java.awt.event.*;

public class vf extends JDialog {
    private JPanel contentPane;
    private JButton btCalcular;
    private JButton buttonCancel;
    private JTextField tfExpressao;
    private JTextField tfResultado;
    private JPanel Calculadora;

    public vf() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btCalcular);

        btCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        trabalho.Calculadora c = new Calculadora();
        Fila<String> termoInfixada =  c.extrairTermos(tfExpressao.getText());
        Fila<String> termosPosfixada = c.gerarExprPosfixada((FilaVetor<String>) termoInfixada);
        double resultado = c.calcularExprPosfixada((FilaVetor<String>) termosPosfixada);
        tfResultado.setText(Double.toString(resultado).replace(".", ","));
    }


    private void onCancel() {
        dispose();
    }

}
