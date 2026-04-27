package com.pnc.gamestore.services;

import com.pnc.gamestore.model.Platform;
import com.pnc.gamestore.repositories.PlatformsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlatformsService {
    @Autowired
    private PlatformsRepository platformsRepository;

    public Optional<Platform> findById(UUID id){
        return platformsRepository.findById(id);
    }
    public Optional<Platform> findByName(String name){
        return platformsRepository.findByName(name);
    }
    public List<Platform> findAll(){
        return platformsRepository.findAll();
    }
    public List<Platform> findByCompany(String company){
        return platformsRepository.findByCompany(company);
    }
    public void deleteById(UUID id){
        platformsRepository.deleteById(id);
    }

    public void save(Platform platform){
        platformsRepository.save(platform);
    }
}
