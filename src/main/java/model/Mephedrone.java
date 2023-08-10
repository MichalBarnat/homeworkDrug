package model;

import service.DrugController;

import java.util.List;

public class Mephedrone extends Drug{

    private String madeFace;


    public Mephedrone(String name, List<Ingredient> ingredients, DrugController drugController, String madeFace) {
        super(name, ingredients, drugController);
        this.madeFace = madeFace;
    }
}
