import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRadio;
	private JButton btnListo;
	private JLabel lblArea;
	private JButton btnListo_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCalculoAreaY = new JLabel("Calculo Area y Longitud");
		GridBagConstraints gbc_lblCalculoAreaY = new GridBagConstraints();
		gbc_lblCalculoAreaY.insets = new Insets(0, 0, 5, 0);
		gbc_lblCalculoAreaY.gridx = 0;
		gbc_lblCalculoAreaY.gridy = 0;
		contentPane.add(lblCalculoAreaY, gbc_lblCalculoAreaY);
		
		txtRadio = new JTextField();
		txtRadio.setText("Radio");
		GridBagConstraints gbc_txtRadio = new GridBagConstraints();
		gbc_txtRadio.insets = new Insets(0, 0, 5, 0);
		gbc_txtRadio.anchor = GridBagConstraints.WEST;
		gbc_txtRadio.gridx = 0;
		gbc_txtRadio.gridy = 1;
		contentPane.add(txtRadio, gbc_txtRadio);
		txtRadio.setColumns(10);
		
		GridBagConstraints gbc_btnListo = new GridBagConstraints();
		gbc_btnListo.insets = new Insets(0, 0, 5, 0);
		gbc_btnListo.anchor = GridBagConstraints.WEST;
		gbc_btnListo.gridx = 0;
		gbc_btnListo.gridy = 2;
		contentPane.add(btnListo, gbc_btnListo);
		
		btnListo_1 = new JButton("Listo");
		btnListo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = Integer.parseInt(txtRadio.getText());
				Circulo c = new Circulo(0, 0, r);
				float area = c.Area(c.getRadio());
				lblArea.setText(Float.toString(area));
				
			}
		});
		GridBagConstraints gbc_btnListo_1 = new GridBagConstraints();
		gbc_btnListo_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnListo_1.gridx = 0;
		gbc_btnListo_1.gridy = 2;
		contentPane.add(btnListo_1, gbc_btnListo_1);
		
		lblArea = new JLabel("Area");
		lblArea.setBackground(Color.WHITE);
		lblArea.setForeground(Color.RED);
		lblArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_lblArea = new GridBagConstraints();
		gbc_lblArea.gridx = 0;
		gbc_lblArea.gridy = 4;
		contentPane.add(lblArea, gbc_lblArea);
		
	}

}
