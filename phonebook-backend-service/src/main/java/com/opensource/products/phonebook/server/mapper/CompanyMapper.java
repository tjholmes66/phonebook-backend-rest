package com.opensource.products.phonebook.server.mapper;

import com.opensource.products.phonebook.server.domain.CompanyEntity;
import com.opensource.products.phonebook.server.dto.CompanyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyEntity dtoToEntity(CompanyDTO source);
    CompanyDTO entityToDTO(CompanyEntity destination);
}
