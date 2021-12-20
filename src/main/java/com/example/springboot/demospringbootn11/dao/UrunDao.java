package com.example.springboot.demospringbootn11.dao;

import com.example.springboot.demospringbootn11.entity.Urun;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunDao extends CrudRepository<Urun,Long> {




}
