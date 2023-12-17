package daos;

import MainApp.ConnectionFactory;
import models.Cars;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DAO implements CarsDao {
    @Override
    public Cars findById(int idCars) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + idCars);

            if(rs.next())
            {
                Cars car = new Cars();

                car.setIdCars(rs.getInt("idCars") );
                car.setMake(rs.getString("make") );
                car.setModel(rs.getString("model") );
                car.setYear(rs.getInt("year") );
                car.setColor(rs.getString("color") );
                car.setVin(rs.getString("vin") );



                return car;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Cars> getAllCars() {
        List<Cars> car = new LinkedList<>();
        Connection connection = ConnectionFactory.getConnection();
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cars");

                while(rs.next()) {
                    Cars cars = new Cars();

                    cars.setIdCars(rs.getInt("idCars") );
                    cars.setMake(rs.getString("make") );
                    cars.setModel(rs.getString("model") );
                    cars.setYear(rs.getInt("year") );
                    cars.setColor(rs.getString("color") );
                    cars.setVin(rs.getString("vin") );

                    car.add(cars);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return car;
        }

    @Override
    public Cars update(Cars dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cars SET make=?, model=?, year=?, color=?, vin=? WHERE idCars=?");
            ps.setInt(1, dto.getIdCars());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setInt(4, dto.getYear());
            ps.setString(5, dto.getColor());
            ps.setString(6, dto.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return findById(dto.getIdCars());
            }

        } catch (SQLException ex) {
            System.out.println("Couldn't update");
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Cars create(Cars dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cars VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, dto.getIdCars());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setInt(4, dto.getYear());
            ps.setString(5, dto.getColor());
            ps.setString(6, dto.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return findById(dto.getIdCars());
            }

        } catch (SQLException ex) {
            System.out.println("Couldn't create");
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM cars WHERE id=" + id);

            if(i > 0) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
