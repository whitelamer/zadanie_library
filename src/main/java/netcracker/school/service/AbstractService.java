package netcracker.school.service;


import netcracker.school.models.LibraryEntity;

import java.util.List;

public interface AbstractService<T extends LibraryEntity> {
    public T create(T object);

    public void update(T object);

    public List<T> getAll();
}
