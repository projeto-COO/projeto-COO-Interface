package GraphicInterface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import MoviesData.MovieData;
import MoviesData.RoomData;
import MoviesData.SessionData;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ManagSessionEdit extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	private ButtonGroup groupF;
	private ButtonGroup groupS;
	protected static Map<Integer, Map<String, SessionData>> mapSessionData;
	protected static Map<Integer, MovieData> mapMovieData;
	protected static Map<Integer, RoomData> mapRoomData;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAno;
	private JTextField txtHora;
	private JTextField txtMinuto;
	private String idSala;
	private String idFilme;
	private SessionData currentSession;
	private String idSessionSala;
	private String idModifFilme;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManagSessionEdit() {
		// inicializa o mapMovieData com o arquivo .ser!!!
		try {
			FileInputStream fluxoSessionIn = new FileInputStream(
					"fileSession.ser");
			ObjectInputStream fSessionIn = new ObjectInputStream(fluxoSessionIn);
			mapSessionData = (Map<Integer, Map<String, SessionData>>) fSessionIn
					.readObject();
			fSessionIn.close();
			fluxoSessionIn.close();
			FileInputStream fluxoMovieIn = new FileInputStream("fileMovie.ser");
			ObjectInputStream fMovieIn = new ObjectInputStream(fluxoMovieIn);
			mapMovieData = (TreeMap<Integer, MovieData>) fMovieIn.readObject();
			fMovieIn.close();
			fluxoMovieIn.close();

			FileInputStream fluxoRoomIn = new FileInputStream("fileRoom.ser");
			ObjectInputStream fRoomIn = new ObjectInputStream(fluxoRoomIn);
			mapRoomData = (TreeMap<Integer, RoomData>) fRoomIn.readObject();
			fRoomIn.close();
			fluxoRoomIn.close();
		} catch (IOException io) {
		} catch (ClassNotFoundException classNotFound) {
		}
		//

		setTitle("GERENCIAMENTO - SESSAO - EDITAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		// CRIA O PAYNEL COM A LISTA DE SESSAO NA ESQUERDA.
		final JPanel DisplaySession = new JPanel();
		DisplaySession.setBounds(0, 0, 213, 229);
		DisplaySession.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "SESSAO"));
		contentPane.add(DisplaySession);
		DisplaySession.setLayout(null);
		int dist = 26;
		group = new ButtonGroup();
		for (Integer roomNow : mapSessionData.keySet()) {
			for (String sessionNow : mapSessionData.get(roomNow).keySet()) {
				if (!mapSessionData.get(roomNow).get(sessionNow).isSold()) {
					JRadioButton b = new JRadioButton(mapSessionData
							.get(roomNow).get(sessionNow).getIdSession()
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

		// CRIA O PAYNEL COM A LISTA DE FILMES No centro.
		final JPanel DisplayMovie = new JPanel();
		DisplayMovie.setBounds(220, 0, 150, 229);
		DisplayMovie.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "FILMES"));
		contentPane.add(DisplayMovie);
		DisplayMovie.setLayout(null);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(535, 208, 169, 43);
		contentPane.add(btnVoltar);
		int distF = 26;
		groupF = new ButtonGroup();
		for (Integer movieNow : mapMovieData.keySet()) {
			if (!mapMovieData.get(movieNow).isSold()) {
				JRadioButton f = new JRadioButton(mapMovieData.get(movieNow)
						.getName().toUpperCase());
				f.setActionCommand(mapMovieData.get(movieNow).getIdMovie()
						.toString()); // ide salvo em string
				f.setBounds(6, distF, 130, 23);
				groupF.add(f);
				DisplayMovie.add(f);
				distF = distF + 26;
			}
		}

		// LISTA OS DADOS DO SALAS NO PAINEL ESQUERDA
		final JPanel DisplayRoom = new JPanel();
		DisplayRoom.setBounds(375, 0, 150, 229);
		DisplayRoom.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "SALA"));
		contentPane.add(DisplayRoom);
		DisplayRoom.setLayout(null);
		int distS = 26;
		groupS = new ButtonGroup();
		for (Integer roomNow : mapRoomData.keySet()) {
			if (!mapRoomData.get(roomNow).isSold()) {
				JRadioButton s = new JRadioButton(mapRoomData.get(roomNow)
						.getIdRoom().toString()
						+ " Lugares: " + mapRoomData.get(roomNow).getCapacity());
				s.setActionCommand(mapRoomData.get(roomNow).getIdRoom()
						.toString()); // id
										// salvo
										// em
										// string
				s.setBounds(6, distS, 135, 23);
				groupS.add(s);
				DisplayRoom.add(s);
				distS = distS + 26;
			}
		}
		//

		JLabel lblData = new JLabel("DATA");
		lblData.setBounds(535, 11, 46, 14);
		contentPane.add(lblData);

		JLabel lblHh = new JLabel("hh");
		lblHh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHh.setBounds(541, 130, 40, 14);
		contentPane.add(lblHh);

		JLabel lblMm = new JLabel("mm");
		lblMm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMm.setBounds(613, 130, 46, 14);
		contentPane.add(lblMm);

		JLabel lblDd = new JLabel("dd");
		lblDd.setHorizontalAlignment(SwingConstants.CENTER);
		lblDd.setBounds(535, 49, 28, 14);
		contentPane.add(lblDd);

		JLabel lblMm_1 = new JLabel("mm");
		lblMm_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMm_1.setBounds(602, 49, 32, 14);
		contentPane.add(lblMm_1);

		JLabel lblYyyy = new JLabel("yyyy");
		lblYyyy.setHorizontalAlignment(SwingConstants.CENTER);
		lblYyyy.setBounds(668, 49, 31, 14);
		contentPane.add(lblYyyy);

		txtDia = new JTextField();
		txtDia.setBounds(535, 29, 31, 20);
		contentPane.add(txtDia);
		txtDia.setColumns(10);

		txtMes = new JTextField();
		txtMes.setBounds(602, 29, 31, 20);
		contentPane.add(txtMes);
		txtMes.setColumns(10);

		txtAno = new JTextField();
		txtAno.setBounds(658, 29, 46, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);

		txtHora = new JTextField();
		txtHora.setBounds(535, 110, 53, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);

		txtMinuto = new JTextField();
		txtMinuto.setBounds(613, 110, 46, 20);
		contentPane.add(txtMinuto);
		txtMinuto.setColumns(10);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarSessao(group.getSelection().getActionCommand());
			}
		});
		btnModificar.setBounds(535, 159, 169, 38);
		contentPane.add(btnModificar);

		// VOLTA PARA A JANELA PRINCIPAL

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
	}

	protected void modificarSessao(String actionCommand) {
		// TODO Auto-generated method stub
		idSessionSala = actionCommand.substring(0, 2); // substring da sessão
		idModifFilme = groupS.getSelection().getActionCommand(); // string que modificara
		currentSession = mapSessionData.get(Integer.parseInt(idSessionSala)).get(actionCommand); // a ser modificada.
		
	}

}
