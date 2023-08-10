package model;

import exceptions.CanNotCreateDrugFromLessThan3IngredientsException;
import exceptions.IWouldNotRiskExpception;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import service.DrugController;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public abstract class Drug implements DrugController {

    //private DrugController drugController;
    private DrugQuality drugQuality;

    private final String name;
    private double pricePerGram;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Drug(String name, List<Ingredient> ingredients, DrugQuality drugQuality) {
        this.name = name;
        pricePerGram = countPrice();
        this.ingredients = ingredients;
        if(ingredients.size() < 3) {
            throw new CanNotCreateDrugFromLessThan3IngredientsException();
        }
        this.drugQuality = drugQuality;
        //this.drugController = drugController;
    }

    public abstract double countPrice();

    public abstract void checkDrug();

//    public  void checkDrug(Drug drug) {
//        if (drugQuality == DrugQuality.POOR) {
//            throw new IWouldNotRiskExpception();
//        } else {
//            System.out.println("Go ahead!");
//        }
//    }
}
