package com.example.springboot.demospringbootn11.converter;

import com.example.springboot.demospringbootn11.dto.UrunDetayDto;
import com.example.springboot.demospringbootn11.dto.UrunDto;
import com.example.springboot.demospringbootn11.entity.Urun;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UrunConverter {

    UrunConverter INSTANCE = Mappers.getMapper(UrunConverter.class);

    @Mapping(source = "kategoriId", target = "kategori.id") //TODO source use from urunDto, target use kategori id from kategori
    Urun convertUrunDtoToUrun(UrunDto urunDto);
    @Mapping(target = "kategoriId", source = "kategori.id")
    UrunDto convertUrunToUrunDto(Urun urun);


    @Mapping(source = "fiyat", target = "urunFiyati") //TODO source use fiyat from urun , target use urunFiyat from urunDetayDto
    @Mapping(source = "adi", target = "urunAdi")
    @Mapping(source = "kategori.adi", target = "kategoriAdi")
    UrunDetayDto convertUrunToUrunDetayDto(Urun urun);
    @AfterMapping
    default void setNulls(@MappingTarget final Urun urun, UrunDto urunDto){
        if (urunDto.getKategoriId() == null){
            urun.setKategori(null);
        }
    }

}
