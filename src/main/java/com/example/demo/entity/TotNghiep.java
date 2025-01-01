package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="TotNghiep")
public class TotNghiep implements Serializable{
	
	@EmbeddedId
	private MaTotNghiep maTotNghiep;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("maSinhVien")
	@JoinColumn(name="SoCMND", nullable = false)
	private SinhVien sinhVien;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("maTruong")
	@JoinColumn(name="ma_truong", nullable = false)
	private Truong truong;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @MapsId("maNganh")
	 @JoinColumn(name = "ma_nganh", nullable = false)
	 private Nganh nganh;
	
	@Column(name="HeTN")
	private String heTotNghiep;
	
	@Column(name="NgayTN")
	private Date ngayTotNghiep;
	
	@Column(name="LoaiTN")
	private String loaiTotNghiep;

	
	@Embeddable
	public static class MaTotNghiep implements Serializable{
	
		private String maSinhVien;

		private String maTruong;
		

		private String maNganh;
		public MaTotNghiep(String maSinhVien, String maTruong, String maNganh) {
			super();
			this.maSinhVien = maSinhVien;
			this.maTruong = maTruong;
			this.maNganh = maNganh;
		}
		public String getMaSinhVien() {
			return maSinhVien;
		}
		public void setMaSinhVien(String maSinhVien) {
			this.maSinhVien = maSinhVien;
		}
		public String getMaTruong() {
			return maTruong;
		}
		public void setMaTruong(String maTruong) {
			this.maTruong = maTruong;
		}
		public String getMaNganh() {
			return maNganh;
		}
		public void setMaNganh(String maNganh) {
			this.maNganh = maNganh;
		}
		public MaTotNghiep() {
			super();
		}
		@Override
		public int hashCode() {
			return Objects.hash(maNganh, maSinhVien, maTruong);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MaTotNghiep other = (MaTotNghiep) obj;
			return Objects.equals(maNganh, other.maNganh) && Objects.equals(maSinhVien, other.maSinhVien)
					&& Objects.equals(maTruong, other.maTruong);
		}
	}


	public TotNghiep(MaTotNghiep maTotNghiep, SinhVien sinhVien, Truong truong, Nganh nganh, String heTotNghiep,
			Date ngayTotNghiep, String loaiTotNghiep) {
		super();
		this.maTotNghiep = maTotNghiep;
		this.sinhVien = sinhVien;
		this.truong = truong;
		this.nganh = nganh;
		this.heTotNghiep = heTotNghiep;
		this.ngayTotNghiep = ngayTotNghiep;
		this.loaiTotNghiep = loaiTotNghiep;
	}


	public TotNghiep() {
		super();
	}


	public MaTotNghiep getMaTotNghiep() {
		return maTotNghiep;
	}


	public void setMaTotNghiep(MaTotNghiep maTotNghiep) {
		this.maTotNghiep = maTotNghiep;
	}


	public SinhVien getSinhVien() {
		return sinhVien;
	}


	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}


	public Truong getTruong() {
		return truong;
	}


	public void setTruong(Truong truong) {
		this.truong = truong;
	}


	public Nganh getNganh() {
		return nganh;
	}


	public void setNganh(Nganh nganh) {
		this.nganh = nganh;
	}


	public String getHeTotNghiep() {
		return heTotNghiep;
	}


	public void setHeTotNghiep(String heTotNghiep) {
		this.heTotNghiep = heTotNghiep;
	}


	public Date getNgayTotNghiep() {
		return ngayTotNghiep;
	}


	public void setNgayTotNghiep(Date ngayTotNghiep) {
		this.ngayTotNghiep = ngayTotNghiep;
	}


	public String getLoaiTotNghiep() {
		return loaiTotNghiep;
	}


	public void setLoaiTotNghiep(String loaiTotNghiep) {
		this.loaiTotNghiep = loaiTotNghiep;
	}


	
	
	


	

}
