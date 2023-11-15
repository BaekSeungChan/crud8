package com.example.crud8.service.Impl;

import com.example.crud8.entity.Two;
import com.example.crud8.payload.TwoDto;
import com.example.crud8.repository.TwoRepository;
import com.example.crud8.service.TwoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TwoServiceImpl implements TwoService {
    private TwoRepository twoRepository;
    private ModelMapper modelMapper;

    public TwoServiceImpl(TwoRepository twoRepository, ModelMapper modelMapper){
        this.twoRepository = twoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TwoDto createTwo(TwoDto twoDto){
        Two two = modelMapper.map(twoDto, Two.class);

        Two saveTwo = twoRepository.save(two);

        return modelMapper.map(saveTwo, TwoDto.class);
    }

}
