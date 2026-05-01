package com.onlineshop.dresses.controller;


import com.onlineshop.dresses.model.Dress;
import com.onlineshop.dresses.service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/dresses")
@CrossOrigin(origins = "http://localhost:3000")
public class DressController {

    @Autowired
    private DressService dressService;


    @GetMapping
    public List<Dress> getAllDresses(){
        return dressService.getAllDresses();
    }

    @GetMapping("/category/{type}")
    public List<Dress> getByCategory(@PathVariable String type){
        return dressService.getDressesByCategory(type);
    }

 /*   @PostMapping("/admin/add")
    public Dress addDress(@RequestBody Dress dress){
        return dressService.saveDress(dress);
    }*/

    @PostMapping(value = "/admin/add", consumes = {"multipart/form-data"})
    public ResponseEntity<Dress> addDress(
            @RequestPart("dress") Dress dress,
            @RequestPart("images") List<MultipartFile> images) {
        try {
            Dress savedDress = dressService.saveDressWithImages(dress, images);
            return ResponseEntity.ok(savedDress);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
