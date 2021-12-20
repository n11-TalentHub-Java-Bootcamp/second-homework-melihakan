package com.example.springboot.demospringbootn11.converter;

import com.example.springboot.demospringbootn11.dto.KategoriDto;
import com.example.springboot.demospringbootn11.dto.UrunDto;
import com.example.springboot.demospringbootn11.dto.UserDto;
import com.example.springboot.demospringbootn11.entity.Kategori;
import com.example.springboot.demospringbootn11.entity.Kullanici;
import com.example.springboot.demospringbootn11.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(target = "kullaniciAdi", source = "kullanici.adi")
    List<UserDto> convertAllUsersListToUsersDtoList(List<Kullanici> kullaniciList);

    @Mapping(target = "kullaniciAdi", source = "kullaniciAdi")
    UserDto convertUserToUserDto(Kullanici kullanici);



/*    @Mapping(source = "adi", target = "adi")
    UserDto convertUserDtoToUser(Kullanici kullanici);*/


    @Mapping(source = "kullaniciAdi", target = "kullaniciAdi")
    Kullanici convertUserDtoToUser(UserDto userDto);


    List<UserDto> convertUserListToUserDtoList(List<Kullanici> kullaniciList);

}





