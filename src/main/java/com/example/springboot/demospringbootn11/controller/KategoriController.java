package com.example.springboot.demospringbootn11.controller;


import com.example.springboot.demospringbootn11.converter.KategoriConverter;
import com.example.springboot.demospringbootn11.dto.KategoriDto;
import com.example.springboot.demospringbootn11.entity.Kategori;
import com.example.springboot.demospringbootn11.service.entityservice.KategoriEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class KategoriController {


    @Autowired
    private KategoriEntityService kategoriEntityService;

    @GetMapping("")
    public List<KategoriDto> findAll(){
        List<Kategori> kategoriList = kategoriEntityService.findAll();

        //Convert
/*        List<KategoriDto> kategoriDtoList = new ArrayList<>();
        for (Kategori kategori : kategoriList) {

            KategoriDto kategoriDto = KategoriConverter.INSTANCE.convertKategoriToKategoriDto(kategori);
            kategoriDtoList.add(kategoriDto);
        }*/
        List<KategoriDto> kategoriDtoList = KategoriConverter.INSTANCE.convertAllKategoriListToKategoriDtoList(kategoriList);


        return kategoriDtoList;
    }
    @GetMapping("/{id}")
    public Kategori findById(@PathVariable Long id){
        Kategori kategori = kategoriEntityService.findById(id);

        return kategori;

    }


    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody KategoriDto kategoriDto){

        Kategori kategori = KategoriConverter.INSTANCE.convertKategoriDtoToKategori(kategoriDto);

        kategori = kategoriEntityService.save(kategori);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(kategori.getId())
                .toUri();


        return ResponseEntity.created(uri).build();

    }



    @PutMapping("")
    public KategoriDto update(@RequestBody KategoriDto kategoriDto){

        Kategori kategori = KategoriConverter.INSTANCE.convertKategoriDtoToKategori(kategoriDto);

        if(kategori.getUstKategori() != null && kategori.getUstKategori().getId() == null){
            kategori.setUstKategori(null);
        }

        kategori = kategoriEntityService.save(kategori);

        KategoriDto kategoriDtoResult = KategoriConverter.INSTANCE.convertKategoriToKategoriDto(kategori);

        return kategoriDtoResult;

    }
    @DeleteMapping("/{id}")
    public void delete(Long id){
        kategoriEntityService.deleteById(id);
    }




    }
