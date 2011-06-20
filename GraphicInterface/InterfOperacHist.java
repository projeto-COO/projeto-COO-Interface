package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class InterfOperacHist extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InterfOperacHist() {
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
		
		JCheckBox chckbxFilme = new JCheckBox("FILME");
		chckbxFilme.setBounds(6, 7, 55, 23);
		contentPane.add(chckbxFilme);
		
		JCheckBox chckbxSessao = new JCheckBox("SESSAO");
		chckbxSessao.setBounds(63, 7, 65, 23);
		contentPane.add(chckbxSessao);
		
		JCheckBox chckbxSala = new JCheckBox("SALA");
		chckbxSala.setBounds(130, 7, 51, 23);
		contentPane.add(chckbxSala);

		// VOLTA PARA A JANELA PRINCIPAL

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
	}
}
