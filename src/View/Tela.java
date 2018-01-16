package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import Controller.ThreadCarro;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
public class Tela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setForeground(Color.BLUE);
		lblCarro1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCarro1.setBounds(27, 75, 76, 27);
		contentPane.add(lblCarro1);
		
		JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setForeground(Color.RED);
		lblCarro2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCarro2.setBounds(27, 132, 76, 27);
		contentPane.add(lblCarro2);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setBounds(28, 232, 89, 23);
		contentPane.add(btnCorrer);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 121, 475, 13);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(500, 75, 48, 97);
		contentPane.add(separator_1);
		
		JLabel lblVencedor = new JLabel("VENCEDOR: ");
		lblVencedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVencedor.setBounds(170, 201, 89, 32);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("PERDEDOR:");
		lblPerdedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPerdedor.setBounds(170, 236, 89, 32);
		contentPane.add(lblPerdedor);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl1.setBounds(255, 205, 76, 25);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl2.setBounds(255, 240, 76, 25);
		contentPane.add(lbl2);
		
		ActionListener correr = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Thread c = new ThreadCarro(lblCarro1, btnCorrer, lbl1, lbl2);
				c.start();
				Thread c2 = new ThreadCarro(lblCarro2, btnCorrer, lbl1, lbl2);
				c2.start();
			}
		};
		btnCorrer.addActionListener(correr);
	}
}
