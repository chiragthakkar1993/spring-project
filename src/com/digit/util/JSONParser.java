package com.digit.util;

/*
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.Reader;
	import java.sql.Timestamp;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Map;

	import org.apache.tomcat.util.http.fileupload.FileUtils;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.query.Query;

	import com.google.gson.Gson;
	import com.google.gson.JsonElement;

		public class JSONParser {

		public static Session session, session1, session2;
		public static Transaction t, t1, t2;

		public static String getEncryption(long activity_id) {
			try {
				String str = DigitEncryption.encryptText(Long.toString(activity_id));
				return str;
			} catch (Exception e) {

				e.printStackTrace();
			}

			return null;

		}

		public List<MobileData> getData(String fileLocation) {
			Configuration cfg = new Configuration();
			cfg.configure("com/digit/config/digit.cfg.xml");
			String csvFile = fileLocation;
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = "\\|";
			String[] filedata = null;
			List<MobileData> mobiledata = new LinkedList<>();
			try {

				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
					if (line != null) {
						filedata = line.split(cvsSplitBy);
						MobileData mob = new MobileData();
						mob.setPolicy_number(filedata[0]);
						mob.setClaim_number(filedata[1]);
						mob.setFnol_lossData(Timestamp.valueOf(filedata[2]));
						mob.setFnol_createdDate(Timestamp.valueOf(filedata[3]));
						mob.setFirst_name(filedata[4]);
						mob.setLast_name(filedata[5]);
						mob.setEmail(filedata[6]);
						mob.setMobile(filedata[7]);
						mob.setAlternative_mobile(filedata[8]);
						mob.setMobile_imei(filedata[9]);
						mob.setMake_model(filedata[10]);
						mobiledata.add(mob);
					}

				}

			} catch (Exception e) {
				System.out.println("error while fetching policy data");
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return mobiledata;

		}

		public static List<MobileData> filterData(List<MobileData> currentData, List<MobileData> previousData) {
			List<MobileData> temp = new ArrayList<>();
			for (int i = 0; i < currentData.size(); i++) {
				for (int j = 0; j < previousData.size(); j++) {
					if (previousData.get(j).getPolicy_number().equals(currentData.get(i).getPolicy_number()))
						temp.add(currentData.get(i));
				}
			}
			currentData.removeAll(temp);
			return currentData;
		}

		public List<MobileData> createActivity(List<MobileData> list) {
			for (MobileData info : list) {
				info.setActivityId(5345454L);
			}
			return list;
		}
		

		public static void main(String[] args) throws IOException {
			try {
				Configuration cfg = new Configuration();
				cfg.configure("com/digit/config/digit.cfg.xml");
				String csvFile = "mobile.csv";
				MainActivity activity = new MainActivity();
				// read data from csv file
				List<MobileData> currentData = activity.getData(csvFile);

				// fetch previous record.
				session = cfg.buildSessionFactory().openSession();
				t = session.beginTransaction();
				Query query = session.createQuery("from MobileData");
				List<MobileData> previousData = query.list();
				t.commit();
				session.clear();
				session.close();

				// delete previous data
				session1 = cfg.buildSessionFactory().openSession();
				t1 = session1.beginTransaction();
				Query query1 = session1.createQuery("delete from MobileData");
				query1.executeUpdate();
				t1.commit();
				session1.clear();
				session1.close();

				// insert new data
				session2 = cfg.buildSessionFactory().openSession();
				t2 = session2.beginTransaction();
				// filter already inserted data
				currentData = filterData(currentData, previousData);
				activity.createActivity(currentData);
				for (int i = 0; i < currentData.size(); i++) {
					session2.saveOrUpdate(currentData.get(i));
				}
				t2.commit();
				session2.clear();
				session2.close();
				
				
				
				//create json object in map with key-value pair for newly insert data.
				List<MobileData> list=activity.createActivity(currentData);
				Map<Integer,String> map=new HashMap<>();
				String json = "";
				int key=1;
				for(MobileData d:list)
				{
					Gson gson = new Gson();
					 json= gson.toJson(d);
				
					if(json!=null)
					{
						map.put(key, json);
						key++;
					}
					
					System.out.println(json);
				
				}
				
				Gson gson = new Gson();

		        try (Reader reader = new FileReader("D:\\mobiledata.json")) {

					// Convert JSON to Java Object
		        	MobileData mobiledata = gson.fromJson(reader, MobileData.class);
		            System.out.println("JSON to java object: "+mobiledata.getEmail());

					// Convert JSON to JsonElement, and later to String
		            JsonElement json = gson.fromJson(reader, JsonElement.class);
		            String jsonInString = gson.toJson(json);
		            System.out.println(jsonInString);

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			
				PrintWriter out = new PrintWriter( "filename.txt"));
				FileWriter f=new FileWriter(new File("D:\\text.json"));
				System.out.println(json);
				f.write(json);
				
				System.out.println(map);
				
				
				//json
				try{
					Reader read=new FileReader("D:\\text.json");
					Gson gson = new Gson();
					MobileData mob=gson.fromJson(read, MobileData.class);
					System.out.println("nbasvmvdjhb         "+mob);
				}
				catch(Exception e){
					e.printStackTrace();
					}
				
				
				
				// activities generation
				//currentData = activity.createActivity(currentData);
				//System.out.println(currentData);
				
				// MailProcess process=new MailProcess();
				// process.sendMails(currentData);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}

		}

	}

*/