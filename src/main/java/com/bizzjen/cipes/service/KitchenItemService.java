package com.bizzjen.cipes.service;

import com.bizzjen.cipes.dto.KitchenItemRequestDto;
import com.bizzjen.cipes.dto.KitchenItemResponseDto;
import com.bizzjen.cipes.entity.KitchenItem;
import com.bizzjen.cipes.repository.KitchenItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class KitchenItemService {

    private final KitchenItemRepository kitchenItemRepository;
    private final ModelMapper modelMapper;

    public KitchenItemService(KitchenItemRepository kitchenItemRepository, ModelMapper modelMapper) {
        this.kitchenItemRepository = kitchenItemRepository;
        this.modelMapper = modelMapper;
    }

    public KitchenItemResponseDto createKitchenItem(KitchenItemRequestDto kitchenItemDto) {
        KitchenItem kitchenItem = this.modelMapper.map(kitchenItemDto, KitchenItem.class);
        return this.modelMapper.map(this.kitchenItemRepository.save(kitchenItem), KitchenItemResponseDto.class);
    }

    public KitchenItemResponseDto getKitchenItemById(long id) {
        //todo check empty if empty throw error
        KitchenItem kitchenItem = this.kitchenItemRepository.findById(id).get();
        return this.modelMapper.map(kitchenItem, KitchenItemResponseDto.class);
    }
}
