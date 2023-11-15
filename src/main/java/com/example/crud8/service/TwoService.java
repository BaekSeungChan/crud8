package com.example.crud8.service;

import com.example.crud8.payload.OneDto;
import com.example.crud8.payload.TwoDto;

import java.util.List;


public interface TwoService {
    TwoDto createTwo(TwoDto twoDto);

    List<TwoDto> getAllTwo();

    TwoDto getTwoById(long id);

}
