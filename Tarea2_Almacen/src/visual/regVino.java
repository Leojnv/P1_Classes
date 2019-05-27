package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.Almacen;
import logica.Suministrador;
import logica.Vino;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class regVino extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Almacen miAlma;
	private Vino miVino = null;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxSuministrador;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JButton btnRegistrar;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxTipo;
	private JSpinner spnMaxima;
	private JSpinner spnMinima;
	private JSpinner spnReal;
	private JSpinner spnCosecha;
	/**
	 * Launch the application.
	/*
	/**
	 * Create the dialog.
	 * @param miAlma 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public regVino(Almacen alma, Vino vino) {
		setResizable(false);
		this.miAlma = alma;
		this.miVino = vino;
		if (miVino == null) {
			setTitle("Registrar Vino");
		}else {
			setTitle("Modificar Vino");
		}
		setBounds(100, 100, 422, 378);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(10, 30, 86, 14);
			panel.add(lblCdigo);
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			if (miVino == null) {
				txtCodigo.setText("V-"+(Vino.generatedCode));
			}else {
				txtCodigo.setText(miVino.getCodigo());
			}
			txtCodigo.setBounds(50, 27, 86, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 55, 220, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(10, 80, 220, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblCosecha = new JLabel("Cosecha:");
			lblCosecha.setBounds(244, 55, 135, 14);
			panel.add(lblCosecha);
			
			spnCosecha = new JSpinner();
			spnCosecha.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnCosecha.setBounds(244, 80, 135, 20);
			panel.add(spnCosecha);
			
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setBounds(244, 111, 46, 14);
			panel.add(lblTipo);
			
			cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Blanco", "Tinto", "Rosado"}));
			cbxTipo.setBounds(244, 136, 135, 20);
			panel.add(cbxTipo);
			
			JLabel lblSuministrador = new JLabel("Suministrador:");
			lblSuministrador.setBounds(10, 111, 220, 14);
			panel.add(lblSuministrador);
			
			cbxSuministrador = new JComboBox();
			cbxSuministrador.setBounds(10, 136, 220, 20);
			panel.add(cbxSuministrador);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cantidades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 167, 370, 106);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel label = new JLabel("Real:");
			label.setBounds(68, 29, 46, 14);
			panel_1.add(label);
			
			JLabel label_1 = new JLabel("M\u00EDnima:");
			label_1.setBounds(164, 29, 46, 14);
			panel_1.add(label_1);
			
			JLabel label_2 = new JLabel("M\u00E1xima:");
			label_2.setBounds(260, 29, 67, 14);
			panel_1.add(label_2);
			
			spnReal = new JSpinner();
			spnReal.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnReal.setBounds(45, 48, 76, 20);
			panel_1.add(spnReal);
			
			spnMinima = new JSpinner();
			spnMinima.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnMinima.setBounds(148, 48, 76, 20);
			panel_1.add(spnMinima);
			
			spnMaxima = new JSpinner();
			spnMaxima.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnMaxima.setBounds(251, 48, 76, 20);
			panel_1.add(spnMaxima);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton();
				if(miVino == null) {
					btnRegistrar.setText("Registrar");
				}else {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							String codigo = txtCodigo.getText();
							Suministrador sumi = miAlma.buscarSuministradorByName(cbxSuministrador.getSelectedItem().toString());
							String nombre = txtNombre.getText();
							String tipo = cbxTipo.getSelectedItem().toString();
							int cmax = Integer.valueOf(spnMaxima.getValue().toString());
							int cmin = Integer.valueOf(spnMinima.getValue().toString());
							int creal = Integer.valueOf(spnReal.getValue().toString());
							int cosecha = Integer.valueOf(spnCosecha.getValue().toString());
							if (miVino == null) {
								Vino aux = new Vino(codigo, sumi, nombre, tipo, cmax, cmin, creal, cosecha);
								//probando las ventas
								int[] sold = new int[10];
								for (int i = 0; i < 10; i++) {
									sold[i] = i+1;
								}
								aux.setVentas(sold);
								miAlma.insertarVino(aux);
								JOptionPane.showMessageDialog(null, "Operacion exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
								clean();
							} else {
								miVino.setMiSum(sumi);
								miVino.setNombre(nombre);
								miVino.setTipo(tipo);
								miVino.setCantMax(cmax);
								miVino.setCantMin(cmin);
								miVino.setCantReal(creal);
								miVino.setCosecha(cosecha);
								miAlma.modVino(miVino);
								JOptionPane.showMessageDialog(null, "Operaci�n exitosa", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
								dispose();
								listVino.loadTable();
							}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
			loadSumis();
			loadVino();
		}
	}
	protected void loadVino() {
		if (miVino != null) {
			txtCodigo.setText(miVino.getCodigo());
			cbxSuministrador.setSelectedItem(miVino.getMiSum().getNombre().toString());
			txtNombre.setText(miVino.getNombre());
			cbxTipo.setSelectedItem(miVino.getTipo().toString());
			spnMaxima.setValue(miVino.getCantMax());
			spnMinima.setValue(miVino.getCantMin());
			spnReal.setValue(miVino.getCantReal());
			spnCosecha.setValue(miVino.getCosecha());
		}
		
	}	
	private void clean() {
		if (miVino == null) {
			txtCodigo.setText("V-"+(Vino.generatedCode));
			cbxSuministrador.setSelectedIndex(0);
			txtNombre.setText(" ");
			cbxTipo.setSelectedIndex(0);
			spnMaxima.setValue(new Integer(1));
			spnMinima.setValue(new Integer(1));
			spnReal.setValue(new Integer(1));
			spnCosecha.setValue(new Integer(1));
		}
	}
	@SuppressWarnings("unchecked")
	private void loadSumis() {
		cbxSuministrador.removeAll();
		for (int i = 0; i < miAlma.getCantSum(); i++) {
			cbxSuministrador.addItem(new String(miAlma.getListSum()[i].getNombre()));
		}
		cbxSuministrador.insertItemAt(new String("<Seleccione>"),0);
		cbxSuministrador.setSelectedIndex(0);
	}
}
