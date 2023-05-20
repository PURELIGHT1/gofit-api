package com.api.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.models.entities.Instruktur;
import com.api.models.entities.JadwalHarian;

import java.util.Date;
import java.util.List;

public interface JadwalHarianRepo extends JpaRepository<JadwalHarian, String> {

    @Query("select j from JadwalHarian j where j.instruktur = ?1")
    public List<JadwalHarian> findJadwalIns(Instruktur ins);

    @Query("select j from JadwalHarian j where j.tglJadwal between ?1 and ?2")
    public List<JadwalHarian> findJadwalSatuMinggu(Date tglAwal, Date tglAkhir);

    @Query("select j from JadwalHarian j where j.tglJadwal between ?1 and ?2 and j.instruktur = ?3")
    public List<JadwalHarian> findJadwalSatuMingguByInstruktur(Date tglAwal, Date tglAkhir, Instruktur ins);

    @Query("select j from JadwalHarian j where j.tglJadwal between ?1 and ?2 and j.instrukturPeganti = ?3")
    public List<JadwalHarian> findJadwalSatuMingguByInstrukturPegganti(Date tglAwal, Date tglAkhir, Instruktur ins);

    @Query("select j from JadwalHarian j where j.hariJadwal LIKE ?1%")
    public List<JadwalHarian> findByNama(String hari);

    @Query("select j from JadwalHarian j where j.tglJadwal =?1")
    public List<JadwalHarian> findJadwalPerhari(Date hariIni);

    // @Query("select j from JadwalHarian j where CAST(j.tglJadwal as text) =?1 and
    // j.status =?2 and j.hariJadwal =?4 and CAST(j.instruktur as text) =?4")
    // public List<JadwalHarian> findJadwalPresensi(String hariIni, String status,
    // String hari, String ins);

    @Query("select j from JadwalHarian j where CAST(j.tglJadwal as text) =?1 and j.status =?2 and j.sesiJadwal =?3 and j.hariJadwal =?4 and CAST(j.instruktur as text) =?5")
    public JadwalHarian findJadwalPresensi(String hariIni, String status, Integer sesi, String hari, String ins);

    @Query("select j from JadwalHarian j where j.tglJadwal =?1 and j.hariJadwal = ?2 order by j.sesiJadwal asc")
    public List<JadwalHarian> findAllBookingGymByDate(Date date, String hari);

    @Query("select j from JadwalHarian j where j.tglJadwal = ?1 and j.hariJadwal = ?3 and (j.hariJadwal LIKE ?2% or CAST(j.sesiJadwal as text) LIKE ?2% or j.status LIKE ?2%) order by j.sesiJadwal asc")
    public List<JadwalHarian> findAllBookingGymByDateAndCari(Date date, String cari, String hari);

}
