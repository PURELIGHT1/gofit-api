package com.api.models.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.models.entities.BookingKelas;
import com.api.models.entities.JadwalHarian;

public interface BookingKelasRepo extends JpaRepository<BookingKelas, String> {

    @Query("SELECT bk FROM BookingKelas bk WHERE bk.jadwal = ?1")
    public List<BookingKelas> findAllBookingKelasJadwal(JadwalHarian jadwal);
}
