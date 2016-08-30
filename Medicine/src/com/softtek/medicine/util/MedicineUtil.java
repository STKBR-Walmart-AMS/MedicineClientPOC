package com.softtek.medicine.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import com.bmc.arsys.api.ARException;
import com.bmc.arsys.api.ARServerUser;
import com.bmc.arsys.api.ArithmeticOrRelationalOperand;
import com.bmc.arsys.api.Constants;
import com.bmc.arsys.api.Entry;
import com.bmc.arsys.api.Field;
import com.bmc.arsys.api.IQuerySource;
import com.bmc.arsys.api.OutputInteger;
import com.bmc.arsys.api.QualifierInfo;
import com.bmc.arsys.api.QuerySourceForm;
import com.bmc.arsys.api.QuerySourceValues;
import com.bmc.arsys.api.RegularQuery;
import com.bmc.arsys.api.RelationalOperationInfo;
import com.bmc.arsys.api.SortInfo;
import com.bmc.arsys.api.StatusInfo;
import com.bmc.arsys.api.Timestamp;
import com.bmc.arsys.api.Value;
import com.softtek.medicine.model.Incident;
import com.softtek.remedy.error.ErrorTreatment;

public class MedicineUtil {
	private String user;
	private String pass;
	private ARServerUser ctx;
	private String formName = "HPD:Help Desk";
	private String groupName = "BRL - Maintenance Softtek BR HD";
	private String submitDate = "7/1/2016 12:00:00 AM";

	public List<Entry> sendData(String user, String pass) {

		List<Entry> entryList = new ArrayList<Entry>();

		this.user = user;
		this.pass = pass;
		this.ctx = this.login(this.user, this.pass);

		entryList = queryEntrysByQual("( \'Assigned Group\' = \"" + groupName
				+ "\" AND \'Submit Date\' > \"" + submitDate + "\" )");

		this.cleanup();

		return entryList;

	}

	private ARServerUser login(String user, String pass) {
		ARServerUser ctx = new ARServerUser();
		ctx.setServer("BSMReports");
		ctx.setPort(24341);
		ctx.setUser(user);
		ctx.setPassword(pass);

		try {
			ctx.verifyUser();
		} catch (ARException e) {
			JOptionPane.showMessageDialog(null, new ErrorTreatment(e));
		}
		System.out.println("Connected to AR Server " + ctx.getServer());
		return ctx;
	}

	public List<Incident> searchIncidents() {

		List<Incident> trackList = new ArrayList<Incident>();

		QuerySourceForm qsf = new QuerySourceForm(formName);
		RegularQuery rq = new RegularQuery();

		rq.addFromSource(qsf);

		/* mandatory fields */
		rq.addFromField(1000000164, qsf); // priority
		rq.addFromField(1000000163, qsf); // impact
		rq.addFromField(1000000162, qsf); // urgency
		rq.addFromField(1000000161, qsf); // incidentNumber
		rq.addFromField(1000000099, qsf); // serviceType
		rq.addFromField(1000000082, qsf); // contactCompany
		rq.addFromField(1000000063, qsf); // categorizationTier1
		rq.addFromField(1000000064, qsf); // categorizationTier2
		rq.addFromField(1000000056, qsf); // phoneNumber
		rq.addFromField(1000000019, qsf); // firstName
		rq.addFromField(1000000018, qsf); // lastName
		rq.addFromField(1000000000, qsf); // description
		rq.addFromField(200000003, qsf); // ProductCategorizationTier1
		rq.addFromField(200000004, qsf); // ProductCategorizationTier2
		rq.addFromField(200000005, qsf); // productCategorizationTier3
		/* mandatory fields */

		rq.addFromField(1, qsf); // entryId
		rq.addFromField(2, qsf); // submitter
		rq.addFromField(3, qsf); // submitDate
		rq.addFromField(303558600, qsf); // template
		rq.addFromField(5, qsf); // lastModifiedBy
		rq.addFromField(6, qsf); // lastModifiedDate
		rq.addFromField(7, qsf); // status
		rq.addFromField(300617700, qsf); // createdBy
		rq.addFromField(303530000, qsf); // customer
		rq.addFromField(1000000001, qsf); // company
		rq.addFromField(1000000017, qsf); // fullName

		ArithmeticOrRelationalOperand aoro = new ArithmeticOrRelationalOperand(
				1000000217, qsf); // assignement group
		ArithmeticOrRelationalOperand aoroVal = new ArithmeticOrRelationalOperand(
				new Value(groupName));

		RelationalOperationInfo roi = new RelationalOperationInfo(
				RelationalOperationInfo.AR_REL_OP_EQUAL, aoro, aoroVal);

		QualifierInfo qi = new QualifierInfo(roi);

		rq.setQualifier(qi);

		try {
			this.ctx.setTimeoutLong(999);
			List<QuerySourceValues> listQsv = this.ctx.getListEntryObjects(rq,
					0, 0, false, null);

			for (QuerySourceValues qsv : listQsv) {
				Iterator<java.util.Map.Entry<IQuerySource, Map<Integer, Value>>> i = qsv
						.entrySet().iterator();
				while (i.hasNext()) {
					Map<Integer, Value> qsvM = i.next().getValue();
					Incident inc = new Incident();

					inc.setPriority(Integer.parseInt(qsvM.get(1000000164)
							.toString()));
					inc.setImpact(Integer.parseInt(qsvM.get(1000000163)
							.toString()));
					inc.setUrgency(Integer.parseInt(qsvM.get(1000000162)
							.toString()));
					inc.setServiceType(Integer.parseInt(qsvM.get(1000000099)
							.toString()));
					inc.setStatus(Integer.parseInt(qsvM.get(7).toString()));

					inc.setEntryId(qsvM.get(1).toString());
					inc.setSubmitter(qsvM.get(2).toString());
					inc.setIncidentNumber(qsvM.get(1000000161).toString());
					inc.setContactCompany(qsvM.get(1000000082).toString());
					inc.setCategorizationTier1(qsvM.get(1000000063).toString());
					inc.setCategorizationTier2(qsvM.get(1000000064).toString());
					inc.setPhoneNumber(qsvM.get(1000000056).toString());
					inc.setFirstName(qsvM.get(1000000019).toString());
					inc.setLastName(qsvM.get(1000000018).toString());
					inc.setDescription(qsvM.get(1000000000).toString());
					inc.setProductCategorizationTier1(qsvM.get(200000003)
							.toString());
					inc.setProductCategorizationTier2(qsvM.get(200000004)
							.toString());
					inc.setProductCategorizationTier3(qsvM.get(200000005)
							.toString());
					inc.setLastModifiedBy(qsvM.get(5).toString());
					inc.setCreatedBy(qsvM.get(300617700).toString());
					inc.setCustomer(qsvM.get(303530000).toString());
					inc.setCompany(qsvM.get(1000000001).toString());
					inc.setFullName(qsvM.get(1000000017).toString());

					inc.setSubmitDate(new Timestamp(Long.parseLong(qsvM
							.get(3)
							.getValue()
							.toString()
							.substring(
									11,
									qsvM.get(3).getValue().toString()
											.indexOf(']')))).toDate());
					inc.setLastModifiedDate(new Timestamp(Long.parseLong(qsvM
							.get(6)
							.getValue()
							.toString()
							.substring(
									11,
									qsvM.get(6).getValue().toString()
											.indexOf(']')))).toDate());

					trackList.add(inc);

					System.out.println(qsvM.get(1000000161).toString());
				}
			}

		} catch (ARException arex) {
			arex.printStackTrace();
		} finally {
			this.ctx.logout();
		}

		return trackList;

	}

	@SuppressWarnings("unused")
	public List<Entry> queryEntrysByQual(String qualStr) {
		List<Entry> entryList = new ArrayList<Entry>();
		List<Incident> incidentList = new ArrayList<Incident>();

		// List<Incident> trackList = new ArrayList<Incident>();
		// List<Entry> entryList = new ArrayList<Entry>();
		System.out.println();
		System.out.println("Retrieving entryies with qualification " + qualStr);
		try {
			// Retrieve the detail info of all fields from the form.
			List<Field> fields = ctx.getListFieldObjects(formName);
			// Create the search qualifier.
			QualifierInfo qual = ctx.parseQualification(qualStr, fields, null,
					Constants.AR_QUALCONTEXT_DEFAULT);

			int[] fieldIds = { 1000000164, // priority
					1000000163, // impact
					1000000162, // urgency
					1000000161, // incidentNumber
					1000000099, // serviceType
					1000000082, // contactCompany
					1000000063, // categorizationTier1
					1000000064, // categorizationTier2
					1000000056, // phoneNumber
					1000000019, // firstName
					1000000018, // lastName
					1000000000, // description
					200000003, // ProductCategorizationTier1
					200000004, // ProductCategorizationTier2
					200000005, // productCategorizationTier3
					1, // entryId
					2, // submitter
					3, // submitDate
					5, // lastModifiedBy
					6, // lastModifiedDate
					7, // status
					1000000001 // company
			};

			OutputInteger nMatches = new OutputInteger();
			List<SortInfo> sortOrder = new ArrayList<SortInfo>();
			sortOrder.add(new SortInfo(2, Constants.AR_SORT_DESCENDING));
			// Retrieve entries from the form using the given
			// qualification.
			entryList = ctx.getListEntryObjects(formName, qual, 0,
					Constants.AR_NO_MAX_LIST_RETRIEVE, sortOrder, fieldIds,
					true, nMatches);

			List<Incident> lstIncident = new ArrayList<Incident>();

			for (Entry lst : entryList) {
				if (!lst.values().isEmpty()) {

					Incident incident = new Incident();

					Iterator<Value> it = lst.values().iterator();

				//	@SuppressWarnings("unchecked")
				//	Map<Integer, Value> qsvM = (Map<Integer, Value>) it.next()
				//			.getValue();

					System.out.println(lst.values());

					Object[] list = lst.values().toArray();

					System.out.println(list[4]);

					/* mandatory fields */
					incident.setEntryId(list[0]==null?null: list[0].toString()); // 1
					/* mandatory fields */
					incident.setPriority(list[1]==null?null: Integer.parseInt(list[1].toString())); // 1000000164
					incident.setImpact(list[2]==null?null: Integer.parseInt(list[2].toString())); // 1000000163
					incident.setUrgency(list[3]==null?null: Integer.parseInt(list[3].toString())); // 1000000162
					incident.setIncidentNumber(list[4]==null?null: list[4].toString()); // 1000000161
					incident.setServiceType(list[5]==null?null: Integer.parseInt(list[5].toString())); // 1000000099
					incident.setContactCompany(list[6]==null?null: list[6].toString()); // 1000000082
					incident.setCategorizationTier1(list[7]==null?null: list[7].toString()); // 1000000063
					incident.setCategorizationTier2(list[8]==null?null: list[8].toString()); // 1000000064
					incident.setPhoneNumber(list[9]==null?null: list[9].toString()); // 1000000056
					incident.setFirstName(list[10]==null?null: list[10].toString()); // 1000000019
					incident.setLastName(list[11]==null?null: list[11].toString()); // 1000000018
					incident.setDescription(list[12]==null?null: list[12].toString()); // 1000000000
					incident.setProductCategorizationTier1(list[13]==null?null: list[13].toString()); // 200000003
					incident.setProductCategorizationTier2(list[14]==null?null: list[14].toString()); // 200000004
					incident.setProductCategorizationTier3(list[15]==null?null: list[15].toString()); // 200000005
					/* mandatory fields */
					incident.setSubmitter(list[16]==null?null: list[16].toString()); // 2
					// TODO VERIFICAR
				//	incident.setSubmitDate(list[17]==null?null: new Date(Long.parseLong(list[17].toString()))); // 3

					incident.setLastModifiedBy(list[18]==null?null: list[18].toString()); // 5
					// TODO VERIFICAR
				//	incident.setLastModifiedDate(list[19]==null?null: new Date(Long.parseLong(list[19].toString()))); // 6
					incident.setStatus(list[20]==null?null: Integer.parseInt(list[20].toString())); // 7
					incident.setCompany(list[21]==null?null: list[21].toString()); // 1000000001

					// TODO NOT FOUND
					// String setTemplate(list[0].toString()); // 303558600
					// TODO NOT FOUND
					// String setCreatedBy(list[0].toString()); // 300617700
					// TODO NOT FOUND
					// incident.setCustomer(list[0].toString()); // 303530000
					// TODO NOT FOUND
					// incident.setFullName(list[0].toString()); // 1000000017

					lstIncident.add(incident);

				}
			}

			System.out.println("Query returned " + nMatches + " matches.");
		} catch (ARException e) {
			ARExceptionHandler(e, "Problem while querying by qualifier. ");
		}

		return entryList;

	}

	public static void sendEmail(Session session, String toEmail,
			String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@walmart.com",
					"NoReply-Medicine"));

			msg.setReplyTo(InternetAddress.parse("no_reply@walmart.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			Transport.send(msg);

			System.out.println("Remedy Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cleanup() {
		// Logout the user from the server. This releases the resource
		// allocated on the server for the user.
		ctx.logout();
		System.out.println();
		System.out.println("User logged out.");
	}

	public void ARExceptionHandler(ARException e, String errMessage) {
		System.out.println(errMessage);
		printStatusList(ctx.getLastStatus());
		System.out.print("Stack Trace:");
		e.printStackTrace();
	}

	public void printStatusList(List<StatusInfo> statusList) {
		if (statusList == null || statusList.size() == 0) {
			System.out.println("Status List is empty.");
			return;
		}
		System.out.print("Message type: ");
		switch (statusList.get(0).getMessageType()) {
		case Constants.AR_RETURN_OK:
			System.out.println("Note");
			break;
		case Constants.AR_RETURN_WARNING:
			System.out.println("Warning");
			break;
		case Constants.AR_RETURN_ERROR:
			System.out.println("Error");
			break;
		case Constants.AR_RETURN_FATAL:
			System.out.println("Fatal Error");
			break;
		default:
			System.out.println("Unknown (" + statusList.get(0).getMessageType()
					+ ")");
			break;
		}
		System.out.println("Status List:");
		for (int i = 0; i < statusList.size(); i++) {

			System.out.println(statusList.get(i).getMessageText());

			System.out.println(statusList.get(i).getAppendedText());
		}
	}

}
