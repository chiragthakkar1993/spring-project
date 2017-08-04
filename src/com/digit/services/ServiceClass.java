package com.digit.services;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.digit.DAO.ActivityDAO;
import com.digit.DAO.HibernateUtil;
import com.digit.models.Activity;

public class ServiceClass {
	public static void main(String args[]) {

		ActivityDAO activityDao = new ActivityDAO();
//		Activity activitynew=new Activity();
//		activitynew.setActivityID(5);
//		act
//		activityDao.createActivity(activitiesnew)
		Activity activity = activityDao.getActivity(1);
		System.out.println("activity = " + activity);

		ObjectMapper mapper = new ObjectMapper();
		String json2 = "";
		try {
			json2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(activity);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
