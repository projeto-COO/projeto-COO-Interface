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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import MoviesData.MovieData;
import System.ManageMovie;
@SuppressWarnings({ "serial"})
public class ManagMovieDelete extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	protected static Map<Integer,MovieData> mapMovieData;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public ManagMovieDelete() {
		
		// inicializa o mapMovieData com o arquivo .ser!!!
		try {
			FileInputStream fluxoMovieIn = new FileInputStream("fileMovie.ser");
			ObjectInputStream fMovieIn = new ObjectInputStream(fluxoMovieIn);
			mapMovieData = (TreeMap<Integer, MovieData>)fMovieIn.readObject();
			fMovieIn.close();
			fluxoMovieIn.close();
		} catch (IOException io) {	} catch (ClassNotFoundException classNotFound) { 	}
		//
		setTitle("GERENCIAMENTO - FILMES - EXCLUIR");
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
		
		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.setBounds(308, 86, 116, 43);
		contentPane.add(btnDeletar);
		
		// CRIA O PAYNEL COM A LISTA DE FILMES NA ESQUERDA.
		final JPanel DisplayMovie = new JPanel();
		DisplayMovie.setBounds(0, 0, 166, 229);
		DisplayMovie.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "FILME"));
		getContentPane().add(DisplayMovie);
		DisplayMovie.setLayout(null);
		contentPane.add(DisplayMovie);
		
		// LISTA OS DADOS DO FILME NO PAINEL DIREITO
		int dist = 26;
		group = new ButtonGroup();
		for (Integer movieNow : mapMovieData.keySet()){
			if(!mapMovieData.get(movieNow).isSold()){
				JRadioButton b = new JRadioButton(mapMovieData.get(movieNow).getName().toUpperCase());
				b.setActionCommand(mapMovieData.get(movieNow).getIdMovie().toString()); // ide salvo em string
				b.setBounds(6, dist, 109, 23);
				group.add(b);
				DisplayMovie.add(b);
				dist = dist + 26;
			}

		}
		
		//deleta o filme selecionado.
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int recebido = Integer.parseInt(group.getSelection().getActionCommand());
				ManageMovie manage = new ManageMovie();
				manage.deleteMovie(recebido);
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
		
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
