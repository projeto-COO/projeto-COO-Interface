package GraphicInterface;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import javax.swing.JTextPane;

import MoviesData.SessionData;
import System.TicketSale;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InterfaceSales extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	protected static Map<Integer, Map<String, SessionData>> mapSessionData;
	private JTextField txtQuant;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public InterfaceSales() {

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

		setTitle("VENDAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		// CRIA O PAYNEL COM A LISTA DE FILMES NA ESQUERDA.
		final JPanel DisplayMovie = new JPanel();
		DisplayMovie.setBounds(0, 0, 424, 217);
		DisplayMovie.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "SESSOES"));
		contentPane.add(DisplayMovie);
		DisplayMovie.setLayout(null);

		// LISTA OS DADOS DO FILME NO PAINEL
		int dist = 26;
		group = new ButtonGroup();
		for (Integer roomNow : mapSessionData.keySet()) {
			for (String sessionNow : mapSessionData.get(roomNow).keySet()) {
				JRadioButton b = new JRadioButton(mapSessionData.get(roomNow)
						.get(sessionNow).getCurrentMovie().getName()
						+ " SALA: "
						+ mapSessionData.get(roomNow).get(sessionNow)
								.getCurrentRoom().getIdRoom()
								+ " DISPONIVEL: "
						+ mapSessionData.get(roomNow).get(sessionNow)
								.getAvailability().toString()
						+ " HORA: "
						+ (mapSessionData.get(roomNow).get(sessionNow)
								.getDate().hh() < 10 ? "0" : "")
						+ mapSessionData.get(roomNow).get(sessionNow).getDate()
								.hh().toString()
						+ ":"
						+ (mapSessionData.get(roomNow).get(sessionNow)
								.getDate().mm() < 10 ? "0" : "")
						+ mapSessionData.get(roomNow).get(sessionNow).getDate()
								.mm().toString());
				b.setActionCommand(mapSessionData.get(roomNow).get(sessionNow)
						.getIdSession()); // ide salvo em string
				b.setBounds(6, dist, 400, 23);
				group.add(b);
				DisplayMovie.add(b);
				dist = dist + 26;
			}
		}
		//

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
			}
		});
		btnVoltar.setBounds(335, 228, 89, 23);
		contentPane.add(btnVoltar);

		txtQuant = new JTextField();
		txtQuant.setBounds(99, 229, 86, 20);
		contentPane.add(txtQuant);
		txtQuant.setColumns(10);

		JButton btnConfirmar = new JButton("CONFIRMAR");

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recebido = group.getSelection().getActionCommand();
				
				if(Integer.parseInt(txtQuant.getText())<= mapSessionData.get(Integer.parseInt(recebido.substring(0, 2))).get(recebido).getAvailability()){
					TicketSale sales = new TicketSale();
					sales.mainSales(mapSessionData.get(Integer.parseInt(recebido.substring(0, 2))).get(recebido).getIdSession(), Integer.parseInt(txtQuant.getText()));
					JOptionPane.showMessageDialog(new JFrame(), "Venda realizada com sucesso!");
					cleanMenu();
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(), "Nao foi possivel realizar compra!");
					cleanMenu();
				}
			}
		});
		btnConfirmar.setBounds(197, 229, 126, 23);



		contentPane.add(btnConfirmar);


		JLabel lblQuantidade = new JLabel("QUANTIDADE");
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setBounds(10, 232, 79, 14);
		contentPane.add(lblQuantidade);
	}
	void cleanMenu(){
		txtQuant.setText("");
	}

	}
