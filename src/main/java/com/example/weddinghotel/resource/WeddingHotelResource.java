package com.example.weddinghotel.resource;

import com.example.weddinghotel.dto.Response;
import com.example.weddinghotel.dto.Hotel;
import com.example.weddinghotel.repo.WeddingHotelRepository;
import com.example.weddinghotel.service.WeddingHotelService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@CrossOrigin("*")
public class WeddingHotelResource {

    private WeddingHotelService hotelService;
    private WeddingHotelRepository weddingHotelRepository;



    public WeddingHotelResource(WeddingHotelService hotelService,WeddingHotelRepository weddingHotelRepository) {
        this.hotelService = hotelService;
        this.weddingHotelRepository = weddingHotelRepository;
    }

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody Hotel hotel) {
        hotelService.create(hotel);
        return ResponseEntity.ok().body(new Response(HttpStatus.CREATED, "Hotel is created"));
    }

    @GetMapping
    public List<Hotel> findAll() {
        return hotelService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> remove(@PathVariable String id) {
        hotelService.deleteById(id);
        return ResponseEntity.ok().body(new Response(HttpStatus.OK, "successfully removed"));

    }

    @GetMapping("{name}")
    public Hotel findHotelByName(@PathVariable  String name){
     return this.weddingHotelRepository.findWeddingHotelByName(name);

    }

    @PatchMapping("/edit/{name}")
    public Hotel hotelEdit (@PathVariable("name") String name, @RequestBody Hotel hoteledit){

        Hotel hotel1 = this.weddingHotelRepository.findWeddingHotelByName(name);
        hotel1.setName(hoteledit.getName());
        hotel1.setPhone(hoteledit.getPhone());
        hotel1.setImage(hoteledit.getImage());
        hotel1.setAddress(hoteledit.getAddress());
        hotel1.setPackages(hoteledit.getPackages());
        this.weddingHotelRepository.save(hotel1);
        return hotel1;
    }

}
