package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import logica.Almacen;
import logica.Vino;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Ventas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Almacen miAlma;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxVinos;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;


	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("rawtypes")
	public Ventas(Almacen alma) {
		this.miAlma = alma;
		setTitle("Ventas");
		setResizable(false);
		setBounds(100, 100, 600, 160);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblVino = new JLabel("Vino:");
			lblVino.setBounds(10, 11, 32, 14);
			contentPanel.add(lblVino);
		}
		{
			cbxVinos = new JComboBox();
			cbxVinos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nombreVino = cbxVinos.getSelectedItem().toString();
					loadTable(nombreVino);
				}
			});
			cbxVinos.setBounds(41, 8, 144, 20);
			contentPanel.add(cbxVinos);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 576, 50);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
			{
				model = new DefaultTableModel();
				String[] header = {"A\u00f1o 1", "A\u00f1o 2", "A\u00f1o 3", "A\u00f1o 4",  "A\u00f1o 5", "A\u00f1o 6", "A\u00f1o 7", "A\u00f1o 8", "A\u00f1o 9", "A\u00f1o 10"};	
				model.setColumnIdentifiers(header);
				table = new JTable();
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnSalir);
			}
			loadVinos();
		}
	}


	private void loadTable(String nombre) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		Vino aux = miAlma.returnVinoByName(nombre);
		if (aux != null) {
			for (int i = 0; i < 10; i++) {
				fila[i] = aux.getVentas()[i];
			}
			model.addRow(fila);
		}
	}


	@SuppressWarnings("unchecked")
	private void loadVinos() {
		cbxVinos.removeAll();
		for (int i = 0; i < miAlma.getCantVinos(); i++) {
			cbxVinos.addItem(new String(miAlma.getListVin()[i].getNombre()));
		}
		cbxVinos.insertItemAt(new String("<Seleccione>"),0);
		cbxVinos.setSelectedIndex(0);
	}
}
