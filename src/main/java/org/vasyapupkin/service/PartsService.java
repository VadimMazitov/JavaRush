package org.vasyapupkin.service;

import org.vasyapupkin.model.Parts;

import java.util.List;

public interface PartsService {

    public Parts findById(int id);

    public void update(Parts part);

    public void deleteById(int id);

    public Parts findByName(String name);

    public void add(Parts part);

    public List<Parts> findAllByPages(int page_id, int total);

    public List<Parts> findAllByRelevanceAndPages(int page_id, int total, boolean relevance);

    public int count();

}
