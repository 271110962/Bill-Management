package gui.frame;

import javax.swing.JFrame;
import gui.panel.MainPanel1;

public class MainFrame extends JFrame{
	public static MainFrame instance = new MainFrame();
	
	private MainFrame() {
		this.setSize(800,450);
		this.setTitle("Financial Book");
        this.setContentPane(MainPanel1.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
        instance.setVisible(true);
    }
}
