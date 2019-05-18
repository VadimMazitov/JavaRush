package org.vasyapupkin.DAO;

import org.vasyapupkin.model.Parts;

import java.util.List;

public interface PartsDAO {

    public Parts findById(int id);

    public void deleteById(int id);

    public void update(Parts parts);

    public void add(Parts parts);

    public Parts findByName(String name);

    public List<Parts> findAllByPages(int page_id, int total);

    public List<Parts> findAllByRelevanceAndPages(int page_id, int total, boolean relevance);

    public int count();

}
