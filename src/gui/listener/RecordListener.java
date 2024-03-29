package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel1;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		RecordPanel p = RecordPanel.instance;
		if(0 == p.cbModel.cs.size()) {
			JOptionPane.showMessageDialog(p,"Please add Category First!!!");
			MainPanel1.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}
		
		if(!GUIUtil.checkZero(p.tfSpend, "Cost"))
			return;
		int spend = Integer.parseInt(p.tfSpend.getText());
		Category c = p.getSelectedCategory();
		String comment = p.tfComment.getText();
		Date d = p.datepick.getDate();
		new RecordService().add(spend,c,comment,d);
		JOptionPane.showMessageDialog(p, "Add successfully");
		
		MainPanel1.instance.workingPanel.show(SpendPanel.instance);
		
	}
	
}
