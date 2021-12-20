package com.example.springboot.demospringbootn11.service.entityservice;


import com.example.springboot.demospringbootn11.converter.KategoriConverter;
import com.example.springboot.demospringbootn11.converter.UserConverter;
import com.example.springboot.demospringbootn11.dao.UserDao;
import com.example.springboot.demospringbootn11.dto.KategoriDto;
import com.example.springboot.demospringbootn11.dto.UserDto;
import com.example.springboot.demospringbootn11.entity.Kategori;
import com.example.springboot.demospringbootn11.entity.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class UserEntityService {
    @Autowired
    private UserDao userDao;

    public List<Kullanici> findAll(){
        return (List<Kullanici>) userDao.findAll();
    }
    public Kullanici findById(Long id){
        Optional<Kullanici> optional = userDao.findById(id);

        Kullanici kullanici = null;
        if(optional.isPresent()){
            kullanici = optional.get();
        }
        return kullanici;
    }
    public Kullanici save(Kullanici kullanici){
        kullanici = userDao.save(kullanici);
        return kullanici;
    }

    public void delete(Kullanici kullanici) {
        userDao.delete(kullanici);
    }
    public void deleteById(Long id){
        userDao.deleteById(id);
    }
    public long count(){
        return userDao.count();

    }
    public UserDto findKullaniciByKullaniciAdi(String adi){

        Optional<Kullanici> optionalKullanici =userDao.findKullaniciByKullaniciAdi(adi);
        Kullanici kullanici = null;
        if(optionalKullanici.isPresent()){
            kullanici = optionalKullanici.get();
        }
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(kullanici);
        return userDto;
    }
    public UserDto findKullaniciByTelefon(String telefon){
        Kullanici kullaniciList = userDao.findKullaniciByTelefon(telefon);
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(kullaniciList);
        return userDto;
    }

    public List<UserDto> deleteKullaniciByAdiAndTelefon(String adi,String telefon){
        List<Kullanici> kullanici = userDao.deleteKullaniciByAdiAndTelefon(adi,telefon);
        List<UserDto> userDto = UserConverter.INSTANCE.convertUserListToUserDtoList(kullanici);
        return userDto;
    }
    public Kullanici findKullaniciByAdi(String adi){
        Kullanici kullanici = userDao.findKullaniciByAdi(adi);
        return kullanici;
    }





}
