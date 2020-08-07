package dao;

import entity.Company;

import java.util.List;

public interface CompanyDAO {
    public List<Company> getAllCompanies();
    public  Company getCompany(String companyId);
    public  boolean saveCompany(Company company);
    public  boolean deleteCompany(String companyId);
    public  boolean updateCompany(Company company);
}
