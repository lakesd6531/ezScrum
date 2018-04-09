package useCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.Sprint;

public class CreateSprint {
	private static long sprintId = 0;
	
	public Sprint addSprint(String goal, int interval, int teamSize, String startDate,
			String demoDate, String demoPlace, String dailyTime, String dailyPlace, long productId) {
		sprintId++;
		Calendar calendar = Calendar.getInstance();
		String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
		Sprint sprint = new Sprint(goal, interval, teamSize, startDate, demoDate, productId, createTime);
		Date startTime = null;
		try {
			startTime = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar start = Calendar.getInstance();
		start.setTime(startTime);
		int availableDays = interval * 5; //�@��§����5�Ӥu�@��
		while(availableDays-->0) {
			while(start.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || start.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				//�P�_����A�åB���L����(�D�u�@��)
				start.add(Calendar.DATE, 1);
			}
			start.add(Calendar.DATE, 1); //�[1�Ӥu�@��
		}
		String endDate = new SimpleDateFormat("yyyy-MM-dd").format(start.getTime());
		sprint.setId(sprintId);
		sprint.setEndDate(endDate);
		sprint.setDemoPlace(demoPlace);
		sprint.setDailyTime(dailyTime);
		sprint.setDailyPlace(dailyPlace);
		return sprint;
	}
}
