package com.opensource.products.phonebook.server.mapper;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.dto.ContactDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactListMapper {

    List<ContactDTO> entityListToDtoList(List<ContactEntity> contactEntityList);
    List<ContactEntity> dtoListToEntityList(List<ContactDTO> contactDtoList);

}
