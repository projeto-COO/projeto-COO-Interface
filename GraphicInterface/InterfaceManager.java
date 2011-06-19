package GraphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceManager extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InterfaceManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(335, 228, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnFilmes = new JButton("FILMES");
		btnFilmes.setBounds(139, 68, 89, 23);
		contentPane.add(btnFilmes);
		
		JButton btnSessoes = new JButton("SESSOES");
		btnSessoes.setBounds(139, 102, 89, 23);
		contentPane.add(btnSessoes);
		
		JButton btnSalas = new JButton("SALAS");
		btnSalas.setBounds(139, 136, 89, 23);
		contentPane.add(btnSalas);
		
		
		
		//A��ES
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGraphUserInterf main = new MainGraphUserInterf();
				setVisible(false);
				main.setVisible(true);
			}
		});
	}

}
