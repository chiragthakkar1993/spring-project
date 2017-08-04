package com.digit.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.digit.models.Activity;

public class ActivityDAO {

	public int createActivity(Activity activity) {
		Session session = null;
		Transaction transaction = null;
		int ActivityId = -1;
		List<Activity> listPersistedactivities = new ArrayList<>();
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();

			ActivityId = (Integer) session.save(activity);

			// batch of 50 objects can be processed to save memory
			// if (i % 50 == 0) {
			// session.flush();
			// session.clear();
			// }

			transaction.commit();
		} catch (

		Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return ActivityId;
	}

	public Activity getActivity(long activityId) {
		Session session = null;
		Transaction transaction = null;
		Activity activity = new Activity();
		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			transaction.begin();

			Query query = session.createQuery("From Activity");

			// query.setParameter("actId", activityId);
			activity = (Activity) query.list().get(0);
			Hibernate.initialize(activity.getAdditionalActivitiesList());
			Hibernate.initialize(activity.getReceivedActivities());
			Hibernate.initialize(activity.getStatusActivities());
			System.out.println("activity retrieved  = " + activity);
			session.flush();
			session.clear();

			transaction.commit();
		} catch (

		Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return activity;
	}

}
