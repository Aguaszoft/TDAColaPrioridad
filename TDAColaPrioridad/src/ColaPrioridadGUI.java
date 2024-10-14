import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaPrioridadGUI {
    private JPanel pGeneral;
    private JTextField txtElemento;
    private JTextField txtPrioridad;
    private JTextArea txtResultado;
    private JButton encolarButton;
    private JButton desencolarButton;

    ColaPrioridad cola=new ColaPrioridad();

    public ColaPrioridadGUI() {
        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cola.desencolar(txtResultado);
            }
        });
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtElemento.getText();
                String priorityInput = txtPrioridad.getText();
                try {
                    // Intentar convertir la entrada en un número entero
                    int valor = Integer.parseInt(input);
                    int prioridad = Integer.parseInt(priorityInput);
                    cola.encolar(valor, prioridad, txtResultado);
                    txtElemento.setText("");
                    txtPrioridad.setText("");
                } catch (NumberFormatException ex) {
                    // Mostrar mensaje si la entrada no es un número válido
                    JOptionPane.showMessageDialog(null, "Introduce un número entero y una prioridad válidos.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaPrioridadGUI");
        frame.setContentPane(new ColaPrioridadGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
