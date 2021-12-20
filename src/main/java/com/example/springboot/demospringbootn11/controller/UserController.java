package com.example.springboot.demospringbootn11.controller;

import com.example.springboot.demospringbootn11.converter.KategoriConverter;
import com.example.springboot.demospringbootn11.converter.UrunConverter;
import com.example.springboot.demospringbootn11.converter.UserConverter;
import com.example.springboot.demospringbootn11.dto.KategoriDto;
import com.example.springboot.demospringbootn11.dto.UrunDto;
import com.example.springboot.demospringbootn11.dto.UserDto;
import com.example.springboot.demospringbootn11.entity.Kullanici;
import com.example.springboot.demospringbootn11.entity.Urun;
import com.example.springboot.demospringbootn11.exception.UserPhoneAndNameNotEqualException;
import com.example.springboot.demospringbootn11.service.entityservice.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/users/")
@Transactional
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("")
    public List<UserDto> findAll() {
        List<Kullanici> kullaniciList = userEntityService.findAll();

        List<UserDto> userDtoList = UserConverter.INSTANCE.convertAllUsersListToUsersDtoList(kullaniciList);

        return userDtoList;
    }
    @GetMapping("/username/{name}")
    public UserDto findUserByName(@PathVariable String name) {
        UserDto userDto = userEntityService.findKullaniciByKullaniciAdi(name);
        return userDto;
    }
    @GetMapping("/userphone/{phone}")
    public UserDto findKullaniciByTelefon(@PathVariable String phone) {
        UserDto userDto = userEntityService.findKullaniciByTelefon(phone);
        return userDto;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {

        Kullanici kullanici = UserConverter.INSTANCE.convertUserDtoToUser(userDto);

        //Urun urun = convertUrunDtoToUrun(urunDto);
        kullanici = userEntityService.save(kullanici);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(kullanici.getId())
                .toUri();


        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping("/control/{name}/{phone}")
    public void delete(@PathVariable String name,@PathVariable String phone) {
        Kullanici kullanici = userEntityService.findKullaniciByAdi(name);

        if (kullanici.equals(kullanici.getAdi())) {
            userEntityService.deleteKullaniciByAdiAndTelefon(name, phone);
        } else {
            throw new UserPhoneAndNameNotEqualException("User's are not equal to name and phone :");
        }
    }

    @PutMapping("")
    public UserDto update(@RequestBody UserDto userDto){

        Kullanici kullanici= UserConverter.INSTANCE.convertUserDtoToUser(userDto);

        kullanici = userEntityService.save(kullanici);

        UserDto userDtoResult = UserConverter.INSTANCE.convertUserToUserDto(kullanici);

        return userDtoResult;
    }


/*    @PostMapping("")
    public Kullanici saveUser(@RequestBody Kullanici user) {

        Kullanici kullanici = userEntityService.save(user);

        return kullanici;
    }*/

}
