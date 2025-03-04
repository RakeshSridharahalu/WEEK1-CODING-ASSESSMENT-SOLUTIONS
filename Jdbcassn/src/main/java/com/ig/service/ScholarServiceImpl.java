package com.ig.service;

import java.util.List;

import com.ig.dao.ScholarDao;
import com.ig.dao.ScholarDaoImpl;
import com.ig.model.Scholar;

public class ScholarServiceImpl implements ScholarService {
    ScholarDao scholarDao;

    @Override
    public void addScholar(Scholar scholar) throws Exception {
        scholarDao = new ScholarDaoImpl();
        scholarDao.addScholar(scholar);
    }

    @Override
    public List<Scholar> listAllScholars() throws Exception {
        scholarDao = new ScholarDaoImpl();
        return scholarDao.listAllScholars();
    }

    @Override
    public Scholar findScholarById(int id) throws Exception {
        scholarDao = new ScholarDaoImpl();
        return scholarDao.findScholarById(id);
    }

    @Override
    public void deleteScholarById(int id) throws Exception {
        scholarDao = new ScholarDaoImpl();
        scholarDao.deleteScholarById(id);
    }

    @Override
    public void updateScholarEmail(int id, String email) throws Exception {
        scholarDao = new ScholarDaoImpl();
        scholarDao.updateScholarEmail(id, email);
    }
}
