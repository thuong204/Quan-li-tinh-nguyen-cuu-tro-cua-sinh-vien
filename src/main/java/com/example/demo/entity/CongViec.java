package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="CongViec")
public class CongViec implements Serializable {

    @EmbeddedId
    private MaCongViec maCongViec;

    @ManyToOne
    @MapsId("maSinhVien") // Correctly maps the maSinhVien from the embedded ID
    @JoinColumn(name="SoCMND", nullable=false)
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name="MaNganh", nullable = false)
    private Nganh nganh;

    @Column(name="TenCongViec")
    private String tenCongViec;

    @Column(name="TenCongTy")
    private String tenCongTy;

    @Column(name="DiaChiCongTy")
    private String diaChiCongTy;

    @Column(name="ThoiGianLamViec")
    private Date thoiGianLamViec;

    // The embedded ID class
    @Embeddable
    public static class MaCongViec implements Serializable {
        @Column(name="MaSinhVien")
        private String maSinhVien;

        @Column(name="NgayVaoCongTy")
        private Date ngayVaoCongTy;

        public MaCongViec(String maSinhVien, Date ngayVaoCongTy) {
            this.maSinhVien = maSinhVien;
            this.ngayVaoCongTy = ngayVaoCongTy;
        }

        public MaCongViec() {}

        // Getters and setters
        public String getMaSinhVien() {
            return maSinhVien;
        }

        public void setMaSinhVien(String maSinhVien) {
            this.maSinhVien = maSinhVien;
        }

        public Date getNgayVaoCongTy() {
            return ngayVaoCongTy;
        }

        public void setNgayVaoCongTy(Date ngayVaoCongTy) {
            this.ngayVaoCongTy = ngayVaoCongTy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(maSinhVien, ngayVaoCongTy);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            MaCongViec other = (MaCongViec) obj;
            return Objects.equals(maSinhVien, other.maSinhVien) && Objects.equals(ngayVaoCongTy, other.ngayVaoCongTy);
        }
    }

    // Getters and setters for the CongViec fields
    public MaCongViec getMaCongViec() {
        return maCongViec;
    }

    public void setMaCongViec(MaCongViec maCongViec) {
        this.maCongViec = maCongViec;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDiaChiCongTy() {
        return diaChiCongTy;
    }

    public void setDiaChiCongTy(String diaChiCongTy) {
        this.diaChiCongTy = diaChiCongTy;
    }

    public Date getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public void setThoiGianLamViec(Date thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }
}
