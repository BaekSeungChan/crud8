package com.example.crud8.service.Impl;

import com.example.crud8.entity.One;
import com.example.crud8.entity.Two;
import com.example.crud8.payload.OneDto;
import com.example.crud8.payload.TwoDto;
import com.example.crud8.repository.TwoRepository;
import com.example.crud8.service.TwoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<TwoDto> getAllTwo(){
        List<Two> twos = twoRepository.findAll();

        return twos.stream().map((two) -> modelMapper.map(two, TwoDto.class)).collect(Collectors.toList());
    }

    @Override
    public TwoDto getTwoById(long id){
        Two two = twoRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(two, TwoDto.class);
    }

}
