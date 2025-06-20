package com.opensource.products.phonebook.server.mapper;

import com.opensource.products.phonebook.server.domain.ContactLinkEntity;
import com.opensource.products.phonebook.server.dto.ContactLinkDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactLinkListMapper {

    List<ContactLinkDTO> entityListToDtoList(List<ContactLinkEntity> contactLinkEntityList);
    List<ContactLinkEntity> dtoListToEntityList(List<ContactLinkDTO> contactLinkDtoList);

}
