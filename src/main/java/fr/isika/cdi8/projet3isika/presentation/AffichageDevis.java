package fr.isika.cdi8.projet3isika.presentation;

import java.util.Date;

public class AffichageDevis {
	String statusTransaction;
	String type;
	String sousType;
	Double cout;
	Date dateSouhaite;

	public AffichageDevis(String statusTransaction, String type, String sousType, Double cout, Date dateSouhaite) {
		super();
		this.statusTransaction = statusTransaction;
		this.type = type;
		this.sousType = sousType;
		this.cout = cout;
		this.dateSouhaite = dateSouhaite;
	}

	public String getStatusTransaction() {
		return statusTransaction;
	}

	public void setStatusTransaction(String statusTransaction) {
		this.statusTransaction = statusTransaction;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSousType() {
		return sousType;
	}

	public void setSousType(String sousType) {
		this.sousType = sousType;
	}

	public Double getCout() {
		return cout;
	}

	public void setCout(Double cout) {
		this.cout = cout;
	}

	public Date getDateSouhaite() {
		return dateSouhaite;
	}

	public void setDateSouhaite(Date dateSouhaite) {
		this.dateSouhaite = dateSouhaite;
	}

}
