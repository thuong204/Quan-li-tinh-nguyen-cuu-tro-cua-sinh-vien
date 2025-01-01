package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CongViec;
import com.example.demo.entity.CongViec.MaCongViec;

@Repository
public interface CongViecRepository extends JpaRepository<CongViec, MaCongViec> {

	List<CongViec> findByTenCongViecContainingOrTenCongTyContaining(String searchInput, String searchInput2);

}
