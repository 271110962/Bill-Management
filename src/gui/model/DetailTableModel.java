package gui.model;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Category;
import entity.Record;
import service.CategoryService;
import service.RecordService;

public class DetailTableModel implements TableModel{
	
	
	String columNames[] = new String[]{"Category Name","Consumption Times","Consumption Comment","Cost"};
	public List<Record> rs = new RecordService().list();
	public CategoryService cs = new CategoryService(); 

	@Override
	public int getRowCount() {
		return rs.size();
	}

	@Override
	public int getColumnCount() {
		return columNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Record r = rs.get(rowIndex);
		if(0 == columnIndex)
			return cs.get(r.cid);
		if(1 == columnIndex)
			return r.date;
		if(2 == columnIndex)
			return r.comment;
		if(3 == columnIndex)
			return r.spend;
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
