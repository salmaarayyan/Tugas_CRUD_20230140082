package com.deploy.praktikum2.mapper;

import com.deploy.praktikum2.model.dto.KtpAddRequest;
import com.deploy.praktikum2.model.dto.KtpDto;
import com.deploy.praktikum2.model.entity.Ktp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface KtpMapper {

    KtpMapper INSTANCE = Mappers.getMapper(KtpMapper.class);

    KtpDto toDto(Ktp ktp);

    Ktp toEntity(KtpAddRequest request);

}
