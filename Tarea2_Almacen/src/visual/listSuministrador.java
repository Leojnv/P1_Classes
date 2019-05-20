package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logica.Almacen;
import logica.Suministrador;

import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class listSuministrador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private static Almacen miAlma;
	private String nombreSumi;
	private JButton btnModificar;
	private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 * @param alma 
	 */
	public listSuministrador(Almacen alma) {
		this.miAlma = alma;
		setTitle("Listar suministradores");
		setBounds(100, 100, 450, 300);
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
				String[] header = {"Nombre", "Pais", "Tiempo de entrega"};
				model.setColumnIdentifiers(header);
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (table.getSelectedRow() >= 0) {
							int index = table.getSelectedRow();
							btnModificar.setEnabled(true);
							btnEliminar.setEnabled(true);
							nombreSumi = (String) table.getValueAt(index, 0);
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
						if (!nombreSumi.equalsIgnoreCase("")) {
							Suministrador aux = miAlma.buscarSuministradorByName(nombreSumi);
							regSuministrador reg = new regSuministrador(alma,aux);
							reg.setModal(true);
							reg.setVisible(true);
							reg.dispose();
							
						}
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el Suministrador: " + nombreSumi, "Eliminar", JOptionPane.WARNING_MESSAGE);
						if (option == 0) {
							miAlma.EliminarSuministrador(nombreSumi);
							JOptionPane.showMessageDialog(null, "Operacion satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE, null);
							loadTable();
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
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
	static void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < miAlma.getCantSum(); i++) {
			fila[0] = miAlma.getListSum()[i].getNombre();
			fila[1] = miAlma.getListSum()[i].getPais();
			fila[2] = miAlma.getListSum()[i].getTiempo();
			model.addRow(fila);
		}
	}

}
