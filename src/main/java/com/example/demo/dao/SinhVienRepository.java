package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SinhVien;
import com.example.demo.entity.TotNghiep;

import jakarta.transaction.Transactional;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String>{
	
	List<SinhVien> findBySoCMNDContainingOrHoTenContainingOrEmailContaining(String soCMND, String hoTen, String email);

	SinhVien findBySoCMND(String cmnd);

	 @Transactional
	 void deleteBySoCMND(String soCMND); 
	

}
