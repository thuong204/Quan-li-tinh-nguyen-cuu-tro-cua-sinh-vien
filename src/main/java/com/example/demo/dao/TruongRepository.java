package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Truong;

@Repository
public interface TruongRepository extends JpaRepository<Truong,String>{

}
