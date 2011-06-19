package GraphicInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MainGraphUserInterf extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public MainGraphUserInterf() {
		//CONSTRUTOR DO PAINEL!!!
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainGraphUserInterf.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("MAIN MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("ARQUIVO");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mnArquivo.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setToolTipText("SAIR DO SISTEMA");
		btnExit.setIcon(new ImageIcon(MainGraphUserInterf.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(497, 356, 117, 54);
		contentPane.add(btnExit);
		
		JButton btnGerenciar = new JButton("GERENCIAR");
		btnGerenciar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGerenciar.setBounds(114, 144, 140, 42);
		contentPane.add(btnGerenciar);
		
		JLabel lblGerenciarSistema = new JLabel("GERENCIAR SISTEMA");
		lblGerenciarSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarSistema.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGerenciarSistema.setBounds(114, 119, 140, 27);
		contentPane.add(lblGerenciarSistema);
		
		JButton btnVender = new JButton("VENDER");
		btnVender.setBounds(368, 144, 140, 42);
		btnVender.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnVender);
		
		JLabel lblVenderIngresso = new JLabel("VENDER INGRESSO");
		lblVenderIngresso.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenderIngresso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblVenderIngresso.setBounds(368, 119, 140, 27);
		contentPane.add(lblVenderIngresso);
		
		JButton btnHistCompra = new JButton("COMPRA");
		btnHistCompra.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHistCompra.setBounds(10, 306, 140, 42);
		contentPane.add(btnHistCompra);
		
		JButton btnHistOperacao = new JButton("OPERACAO");
		btnHistOperacao.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHistOperacao.setBounds(10, 347, 140, 42);
		contentPane.add(btnHistOperacao);
		
		JLabel lblHistoricos = new JLabel("HISTORICOS");
		lblHistoricos.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistoricos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblHistoricos.setBounds(10, 281, 140, 27);
		contentPane.add(lblHistoricos);
		
		//ACOES DOS BOT�ES.
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnGerenciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfaceManager manager = new InterfaceManager();
				setVisible(false);
				manager.setVisible(true);
			}
		});
		
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfaceSales sales = new InterfaceSales();
				setVisible(false);
				sales.setVisible(true);
			}
		});
	}
}
