package jdbc_carshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private int nr_rejestracyjny;
    private int przebieg;
    private String marka_i_model;
    private int rocznik;
    private String nazwisko;
    private String typ;

    public Car(String nr_rejestracyjny, int przebieg, String marka_i_model, int rocznik, String nazwisko, String typ) {
    }
}
