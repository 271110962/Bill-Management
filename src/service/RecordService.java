package service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import dao.RecordDAO;
import entity.Category;
import entity.Record;

public class RecordService {
	RecordDAO recordDao = new RecordDAO();

	public void add(int spend, Category c, String comment,Date date) {
		Record r = new Record();
		r.spend = spend;
		r.cid = c.id;
		r.comment =comment;
		r.date = date;
		recordDao.add(r);
	}
	public List<Record> list(){
		List <Record> rs = recordDao.list();
		return rs;
	}
	
	public void update(int id, String spend) {
		Record c = new Record();
		int sp = Integer.parseInt(spend);
		c.setId(id);
		c.setSpend(sp);
		recordDao.update1(c);
	}
	public void delete(int id) {
		recordDao.delete(id);
		
	}
}
