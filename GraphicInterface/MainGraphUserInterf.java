package GraphicInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
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
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("ARQUIVO");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArquivo.add(mntmExit);
		
		JMenu mnGerenciar = new JMenu("GERENCIAR");
		menuBar.add(mnGerenciar);
		
		JMenu mnSessao = new JMenu("SESSAO");
		mnGerenciar.add(mnSessao);
		
		
		JMenuItem mntmExibir = new JMenuItem("EXIBIR");
		mntmExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagSessionDisplay display = new ManagSessionDisplay();
				display.setVisible(true);
				setVisible(false);
			}
		});
		mnSessao.add(mntmExibir);
		
		JMenuItem mntmCriar = new JMenuItem("CRIAR");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagSessionAdd add = new ManagSessionAdd();
				add.setVisible(true);
				setVisible(false);
			}
		});
		mnSessao.add(mntmCriar);
		
		JMenuItem mntmDeletar = new JMenuItem("EXCLUIR");
		mntmDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagSessionDelete del = new ManagSessionDelete();
				del.setVisible(true);
				setVisible(false);
			}
		});
		mnSessao.add(mntmDeletar);
		
		JMenuItem mntmModificar = new JMenuItem("MODIFICAR");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagSessionEdit edit = new ManagSessionEdit();
				edit.setVisible(true);
				setVisible(false);
			}
		});
		mnSessao.add(mntmModificar);
		
		JMenu mnFilme = new JMenu("FILME");
		mnGerenciar.add(mnFilme);
		
		JMenuItem mntmExibir_1 = new JMenuItem("EXIBIR");
		mntmExibir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagMovieDisplay display = new ManagMovieDisplay();
				display.setVisible(true);
				setVisible(false);
			}
		});
		mnFilme.add(mntmExibir_1);
		
		JMenuItem mntmCriar_1 = new JMenuItem("CRIAR");
		mntmCriar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagMovieAdd add = new ManagMovieAdd();
				add.setVisible(true);
				setVisible(false);
			}
		});
		mnFilme.add(mntmCriar_1);
		
		JMenuItem mntmDeletar_1 = new JMenuItem("EXCLUIR");
		mntmDeletar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagMovieDelete del = new ManagMovieDelete();
				setVisible(false);
				del.setVisible(true);
			}
		});
		mnFilme.add(mntmDeletar_1);
		
		JMenuItem mntmModificar_1 = new JMenuItem("MODIFICAR");
		mntmModificar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagMovieEdit edit = new ManagMovieEdit();
				edit.setVisible(true);
				setVisible(false);
			}
		});
		mnFilme.add(mntmModificar_1);
		
		JMenu mnSala = new JMenu("SALA");
		mnGerenciar.add(mnSala);
		
		JMenuItem mntmExibir_2 = new JMenuItem("EXIBIR");
		mntmExibir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagRoomDisplay display = new ManagRoomDisplay();
				display.setVisible(true);
				setVisible(false);
			}
		});
		mnSala.add(mntmExibir_2);
		
		JMenuItem mntmCriar_2 = new JMenuItem("CRIAR");
		mntmCriar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagRoomAdd add = new ManagRoomAdd();
				add.setVisible(true);
				setVisible(false);
			}
		});
		mnSala.add(mntmCriar_2);
		
		JMenuItem mntmDeletar_2 = new JMenuItem("EXCLUIR");
		mntmDeletar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagRoomDelete del = new ManagRoomDelete();
				del.setVisible(true);
				setVisible(false);
			}
		});
		mnSala.add(mntmDeletar_2);
		
		JMenuItem mntmEditar = new JMenuItem("EDITAR");
		mntmEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagRoomEdit edit = new ManagRoomEdit();
				edit.setVisible(true);
				setVisible(false);
			}
		});
		mnSala.add(mntmEditar);
		
		JMenu mnHistorico = new JMenu("HISTORICO");
		menuBar.add(mnHistorico);
		
		JMenuItem mntmOperaoes = new JMenuItem("OPERACOES");
		mntmOperaoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfOperacHist hoper = new InterfOperacHist();
				hoper.setVisible(true);
				setVisible(false);
			}
		});
		mnHistorico.add(mntmOperaoes);
		
		JMenuItem mntmVendas = new JMenuItem("VENDAS");
		mntmVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfSalesHist hsales = new InterfSalesHist();
				hsales.setVisible(true);
				setVisible(false);
			}
		});
		mnHistorico.add(mntmVendas);
		
		JMenuItem mntmVender = new JMenuItem("VENDER");
		mntmVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfaceSales sales = new InterfaceSales();
				sales.setVisible(true);
				setVisible(false);
			}
		});
		menuBar.add(mntmVender);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setToolTipText("SAIR DO SISTEMA");
		btnExit.setIcon(new ImageIcon(MainGraphUserInterf.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.setBounds(307, 176, 117, 54);
		contentPane.add(btnExit);
		
		//ACOES DOS BOT�ES.
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
}
