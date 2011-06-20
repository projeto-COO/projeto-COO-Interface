package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.Map;
import java.util.TreeMap;

import javax.swing.JRadioButton;
import MoviesData.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class ManagMovieDisplay extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	protected static Map<Integer,MovieData> mapMovieData;
	private JTextField textFCodigo;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtRateage;
	private JTextField txtLinguagem;
	private JTextField txtDuracao;
	private JTextField txtSevendeu;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManagMovieDisplay() {
		
		// inicializa o mapMovieData com o arquivo .ser!!!
		try {
			FileInputStream fluxoMovieIn = new FileInputStream("fileMovie.ser");
			ObjectInputStream fMovieIn = new ObjectInputStream(fluxoMovieIn);
			mapMovieData = (TreeMap<Integer, MovieData>)fMovieIn.readObject();
			fMovieIn.close();
			fluxoMovieIn.close();
		} catch (IOException io) {	} catch (ClassNotFoundException classNotFound) { 	}
		//
		
		
		setTitle("GERENCIAMENTO - FILMES - EXIBIR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(2, 3));
		getContentPane().setLayout(null);

		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBounds(0, 231, 434, 31);
		ButtonPanel.setLayout(null);
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(10, 0, 100, 23);
		ButtonPanel.add(btnVoltar);
		getContentPane().add(ButtonPanel);

		/*
		JButton btnMostrar = new JButton("MOSTRAR");
		btnMostrar.setBounds(300, 0, 120, 23);
		ButtonPanel.add(btnMostrar);
*/
		// CRIA O PAYNEL COM A LISTA DE FILMES NA ESQUERDA.
		final JPanel DisplayMovie = new JPanel();
		DisplayMovie.setBounds(0, 0, 166, 229);
		DisplayMovie.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "FILME"));
		getContentPane().add(DisplayMovie);
		DisplayMovie.setLayout(null);
		

		// LISTA OS DADOS DO FILME NO PAINEL 
		int dist = 26;
		group = new ButtonGroup();
	
		if(mapMovieData==null){
			JOptionPane.showMessageDialog(new JFrame(), "Não existem filmes cadastrados!");	
			return;
		}
		for (Integer movieNow : mapMovieData.keySet()){
			JRadioButton b = new JRadioButton(mapMovieData.get(movieNow).getName().toUpperCase());
			b.setActionCommand(mapMovieData.get(movieNow).getIdMovie().toString()); // ide salvo em string
			b.setBounds(6, dist, 109, 23);
			group.add(b);
			DisplayMovie.add(b);
			dist = dist + 26;
			
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int recebido = Integer.parseInt(group.getSelection().getActionCommand());
					textFCodigo.setText(mapMovieData.get(recebido).getIdMovie().toString());
					txtNome.setText(mapMovieData.get(recebido).getName().toUpperCase());
					txtGenero.setText(mapMovieData.get(recebido).getGender().toUpperCase());
					txtLinguagem.setText(mapMovieData.get(recebido).getLanguage().toUpperCase());
					txtRateage.setText(mapMovieData.get(recebido).getAgeRate().toString());
					txtDuracao.setText(mapMovieData.get(recebido).getDuration().toDuration());
					if(mapMovieData.get(recebido).isSold())
						txtSevendeu.setText("VENDIDO");
					else
						txtSevendeu.setText("NAO VENDIDO");
				}
			});
		}
		//

		JPanel DisplayMovieData = new JPanel();
		DisplayMovieData.setBounds(176, 0, 258, 229);
		DisplayMovieData.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "FILME - DADOS"));
		getContentPane().add(DisplayMovieData);
		DisplayMovieData.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(10, 33, 77, 14);
		DisplayMovieData.add(lblCodigo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(10, 58, 77, 14);
		DisplayMovieData.add(lblNome);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setBounds(10, 83, 77, 14);
		DisplayMovieData.add(lblGenero);
		
		JLabel lblClassificacao = new JLabel("Classif.");
		lblClassificacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClassificacao.setBounds(10, 108, 77 , 14);
		DisplayMovieData.add(lblClassificacao);
		
		JLabel lblLingagem = new JLabel("Idioma");
		lblLingagem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLingagem.setBounds(10, 133, 77, 14);
		DisplayMovieData.add(lblLingagem);
		
		JLabel lblDuracao = new JLabel("Duracao");
		lblDuracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracao.setBounds(10, 158, 77, 14);
		DisplayMovieData.add(lblDuracao);
		
		JLabel lblVendeu = new JLabel("Vendeu?");
		lblVendeu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendeu.setBounds(10, 183, 77, 14);
		DisplayMovieData.add(lblVendeu);
		
		textFCodigo = new JTextField();
		textFCodigo.setBounds(94, 30, 86, 20);
		DisplayMovieData.add(textFCodigo);
		textFCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(94, 55, 86, 20);
		DisplayMovieData.add(txtNome);
		txtNome.setColumns(10);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(94, 80, 86, 20);
		DisplayMovieData.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtRateage = new JTextField();
		txtRateage.setBounds(94, 105, 86, 20);
		DisplayMovieData.add(txtRateage);
		txtRateage.setColumns(10);
		
		txtLinguagem = new JTextField();
		txtLinguagem.setBounds(94, 130, 86, 20);
		DisplayMovieData.add(txtLinguagem);
		txtLinguagem.setColumns(10);
		
		txtDuracao = new JTextField();
		txtDuracao.setBounds(94, 155, 86, 20);
		DisplayMovieData.add(txtDuracao);
		txtDuracao.setColumns(10);
		
		txtSevendeu = new JTextField();
		txtSevendeu.setBounds(94, 180, 86, 20);
		DisplayMovieData.add(txtSevendeu);
		txtSevendeu.setColumns(10);

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
