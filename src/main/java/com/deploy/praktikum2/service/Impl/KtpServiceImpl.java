package com.deploy.praktikum2.service.Impl;

import com.deploy.praktikum2.mapper.KtpMapper;
import com.deploy.praktikum2.model.dto.KtpAddRequest;
import com.deploy.praktikum2.model.dto.KtpDto;
import com.deploy.praktikum2.model.entity.Ktp;
import com.deploy.praktikum2.repository.KtpRepository;
import com.deploy.praktikum2.service.KtpService;
import com.deploy.praktikum2.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private KtpMapper ktpMapper;

    @Override
    public KtpDto add(KtpAddRequest request) {

        ValidationUtil.validate(request);

        if(ktpRepository.findByNomorKtp(request.getNomorKtp()).isPresent()){
            throw new RuntimeException("Nomor KTP sudah ada");
        }

        Ktp ktp = ktpMapper.toEntity(request);

        ktpRepository.save(ktp);

        return ktpMapper.toDto(ktp);
    }

    @Override
    public List<KtpDto> getAll() {

        return ktpRepository.findAll()
                .stream()
                .map(ktpMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getById(Integer id) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        return ktpMapper.toDto(ktp);
    }

    @Override
    public KtpDto update(Integer id, KtpAddRequest request) {

        ValidationUtil.validate(request);

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        ktp.setNomorKtp(request.getNomorKtp());
        ktp.setNamaLengkap(request.getNamaLengkap());
        ktp.setAlamat(request.getAlamat());
        ktp.setTanggalLahir(request.getTanggalLahir());
        ktp.setJenisKelamin(request.getJenisKelamin());

        ktpRepository.save(ktp);

        return ktpMapper.toDto(ktp);
    }

    @Override
    public void delete(Integer id) {

        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        ktpRepository.delete(ktp);
    }
}
