package com.opensource.products.phonebook.server.mapper;

import com.opensource.products.phonebook.server.domain.ContactPhoneEntity;
import com.opensource.products.phonebook.server.dto.ContactPhoneDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactPhoneListMapper {
    
    List<ContactPhoneDTO> entityListToDtoList(List<ContactPhoneEntity> contactPhoneEntityList);
    List<ContactPhoneEntity> dtoListToEntityList(List<ContactPhoneDTO> contactPhoneDtoList);
        
}
