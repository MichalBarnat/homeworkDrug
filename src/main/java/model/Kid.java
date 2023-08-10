package model;

import exceptions.TheKidIsAlreadyDeadException;

import java.util.ArrayList;
import java.util.List;

public class Kid {

    private String name;
    private String surname;
    private int age;

    private List<Drug> takenDrugs = new ArrayList<>();

    public Kid(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void buyDrug (Drug drug) {
        takenDrugs.add(drug);
        if(takenDrugs.size() > 5) {
            throw new TheKidIsAlreadyDeadException();
        }
    }


}
