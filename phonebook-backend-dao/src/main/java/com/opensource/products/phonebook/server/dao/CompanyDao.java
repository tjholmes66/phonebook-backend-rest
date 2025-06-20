package com.opensource.products.phonebook.server.dao;

import com.opensource.products.phonebook.server.domain.CompanyEntity;
import com.opensource.products.phonebook.server.domain.UserEntity;

import java.util.List;

public interface CompanyDao {

    public CompanyEntity createCompanyEntity(CompanyEntity companyEntity);

    public CompanyEntity updateCompanyEntity(CompanyEntity companyEntity);

    public void deleteCompanyEntity(long companyId);

    public void deleteCompanyEntity(CompanyEntity companyEntity);

    public List<CompanyEntity> getAllCompanyEntitys();

    public CompanyEntity getCompanyEntity(long id);

    public List<CompanyEntity> getCompanyEntity(CompanyEntity exampleEntity);

}
