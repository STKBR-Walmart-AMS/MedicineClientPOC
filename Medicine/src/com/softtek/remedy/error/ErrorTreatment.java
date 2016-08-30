package com.softtek.remedy.error;



public class ErrorTreatment {



	public ErrorTreatment(Exception e){
		displayMessage(e);
	}
	
	
	
	
	private String displayMessage(Exception e){
		String message = "";
		
		if(e.getMessage().contains("ARException")){
			message = "Erro ao iniciar o sistema de alertas";
		}
		
		
		return message;
	}
}
