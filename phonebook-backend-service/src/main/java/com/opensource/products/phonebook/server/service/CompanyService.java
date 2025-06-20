package com.opensource.products.phonebook.server.service;

import java.util.List;

import com.opensource.products.phonebook.server.domain.CompanyEntity;
import com.opensource.products.phonebook.server.dto.CompanyDTO;

public interface CompanyService
{

    // CREATE ==============================================================================

    public CompanyEntity ceateNewCompany(CompanyEntity company);
    public CompanyEntity add(CompanyEntity company);

    // RETRIEVE ============================================================================

    public CompanyEntity findById(long companyId);
    public CompanyDTO findDtoById(long companyId);
    public List<CompanyEntity> findAllCompanies();
    public List<CompanyDTO> getAllCompanys();
    public CompanyEntity getCompanyById(long companyId);

    // UPDATE ==============================================================================

    public CompanyEntity save(CompanyEntity companyEntity);
    public CompanyEntity update(CompanyEntity companyEntity);

    // DELETE ==============================================================================

    public void deleteById (long companyId);
    public void remove (long companyId);

}
