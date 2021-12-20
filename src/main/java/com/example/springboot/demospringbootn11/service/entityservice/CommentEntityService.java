package com.example.springboot.demospringbootn11.service.entityservice;


import com.example.springboot.demospringbootn11.dao.CommentDao;
import com.example.springboot.demospringbootn11.entity.UrunYorum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentEntityService {

    @Autowired
    private CommentDao commentDao;

    public List<UrunYorum> findAll(){
        return (List<UrunYorum>) commentDao.findAll();
    }
    public UrunYorum findById(Long id){
        Optional<UrunYorum> optional = commentDao.findById(id);

        UrunYorum urun = null;
        if(optional.isPresent()){
            urun = optional.get();
        }
        return urun;
    }
    public UrunYorum save(UrunYorum urun){
        urun = commentDao.save(urun);

        return urun;
    }

    public void delete(UrunYorum urun) {
        commentDao.delete(urun);
    }
    public void deleteById(Long id){
        commentDao.deleteById(id);
    }
    public long count(){
        return commentDao.count();

    }

    public List<UrunYorum> findAllByKullaniciOrderById(Long kullaniciId){
        return commentDao.findAllByKullaniciOrderById(kullaniciId);
    }

    public List<UrunYorum> findAllByUrunOrderById(Long urunId){
        return commentDao.findAllByUrunOrderById(urunId);
    }
    public List<UrunYorum> deleteUrunYorumById(Long id){
        return commentDao.deleteUrunYorumById(id);
    }


    
    
    
    
}
