package sql.dao;



import sql.model.Attribute;

import java.util.List;

public interface AttributeDAO {
    void create(Attribute attribute);
    void update(Attribute attribute);
    void delete(Attribute attribute);

    Attribute getById(int id);
    List<Attribute> getAll();
}
