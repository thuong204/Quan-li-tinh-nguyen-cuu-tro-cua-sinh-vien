package com.example.demo.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CongViec;
import com.example.demo.entity.TotNghiep;
import com.example.demo.entity.TotNghiep.MaTotNghiep;

import jakarta.transaction.Transactional;

@Repository
public interface TotNghiepRepository extends JpaRepository<TotNghiep, MaTotNghiep>{
	
	 @Modifying
	    @Transactional
	    @Query(value = "INSERT INTO tot_nghiep (SoCMND, ma_truong, ma_nganh, hetn, ngaytn, loaitn) " +
	                   "VALUES (:soCMND, :maTruong, :maNganh, :heTN, :ngayTN, :loaiTN)", nativeQuery = true)
	    void themSinhVienTotNghiep(
	        @Param("soCMND") String soCMND,
	        @Param("maTruong") String maTruong,
	        @Param("maNganh") String maNganh,
	        @Param("heTN") String heTN,
	        @Param("ngayTN") Date ngayTN,
	        @Param("loaiTN") String loaiTN
	    );
//	 
//	 @Query("SELECT t FROM tot_nghiep t JOIN FETCH t.sinhVien s JOIN FETCH s.congViec")
//	 List<TotNghiep> findAllWithCongViec();

	List<TotNghiep> findByHeTotNghiepContainingOrLoaiTotNghiepContaining(
			String heTotNghiep, String loaiTotNghiep);

	//List<TotNghiep> findByContainingOrHoTenContainingOrEmailContaining(String soCMND, String hoTen, String email);

}
