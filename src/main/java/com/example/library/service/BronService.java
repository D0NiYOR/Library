package com.example.library.service;

import com.example.library.model.BronEntity;
import com.example.library.model.request.BronDto;
import com.example.library.model.response.BronResponse;
import com.example.library.repository.BronRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BronService {
    private final BronRepository bronRepository;
    private final ModelMapper modelMapper;
    public String bron(BronDto bronDto){
        bronRepository.save(modelMapper.map(bronDto, BronEntity.class));
        return "saved";
    }

    public List<BronResponse> getAll() {
        List<BronEntity> brons = bronRepository.findAll();
        return modelMapper.map(brons, new TypeToken<List<BronResponse>>(){}.getType());
    }
}
