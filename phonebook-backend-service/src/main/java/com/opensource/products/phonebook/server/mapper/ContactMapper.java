package com.opensource.products.phonebook.server.mapper;

import com.opensource.products.phonebook.server.domain.ContactEntity;
import com.opensource.products.phonebook.server.dto.ContactDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactEntity dtoToEntity(ContactDTO source);
    ContactDTO entityToDTO(ContactEntity destination);
}
