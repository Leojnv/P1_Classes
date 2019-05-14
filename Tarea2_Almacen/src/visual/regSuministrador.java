package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import logica.Almacen;
import logica.Suministrador;

public class regSuministrador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private Almacen miAlma;

	public regSuministrador(Almacen miAlma) {
		this.miAlma = miAlma;
		setResizable(false);
		setTitle("Registrar Suministrador");
		setBounds(100, 100, 442, 204);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 25, 60, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 40, 414, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(10, 71, 130, 14);
		contentPanel.add(lblPas);
		
		JLabel lblTiempoEntrega = new JLabel("Tiempo entrega:");
		lblTiempoEntrega.setBounds(221, 71, 130, 14);
		contentPanel.add(lblTiempoEntrega);
		
		JComboBox cbxPais = new JComboBox();
		cbxPais.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Chile", "Republica Dominicana", "Espa\u00F1a", "Francia", "Italia", "Portugal"}));
		cbxPais.setBounds(10, 96, 184, 20);
		contentPanel.add(cbxPais);
		
		JSpinner spnTiempo = new JSpinner();
		spnTiempo.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spnTiempo.setBounds(221, 96, 203, 20);
		contentPanel.add(spnTiempo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Suministrador aux = new Suministrador(txtNombre.getText(), cbxPais.getSelectedItem().toString(), Integer.valueOf(spnTiempo.getValue().toString()));
						miAlma.insertarSuministrador(aux);
						JOptionPane.showMessageDialog(null, "Operacion satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE, null);
						clean();
					}

					private void clean() {
						txtNombre.setText("");
						cbxPais.setSelectedIndex(0);
						spnTiempo.setValue(new Integer(1));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
