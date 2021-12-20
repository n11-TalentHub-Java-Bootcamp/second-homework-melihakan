package com.example.springboot.demospringbootn11.service.entityservice;

import com.example.springboot.demospringbootn11.dao.KategoriDao;
import com.example.springboot.demospringbootn11.entity.Kategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KategoriEntityService {

    @Autowired
    private KategoriDao kategoriDao;

    public List<Kategori> findAll(){
        return (List<Kategori>) kategoriDao.findAll();
    }
    public Kategori findById(Long id){
        Optional<Kategori> optional = kategoriDao.findById(id);

        Kategori kategori = null;
        if(optional.isPresent()){
            kategori = optional.get();
        }
        return kategori;
    }
    public Kategori save(Kategori kategori){
        kategori = kategoriDao.save(kategori);

        return kategori;
    }

    public void delete(Kategori kategori) {
        kategoriDao.delete(kategori);
    }
    public void deleteById(Long id){
        kategoriDao.deleteById(id);
    }
    public long count(){
        return kategoriDao.count();

    }
}
