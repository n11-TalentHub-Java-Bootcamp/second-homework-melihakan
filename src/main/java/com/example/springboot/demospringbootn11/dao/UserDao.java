package com.example.springboot.demospringbootn11.dao;

import com.example.springboot.demospringbootn11.dto.UserDto;
import com.example.springboot.demospringbootn11.entity.Kullanici;
import com.example.springboot.demospringbootn11.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<Kullanici,Long> {

    Optional<Kullanici> findKullaniciByKullaniciAdi(String adi);

    Kullanici findKullaniciByTelefon(String telefon);
    Kullanici findKullaniciByAdi(String adi);

    Kullanici removeKullaniciByAdiEqualsAndTelefon(String adi,String telefon);
    Kullanici removeKullaniciByKullaniciAdiEqualsAndTelefon(String adi,String telefon);
    //Kullanici removeKullaniciByAdiEqualsAndTelefon(String adi,String telefon);
    List<Kullanici> deleteKullaniciByAdiAndTelefon(String adi,String telefon);
    //Kullanici findKullaniciByAdiAndTelefon(String adi,String telefon);


}
