package GraphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import MoviesData.SessionData;
import javax.swing.JLabel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ManagSessionDisplay extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;

	protected static Map<Integer, Map<String,SessionData>> mapSessionData; 
	private JLabel txtSessao;
	private JLabel txtFilme;
	private JLabel txtSala;
	private JLabel txtData;
	private JLabel txtHora;
	private JLabel txtVenda;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManagSessionDisplay() {

		// inicializa o mapMovieData com o arquivo .ser!!!
		try {
			FileInputStream fluxoSessionIn = new FileInputStream(
					"fileSession.ser");
			ObjectInputStream fSessionIn = new ObjectInputStream(fluxoSessionIn);
			mapSessionData = (Map<Integer, Map<String, SessionData>>) fSessionIn
					.readObject();
			fSessionIn.close();
			fluxoSessionIn.close();
		} catch (IOException io) {
		} catch (ClassNotFoundException classNotFound) {
		}
		//

		setTitle("GERENCIAMENTO - SESSAO - EXIBIR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(333, 208, 91, 43);
		contentPane.add(btnVoltar);

		// CRIA O PAYNEL COM A LISTA DE FILMES NA ESQUERDA.
		final JPanel DisplayMovie = new JPanel();
		DisplayMovie.setBounds(0, 0, 213, 229);
		DisplayMovie.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "FILME"));
		contentPane.add(DisplayMovie);
		DisplayMovie.setLayout(null);

		JLabel lblIdSession = new JLabel("ID SESSION");
		lblIdSession.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdSession.setBounds(222, 14, 69, 14);
		contentPane.add(lblIdSession);

		JLabel lblFilme = new JLabel("FILME");
		lblFilme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFilme.setBounds(222, 39, 69, 14);
		contentPane.add(lblFilme);

		JLabel lblSala = new JLabel("SALA");
		lblSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSala.setBounds(222, 64, 69, 14);
		contentPane.add(lblSala);

		JLabel lblData = new JLabel("DATA");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setBounds(222, 89, 69, 14);
		contentPane.add(lblData);

		JLabel lblHora = new JLabel("HORA");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds(222, 114, 69, 14);
		contentPane.add(lblHora);

		JLabel lblVenda = new JLabel("VENDA");
		lblVenda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVenda.setBounds(222, 139, 69, 14);
		contentPane.add(lblVenda);
	
		txtSessao = new JLabel();
		txtSessao.setBounds(301, 11, 123, 20);
		contentPane.add(txtSessao);

		txtFilme = new JLabel();

		txtFilme.setBounds(301, 36, 123, 20);
		contentPane.add(txtFilme);

		txtSala = new JLabel();

		txtSala.setBounds(301, 61, 86, 20);
		contentPane.add(txtSala);
	
		txtData = new JLabel();

		txtData.setBounds(301, 86, 86, 20);
		contentPane.add(txtData);

		
		txtHora = new JLabel();

		txtHora.setBounds(301, 111, 86, 20);
		contentPane.add(txtHora);

		txtVenda = new JLabel();

		txtVenda.setBounds(301, 136, 86, 20);
		contentPane.add(txtVenda);

		// LISTA OS DADOS DO FILME NO PAINEL
		int dist = 26;
		group = new ButtonGroup();
		if(mapSessionData==null){
			JOptionPane.showMessageDialog(new JFrame(), "N�o existem salas cadastradas!");	
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MainGraphUserInterf main = new MainGraphUserInterf();
					main.setVisible(true);
					setVisible(false);
				}
			});
			return;
			}
		for (Integer roomNow : mapSessionData.keySet()) {
			for (String sessionNow : mapSessionData.get(roomNow).keySet()) {
				JRadioButton b = new JRadioButton(mapSessionData.get(roomNow)
						.get(sessionNow).getIdSession()
						+ " - "
						+ mapSessionData.get(roomNow).get(sessionNow)
								.getCurrentMovie().getName());
				b.setActionCommand(mapSessionData.get(roomNow).get(sessionNow)
						.getIdSession()); // ide salvo em string
				b.setBounds(6, dist, 200, 23);
				group.add(b);
				DisplayMovie.add(b);
				dist = dist + 26;
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String recebido = group.getSelection()
								.getActionCommand();
						txtSessao.setText(recebido);
						txtFilme.setText(mapSessionData
								.get(Integer.parseInt(recebido.substring(0, 2)))
								.get(recebido).getCurrentMovie().getName());
						txtSala.setText(recebido.substring(0, 2));
						txtData.setText(recebido.substring(4, 6) + " / "
								+ recebido.substring(6, 8));
						txtHora.setText(recebido.substring(8, 10) + ":"
								+ recebido.substring(10, 12));
						if (mapSessionData
								.get(Integer.parseInt(recebido.substring(0, 2)))
								.get(recebido).isSold()) {
							txtVenda.setText("VENDIDO");
						} else {
							txtVenda.setText("NAO VENDIDO");
						}
					}
				});

			}
		}
		//

		// GERA OS DADOS DO ITEM SELECIOANDO.

		// VOLTA PARA A JANELA PRINCIPAL

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
	}
}
