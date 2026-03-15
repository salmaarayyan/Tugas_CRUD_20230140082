package com.deploy.praktikum2.service;

import com.deploy.praktikum2.model.dto.KtpAddRequest;
import com.deploy.praktikum2.model.dto.KtpDto;

import java.util.List;

public interface KtpService {

    KtpDto add(KtpAddRequest request);

    List<KtpDto> getAll();

    KtpDto getById(Integer id);

    KtpDto update(Integer id, KtpAddRequest request);

    void delete(Integer id);

}
