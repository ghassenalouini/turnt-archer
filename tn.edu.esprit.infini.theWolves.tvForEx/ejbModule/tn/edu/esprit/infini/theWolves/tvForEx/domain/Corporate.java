package tn.edu.esprit.infini.theWolves.tvForEx.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import tn.edu.esprit.infini.theWolves.tvForEx.domain.Customer;

/**
 * Entity implementation class for Entity: Corporate
 *
 */
@Entity

public class Corporate extends Customer implements Serializable {

	
	private String typeActivity;
	private static final long serialVersionUID = 1L;

	public Corporate() {
		super();
	} 
	public Corporate(String name, String login, String password, int phone_number, String adresse_mail, String typeActivity) {
		super(name, login, password, phone_number, adresse_mail);
		this.typeActivity=typeActivity;
	} 
	
	public String getTypeActivity() {
		return this.typeActivity;
	}

	public void setTypeActivity(String typeActivity) {
		this.typeActivity = typeActivity;
	}
   
}
