package Controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadCarro extends Thread {
	private JLabel lblCarro1;
	private JButton btnCorrer;
	private JLabel lbl1;
	private JLabel lbl2;

	public ThreadCarro(JLabel lblCarro1, JButton btnCorrer, JLabel lbl1, JLabel lbl2) {
		this.lblCarro1 = lblCarro1;
		this.btnCorrer = btnCorrer;
		this.lbl1=lbl1;
		this.lbl2=lbl2;
		// TODO Auto-generated constructor stub
	}
	public void run() {
		correr();
	}

	private void correr() {
		Random r = new Random();
		int num = r.nextInt(5)+10;
		lbl1.setText("");
		lbl2.setText("");
		btnCorrer.setEnabled(false);
		Rectangle posicao;
		
		posicao = lblCarro1.getBounds();
		posicao.x=25;
		lblCarro1.setBounds(posicao);
		while (posicao.x<=500) {
			posicao.x = posicao.x + num;
			lblCarro1.setBounds(posicao);
			try {
				Thread.sleep(30);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		if(lbl1.getText().equals("")) {
			lbl1.setText(lblCarro1.getText());
		}else {
			lbl2.setText(lblCarro1.getText());
		}
		btnCorrer.setEnabled(true);
	}
}
