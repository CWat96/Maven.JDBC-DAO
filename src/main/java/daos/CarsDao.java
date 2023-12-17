package daos;

import models.Cars;

import java.util.Set;

public interface CarsDao {
    Cars getCars();
    Set<Cars> getAllCars();
    Cars getCarsMakeAndModel();
    boolean insertCars();
    boolean updateCars();
    boolean deleteCars();
}
