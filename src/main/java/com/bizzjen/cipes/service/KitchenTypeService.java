package com.bizzjen.cipes.service;

import com.bizzjen.cipes.dto.KitchenTypeRequestDto;
import com.bizzjen.cipes.dto.KitchenTypeResponseDto;
import com.bizzjen.cipes.entity.KitchenType;
import com.bizzjen.cipes.exception.CipesClassNotFoundException;
import com.bizzjen.cipes.exception.ExceptionMessage;
import com.bizzjen.cipes.repository.KitchenTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class KitchenTypeService {

    private final KitchenTypeRepository kitchenTypeRepository;
    private final ModelMapper modelMapper;

    public KitchenTypeService(KitchenTypeRepository kitchenTypeRepository, ModelMapper modelMapper) {
        this.kitchenTypeRepository = kitchenTypeRepository;
        this.modelMapper = modelMapper;
    }

    public KitchenTypeResponseDto createKitchenType(KitchenTypeRequestDto kitchenTypeRequestDto) {
        KitchenType kitchenType = this.modelMapper.map(kitchenTypeRequestDto, KitchenType.class);
        return this.modelMapper.map(this.kitchenTypeRepository.save(kitchenType), KitchenTypeResponseDto.class);
    }

    public KitchenTypeResponseDto getKitchenTypeById(long kitchenTypeId) {
        Optional<KitchenType> kitchenType = kitchenTypeRepository.findById(BigDecimal.valueOf(kitchenTypeId));
        if(kitchenType.isEmpty()){
            throw new CipesClassNotFoundException(ExceptionMessage.NOT_FOUND.name());
        }
        return this.modelMapper.map(kitchenType.get(), KitchenTypeResponseDto.class);
    }
}
