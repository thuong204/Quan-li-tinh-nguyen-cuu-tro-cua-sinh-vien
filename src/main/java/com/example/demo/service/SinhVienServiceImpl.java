package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SinhVienRepository;
import com.example.demo.dao.TotNghiepRepository;
import com.example.demo.entity.SinhVien;
import com.example.demo.entity.TotNghiep;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class SinhVienServiceImpl implements SinhVienService {
	
	@Autowired
	private SinhVienRepository sinhVienRepository;
	
	@Autowired
	private TotNghiepRepository totNghiepRepository;
	

	@Override
	@Transactional
	public SinhVien addSinhVienTotNghiep(SinhVien sv, TotNghiep tn) {
		;
		
		SinhVien savedSinhVien = sinhVienRepository.save(sv);
		
	    // Lưu thông tin tốt nghiệp

	    totNghiepRepository.themSinhVienTotNghiep(sv.getSoCMND(), tn.getMaTotNghiep().getMaTruong(), tn.getMaTotNghiep().getMaNganh(), tn.getHeTotNghiep(), tn.getNgayTotNghiep(), tn.getLoaiTotNghiep());
		// TODO Auto-generated method stub
		return savedSinhVien;
	}


	@Override
	public List<SinhVien> getListSinhVien() {
		// TODO Auto-generated method stub
		return sinhVienRepository.findAll();
	}


	@Override
	public List<SinhVien> searchSinhVien(String search) {
		// TODO Auto-generated method stub
		
		 return sinhVienRepository.findBySoCMNDContainingOrHoTenContainingOrEmailContaining(search,search,search);
	}


	@Override
	public SinhVien getSinhVienByCMND(String cmnd) {
		
		// TODO Auto-generated method stub
		return sinhVienRepository.findBySoCMND(cmnd);
	}


	@Override
	public SinhVien capNhatSinhVien(SinhVien sv) {
		// TODO Auto-generated method stub
		return sinhVienRepository.saveAndFlush(sv);
	}


	@Override
	public void xoaSinhVien(String soCMND) {
		sinhVienRepository.deleteBySoCMND(soCMND);
	}

}
