package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Startup.DataHours;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ManagRoomAdd extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ManagRoomAdd() {
		//createMovie(String nome,String genero,String classif,String dimens,String linguagem, DataHours duracao)
		
		setTitle("GERENCIAMENTO - FILMES - CRIAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
