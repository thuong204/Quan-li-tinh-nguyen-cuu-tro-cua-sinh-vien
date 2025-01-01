package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CongViecRepository;
import com.example.demo.dao.TotNghiepRepository;
import com.example.demo.entity.CongViec;
import com.example.demo.entity.TotNghiep;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class TotNghiepServiceImpl  implements TotNghiepService{
	@Autowired
	private TotNghiepRepository totNghiepRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private CongViecRepository congViecRepository;

	@Override
	@Transactional
	public List<TotNghiep> getListTotNghiep() {
		// TODO Auto-generated method stub
		return totNghiepRepository.findAll();
	}

	@Override
	public List<TotNghiep> searchTotNghiep(String searchInput) {
		// TODO Auto-generated method stub
		 return totNghiepRepository.findByHeTotNghiepContainingOrLoaiTotNghiepContaining(
		            searchInput, searchInput);
	}

//	@Override
//	public List<CongViec> searchCongViec(String searchInput) {
//	    String jpql = "SELECT c FROM CongViec c JOIN c.congTy t WHERE c.tenCongViec LIKE :searchInput OR t.tenCongTy LIKE :searchInput";
//	    
//	    TypedQuery<CongViec> query = entityManager.createQuery(jpql, CongViec.class);
//	    query.setParameter("searchInput", "%" + searchInput + "%");
//	    
//	    return query.getResultList();
//	}


}
