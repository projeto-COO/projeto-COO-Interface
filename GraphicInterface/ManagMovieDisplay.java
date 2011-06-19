package GraphicInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ManagMovieDisplay extends JFrame {

	private JPanel contentPane;
	private JLabel lblExibir;
	private JList list;
	
	
	
	/**
	 * Create the frame.
	 */
	public ManagMovieDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblExibir = new JLabel("Exibindo os filmes cadastrados");
		lblExibir.setBounds(0,0,250,20);
		contentPane.add(lblExibir);
		
		DefaultListModel filmes = new DefaultListModel();  
		list = new JList(filmes);
		// AQUI SÃO OS FILMES CADASTRADOS
		filmes.addElement("filme1");
		filmes.addElement("filme2");
		filmes.addElement("filme3");
		filmes.addElement("filme4");
		filmes.addElement("filme5");
		filmes.addElement("filme6");
		filmes.addElement("filme7");
		filmes.addElement("filme8");
		filmes.addElement("filme9");
		filmes.addElement("filme10");
		filmes.addElement("filme11");
		filmes.addElement("filme12");
		filmes.addElement("filme13");
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