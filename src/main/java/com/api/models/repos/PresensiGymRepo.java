package com.api.models.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.models.entities.PresensiGym;

public interface PresensiGymRepo extends JpaRepository<PresensiGym, String> {

    @Query("SELECT pg FROM PresensiGym pg WHERE pg.status = 'S'")
    public List<PresensiGym> findAllPresensiGym();

}
