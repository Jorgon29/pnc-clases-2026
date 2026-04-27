package com.pnc.gamestore.repositories;

import com.pnc.gamestore.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlatformsRepository extends JpaRepository<Platform, UUID> {
    public Optional<Platform> findByName(String name);
    public List<Platform> findByCompany(String company);
}
