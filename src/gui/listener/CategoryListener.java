package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		CategoryPanel p = CategoryPanel.instance;
		
		JButton b = (JButton) e.getSource();
		
		if(b ==p.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			if(0 == name.length()) {
				JOptionPane.showMessageDialog(p, "Category name can not be null!");
				return;
			}
			new CategoryService().add(name);
		}
		if (b == p.bEdit) {
            Category c = p.getSelectedCategory();
            int id = c.id;
            String name = JOptionPane.showInputDialog("Edit Category Name", c.name);
            if (0 == name.length()) {
                JOptionPane.showMessageDialog(p, "Category name can not be null!");
                return;
            }
 
            new CategoryService().update(id, name);
        }
		
		 if (b == p.bDelete) {
	            Category c = p.getSelectedCategory();
	            if (0 != c.recordNumber) {
	                JOptionPane.showMessageDialog(p, "Something inside, cannot delete yet");
	                return;
	            }
	            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "Are you sure to delete it ?"))
	                return;
	 
	            int id = c.id;
	            new CategoryService().delete(id);
	        }
	        p.updateData();
	    
		
	}

}
