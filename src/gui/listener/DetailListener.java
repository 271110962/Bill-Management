package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import entity.Record;
import gui.panel.DetailPanel;
import service.CategoryService;
import service.RecordService;

public class DetailListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		DetailPanel d = DetailPanel.instance;
		
		JButton b = (JButton)e.getSource();
		
		if (b == d.bEdit) {
            Record c = d.getSelectedRecord();
            int id = c.id;
            String sp = JOptionPane.showInputDialog("Edit Cost", c.spend);
            if (0 == sp.length()) {
                JOptionPane.showMessageDialog(d, "Cost can not be null!");
                return;
            }
 
            new RecordService().update(id, sp);
        }
		
		 if (b == d.bDelete) {
			 	List<Record> rs = new RecordService().list();
	            Record r = d.getSelectedRecord();
	            if (0 == rs.size()) {
	                JOptionPane.showMessageDialog(d, "It is null!!");
	                return;
	            }
	            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(d, "Are you sure to delete it ?"))
	                return;
	 
	            int id = r.id;
	            new RecordService().delete(id);
	        }
	        d.updateData();
		
		
	}

}
