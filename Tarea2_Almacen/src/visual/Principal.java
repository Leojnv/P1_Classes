package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Giraldilla");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height-50);;
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVino = new JMenu("Vino");
		menuBar.add(mnVino);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mnVino.add(mntmRegistrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnVino.add(mntmListar);
		
		JMenu mnSuministrador = new JMenu("Suministrador");
		menuBar.add(mnSuministrador);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regSuministrador regSumi = new regSuministrador();
				regSumi.setModal(true);
				regSumi.setVisible(true);
			}
		});
		mnSuministrador.add(mntmRegistrar_1);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mnSuministrador.add(mntmListar_1);
		
		JMenu mnPedidos = new JMenu("Pedidos");
		menuBar.add(mnPedidos);
		
		JMenuItem mntmRealizarPedido = new JMenuItem("Realizar Pedido");
		mnPedidos.add(mntmRealizarPedido);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		panel.add(panel_1, BorderLayout.SOUTH);
	}

}
