package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import MoviesData.MovieData;
import System.ManageMovie;

@SuppressWarnings("serial")
public class ManagMovieEdit extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	protected static Map<Integer, MovieData> mapMovieData;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtClassif;
	private JTextField txtDimensao;
	private JTextField txtLinguagem;
	private JTextField txtHoras;
	private JTextField txtMinuto;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManagMovieEdit() {

		// inicializa o mapMovieData com o arquivo .ser!!!
		try {
			FileInputStream fluxoMovieIn = new FileInputStream("fileMovie.ser");
			ObjectInputStream fMovieIn = new ObjectInputStream(fluxoMovieIn);
			mapMovieData = (TreeMap<Integer, MovieData>) fMovieIn.readObject();
			fMovieIn.close();
			fluxoMovieIn.close();
		} catch (IOException io) {
		} catch (ClassNotFoundException classNotFound) {
		}
		//

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

		// CRIA O PAYNEL COM A LISTA DE FILMES NA ESQUERDA.
		final JPanel DisplayMovie = new JPanel();
		DisplayMovie.setBounds(0, 0, 166, 229);
		DisplayMovie.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "FILME"));
		getContentPane().add(DisplayMovie);
		DisplayMovie.setLayout(null);
		contentPane.add(DisplayMovie);

		final JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setEnabled(false);
		btnModificar.setBounds(176, 208, 127, 43);
		contentPane.add(btnModificar);

		JLabel lblNome = new JLabel("NOME");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(176, 11, 89, 14);
		contentPane.add(lblNome);

		JLabel lblGenero = new JLabel("GENERO");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setBounds(176, 36, 89, 14);
		contentPane.add(lblGenero);

		JLabel lblClassificacao = new JLabel("CLASSIFICACAO");
		lblClassificacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClassificacao.setBounds(176, 61, 89, 14);
		contentPane.add(lblClassificacao);

		JLabel lblDimensao = new JLabel("DIMENSAO");
		lblDimensao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDimensao.setBounds(176, 86, 89, 14);
		contentPane.add(lblDimensao);

		JLabel lblLinguagem = new JLabel("LINGUAGEM");
		lblLinguagem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLinguagem.setBounds(176, 111, 89, 14);
		contentPane.add(lblLinguagem);

		JLabel lblDuracao = new JLabel("DURACAO");
		lblDuracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracao.setBounds(176, 136, 89, 14);
		contentPane.add(lblDuracao);

		txtNome = new JTextField();
		txtNome.setBounds(275, 8, 130, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtGenero = new JTextField();
		txtGenero.setBounds(275, 33, 86, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);

		txtClassif = new JTextField();
		txtClassif.setBounds(275, 58, 86, 20);
		contentPane.add(txtClassif);
		txtClassif.setColumns(10);

		txtDimensao = new JTextField();
		txtDimensao.setBounds(275, 83, 86, 20);
		contentPane.add(txtDimensao);
		txtDimensao.setColumns(10);

		txtLinguagem = new JTextField();
		txtLinguagem.setBounds(275, 108, 86, 20);
		contentPane.add(txtLinguagem);
		txtLinguagem.setColumns(10);

		txtHoras = new JTextField();
		txtHoras.setBounds(275, 133, 60, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);

		txtMinuto = new JTextField();
		txtMinuto.setBounds(345, 133, 60, 20);
		contentPane.add(txtMinuto);
		txtMinuto.setColumns(10);

		JLabel lblHora = new JLabel("HORA");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setBounds(275, 153, 60, 14);
		contentPane.add(lblHora);

		JLabel lblMinuto = new JLabel("MINUTO");
		lblMinuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinuto.setBounds(345, 153, 60, 14);
		contentPane.add(lblMinuto);

		JButton btnCarregar = new JButton("CARREGAR");
		btnCarregar.setBounds(176, 174, 127, 23);
		contentPane.add(btnCarregar);

		// modifyMovie(String name, String gender, Integer ageRate, String
		// dimension, String language, String duration)
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int recebido = Integer.parseInt(group.getSelection()
						.getActionCommand());
				ManageMovie manage = new ManageMovie();
				manage.modifyMovie(recebido, txtNome.getText(),
						txtGenero.getText(),
						Integer.parseInt(txtClassif.getText()),
						txtDimensao.getText(), txtLinguagem.getText(),
						txtHoras.getText() + "-" + txtMinuto.getText());
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
				JOptionPane.showMessageDialog(new JFrame(), "Filme modificado com sucesso!");
			}
		});
		
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnModificar.setEnabled(true);
				int recebido = Integer.parseInt(group.getSelection()
						.getActionCommand());
				txtNome.setText(mapMovieData.get(recebido).getName()
						.toUpperCase());
				txtGenero.setText(mapMovieData.get(recebido).getGender()
						.toUpperCase());
				txtLinguagem.setText(mapMovieData.get(recebido).getLanguage()
						.toUpperCase());
				txtClassif.setText(mapMovieData.get(recebido).getAgeRate()
						.toString());
				txtDimensao.setText(mapMovieData.get(recebido).getDimension());
				
				if(mapMovieData.get(recebido).getDuration().hh().toString().length()==1)
					txtHoras.setText("0"+mapMovieData.get(recebido).getDuration().hh().toString());
				else txtHoras.setText(mapMovieData.get(recebido).getDuration().hh().toString());
				
				if(mapMovieData.get(recebido).getDuration().mm().toString().length()==1)
					txtMinuto.setText("0"+mapMovieData.get(recebido).getDuration().mm().toString());
				else txtHoras.setText(mapMovieData.get(recebido).getDuration().mm().toString());
			}
		});

		// LISTA OS DADOS DO FILME NO PAINEL DIREITO
		int dist = 26;
		group = new ButtonGroup();
		for (Integer movieNow : mapMovieData.keySet()) {
			JRadioButton b = new JRadioButton(mapMovieData.get(movieNow)
					.getName().toUpperCase());
			b.setActionCommand(mapMovieData.get(movieNow).getIdMovie()
					.toString()); // ide salvo em string
			b.setBounds(6, dist, 109, 23);
			group.add(b);
			DisplayMovie.add(b);
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
