
package GraphicInterface;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ManagMovieAdd extends JFrame {

	private JPanel contentPane;
	private JButton btnCriar;
	private JLabel lblCriarFilme, lblNome, lblGenero, lblFaixaEtaria, lblDimensao, lblIdioma, lblDuracao;
	private JTextField txtNome, txtGenero, txtFaixaEtaria, txtDimensao, txtIdioma, txtDuracao;
	
	/**
	 * Create the frame.
	 */
	public ManagMovieAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//informação da página
		lblCriarFilme = new JLabel("Criar Filme");
		lblCriarFilme.setBounds(0, 0, 100, 20);
		contentPane.add(lblCriarFilme);
		
		//nome do filme
		lblNome = new JLabel("Digite o nome:");
		lblNome.setBounds(0, 35, 100, 20);
		contentPane.add(lblNome);
		txtNome = new JTextField();
		txtNome.setBounds(200, 35, 200, 20);
		contentPane.add(txtNome);
		
		//genero do filme
		lblGenero = new JLabel("Digite o genero:");
		lblGenero.setBounds(0, 70, 100, 20);
		contentPane.add(lblGenero);
		txtGenero = new JTextField();
		txtGenero.setBounds(200, 70, 200, 20);
		contentPane.add(txtGenero);
		
		//faixa etaria
		lblFaixaEtaria = new JLabel("Digite a faixa etaria:");
		lblFaixaEtaria.setBounds(0, 105, 150, 20);
		contentPane.add(lblFaixaEtaria);
		txtFaixaEtaria = new JTextField();
		txtFaixaEtaria.setBounds(200, 105, 200, 20);
		contentPane.add(txtFaixaEtaria);
		
		//dimensao
		lblDimensao = new JLabel("Digite a dimensão (2D ou 3D):");
		lblDimensao.setBounds(0, 140, 150, 20);
		contentPane.add(lblDimensao);
		txtDimensao = new JTextField();
		txtDimensao.setBounds(200, 140, 200, 20);
		contentPane.add(txtDimensao);
				
		//idioma
		lblIdioma = new JLabel("Digite o idioma:");
		lblIdioma.setBounds(0, 175, 100, 20);
		contentPane.add(lblIdioma);
		txtIdioma = new JTextField();
		txtIdioma.setBounds(200, 175, 200, 20);
		contentPane.add(txtIdioma);
		
		//duracao
		lblDuracao = new JLabel("Digite a duração (hh-mm):");
		lblDuracao.setBounds(0, 210, 100, 20);
		contentPane.add(lblDuracao);
		txtDuracao = new JTextField();
		txtDuracao.setBounds(200, 210, 200, 20);
		contentPane.add(txtDuracao);
		
		//criar
		btnCriar = new JButton("CRIAR");
		btnCriar.setBounds(333, 250, 91, 43);
		contentPane.add(btnCriar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(0, 250, 91, 43);
		contentPane.add(btnVoltar);

		// VOLTA PARA A JANELA PRINCIPAL

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
		
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//IMPLEMENTAR AQUI O CÓDIGO DE ADICIONAR FILME;
				
				JOptionPane alerta = new JOptionPane();
				alerta.showMessageDialog(contentPane, "Filme criado com sucesso!");
				
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
		
		
	}

}
