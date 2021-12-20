package com.example.springboot.demospringbootn11.converter;

import com.example.springboot.demospringbootn11.dto.KategoriDto;
import com.example.springboot.demospringbootn11.dto.UrunDto;
import com.example.springboot.demospringbootn11.entity.Kategori;
import com.example.springboot.demospringbootn11.entity.Urun;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KategoriConverter {

    KategoriConverter INSTANCE = Mappers.getMapper(KategoriConverter.class);

    @Mapping(target = "ustKategoriId", source = "ustKategori.id")
    KategoriDto convertKategoriToKategoriDto(Kategori kategori);

    @Mapping(target = "ustKategoriId", source = "ustKategori.id")
    List<KategoriDto> convertAllKategoriListToKategoriDtoList(List<Kategori> kategoriList);

    @Mapping(source = "ustKategoriId", target = "ustKategori.id")
    Kategori convertKategoriDtoToKategori(KategoriDto kategoriDto);
    @AfterMapping
    default void setNulls(@MappingTarget Kategori kategori, KategoriDto kategoriDto) {
        if (kategoriDto.getUstKategoriId() == null) {
            kategori.setUstKategori(null);
        }
    }
}
