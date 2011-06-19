package GraphicInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ManagRoomDisplay extends JFrame {

	private JPanel contentPane;
	private JLabel lblExibir;
	private JList list;
	
	/**
	 * Create the frame.
	 */
	public ManagRoomDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblExibir = new JLabel("Exibindo as salas cadastrados");
		lblExibir.setBounds(0,0,250,20);
		contentPane.add(lblExibir);
		
		DefaultListModel filmes = new DefaultListModel();  
		list = new JList(filmes);
		// AQUI SÃO AS SALAS CADASTRADOS
		filmes.addElement("Sala 1 - 98 lugares");
		filmes.addElement("Sala 2 - 34 lugares");
		filmes.addElement("Sala 3 - 300 lugares");
		filmes.addElement("Sala 4 - 50 lugares");
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