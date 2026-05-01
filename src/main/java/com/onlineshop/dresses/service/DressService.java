package com.onlineshop.dresses.service;


import com.onlineshop.dresses.model.Dress;
import com.onlineshop.dresses.repository.DressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class DressService {

    @Autowired
    private DressesRepository dressesRepository;

    @Autowired
    private CloudinaryService cloudinaryService;


    //Getting all dresses for the catalog
    public List<Dress> getAllDresses(){
        return dressesRepository.findAll();
    }

    //Filter by category
    public List<Dress> getDressesByCategory(String category){
        return dressesRepository.findByCategory_CategoryType(category);
    }

    //save a new dress
    /*public Dress saveDress(Dress dress){
        return dressesRepository.save(dress);
    }*/

    public Dress saveDressWithImages(Dress dress, List<MultipartFile> images) throws IOException {
        List<String> urls = new ArrayList<>();

        // Upload each image to Cloudinary and collect the URLs
        for (MultipartFile file : images) {
            String url = cloudinaryService.uploadImage(file);
            urls.add(url);
        }

        // Set the list of URLs to the dress entity
        dress.setImageUrls(urls);

        return dressesRepository.save(dress);
    }

    //Whatsapp inquiry generation
    public String generateWhatsAppLink(Long dressId) {

        Dress dress = dressesRepository.findById(dressId)
                .orElseThrow(() -> new RuntimeException("Dress not found"));

        String phoneNumber = "919876543210";

        // Convert colors list to string
        String colors = String.join(", ", dress.getAvailableColors());

        String message = "Hi! I am interested in this dress:\n" +
                "Name: " + dress.getName() + "\n" +
                "Price: " + dress.getPrice() + "\n" +
                "Colors: " + colors;

        // Encode message properly
        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);

        return "https://wa.me/" + phoneNumber + "?text=" + encodedMessage;
    }
}
