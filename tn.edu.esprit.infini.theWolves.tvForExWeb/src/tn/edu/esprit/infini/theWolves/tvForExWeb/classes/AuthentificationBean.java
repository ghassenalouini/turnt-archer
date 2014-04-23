package tn.edu.esprit.infini.theWolves.tvForExWeb.classes;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.edu.esprit.infini.theWolves.tvForEx.domain.Administrator;
import tn.edu.esprit.infini.theWolves.tvForEx.facadeLocal.interfaces.AdminFacadeLocal;

@ManagedBean
@SessionScoped
public class AuthentificationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdminFacadeLocal adminFacadeLocal;

	private Administrator administrator = new Administrator();
	private String login;
	private String password;
	private boolean loggedIn = false;

	public AuthentificationBean() {
		// TODO Auto-generated constructor stub
	}

	public String doLogin() {

		String navigateTo = null;
		System.out.println(login);
		administrator = adminFacadeLocal.loginAdmin(administrator.getLogin(),
				administrator.getPassword());

		if (administrator != null) {

			setLoggedIn(true);
			System.out.println("instance passé");
			navigateTo = "/Pages/Platfrom/Administrator/AdminHome?faces-redirect=true";
			System.out.println("oui");

		} else {
			System.out.println("non");
			FacesMessage message = new FacesMessage("Erreur");
			FacesContext.getCurrentInstance().addMessage(
					"login-form:submit-id", message);
			setLoggedIn(false);
			navigateTo = null;

		}
		return navigateTo;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
