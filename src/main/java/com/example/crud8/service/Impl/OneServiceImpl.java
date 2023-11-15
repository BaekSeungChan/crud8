package com.example.crud8.service.Impl;

import com.example.crud8.entity.One;
import com.example.crud8.payload.OneDto;
import com.example.crud8.repository.OneRepository;
import com.example.crud8.service.OneService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OneServiceImpl implements OneService {

    private OneRepository oneRepository;
    private ModelMapper modelMapper;

    public OneServiceImpl(OneRepository oneRepository, ModelMapper modelMapper){
        this.oneRepository = oneRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OneDto createOne(OneDto oneDto){
        One one = modelMapper.map(oneDto, One.class);

        One saveOne = oneRepository.save(one);

        return modelMapper.map(saveOne, OneDto.class);
    }
}
