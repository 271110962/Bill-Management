import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class HutuMainFrame {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500,450);
		f.setTitle("Financial Book");
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar tb = new JToolBar();
		JButton bSpend = new JButton("Consumption Summary");
		JButton bRecord = new JButton("Consumption Input");
		JButton bCategory = new JButton("Consumption Classification");
		JButton bReport = new JButton("Monthly Consumption Report");
		JButton bConfig = new JButton("Setting");
		JButton bBackup = new JButton("Backup");
		JButton bRecover = new JButton("Recover");
		
		tb.add(bSpend);
		tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        f.setLayout(new BorderLayout());
        f.add(tb,BorderLayout.NORTH);
        f.add(new JPanel(),BorderLayout.CENTER);
        f.setVisible(true);
        
        
        bSpend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
        	
        });
        
        bRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
        	
        });
        
        bCategory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
        	
        });
        
        bConfig.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
        	
        });
        
        bBackup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
        	
        });
        
        bRecover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
        	
        });
	}
}
