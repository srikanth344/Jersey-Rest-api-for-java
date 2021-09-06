package org.restapi.crud.crud.model;

import java.sql.Date;

public class crudmodel {
	
	private int STUDENT_NO;
	private String STUDENT_NAME;
	private Date STUDENT_DOB;
	private Date STUDENT_DOJ;
	
	
	public crudmodel() {
		
	}
	
	
	public crudmodel(int STUDENT_NO,String STUDENT_NAME, Date STUDENT_DOB , Date STUDENT_DOJ) {
	
		super();
		
		
		this.STUDENT_NO = STUDENT_NO;
		this.STUDENT_NAME = STUDENT_NAME;
		this.STUDENT_DOB = STUDENT_DOB;
		this.STUDENT_DOJ = STUDENT_DOJ;
	}
	
	
	
	public int getSTUDENT_NO() {
		return STUDENT_NO;
	}


	public void setSTUDENT_NO(int STUDENT_NO) {
		this.STUDENT_NO = STUDENT_NO;
	}


	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}


	public void setSTUDENT_NAME(String STUDENT_NAME) {
		this.STUDENT_NAME = STUDENT_NAME;
	}


	
	
	public Date getSTUDENT_DOB() {
		return STUDENT_DOB;
	}


	public void setSTUDENT_DOB(Date STUDENT_DOB) {
		this.STUDENT_DOB = STUDENT_DOB;
	}
	
	public Date getSTUDENT_DOJ() {
		return STUDENT_DOJ;
	}


	public void setSTUDENT_DOJ(Date STUDENT_DOJ) {
		this.STUDENT_DOJ = STUDENT_DOJ;
	}
	
	
	

}
