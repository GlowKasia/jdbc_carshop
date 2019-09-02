package jdbc_carshop;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final String DB_HOST = "127.0.0.1"; // 127.0.0.1
    private static final String DB_PORT = "13306";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
    private static final String DB_NAME = "jdbc_carshop";

    public static void main(String[] args){
        CarDao carDao = null;
        try {
            carDao = new CarDao();
        } catch (IOException e) {
            System.err.println("Car dao cannot be created. Mysql error.");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        String komenda;
        do {
            komenda = scanner.nextLine();
            if (komenda.equalsIgnoreCase("wstaw")){
                System.out.println("Nr_rejestracyjny:");
                String nr_rejestracyjny = scanner.nextLine();
                System.out.println("Przebieg:");
                int przebieg = Integer.parseInt(scanner.nextLine());
                System.out.println("Marka i model");
                String marka_i_model = scanner.nextLine();
                System.out.println("Rocznik:");
                int rocznik = Integer.parseInt(scanner.nextLine());
                System.out.println("Nazwisko:");
                String nazwisko = scanner.nextLine();
                System.out.println("Typ:");
                String typ = scanner.nextLine();

                Car car = new Car(nr_rejestracyjny, przebieg, marka_i_model, rocznik, nazwisko,typ);
                try {
                    carDao.insertCar(car);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if (komenda.equalsIgnoreCase("usun")){
                System.out.println("Podaj id:");
                int Id = Integer.parseInt(scanner.nextLine());
            }
        }while (!komenda.equalsIgnoreCase("quit"));
    }
}

