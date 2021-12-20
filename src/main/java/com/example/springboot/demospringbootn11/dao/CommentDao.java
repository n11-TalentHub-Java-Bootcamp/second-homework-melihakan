package com.example.springboot.demospringbootn11.dao;

import com.example.springboot.demospringbootn11.entity.Urun;
import com.example.springboot.demospringbootn11.entity.UrunYorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface CommentDao extends JpaRepository<UrunYorum,Long> {

    @Query("select urun from UrunYorum urun where urun.kullanici.id =:kullaniciId")
    List<UrunYorum> findAllByKullaniciOrderById(Long kullaniciId);

    @Query("select urun from UrunYorum urun where urun.urun.id =:urunId")
    List<UrunYorum> findAllByUrunOrderById(Long urunId);

    //@Query("delete from UrunYorum come where come.id=:id")
    List<UrunYorum> deleteUrunYorumById(Long id);

}
