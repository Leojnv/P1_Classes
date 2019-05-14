package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import logica.Almacen;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim; //Variable stores Width x Height
	private Almacen miAlma;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen alma = new Almacen();
					Principal frame = new Principal(alma);
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
	public Principal(Almacen alma) {
		miAlma = alma;
		setTitle("Giraldilla");
		setResizable(false); //para que no se pueda redimensionar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480); // definir las dimensiones de la pantalla
		dim = super.getToolkit().getScreenSize(); //para obtener las dimensiones de la pantalla
		super.setSize(dim.width, dim.height-50);; // definir el tamaño de la pantalla completa
		setLocationRelativeTo(null); // para que se abra centrado
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVino = new JMenu("Vino");
		menuBar.add(mnVino);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mnVino.add(mntmRegistrar);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mnVino.add(mntmListado);
		
		JMenu mnSuministrador = new JMenu("Suministrador");
		menuBar.add(mnSuministrador);
		
		JMenuItem mntmRegistrar_1 = new JMenuItem("Registrar");
		mntmRegistrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regSuministrador regSumi = new regSuministrador(miAlma);
				regSumi.setModal(true);
				regSumi.setVisible(true);
			}
		});
		mnSuministrador.add(mntmRegistrar_1);
		
		JMenuItem mntmListado_1 = new JMenuItem("Listado");
		mntmListado_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listSuministrador list = new listSuministrador(alma);
				list.setModal(true);// para que no pueda interactuar con otra ventana mientras esta se encuentra abierta
				list.setVisible(true);
			}
		});
		mnSuministrador.add(mntmListado_1);
		
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
