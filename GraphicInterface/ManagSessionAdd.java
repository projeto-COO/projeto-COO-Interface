package GraphicInterface;


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
import Startup.DataHours;
import System.ManageMovies;
import System.ManageSession;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ManagSessionAdd extends JFrame {

	private JPanel contentPane;
	private ButtonGroup groupF;
	private ButtonGroup groupS;
	protected static Map<Integer,RoomData> mapRoomData;
	protected static Map<Integer,MovieData> mapMovieData;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textHora;
	private JTextField textMinut;
	private JTextField textAno;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManagSessionAdd() {
		
		// inicializa o mapMovieData com o arquivo .ser!!!
		try {
			FileInputStream fluxoRoomIn = new FileInputStream("fileRoom.ser");
			ObjectInputStream fRoomIn = new ObjectInputStream(fluxoRoomIn);
			mapRoomData = (TreeMap<Integer, RoomData>)fRoomIn.readObject();
			fRoomIn.close();
			fluxoRoomIn.close();
			
			FileInputStream fluxoMovieIn = new FileInputStream("fileMovie.ser");
			ObjectInputStream fMovieIn = new ObjectInputStream(fluxoMovieIn);
			mapMovieData = (TreeMap<Integer, MovieData>)fMovieIn.readObject();
			fMovieIn.close();
			fluxoMovieIn.close();
		} catch (IOException io) {	} catch (ClassNotFoundException classNotFound) { 	}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		// CRIA O PAYNEL COM A LISTA DE SALAS NA ESQUERDA.
		final JPanel DisplayRoom = new JPanel();
		DisplayRoom.setBounds(0, 0, 145, 262);
		DisplayRoom.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "SALA"));
		contentPane.add(DisplayRoom);
		DisplayRoom.setLayout(null);
		
		// LISTA OS DADOS DO SALAS NO PAINEL ESQUERDA
		int distS = 26;
		groupS = new ButtonGroup();
		for (Integer roomNow : mapRoomData.keySet()){
			JRadioButton s = new JRadioButton(mapRoomData.get(roomNow).getIdRoom().toString() + " Lugares: "+mapRoomData.get(roomNow).getCapacity());
			s.setActionCommand(mapRoomData.get(roomNow).getIdRoom().toString()); // id salvo em string
			s.setBounds(6, distS, 135, 23);
			groupS.add(s);
			DisplayRoom.add(s);
			distS = distS + 26;
		}
		//
		
		// CRIA O PAYNEL COM A LISTA DE FILMES NO CENTRO.
		final JPanel DisplayMovie = new JPanel();
		DisplayMovie.setBounds(147, 0, 140, 262);
		DisplayMovie.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "FILME"));
		contentPane.add(DisplayMovie);
		DisplayMovie.setLayout(null);
		
		// LISTA OS DADOS DO FILME NO PAINEL 
		int distF = 26;
		groupF = new ButtonGroup();
		for (Integer movieNow : mapMovieData.keySet()){
			JRadioButton f = new JRadioButton(mapMovieData.get(movieNow).getName().toUpperCase());
			f.setActionCommand(mapMovieData.get(movieNow).getIdMovie().toString()); // ide salvo em string
			f.setBounds(6, distF, 130, 23);
			groupF.add(f);
			DisplayMovie.add(f);
			distF = distF + 26;
		}
		//
		
		
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(345, 219, 79, 32);
		contentPane.add(btnVoltar);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(295, 11, 129, 14);
		contentPane.add(lblData);
		
		JLabel lblHora = new JLabel("HORA");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setBounds(297, 95, 76, 14);
		contentPane.add(lblHora);
		
		textDia = new JTextField();
		textDia.setBounds(297, 25, 39, 20);
		contentPane.add(textDia);
		textDia.setColumns(10);
		
		textMes = new JTextField();
		textMes.setBounds(345, 25, 39, 20);
		contentPane.add(textMes);
		textMes.setColumns(10);
		
		JLabel lblDia = new JLabel("dd");
		lblDia.setBounds(297, 47, 39, 14);
		contentPane.add(lblDia);
		
		JLabel lblMes = new JLabel("mm");
		lblMes.setBounds(342, 47, 39, 14);
		contentPane.add(lblMes);
		
		textHora = new JTextField();
		textHora.setBounds(297, 112, 39, 20);
		contentPane.add(textHora);
		textHora.setColumns(10);
		
		textMinut = new JTextField();
		textMinut.setBounds(345, 112, 39, 20);
		contentPane.add(textMinut);
		textMinut.setColumns(10);
		
		JLabel lblHh = new JLabel("hh");
		lblHh.setBounds(297, 137, 46, 14);
		contentPane.add(lblHh);
		
		textAno = new JTextField();
		textAno.setBounds(394, 25, 30, 20);
		contentPane.add(textAno);
		textAno.setColumns(10);
		
		JLabel lblYyyy = new JLabel("yyyy");
		lblYyyy.setBounds(391, 47, 46, 14);
		contentPane.add(lblYyyy);
		
		JLabel lblMm = new JLabel("mm");
		lblMm.setBounds(345, 137, 46, 14);
		contentPane.add(lblMm);
		
		JButton btnCriar = new JButton("CRIAR");
		btnCriar.setBounds(345, 176, 79, 32);
		contentPane.add(btnCriar);
		
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MovieData currentMovieData = mapMovieData.get(Integer.parseInt(groupF.getSelection().getActionCommand()));
				RoomData currentRoomData = mapRoomData.get(Integer.parseInt(groupS.getSelection().getActionCommand()));
				DataHours data = new DataHours(Integer.parseInt(textDia.getText()), Integer.parseInt(textMes.getText()), Integer.parseInt(textAno.getText()), Integer.parseInt(textHora.getText()), Integer.parseInt(textMinut.getText()));
				ManageMovies manag = new ManageMovies();
				ManageSession sess = new ManageSession();
				if(manag.checkData(data)){
					SessionData newSession = new SessionData(currentMovieData, data, currentRoomData);
					if(sess.checkSession(newSession)){
						sess.createSession(newSession);
					}
				}
			}
		});
		
		//VOLTA PARA A JANELA PRINCIPAL
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
	}
}
