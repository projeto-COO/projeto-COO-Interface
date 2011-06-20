package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InterfOperacHist extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;

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
		btnVoltar.setBounds(317, 208, 107, 43);
		contentPane.add(btnVoltar);
		
		JCheckBox chckbxFilme = new JCheckBox("FILME");
		chckbxFilme.setBounds(6, 7, 73, 23);
		contentPane.add(chckbxFilme);
		
		JCheckBox chckbxSessao = new JCheckBox("SESSAO");
		chckbxSessao.setBounds(91, 7, 77, 23);
		contentPane.add(chckbxSessao);
		
		JCheckBox chckbxSala = new JCheckBox("SALA");
		chckbxSala.setBounds(188, 7, 62, 23);
		contentPane.add(chckbxSala);
		
		JCheckBox chckbxCriacao = new JCheckBox("CRIACAO");
		chckbxCriacao.setBounds(6, 33, 83, 23);
		contentPane.add(chckbxCriacao);
		
		JCheckBox chckbxExclusao = new JCheckBox("EXCLUSAO");
		chckbxExclusao.setBounds(91, 33, 91, 23);
		contentPane.add(chckbxExclusao);
		
		JCheckBox chckbxModificacao = new JCheckBox("MODIFICACAO");
		chckbxModificacao.setBounds(188, 33, 99, 23);
		contentPane.add(chckbxModificacao);
		
		JButton btnMostrar = new JButton("MOSTRAR");
		btnMostrar.setBounds(317, 149, 107, 23);
		contentPane.add(btnMostrar);
		
		JTextArea txtrHistorico = new JTextArea();
		txtrHistorico.setBounds(6, 63, 292, 188);
		contentPane.add(txtrHistorico);
		
		String[] lista = {"DATA", "SITIACAO", "TIPO"};
		int dist = 6;
		group = new ButtonGroup();
		for (String radioB : lista){
			JRadioButton b = new JRadioButton(radioB);
			b.setActionCommand(radioB); // ide salvo em string
			b.setBounds(315, dist, 109, 23);
			group.add(b);
			contentPane.add(b);
			dist = dist + 26;
		}

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
