import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class test extends JFrame {
	public test(){
		setLayout(new FlowLayout());
		for(int i=1;i<=20;i++){
			add(new JButton(String.valueOf(i)));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test f = new test();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setPreferredSize(new Dimension(500, 500));
		f.pack();
	}

}
