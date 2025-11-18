package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.TravelClubApp;
import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    @PostMapping// localhost:8090/club
    public String register(@RequestBody TravelClubCdo travelClubCdo){
        return clubService.registerClub(travelClubCdo);
    }

    @GetMapping("/all")
    public List<TravelClub> findAll(){
        return clubService.findAll();
    }

    @GetMapping("/{clubId}")
    public TravelClub find(@PathVariable String clubId){
        return clubService.findClubById(clubId);
    }
}
