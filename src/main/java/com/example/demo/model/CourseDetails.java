package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String cmsc;
	private String inftech;
	private String cloud;
	private String datasc;
	private String mba;
	private String suplychn;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCmsc() {
		return cmsc;
	}
	public void setCmsc(String cmsc) {
		this.cmsc = cmsc;
	}
	public String getInftech() {
		return inftech;
	}
	public void setInftech(String inftech) {
		this.inftech = inftech;
	}
	public String getCloud() {
		return cloud;
	}
	public void setCloud(String cloud) {
		this.cloud = cloud;
	}
	public String getDatasc() {
		return datasc;
	}
	public void setDatasc(String datasc) {
		this.datasc = datasc;
	}
	public String getMba() {
		return mba;
	}
	public void setMba(String mba) {
		this.mba = mba;
	}
	public String getSuplychn() {
		return suplychn;
	}
	public void setSuplychn(String suplychn) {
		this.suplychn = suplychn;
	}
	@Override
	public String toString() {
		return "CourseDetails [id=" + id + ", cmsc=" + cmsc + ", inftech=" + inftech + ", cloud=" + cloud + ", datasc="
				+ datasc + ", mba=" + mba + ", suplychn=" + suplychn + "]";
	}


}


