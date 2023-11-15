package com.example.crud8.service;


import com.example.crud8.payload.TwoDto;

import java.util.List;


public interface TwoService {
    TwoDto createTwo(TwoDto twoDto);

    List<TwoDto> getAllTwo();

    TwoDto getTwoById(long id);

    void deleteTwoById(long id);

    TwoDto updateTwo(TwoDto twoDto, long id);

}
