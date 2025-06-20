package com.opensource.products.phonebook.server.service;

import com.opensource.products.phonebook.server.dao.CompanyDao;
import com.opensource.products.phonebook.server.domain.CompanyEntity;
import com.opensource.products.phonebook.server.dto.CompanyDTO;
import com.opensource.products.phonebook.server.mapper.CompanyListMapper;
import com.opensource.products.phonebook.server.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService
{
    private CompanyDao companyDao;
    private CompanyMapper companyMapper;
    private CompanyListMapper companyListMapper;

    public CompanyServiceImpl(CompanyDao companyDao, CompanyMapper companyMapper, CompanyListMapper companyListMapper)
    {
        this.companyDao = companyDao;
        this.companyMapper = companyMapper;
        this.companyListMapper = companyListMapper;
    }

    // CREATE ==============================================================================

    @Override
    public CompanyEntity ceateNewCompany(CompanyEntity company)
    {
        CompanyEntity companyEntity = companyDao.createCompanyEntity(company);
        return companyEntity;
    }

    @Override
    public CompanyEntity add(CompanyEntity company)
    {
        CompanyEntity companyEntity = companyDao.createCompanyEntity(company);
        return companyEntity;
    }

    // RETRIEVE ============================================================================

    @Override
    public CompanyEntity findById(long companyId)
    {
        CompanyEntity companyEntity = companyDao.getCompanyEntity(companyId);
        return companyEntity;
    }

    @Override
    public CompanyDTO findDtoById(long companyId)
    {
        CompanyEntity companyEntity = companyDao.getCompanyEntity(companyId);
        CompanyDTO companyDto = companyMapper.entityToDTO(companyEntity);
        return companyDto;
    }

    @Override
    public List<CompanyEntity> findAllCompanies()
    {
        return companyDao.getAllCompanyEntitys();
    }

    @Override
    public List<CompanyDTO> getAllCompanys()
    {
        List<CompanyEntity> companyEntityList = companyDao.getAllCompanyEntitys();
        List<CompanyDTO> companyDtoList = companyListMapper.entityListToDtoList(companyEntityList);
        return companyDtoList;
    }

    @Override
    public CompanyEntity getCompanyById(long companyId)
    {
        CompanyEntity companyEntity = companyDao.getCompanyEntity(companyId);
        return companyEntity;
    }

    // UPDATE ==============================================================================

    @Override
    public CompanyEntity save(CompanyEntity companyEntity)
    {
        return companyDao.createCompanyEntity(companyEntity);
    }

    @Override
    public CompanyEntity update(CompanyEntity companyEntity) {
        return companyDao.updateCompanyEntity(companyEntity);
    }

        // DELETE ==============================================================================

        @Override
        public void deleteById (long companyId)
        {
            companyDao.deleteCompanyEntity(companyId);
        }

        @Override
        public void remove (long companyId)
        {
            companyDao.deleteCompanyEntity(companyId);
        }

    }
