package com.barapp.barapp.Service;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T, ID> {

    List<T> getAll();
    Optional<T> getOneById(ID id);
    Boolean deleteById(ID id);

}
