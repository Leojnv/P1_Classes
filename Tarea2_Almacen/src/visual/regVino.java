package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.Almacen;

import javax.swing.JComboBox;

public class regVino extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Almacen miAlma;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	/*
	/**
	 * Create the dialog.
	 * @param miAlma 
	 */
	public regVino(Almacen miAlma) {
		this.miAlma = miAlma;
		
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			comboBox = new JComboBox();
			comboBox.setBounds(10, 145, 198, 20);
			panel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			loadSumis();
		}
	}
	private void loadSumis() {
		comboBox.removeAll();
		for (int i = 0; i < miAlma.getCantSum(); i++) {
			comboBox.addItem(new String(miAlma.getListSum()[i].getNombre()));
		}
		comboBox.insertItemAt(new String("<Seleccione>"),0);
		comboBox.setSelectedIndex(0);
	}
}
