package com.example.springboot.demospringbootn11.service.entityservice;

import com.example.springboot.demospringbootn11.dao.UrunDao;
import com.example.springboot.demospringbootn11.entity.Urun;
import com.example.springboot.demospringbootn11.entity.Urun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrunEntityService {

    @Autowired
    private UrunDao urunDao;

    public List<Urun> findAll(){
        return (List<Urun>) urunDao.findAll();
    }
    public Urun findById(Long id){
        Optional<Urun> optional = urunDao.findById(id);

        Urun urun = null;
        if(optional.isPresent()){
            urun = optional.get();
        }
        return urun;
    }
    public Urun save(Urun urun){
        urun = urunDao.save(urun);

        return urun;
    }

    public void delete(Urun urun) {
        urunDao.delete(urun);
    }
    public void deleteById(Long id){
        urunDao.deleteById(id);
    }
    public long count(){
        return urunDao.count();

    }
}
