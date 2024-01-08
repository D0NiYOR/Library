package com.example.library.service;

import com.example.library.model.BookEntity;
import com.example.library.model.RowEntity;
import com.example.library.model.ShelfEntity;
import com.example.library.model.response.RowResponse;
import com.example.library.model.response.ShelfResponse;
import com.example.library.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RowService {

    private final ShelfRepository shelfRepository;
    private final RowRepository rowRepository;
    private final BookRepository bookRepository;

    public List<ShelfResponse> getShelfInfos(UUID floorId){
        List<ShelfResponse> shelfResponses = new ArrayList<>();
        List<ShelfEntity> allByFloorId = shelfRepository.findAllByFloorId(floorId);
        for (ShelfEntity shelfEntity : allByFloorId) {
            for (RowEntity rowEntity : rowRepository.findAllByShelfId(shelfEntity.getId())) {
              ShelfResponse shelfResponse = new ShelfResponse();
                shelfResponse.setBoshJoy(boshJoyByRow(rowEntity.getId()));
                shelfResponse.setShelfNumber(shelfEntity.getNumber());
                shelfResponse.setRowNumber(rowEntity.getNumber());
              shelfResponses.add(shelfResponse);
            }
        }
       return shelfResponses;
    }

    public int  boshJoyByRow(UUID rowId){
        List<BookEntity> allByRowId = bookRepository.findAllByRowId(rowId);
        return 20-allByRowId.size();

    }


    public boolean boshmi(UUID rowId){
        List<BookEntity> all = bookRepository.findAll();
        for (BookEntity bookEntity : all) {
           if(bookEntity.getRowId().equals(rowId)){
                return false;
            }
        }
     return true;
    }

}
