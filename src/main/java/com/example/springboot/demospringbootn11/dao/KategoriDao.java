package com.example.springboot.demospringbootn11.dao;

import com.example.springboot.demospringbootn11.entity.Kategori;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KategoriDao extends CrudRepository<Kategori,Long> {


}
