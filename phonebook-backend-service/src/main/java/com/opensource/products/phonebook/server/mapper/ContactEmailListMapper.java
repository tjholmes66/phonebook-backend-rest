package com.opensource.products.phonebook.server.mapper;

import com.opensource.products.phonebook.server.domain.ContactEmailEntity;
import com.opensource.products.phonebook.server.dto.ContactEmailDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactEmailListMapper {

    List<ContactEmailDTO> entityListToDtoList(List<ContactEmailEntity> contactEmailEntityList);
    List<ContactEmailEntity> dtoListToEntityList(List<ContactEmailDTO> contactEmailDtoList);

}
