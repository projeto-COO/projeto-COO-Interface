package GraphicInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ManagSessionDisplay extends JFrame {

	private JPanel contentPane;
	private JLabel lblExibir;
	private JList list;
	/**
	 * Create the frame.
	 */
	public ManagSessionDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblExibir = new JLabel("Exibindo as sessões cadastradas");
		lblExibir.setBounds(0,0,250,20);
		contentPane.add(lblExibir);
		
		DefaultListModel filmes = new DefaultListModel();  
		list = new JList(filmes);
		// AQUI SÃO AS SALAS CADASTRADOS
		filmes.addElement("Sala 1 - 15:00 - Titanic - legendado - 2d");
		filmes.addElement("Sala 2 - 12:34 - Poseidon - dublado - 3d");
		filmes.addElement("Sala 3 - 16:00 - Tubarao - legendado - 3d");
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(400, 170));
		listScroller.setBounds(0,30,400,170);
		contentPane.add(listScroller);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(333, 208, 91, 43);
		contentPane.add(btnVoltar);
		
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