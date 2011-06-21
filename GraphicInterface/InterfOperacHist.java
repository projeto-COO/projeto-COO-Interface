package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.BoundedRangeModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import MoviesData.HistoricData;
import MoviesData.MovieData;
import MoviesData.RoomData;
import MoviesData.SessionData;
import System.HistoricFactory;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JList;

@SuppressWarnings("serial")
public class InterfOperacHist extends JFrame {

	private JPanel contentPane;
	protected static List<HistoricData> listHistoricData;
	HistoricFactory historic = new HistoricFactory();
	private JTextArea txtrHistorico;
	private JCheckBox chckbxFilme;
	private JCheckBox chckbxSessao;
	private JCheckBox chckbxSala;
	private JCheckBox chckbxCriacao;
	private JCheckBox chckbxModificacao;
	private JCheckBox chckbxExclusao;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public InterfOperacHist() {
		try {
			FileInputStream fluxoHistoricIn = new FileInputStream(
					"fileHistoric.ser");
			ObjectInputStream fHistoricIn = new ObjectInputStream(
					fluxoHistoricIn);
			listHistoricData = (LinkedList<HistoricData>) fHistoricIn
					.readObject();
			fHistoricIn.close();
			fluxoHistoricIn.close();

		} catch (FileNotFoundException fileNotFound) {
		} catch (IOException io) {
		} catch (ClassNotFoundException classNotFound) {
		}
		setTitle("HISTORICO - OPERACAO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(567, 7, 107, 43);
		contentPane.add(btnVoltar);

		chckbxFilme = new JCheckBox("FILME");
		chckbxFilme.setBounds(6, 7, 73, 23);
		contentPane.add(chckbxFilme);

		chckbxSessao = new JCheckBox("SESSAO");
		chckbxSessao.setBounds(105, 7, 91, 23);
		contentPane.add(chckbxSessao);

		chckbxSala = new JCheckBox("SALA");
		chckbxSala.setBounds(211, 7, 62, 23);
		contentPane.add(chckbxSala);

		chckbxCriacao = new JCheckBox("CRIACAO");
		chckbxCriacao.setBounds(6, 33, 91, 23);
		contentPane.add(chckbxCriacao);

		chckbxExclusao = new JCheckBox("EXCLUSAO");
		chckbxExclusao.setBounds(105, 33, 107, 23);
		contentPane.add(chckbxExclusao);

		chckbxModificacao = new JCheckBox("MODIFICACAO");
		chckbxModificacao.setBounds(211, 33, 121, 23);
		contentPane.add(chckbxModificacao);

		JButton btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textShow();
			}
		});
		btnMostrar.setBounds(448, 7, 107, 23);
		contentPane.add(btnMostrar);
		txtrHistorico = new JTextArea();
		txtrHistorico.setBounds(6, 63, 668, 188);
		contentPane.add(txtrHistorico);
		
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
		for(String hist : historic.chooseManageI(chckbxFilme.isSelected(), chckbxSessao.isSelected(), chckbxSala.isSelected(), chckbxCriacao.isSelected(), chckbxModificacao.isSelected(), chckbxExclusao.isSelected())){
		txtrHistorico.setText(txtrHistorico.getText() +"\n"+hist);
		
		
		}
	}
}