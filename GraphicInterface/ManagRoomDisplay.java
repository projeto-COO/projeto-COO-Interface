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

import MoviesData.RoomData;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ManagRoomDisplay extends JFrame {

	private JPanel contentPane;
	protected static Map<Integer,RoomData> mapRoomData;
	private JTextField txtId;
	private JTextField txtFileira;
	private JTextField txtColuna;
	private JTextField txtCapacidade;
	private JTextField txtSevendeu;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManagRoomDisplay() {
		
		// inicializa o mapMovieData com o arquivo .ser!!!
		try {
			FileInputStream fluxoRoomIn = new FileInputStream("fileRoom.ser");
			ObjectInputStream fRoomIn = new ObjectInputStream(fluxoRoomIn);
			mapRoomData = (TreeMap<Integer, RoomData>)fRoomIn.readObject();
			fRoomIn.close();
			fluxoRoomIn.close();
		} catch (IOException io) {	} catch (ClassNotFoundException classNotFound) { 	}
		
		setLocationRelativeTo(null);
		setTitle("GERENCIAMENTO - SALA - EXIBIR");
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
		
		JButton btnMostrar = new JButton("MOSTRAR");
		btnMostrar.setBounds(207, 208, 91, 43);
		contentPane.add(btnMostrar);
		

		// CRIA O PAYNEL COM A LISTA DE FILMES NA ESQUERDA.
		final JPanel DisplayRoom = new JPanel();
		DisplayRoom.setBounds(0, 0, 166, 262);
		DisplayRoom.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "SALA"));
		contentPane.add(DisplayRoom);
		DisplayRoom.setLayout(null);
		
		JLabel lblIdsala = new JLabel("ID SALA");
		lblIdsala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdsala.setBounds(207, 36, 70, 14);
		contentPane.add(lblIdsala);
		
		JLabel lblFileiras = new JLabel("FILEIRAS");
		lblFileiras.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFileiras.setBounds(207, 61, 70, 14);
		contentPane.add(lblFileiras);
		
		JLabel lblColunas = new JLabel("COLUNAS");
		lblColunas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColunas.setBounds(207, 86, 70, 14);
		contentPane.add(lblColunas);
		
		JLabel lblCapacidade = new JLabel("CAPACIDADE");
		lblCapacidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidade.setBounds(207, 111, 70, 14);
		contentPane.add(lblCapacidade);
		
		JLabel lblVendeu = new JLabel("VENDEU?");
		lblVendeu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendeu.setBounds(207, 136, 70, 14);
		contentPane.add(lblVendeu);
		
		txtId = new JTextField();
		txtId.setBounds(287, 33, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtFileira = new JTextField();
		txtFileira.setBounds(287, 58, 86, 20);
		contentPane.add(txtFileira);
		txtFileira.setColumns(10);
		
		txtColuna = new JTextField();
		txtColuna.setBounds(287, 83, 86, 20);
		contentPane.add(txtColuna);
		txtColuna.setColumns(10);
		
		txtCapacidade = new JTextField();
		txtCapacidade.setBounds(287, 108, 86, 20);
		contentPane.add(txtCapacidade);
		txtCapacidade.setColumns(10);
		
		txtSevendeu = new JTextField();
		txtSevendeu.setBounds(287, 133, 86, 20);
		contentPane.add(txtSevendeu);
		txtSevendeu.setColumns(10);
		

		// LISTA OS DADOS DO FILME NO PAINEL ESQUERDA
		int dist = 26;
		final ButtonGroup group = new ButtonGroup();
		for (Integer roomNow : mapRoomData.keySet()){
			JRadioButton b = new JRadioButton(mapRoomData.get(roomNow).getIdRoom().toString());
			b.setActionCommand(mapRoomData.get(roomNow).getIdRoom().toString()); // id salvo em string
			b.setBounds(6, dist, 109, 23);
			group.add(b);
			DisplayRoom.add(b);
			dist = dist + 26;
		}
		//
		
		//EXIBE OS DADOS DO ITEM SELECIONADO.
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int recebido = Integer.parseInt(group.getSelection().getActionCommand());
				txtId.setText(mapRoomData.get(recebido).getIdRoom().toString());
				txtColuna.setText(mapRoomData.get(recebido).getColumns().toString());
				txtFileira.setText(mapRoomData.get(recebido).getRows().toString());
				txtCapacidade.setText(mapRoomData.get(recebido).getCapacity().toString());
				if(mapRoomData.get(recebido).isSold())
					txtSevendeu.setText("VENDIDO");
				else
					txtSevendeu.setText("NAO VENDIDO");
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
