package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logica.Almacen;
import logica.Vino;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class listVino extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private static Almacen miAlma;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private String codVino;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("static-access")
	public listVino(Almacen alma) {
		setResizable(false);
		this.miAlma = alma;
		setTitle("Lista vinos");
		setBounds(100, 100, 1000, 480);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Listado:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				model = new DefaultTableModel();
				String[] header = {"Codigo", "Nombre", "Cosecha", "Suministrador", "Tipo", "Cantidad minima", "Cantidad real", "Cantidad maxima"};
				model.setColumnIdentifiers(header);
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (table.getSelectedRow() >= 0) {
							int index = table.getSelectedRow();
							btnModificar.setEnabled(true);
							btnEliminar.setEnabled(true);
							codVino = (String) table.getValueAt(index, 0);
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(model);
				scrollPane.setViewportView(table);
				loadTable();
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!codVino.equalsIgnoreCase("")) {
							Vino aux = miAlma.buscarVinoByCod(codVino);
							regVino reg = new regVino(miAlma,aux);
							reg.setModal(true);
							reg.setVisible(true);
							reg.dispose();
						}
						
					}
				});
				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//int option = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea eliminar el vino:" + miAlma.buscarVinoByCod(codVino).getNombre() , "Eliminar", JOptionPane.WARNING_MESSAGE);
						int option =0;
						if (option == 0) {
							miAlma.eliminarVino(codVino);
							//JOptionPane.showMessageDialog(null, "Operacion satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE, null);
							loadTable();
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
						}
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

	static void loadTable() {
		// TODO Auto-generated method stub
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < miAlma.getCantVinos(); i++) {
			fila[0] = miAlma.getListVin()[i].getCodigo();
			fila[1] = miAlma.getListVin()[i].getNombre();
			fila[2] = miAlma.getListVin()[i].getCosecha();
			fila[3] = miAlma.getListVin()[i].getMiSum().getNombre();
			fila[4] = miAlma.getListVin()[i].getTipo();
			fila[5] = miAlma.getListVin()[i].getCantMin();
			fila[6] = miAlma.getListVin()[i].getCantReal();
			fila[7] = miAlma.getListVin()[i].getCantMax();
			model.addRow(fila);
		}
	}

}
