package Presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Modelo.Logica;


public class presentacion extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	
	
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private JLabel lblResultado;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JButton btCalcular;

	private Logica parcial;

	public presentacion() {
		parcial = new Logica();

		setTitle("Examen Daniel Casasfranco");
		setSize(600, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 2, 5, 10));

		lblA = new JLabel("a:  ", SwingConstants.RIGHT);
		lblB = new JLabel("b:  ", SwingConstants.RIGHT);
		lblC = new JLabel("c:  ", SwingConstants.RIGHT);
		txtA = new JTextField();
		txtB = new JTextField();
		txtC = new JTextField();
		btCalcular = new JButton("Calcular");
		lblResultado = new JLabel("");

		btCalcular.addActionListener(this);

		add(lblA);
		add(txtA);
		add(lblB);
		add(txtB);
		add(lblC);
		add(txtC);
		add(btCalcular);
		add(lblResultado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btCalcular) {
			try {
				double a = Double.parseDouble(txtA.getText().trim());
				double b = Double.parseDouble(txtB.getText().trim());
				double c = Double.parseDouble(txtC.getText().trim());
				lblResultado.setText(parcial.calcularRaices(a, b, c));
			} catch (NumberFormatException ex) {
				lblResultado.setText("Ingrese valores numericos validos");
			}
		}
	}

	public static void main(String[] args) {
		new presentacion().setVisible(true);
	}
}