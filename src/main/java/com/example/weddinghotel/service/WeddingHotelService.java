package com.example.weddinghotel.service;

import com.example.weddinghotel.dto.Hotel;
import com.example.weddinghotel.repo.WeddingHotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeddingHotelService {

    private WeddingHotelRepository hotelRepository;

    public WeddingHotelService(WeddingHotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void create(Hotel hotel){
        hotelRepository.save(hotel);
    }

   /* public Hotel findById(String id){
        return hotelRepository.findById(id).orElse(null);
    }

    */


    public List<Hotel> findAll(){
        return hotelRepository.findAll();
    }

    public void deleteById(String id){
        hotelRepository.deleteById(id);
    }








}
