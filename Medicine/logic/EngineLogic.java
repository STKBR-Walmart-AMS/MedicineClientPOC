
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

import remedy.RemedySearch;
import remedy.Ticket;

import com.bmc.arsys.api.ARException;
import com.bmc.arsys.api.ARServerUser;

import error.ErrorTreatment;

public class EngineLogic {
	
	private String user;
	private String pass;
	private String mail;
	private ARServerUser ctx;
	
	final Integer TIME_SLA_ACKNOWLEDGE_LOW = 16;
	final Integer TIME_SLA_ACKNOWLEDGE_MED = 8;
	final Integer TIME_SLA_ACKNOWLEDGE_HI = 4;
	final Integer TIME_SLA_ACKNOWLEDGE_CRIT = 1;
	
	final Integer TIME_SLA_RESOLUTION_LOW = 40;
	final Integer TIME_SLA_RESOLUTION_MED = 24;
	final Integer TIME_SLA_RESOLUTION_HI = 8;
	final Integer TIME_SLA_RESOLUTION_CRIT = 4;

	public EngineLogic(String user, String pass, String mail){
		this.user = user;
		this.pass = pass;
		this.mail = mail;
		
		 
		
		this.ctx = this.login(this.user, this.pass);
		this.searchSlaEngine(this.mail, ctx);
		
		
	}
	
	private ARServerUser login(String user, String pass){
		
		ARServerUser ctx = new ARServerUser();
		ctx.setServer("BSMReports");
		ctx.setPort(24341);
		ctx.setUser(user);
		ctx.setPassword(pass);
		
		try {
			ctx.verifyUser();
			return ctx;
		} catch (ARException e) {
			JOptionPane.showMessageDialog(null, new ErrorTreatment(e));
		}
		return ctx;
		
	}
	
	
	
	private void searchSlaEngine(String mail, ARServerUser ctx){
		
		List<Ticket> listOfTickets = new RemedySearch(ctx).searchTickets();
		final Date dateTimeCurrent = Calendar.getInstance().getTime();
		
		for(Ticket t : listOfTickets){
			switch(Integer.parseInt(t.getPriority())){
			case 0: 
				this.setDateTimeSlaAcknowledge(t, TIME_SLA_ACKNOWLEDGE_LOW);
				this.setDateTimeSlaResolution(t, TIME_SLA_RESOLUTION_LOW);
				break;
			case 1: 
				this.setDateTimeSlaAcknowledge(t, TIME_SLA_ACKNOWLEDGE_MED);
				this.setDateTimeSlaResolution(t, TIME_SLA_RESOLUTION_MED);
				break;
			case 2: 
				this.setDateTimeSlaAcknowledge(t, TIME_SLA_ACKNOWLEDGE_HI);
				this.setDateTimeSlaResolution(t, TIME_SLA_RESOLUTION_HI);
				break;
			case 3: 
				this.setDateTimeSlaAcknowledge(t, TIME_SLA_ACKNOWLEDGE_CRIT);
				this.setDateTimeSlaResolution(t, TIME_SLA_RESOLUTION_CRIT);
				break;
			}
		}
		this.print(listOfTickets);
		this.issueWarning(listOfTickets, dateTimeCurrent);
		
	}
	
	private void print(List<Ticket> lt){
		for(Ticket t : lt){
			if((t.getResolutionSla() - Calendar.getInstance().getTimeInMillis() < 0) && (!t.getStatus().equalsIgnoreCase("5"))){
			System.out.println(t.getIncidentId() + ", " 
					+ t.getPriority() + ", " 
					+ t.getStatus() + ", " 
					+ t.getCreateDate() + ", "
					+ new Date(t.getAcknowledgeSla()) + ", "
					+ new Date(t.getResolutionSla()));
			}
		}
	}
	
	
	
	private void setDateTimeSlaAcknowledge(Ticket t, int timeInHours){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setLenient(true);
		gc.setTime(t.getCreateDate());
		gc.set(Calendar.HOUR_OF_DAY, gc.get(Calendar.HOUR_OF_DAY) + timeInHours);
		t.setAcknowledgeSla(gc.getTimeInMillis());
	}
	
	private void setDateTimeSlaResolution(Ticket t, int timeInHours){
		GregorianCalendar gc = new GregorianCalendar();
		gc.setLenient(true);
		gc.setTime(t.getCreateDate());
		gc.set(Calendar.HOUR_OF_DAY, gc.get(Calendar.HOUR_OF_DAY) + timeInHours);
		t.setResolutionSla(gc.getTimeInMillis());
	}
	
	private void issueWarning(List<Ticket> lt, Date currentDateTime){
		StringBuilder sb = new StringBuilder();
		Integer counter = 0;
		List<String> incidentsId = new ArrayList<String>();
		sb.append("Os seguintes Chamados requerem sua atenção: \n");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(currentDateTime);
		Long currentTimeMillis = gc.getTimeInMillis();
		for(Ticket t : lt){
			if((t.getResolutionSla() - currentTimeMillis < 0) && (!t.getStatus().equalsIgnoreCase("5"))){
				incidentsId.add(t.getIncidentId());
			}
		}
		for(int i = 0; i < incidentsId.size(); i++){
			sb.append(incidentsId.get(i));
			if(counter < 8){
				counter++;
				sb.append(", ");
			}else{
				counter = 0;
				sb.append("\n");
			}
		}
		sb.append("\n Motivo: os prazos de resolução estão estourados");
		
		JOptionPane.showMessageDialog(null, sb.toString());
		
		
	}
}
