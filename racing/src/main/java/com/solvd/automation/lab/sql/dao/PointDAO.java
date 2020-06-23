package com.solvd.automation.lab.sql.dao;




import com.solvd.automation.lab.model.Point;

import java.util.List;

public interface PointDAO {
    void create(Point point);
    void update(Point point);
    void deleteById(int id);

    Point getById(int id);
    List<Point> getAll();
}