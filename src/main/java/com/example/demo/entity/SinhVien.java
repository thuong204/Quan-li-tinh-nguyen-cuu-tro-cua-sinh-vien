package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="SinhVien")
public class SinhVien {
	@Column(name="SoCMND",length= 12)
	@Id
	private String soCMND;
	
	@Column(name="HoTen", nullable = false)
	private String hoTen;
	
	
	 
	@Email(message  = "Email không hợp lệ") // Kiểm tra định dạng email
	@Column(name="Email", nullable = false, unique = true)
	private String email;
	
	@Pattern(regexp = "^\\+?[0-9]{10,13}$", message = "Số điện thoại không hợp lệ")
	@Column(name="SoDT")
	private String soDT;
	
	@Column(name="DiaChi")
	private String diaChi;
	
	@OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<TotNghiep>  totNghiep= new ArrayList<>();
	
	
	@OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CongViec> congViec = new ArrayList<>();
	
	
	
	
	
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
	public SinhVien(String soCMND, String hoTen, String email, String soDT, String diaChi) {
		super();
		this.soCMND = soCMND;
		this.hoTen = hoTen;
		this.email = email;
		this.soDT = soDT;
		this.diaChi = diaChi;
	}
	public SinhVien() {
		super();
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "SinhVien [soCMND=" + soCMND + ", hoTen=" + hoTen + ", email=" + email + ", soDT=" + soDT + ", diaChi="
				+ diaChi + ", totNghiep=" + totNghiep + ", congViec=" + congViec + "]";
	}
	
	
	
	

}
