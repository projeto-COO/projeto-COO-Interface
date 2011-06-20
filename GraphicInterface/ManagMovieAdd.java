package GraphicInterface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Startup.DataHours;
import System.ManageMovie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ManagMovieAdd extends JFrame {
	// private void createMovie(String nome,String genero,String classif,String
	// dimens,String linguagem, DataHours duracao)
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtGenero;
	private JTextField txtClassificacao;
	private JTextField txtDimensao;
	private JTextField txtLinguagem;
	private JTextField txtHoras;
	private JTextField txtMinutos;

	/**
	 * Create the frame.
	 */
	public ManagMovieAdd() {
		setTitle("GERENCIAMENTO - FILME - CRIAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(333, 208, 91, 43);
		contentPane.add(btnVoltar);

		JLabel lblNome = new JLabel("NOME");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(39, 48, 87, 14);
		contentPane.add(lblNome);

		JLabel lblGenero = new JLabel("GENERO");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setBounds(39, 73, 87, 14);
		contentPane.add(lblGenero);

		JLabel lblClassificacao = new JLabel("CLASSIFICACAO");
		lblClassificacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClassificacao.setBounds(39, 98, 87, 14);
		contentPane.add(lblClassificacao);

		JLabel lblDimensao = new JLabel("DIMENSAO");
		lblDimensao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDimensao.setBounds(39, 123, 87, 14);
		contentPane.add(lblDimensao);

		JLabel lblLinguagem = new JLabel("LINGUAGEM");
		lblLinguagem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLinguagem.setBounds(39, 148, 87, 14);
		contentPane.add(lblLinguagem);

		JLabel lblDuracao = new JLabel("DURACAO");
		lblDuracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracao.setBounds(39, 173, 87, 14);
		contentPane.add(lblDuracao);

		txtNome = new JTextField();
		txtNome.setBounds(136, 45, 182, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtGenero = new JTextField();
		txtGenero.setBounds(136, 70, 86, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);

		txtClassificacao = new JTextField();
		txtClassificacao.setBounds(136, 95, 86, 20);
		contentPane.add(txtClassificacao);
		txtClassificacao.setColumns(10);

		txtDimensao = new JTextField();
		txtDimensao.setBounds(136, 120, 86, 20);
		contentPane.add(txtDimensao);
		txtDimensao.setColumns(10);

		txtLinguagem = new JTextField();
		txtLinguagem.setBounds(136, 145, 86, 20);
		contentPane.add(txtLinguagem);
		txtLinguagem.setColumns(10);

		txtHoras = new JTextField();
		txtHoras.setBounds(136, 170, 86, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);

		txtMinutos = new JTextField();
		txtMinutos.setBounds(232, 170, 86, 20);
		contentPane.add(txtMinutos);
		txtMinutos.setColumns(10);

		JLabel lblHoras = new JLabel("HORAS");
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoras.setBounds(136, 195, 86, 14);
		contentPane.add(lblHoras);

		JLabel lblMinutos = new JLabel("MINUTOS");
		lblMinutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos.setBounds(232, 195, 87, 14);
		contentPane.add(lblMinutos);

		JButton btnCriar = new JButton("CRIAR");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ManageMovie newMovie = new ManageMovie();

				DataHours duracao = new DataHours(Integer.parseInt(txtHoras
						.getText()), Integer.parseInt(txtMinutos.getText()));
				newMovie.createMovie(txtNome.getText(), txtGenero.getText(),
						txtClassificacao.getText(), txtDimensao.getText(),
						txtLinguagem.getText(), duracao);
                                JOptionPane alerta = new JOptionPane();
				alerta.showMessageDialog(contentPane, "Criado com Sucesso!");
			}
		});
		btnCriar.setBounds(10, 208, 91, 43);
		contentPane.add(btnCriar);

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
