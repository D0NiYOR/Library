package com.example.library.service;

import com.example.library.model.TakeAwayEntity;

import com.example.library.model.request.TakeAwayDto;
;
import com.example.library.model.response.TakeAwayResponseDto;

import com.example.library.repository.TakeAwayRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TakeAwayService {

    private final TakeAwayRepository takeAwayRepository;
    private final ModelMapper modelMapper;
    public TakeAwayResponseDto takeAway(TakeAwayDto takeAwayDto){
        return modelMapper.map(takeAwayRepository.save(modelMapper.map(takeAwayDto, TakeAwayEntity.class)), TakeAwayResponseDto.class);
    }
    public List<TakeAwayResponseDto> getAll() {
        List<TakeAwayEntity> takeAwayBooks = takeAwayRepository.findAll();
        return modelMapper.map(takeAwayBooks, new TypeToken<List<TakeAwayResponseDto>>(){}.getType());
    }
}
