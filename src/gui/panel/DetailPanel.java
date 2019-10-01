package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Category;
import entity.Record;
import gui.listener.CategoryListener;
import gui.listener.DetailListener;
import gui.model.DetailTableModel;
import service.CategoryService;
import service.RecordService;
import util.ColorUtil;
import util.GUIUtil;

public class DetailPanel extends WorkingPanel{
	
	static {
		GUIUtil.useLNF();
	}
	
	public static DetailPanel instance = new DetailPanel(); 
    public JButton bEdit = new JButton("Edit");
    public JButton bDelete = new JButton("Delete");
    
    String columNames[] = new String[]{"Category Name","Consumption Times","Consumption Comment","Cost"};
    
    public DetailTableModel dtm = new DetailTableModel();
    public JTable t = new JTable(dtm);
    
    public DetailPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bEdit,bDelete);
        JScrollPane sp =new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
         
        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);
        
        addListener();
    }
    
    
    public Record getSelectedRecord() {
        int index = t.getSelectedRow();
        return dtm.rs.get(index);
    }
    
    
    public static void main(String[] args) {
        GUIUtil.showPanel(DetailPanel.instance);
    }


	@Override
	public void updateData() {
		dtm.rs = new RecordService().list();
    	
    	t.updateUI();
    	t.getSelectionModel().addSelectionInterval(0, 0);
    	
    	if(0 == dtm.rs.size()) {
    		bEdit.setEnabled(false);
            bDelete.setEnabled(false);
    	}
    	else {
    		bEdit.setEnabled(true);
            bDelete.setEnabled(true);
    	}
		
	}


	@Override
	public void addListener() {
		DetailListener listener = new DetailListener();
        bEdit.addActionListener(listener);
        bDelete.addActionListener(listener);
		
	}

}
