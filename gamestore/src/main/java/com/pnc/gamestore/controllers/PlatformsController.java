package com.pnc.gamestore.controllers;

import com.pnc.gamestore.model.Platform;
import com.pnc.gamestore.services.PlatformsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("platforms")
public class PlatformsController {
    @Autowired
    PlatformsService platformsService;

    @GetMapping
    public List<Platform> getPlatforms(){
        return platformsService.findAll();
    }
    @GetMapping("/name/{name}")
    public Optional<Platform> findByName(@PathVariable String name){
        return platformsService.findByName(name);
    }

    @GetMapping("/{id}")
    public Optional<Platform> findById(@PathVariable UUID id){
        return platformsService.findById(id);
    }

    @GetMapping("/company/{company}")
    public List<Platform> findByCompany(@PathVariable String company){
        return platformsService.findByCompany(company);
    }

    @PostMapping
    public void save(@RequestBody @Valid Platform platform){
        platformsService.save(platform);
    }

    @PutMapping
    public void savePlatforms(@RequestBody @Valid Platform platform){
        platformsService.save(platform);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        platformsService.deleteById(id);
    }

}
