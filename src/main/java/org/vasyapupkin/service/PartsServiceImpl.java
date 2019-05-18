package org.vasyapupkin.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vasyapupkin.DAO.PartsDAO;
import org.vasyapupkin.model.Parts;

import java.util.List;

@Service
public class PartsServiceImpl implements PartsService {

    private PartsDAO partsDAO;

    public void setPartsDAO(PartsDAO partsDAO) {
        this.partsDAO = partsDAO;
    }

    @Override
    @Transactional
    public List<Parts> findAllByRelevanceAndPages(int page_id, int total, boolean relevance) {
        int startNumber = (page_id - 1) * 10;
        List<Parts> parts = partsDAO.findAllByRelevanceAndPages(startNumber, total, relevance);
        return partsDAO.findAllByRelevanceAndPages(startNumber, total, relevance);
    }

    @Override
    @Transactional
    public List<Parts> findAllByPages(int page_id, int total) {
        int startNumber = (page_id - 1) * 10;
        return partsDAO.findAllByPages(startNumber, total);
    }

    @Override
    @Transactional
    public int count() {
        return partsDAO.count();
    }

    @Override
    @Transactional
    public Parts findById(int id) {
        return partsDAO.findById(id);
    }

    @Override
    @Transactional
    public void update(Parts part) {
        partsDAO.update(part);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        partsDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Parts findByName(String name) {
        return partsDAO.findByName(name);
    }

    @Override
    @Transactional
    public void add(Parts part) {
        partsDAO.add(part);
    }
}
