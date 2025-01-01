package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TruongRepository;
import com.example.demo.entity.Truong;

import jakarta.transaction.Transactional;

@Service
public class TruongServiceImpl implements TruongService {
	
	@Autowired
	private TruongRepository truongRepository;

	@Override
	@Transactional
	public List<Truong> getListTruong() {
		// TODO Auto-generated method stub
		return truongRepository.findAll() ;
	}
	

}
