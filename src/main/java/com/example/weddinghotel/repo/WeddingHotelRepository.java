package com.example.weddinghotel.repo;

import com.example.weddinghotel.dto.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingHotelRepository extends MongoRepository<Hotel,String> {

    Hotel findWeddingHotelByName(String name);




}
