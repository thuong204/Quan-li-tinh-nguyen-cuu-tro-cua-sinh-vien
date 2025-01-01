package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Nganh")
public class Nganh {
	@Column(name="ma_nganh")
	@Id
	private String maNganh;
	
	@Column(name="ten_nganh", nullable = false)
	private String tenNganh;
	
	@Column(name="loai_nganh")
	private String loaiNganh;
	
	@OneToMany(mappedBy = "nganh", cascade = CascadeType.ALL)
	private List<TotNghiep> totNghiep = new ArrayList<>();
	
	@OneToMany(mappedBy = "nganh", cascade = CascadeType.ALL)
	private List<CongViec> congViec = new ArrayList<>();


	
	

	public Nganh(String maNganh, String tenNganh, String loaiNganh, List<TotNghiep> totNghiep,
			List<CongViec> congViec) {
		super();
		this.maNganh = maNganh;
		this.tenNganh = tenNganh;
		this.loaiNganh = loaiNganh;
		this.totNghiep = totNghiep;
		this.congViec = congViec;
	}
	

	public List<TotNghiep> getTotNghiep() {
		return totNghiep;
	}


	public void setTotNghiep(List<TotNghiep> totNghiep) {
		this.totNghiep = totNghiep;
	}


	public List<CongViec> getCongViec() {
		return congViec;
	}


	public void setCongViec(List<CongViec> congViec) {
		this.congViec = congViec;
	}


	public Nganh() {
		super();
	}

	public String getMaNganh() {
		return maNganh;
	}

	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

	public String getLoaiNganh() {
		return loaiNganh;
	}

	public void setLoaiNganh(String loaiNganh) {
		this.loaiNganh = loaiNganh;
	}


}
