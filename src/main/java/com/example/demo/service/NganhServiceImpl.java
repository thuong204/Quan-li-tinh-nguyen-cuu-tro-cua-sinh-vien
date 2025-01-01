package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NganhRepository;
import com.example.demo.dao.SinhVienRepository;
import com.example.demo.entity.Nganh;

import jakarta.transaction.Transactional;

@Service
public class NganhServiceImpl implements NganhService{
	@Autowired
	private NganhRepository nganhRepository;

	@Override
	@Transactional
	public List<Nganh> getListNganh() {
		// TODO Auto-generated method stub
		return nganhRepository.findAll();
	}
	

}
