package com.example.springboot.demospringbootn11.controller;

import com.example.springboot.demospringbootn11.converter.CommentConverter;

import com.example.springboot.demospringbootn11.dto.CommentDto;

import com.example.springboot.demospringbootn11.entity.UrunYorum;
import com.example.springboot.demospringbootn11.service.entityservice.CommentEntityService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/comments/")
@Transactional
public class CommentController {

    @Autowired
    private CommentEntityService commentEntityService;

    @GetMapping("user/{userId}")
    public List<CommentDto> findAllCommentByKullaniciId(@PathVariable Long userId){
        List<UrunYorum> commentList = commentEntityService.findAllByKullaniciOrderById(userId);

        List<CommentDto> commentDtos = CommentConverter.INSTANCE.convertAllCommentListToCommentDtosList(commentList);

        return commentDtos;

    }
    @GetMapping("urun/{urunId}")
    public List<CommentDto> findAllCommentByUrunId(@PathVariable Long urunId){
        List<UrunYorum> commentList = commentEntityService.findAllByUrunOrderById(urunId);

        List<CommentDto> commentDtos = CommentConverter.INSTANCE.convertAllYorumListToCommentDtosList(commentList);

        return commentDtos;
    }
    @PostMapping("")
    public ResponseEntity<Object> saveComment(@RequestBody CommentDto commentDto) {


        UrunYorum urunYorum = CommentConverter.INSTANCE.convertCommentDtoToComment(commentDto);

        //Urun urun = convertUrunDtoToUrun(urunDto);
        urunYorum = commentEntityService.save(urunYorum);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(urunYorum.getId())
                .toUri();


        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable Long id){
        commentEntityService.deleteUrunYorumById(id);

    }

}
