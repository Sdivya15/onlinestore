package com.onlineshop.dresses.service;


import com.onlineshop.dresses.model.Dress;
import com.onlineshop.dresses.repository.DressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class DressService {

    @Autowired
    private DressesRepository dressesRepository;

    //Getting all dresses for the catalog
    public List<Dress> getAllDresses(){
        return dressesRepository.findAll();
    }

    //Filter by category
    public List<Dress> getDressesByCategory(String category){
        return dressesRepository.findByCategory_CategoryType(category);
    }

    //save a new dress
    public Dress saveDress(Dress dress){
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
