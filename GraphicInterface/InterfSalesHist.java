package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import MoviesData.SessionData;
import System.HistoricFactory;

@SuppressWarnings("serial")
public class InterfSalesHist extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	private JRadioButton b;
	private JTextArea txtrHistorico;
	HistoricFactory historic = new HistoricFactory();
	private JButton btnMostrar;

	/**
	 * Create the frame.
	 */
	public InterfSalesHist() {
		setTitle("VENDAS");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		String[] lista = { "DATA CRESCENTE", "DATA DECRESCENTE" };
		int dist = 6;
		group = new ButtonGroup();
		for (String radioB : lista) {
			b = new JRadioButton(radioB);
			b.setActionCommand(radioB); // ide salvo em string
			b.setBounds(100, dist, 200, 23);
			group.add(b);
			contentPane.add(b);
			dist = dist + 26;
		}

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(484, 11, 91, 43);
		contentPane.add(btnVoltar);

		txtrHistorico = new JTextArea();
		txtrHistorico.setBounds(10, 69, 565, 182);
		contentPane.add(txtrHistorico);

		btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textShow();
			}
		});
		btnMostrar.setBounds(362, 11, 112, 43);
		contentPane.add(btnMostrar);

		// VOLTA PARA A JANELA PRINCIPAL

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
	}

	void textShow() {
		txtrHistorico.setText("");
		List<String> listSession = historic.chooseManageS();
		if(group.getSelection().getActionCommand().equals("DATA DECRESCENTE")){
			Collections.reverse(listSession);
		}
		
		for (String hist : listSession){
			txtrHistorico.setText(txtrHistorico.getText() + "\n" + hist);
		}
	}
}
