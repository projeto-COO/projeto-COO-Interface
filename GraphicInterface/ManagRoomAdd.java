package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Startup.DataHours;
import System.ManageRoom;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ManagRoomAdd extends JFrame {

	private JPanel contentPane;
	private JTextField txtColunas;
	private JTextField txtFileiras;

	/**
	 * Create the frame.
	 */
	public ManagRoomAdd() {
		//createMovie(String nome,String genero,String classif,String dimens,String linguagem, DataHours duracao)
		
		setTitle("GERENCIAMENTO - FILMES - CRIAR");
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
		
		JLabel lblColunas = new JLabel("COLUNAS");
		lblColunas.setHorizontalAlignment(SwingConstants.CENTER);
		lblColunas.setBounds(68, 63, 62, 14);
		contentPane.add(lblColunas);
		
		JLabel lblFileiras = new JLabel("FILEIRAS");
		lblFileiras.setHorizontalAlignment(SwingConstants.CENTER);
		lblFileiras.setBounds(68, 88, 62, 14);
		contentPane.add(lblFileiras);
		
		txtColunas = new JTextField();
		txtColunas.setBounds(140, 60, 86, 20);
		contentPane.add(txtColunas);
		txtColunas.setColumns(10);
		
		txtFileiras = new JTextField();
		txtFileiras.setBounds(140, 85, 86, 20);
		contentPane.add(txtFileiras);
		txtFileiras.setColumns(10);
		
		JButton btnCriar = new JButton("CRIAR");
		
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageRoom manage = new ManageRoom();
				try{
					manage.createRoom(Integer.parseInt(txtFileiras.getText()), Integer.parseInt(txtColunas.getText()));
					cleanMenu();
					JOptionPane.showMessageDialog(new JFrame(), "Sala criada com sucesso.");
				}
				catch(NumberFormatException he){
					JOptionPane.showMessageDialog(new JFrame(), "Valores inadequados para fileira e/ou colunas!");
					
				}}
		});
		btnCriar.setBounds(135, 116, 91, 43);
		contentPane.add(btnCriar);
		
		//VOLTA PARA A JANELA PRINCIPAL		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGraphUserInterf main = new MainGraphUserInterf();
				main.setVisible(true);
				setVisible(false);
			}
		});
	}
	void cleanMenu(){
		txtFileiras.setText("");
		txtColunas.setText("");
	}

}