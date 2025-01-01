package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SinhVien;
import com.example.demo.entity.TotNghiep;

public interface SinhVienService {
	public SinhVien addSinhVienTotNghiep(SinhVien sv, TotNghiep tn);
	public List<SinhVien> getListSinhVien();

	public List<SinhVien> searchSinhVien(String search);
	
	public SinhVien getSinhVienByCMND(String cmnd);
	
	public SinhVien capNhatSinhVien(SinhVien sv);
	public void xoaSinhVien(String soCMND);
	
}
