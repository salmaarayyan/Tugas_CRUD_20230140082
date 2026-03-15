package com.deploy.praktikum2.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ktp")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nomorKtp;

    private String namaLengkap;

    private String alamat;

    private LocalDate tanggalLahir;

    private String jenisKelamin;
}