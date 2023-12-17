package daos;

import models.Cars;

import java.util.List;
import java.util.Set;

public interface CarsDao {
    Cars findById(int idCars);

    List<Cars> getAllCars();

    Cars update(Cars dto);

    Cars create(Cars dto);
    boolean delete(int id);

}
