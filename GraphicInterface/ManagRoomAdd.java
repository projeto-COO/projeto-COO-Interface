package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ManagRoomAdd extends JFrame {

	private JPanel contentPane;
	private JLabel lblCriar, lblFileiras, lblColunas;
	private JButton btnCriar;
	private JTextField txtFileiras, txtColunas;

	/**
	 * Create the frame.
	 */
	public ManagRoomAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//informação da página
		lblCriar = new JLabel("Criar Filme");
		lblCriar.setBounds(0, 0, 100, 20);
		contentPane.add(lblCriar);
		
		lblFileiras = new JLabel("Digite a quantidade de fileiras:");
		lblFileiras.setBounds(0, 35, 200, 20);
		contentPane.add(lblFileiras);
		txtFileiras = new JTextField();
		txtFileiras.setBounds(210, 35, 20, 20);
		contentPane.add(txtFileiras);
		

		lblColunas = new JLabel("Digite a quantidade de colunas:");
		lblColunas.setBounds(0, 70, 200, 20);
		contentPane.add(lblColunas);
		txtColunas = new JTextField();
		txtColunas.setBounds(210, 70, 20, 20);
		contentPane.add(txtColunas);
		
		
		btnCriar = new JButton("CRIAR");
		btnCriar.setBounds(333, 208, 91, 43);
		contentPane.add(btnCriar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(0, 208, 91, 43);
		contentPane.add(btnVoltar);
		
		//VOLTA PARA A JANELA PRINCIPAL
		
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
				alerta.showMessageDialog(contentPane, "Sala criada com sucesso!");
				
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
	}

}