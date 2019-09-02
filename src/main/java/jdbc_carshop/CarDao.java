package jdbc_carshop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static jdbc_carshop.CarsQueries.*;

public class CarDao {
   private MysqlConnection mysqlConnection;

   public CarDao() throws IOException, SQLException {
       mysqlConnection = new MysqlConnection();
           createTableIfNotExists();

   }

   private void createTableIfNotExists() throws SQLException {
       try (Connection connection = mysqlConnection.getConnection()) {
           try (PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_QUERY)) {
               statement.execute();
           }

       }

   }



   public void insertCar(Car car) throws SQLException{
       try (Connection connection = mysqlConnection.getConnection()){
           try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)){
               statement.setInt(1, car.getNr_rejestracyjny());
               statement.setInt(2, car.getPrzebieg());
               statement.setString(3, car.getMarka_i_model());
               statement.setInt(4, car.getRocznik());
               statement.setString(5, car.getNazwisko());
               statement.setString(6, car.getTyp());

               boolean areThereAnyResultData = statement.execute();

               ResultSet resultSet = statement.getGeneratedKeys();
               if (resultSet.next()){
                   Long generatedId = resultSet.getLong(1);
                   System.out.println("Został utworzony rekord o identyfikatorze" + generatedId);
               }
           }
       }
   }

   public Optional<Car> getByIdCar(Long searchedId) throws SQLException{
       try (Connection connection = mysqlConnection.getConnection()){
           try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)){
               statement.setLong(1, searchedId);

               ResultSet resultSet = statement.executeQuery();

               if (resultSet.next()){
                   Car car = loadCarFromResultSet(resultSet);

                   return Optional.of(car);
               }
           }
       }
       return Optional.empty();
   }

   private void loadMultipleCarsFromResultSet (List<Car> carList, ResultSet resultSet) throws SQLException{
       while (resultSet.next()){
           Car car = loadCarFromResultSet(resultSet);

           carList.add(car);
       }
   }


   private Car loadCarFromResultSet(ResultSet resultSet) throws SQLException{
       Car car = new Car();

       car.setId(resultSet.getInt(1));
       car.setNr_rejestracyjny(resultSet.getInt(2));
       car.setPrzebieg(resultSet.getInt(3));
       car.setMarka_i_model(resultSet.getString(4));
       car.setRocznik(resultSet.getInt(5));
       car.setNazwisko(resultSet.getString(6));
       car.setTyp(resultSet.getString(7));
       return car;
   }

}
