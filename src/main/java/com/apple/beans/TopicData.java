package com.apple.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GNV_TOPIC")
public class TopicData {
	
	@Id
	@Column(name="TOPIC_ID")
	public int TOPIC_ID ;
	

	public int getTOPIC_ID() {
		return TOPIC_ID;
	}

	public void setTOPIC_ID(int tOPIC_ID) {
		TOPIC_ID = tOPIC_ID;
	}

	public String getTOPIC_NM() {
		return TOPIC_NM;
	}

	public void setTOPIC_NM(String tOPIC_NM) {
		TOPIC_NM = tOPIC_NM;
	}

	public int getAPP_ID() {
		return APP_ID;
	}

	public void setAPP_ID(int aPP_ID) {
		APP_ID = aPP_ID;
	}

	@Column(name="TOPIC_NM")
	public String TOPIC_NM;
	
	@Column(name="APP_ID")
	public int APP_ID ;

}


 