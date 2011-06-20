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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import MoviesData.RoomData;
import System.ManageRoom;

public class ManagRoomDelete extends JFrame {

	private JPanel contentPane;
	protected static Map<Integer,RoomData> mapRoomData;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManagRoomDelete() {
		// inicializa o mapMovieData com o arquivo .ser!!!
		try {
			FileInputStream fluxoRoomIn = new FileInputStream("fileRoom.ser");
			ObjectInputStream fRoomIn = new ObjectInputStream(fluxoRoomIn);
			mapRoomData = (TreeMap<Integer, RoomData>)fRoomIn.readObject();
			fRoomIn.close();
			fluxoRoomIn.close();
		} catch (IOException io) {	} catch (ClassNotFoundException classNotFound) { 	}
		//
		
		setTitle("GERENCIAMENTO - SALAS - EXCLUIR");
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
		final JPanel DisplayRoom = new JPanel();
		DisplayRoom.setBounds(0, 0, 166, 262);
		DisplayRoom.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "SALA"));
		contentPane.add(DisplayRoom);
		DisplayRoom.setLayout(null);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(333, 94, 91, 43);
		contentPane.add(btnExcluir);
		
		// LISTA OS DADOS DO FILME NO PAINEL ESQUERDA
		int dist = 26;
		final ButtonGroup group = new ButtonGroup();
		for (Integer roomNow : mapRoomData.keySet()){
			if(!mapRoomData.get(roomNow).isSold()){
				JRadioButton b = new JRadioButton(mapRoomData.get(roomNow).getIdRoom().toString());
				b.setActionCommand(mapRoomData.get(roomNow).getIdRoom().toString()); // id salvo em string
				b.setBounds(6, dist, 109, 23);
				group.add(b);
				DisplayRoom.add(b);
				dist = dist + 26;
			}

		}
		//
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(group.getSelection()==null){
					JOptionPane.showMessageDialog(new JFrame(), "Nao existem salas!");
				}else{
				int recebido = Integer.parseInt(group.getSelection().getActionCommand());
				ManageRoom manage = new ManageRoom();
				manage.deleteRoom(recebido);
				JOptionPane.showMessageDialog(new JFrame(), "Sala excluida com sucesso!");
			}}
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
