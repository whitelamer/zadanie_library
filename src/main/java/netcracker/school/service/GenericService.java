package netcracker.school.service;


import netcracker.school.models.ModelsForDAO;

import java.util.List;

public interface GenericService<T extends ModelsForDAO> {
    public T create(T object);

    public void update(T object);

    public List<T> getAll();
}
