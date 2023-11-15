package com.example.crud8.service;

import com.example.crud8.payload.OneDto;

import java.util.List;

public interface OneService {

    OneDto createOne(OneDto oneDto);

    List<OneDto> getAllOne();

    OneDto getOneById(long id);
}
