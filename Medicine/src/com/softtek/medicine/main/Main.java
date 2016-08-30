package com.softtek.medicine.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;

import com.bmc.arsys.api.Entry;
import com.google.gson.Gson;
import com.softtek.medicine.util.MedicineUtil;

public class Main {

	public static void main(String[] args) {

		// if(args.length == 0){
		// throw new
		// RuntimeException("Provide user, pass and mail as startup!");
		// }else{
		String user = "";
		String pass = "";
		String mail = "";

		try {
			System.out.print("User : ");
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					System.in));
			user = bf.readLine();
			System.out.print("Password : ");
			pass = bf.readLine();
			System.out.print("e-mail : ");
			mail = bf.readLine();

			System.out.println("Doctor sugest remedy Start");
			String smtpHostServer = "smtp-gw1.homeoffice.wal-mart.com";
			Properties props = System.getProperties();
			props.put("mail.smtp.host", smtpHostServer);
			Session session = Session.getInstance(props, null);

			List<Entry> lst = new MedicineUtil().sendData(user, pass);

			Gson gson = new Gson();

			// 2. Java object to JSON, and assign to a String
			String jsonInString = gson.toJson(lst);

			MedicineUtil.sendEmail(session, mail,
					"SimpleEmail Testing Subject", jsonInString);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
