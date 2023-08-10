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
public class Drug {

    private DrugController drugController;

    private final String name;
    private double pricePerGram;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Drug(String name, List<Ingredient> ingredients, DrugController drugController) {
        this.name = name;
        pricePerGram = countPrice();
        this.ingredients = ingredients;
        if(ingredients.size() < 3) {
            throw new CanNotCreateDrugFromLessThan3IngredientsException();
        }
        this.drugController = drugController;
    }

    public double countPrice(){
        return 0;
    };

    public void checkDrug(Drug drug) {
        if (drugController.getQuality() == DrugQuality.POOR) {
            throw new IWouldNotRiskExpception();
        } else {
            System.out.println("Go ahead!");
        }
    }
}
