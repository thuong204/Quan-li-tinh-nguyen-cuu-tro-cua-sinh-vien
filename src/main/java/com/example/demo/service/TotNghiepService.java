package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CongViec;
import com.example.demo.entity.TotNghiep;

public interface TotNghiepService {
	public List<TotNghiep> getListTotNghiep();

	public List<TotNghiep> searchTotNghiep(String search);

//	public List<CongViec> searchCongViec(String search);
}
