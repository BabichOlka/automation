package com.solvd.automation.lab.sql.dao;
import com.solvd.automation.lab.model.Wheels;

import java.util.List;

public interface WheelsDAO {
    void create(Wheels wheels);
    void update(Wheels wheels);
    void delete(Wheels wheels);

    Wheels getById(int id);
    List<Wheels> getAll();
}