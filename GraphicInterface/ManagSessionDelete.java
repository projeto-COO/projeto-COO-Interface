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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import MoviesData.SessionData;

public class ManagSessionDelete extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	private Object JRadioButton;
	private JRadioButton b;
	protected static Map<Integer, Map<String, SessionData>> mapSessionData;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManagSessionDelete() {
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
		setTitle("GERENCIAMENTO - SESSAO - DELETAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		// CRIA O PAYNEL COM A LISTA DE FILMES NA ESQUERDA.
		final JPanel DisplaySession = new JPanel();
		DisplaySession.setBounds(0, 0, 213, 229);
		DisplaySession.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "FILME"));
		contentPane.add(DisplaySession);
		DisplaySession.setLayout(null);
		// LISTA OS DADOS DO FILME NO PAINEL
		int dist = 26;
		group = new ButtonGroup();
		for (Integer roomNow : mapSessionData.keySet()) {
			for (String sessionNow : mapSessionData.get(roomNow).keySet()) {
				if (!mapSessionData.get(roomNow).get(sessionNow).isSold()) {
					b = new JRadioButton(mapSessionData.get(roomNow)
							.get(sessionNow).getIdSession()
							+ " - "
							+ mapSessionData.get(roomNow).get(sessionNow)
									.getCurrentMovie().getName());
					b.setActionCommand(mapSessionData.get(roomNow)
							.get(sessionNow).getIdSession()); // ide salvo em
																// string
					b.setBounds(6, dist, 200, 23);
					group.add(b);
					DisplaySession.add(b);
					dist = dist + 26;
				}
			}
		}
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(333, 208, 91, 43);
		contentPane.add(btnVoltar);
		
		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.setBounds(259, 77, 89, 23);
		contentPane.add(btnDeletar);

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
