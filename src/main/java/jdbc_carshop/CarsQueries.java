package jdbc_carshop;

public class CarsQueries {
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `carshop`(\n" +
            " `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
            " `nr_rejestracyjny` INT NOT NULL,\n" +
            " `przebieg` INT NOT NULL,\n" +
            " `marka_i_model` VARCHAR (100) NOT NULL,\n" +
            " `rocznik` INT NOT NULL\n" +
            " `nazwisko` VARCHAR (50) NOT NULL\n" +
            " `typ` VARCHAR (50) NOT NULL\n" +
            ")";;
    public static final String INSERT_QUERY = "INSERT INTO `carshop` \n" +
            "(`nr_rejestracyjny`, `przebieg`, `marka_i_model`, `rocznik`, `nazwisko`, `typ`) \n" +
            "VALUES\n" +
            "( ? , ? , ? , ? , ? , ?);";

    public static final String SELECT_BY_ID_QUERY = "SELECT FROM `carshop` WHERE `id` = ?";

//    public static final String


    public static final String DELETE_QUERY_BY_ID = "DELETE FROM `carschop` WHERE `id` = ?";
    String DELETE_QUERY_BY_NR = "DELETE FROM `carshop` WHERE `id` = ?";
}
