package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

public class ReportService {

	
	public int getDaySpend(Date d,List<Record> monthRawData) {
		int daySpend = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = sdf.format(d);
	    for(Record record : monthRawData) {
			String date = sdf.format(record.date);
			
			System.out.println(nowDate +"  11");
			System.out.println(date);
			if(date.equals(nowDate))
				daySpend += record.spend;
		}
		System.out.println("The Total Money: "+daySpend);
		return daySpend;
	}
	

	
	
	
	public List<Record> listThisMonthRecords(){
		RecordDAO dao = new RecordDAO();
		List<Record> monthRawData = dao.listThisMonth();
		List<Record> result = new ArrayList<>();
		Date monthBegin = DateUtil.monthBegin();
		int monthTotalDay = DateUtil.thisMonthTotalDay();
		Calendar c = Calendar.getInstance();
		for(int i = 0; i<monthTotalDay;i++) {
			Record r = new Record();
			c.setTime(monthBegin);
			c.add(Calendar.DATE, i);
			Date eachDayOfThisMonth = c.getTime();
			int daySpend = getDaySpend(eachDayOfThisMonth,monthRawData);
			r.spend = daySpend;
			result.add(r);
			
		}
		return result;
	}
}
