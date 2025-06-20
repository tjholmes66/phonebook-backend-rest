package com.opensource.products.phonebook.server.mapper;

import com.opensource.products.phonebook.server.domain.CompanyEntity;
import com.opensource.products.phonebook.server.dto.CompanyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyListMapper {

    List<CompanyDTO> entityListToDtoList(List<CompanyEntity> CompanyEntityList);
    List<CompanyEntity> dtoListToEntityList(List<CompanyDTO> CompanyDtoList);

}
