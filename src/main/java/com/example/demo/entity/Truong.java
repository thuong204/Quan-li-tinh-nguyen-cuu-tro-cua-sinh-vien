package com.example.demo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Truong")
public class Truong {
	
	@Id
	@Column(name="MaTruong")
	private String maTruong;
	
	@Column(name="TenTruong", nullable = false)
	private String tenTruong;
	
	@Column(name="SoDT")
	private String soDT;
	
	@Column(name="DiaChi")
	private String diaChi;

	@OneToMany(mappedBy = "truong" , cascade = CascadeType.ALL)
	private List<TotNghiep> totNghiep = new ArrayList<>();

	public Truong(String maTruong, String tenTruong, String soDT, String diaChi, List<TotNghiep> totNghiep) {
		super();
		this.maTruong = maTruong;
		this.tenTruong = tenTruong;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.totNghiep = totNghiep;
	}

	public Truong() {
		super();
	}

	public String getMaTruong() {
		return maTruong;
	}

	public void setMaTruong(String maTruong) {
		this.maTruong = maTruong;
	}

	public String getTenTruong() {
		return tenTruong;
	}

	public void setTenTruong(String tenTruong) {
		this.tenTruong = tenTruong;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public List<TotNghiep> getTotNghiep() {
		return totNghiep;
	}

	public void setTotNghiep(List<TotNghiep> totNghiep) {
		this.totNghiep = totNghiep;
	}
	
	
}
