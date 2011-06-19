package GraphicInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ManagSessionDelete extends JFrame {

	private JPanel contentPane;
	private JLabel lblExcluir, lblSelecione;
	private JComboBox comboboxSelecione;
	private JButton btnVoltar, btnExcluir;

	/**
	 * Create the frame.
	 */
	public ManagSessionDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblExcluir = new JLabel("Excluír Sessões");
		lblExcluir.setBounds(0,0,100,20);
		contentPane.add(lblExcluir);
		
		lblSelecione = new JLabel("Selecione a sessão abaixo:");
		lblSelecione.setBounds(100, 50, 300, 20);
		contentPane.add(lblSelecione);
		
		comboboxSelecione = new JComboBox();
		comboboxSelecione.addItem("exemplo1");
		comboboxSelecione.addItem("exemplo2");
		comboboxSelecione.addItem("exemplo3");
		comboboxSelecione.setBounds(100, 100, 300, 20);
		contentPane.add(comboboxSelecione);
		
		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(333, 208, 91, 43);
		contentPane.add(btnExcluir);
		btnVoltar = new JButton("VOLTAR");
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
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			// IMPLEMENTAR AQUI O CÓDIGO PARA EXCLUIR A SESSÃO;
				
			JOptionPane alerta = new JOptionPane();
			alerta.showMessageDialog(contentPane, "Sessão excluída com sucesso!");
				
			ManagMovieEditInfo info = new ManagMovieEditInfo();
			info.setVisible(true);
			setVisible(false);
			}
		});
	}

}