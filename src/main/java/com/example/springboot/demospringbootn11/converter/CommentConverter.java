package com.example.springboot.demospringbootn11.converter;

import com.example.springboot.demospringbootn11.dto.CommentDto;
import com.example.springboot.demospringbootn11.dto.UrunDto;
import com.example.springboot.demospringbootn11.dto.UserDto;
import com.example.springboot.demospringbootn11.entity.Kullanici;
import com.example.springboot.demospringbootn11.entity.Urun;
import com.example.springboot.demospringbootn11.entity.UrunYorum;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentConverter {

    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);


    //@Mapping(target = "urunId", source = "id") //TODO User id is now showing

    //List<CommentDto> convertCommentListToCommentDtoList(List<UrunYorum> urunYorumList);

    @Mapping(target = "kullaniciId", source = "kullanici.id")
    List<CommentDto> convertAllCommentListToCommentDtosList(List<UrunYorum> commentList);
    @AfterMapping
    default void setNulls(@MappingTarget final  CommentDto commentDto,UrunYorum urun){
        if (commentDto.getKullaniciId() == null){
            commentDto.setKullaniciId(urun.getKullanici().getId());
        }
    }
    @Mapping(target = "urunId", source = "urun.id")
    List<CommentDto> convertAllYorumListToCommentDtosList(List<UrunYorum> yorumList);
    @AfterMapping
    default void setNull(@MappingTarget final  CommentDto commentDto,UrunYorum urun){
        if (commentDto.getUrunId() == null){
            commentDto.setUrunId(urun.getUrun().getId());
        }
    }
    @Mapping(source = "urunId",  target = "urun.id")
    @Mapping(source = "kullaniciId", target = "kullanici.id")
    UrunYorum convertCommentDtoToComment(CommentDto commentDto);


//


}
