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

@SuppressWarnings("serial")
public class regSuministrador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	@SuppressWarnings("unused")
	private Almacen miAlma;
	private Suministrador sumi = null;
	private JButton okButton;
	private JSpinner spnTiempo;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxPais;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public regSuministrador(Almacen miAlma, Suministrador miSumi) {
		this.miAlma = miAlma;
		this.sumi = miSumi;
		setResizable(false);
		if (miSumi == null) {
			setTitle("Registrar Suministrador");
		}else {
			setTitle("Modificar Suministrador");
		}
		
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
		if (sumi == null) {
			txtNombre.setEditable(true);
		}else {
			txtNombre.setEditable(false);
		}
		txtNombre.setBounds(10, 40, 414, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(10, 71, 130, 14);
		contentPanel.add(lblPas);
		
		JLabel lblTiempoEntrega = new JLabel("Tiempo entrega:");
		lblTiempoEntrega.setBounds(221, 71, 130, 14);
		contentPanel.add(lblTiempoEntrega);
		
		cbxPais = new JComboBox();
		cbxPais.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Chile", "Republica Dominicana", "Espa\u00F1a", "Francia", "Italia", "Portugal"}));
		cbxPais.setBounds(10, 96, 184, 20);
		contentPanel.add(cbxPais);
		
		spnTiempo = new JSpinner();
		spnTiempo.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spnTiempo.setBounds(221, 96, 203, 20);
		contentPanel.add(spnTiempo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton();
				if(sumi == null) {
					okButton.setText("Registrar");
				}else {
					okButton.setText("Modificar");
				}
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("unused")
					public void actionPerformed(ActionEvent e) {
						String nombre = txtNombre.getText();
						if (sumi == null) {
							Suministrador aux = new Suministrador(txtNombre.getText(), cbxPais.getSelectedItem().toString(), Integer.valueOf(spnTiempo.getValue().toString()));
							miAlma.insertarSuministrador(aux);
							JOptionPane.showMessageDialog(null, "Operacion satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE, null);
							clean();
						}else {
							sumi.setNombre(txtNombre.getText());
							sumi.setPais(cbxPais.getSelectedItem().toString());
							sumi.setTiempo(Integer.parseInt(spnTiempo.getValue().toString()));
							miAlma.modAdministrador(miSumi);
							JOptionPane.showMessageDialog(null, "Operación exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							listSuministrador.loadTable();
						}
						
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
		loadSuministrador();
	}
	
	private void loadSuministrador() {
		if(sumi != null){
			txtNombre.setText(sumi.getNombre());
			cbxPais.setSelectedItem(sumi.getPais().toString());
			spnTiempo.setValue(sumi.getTiempo());
		}
		
		
	}
}
