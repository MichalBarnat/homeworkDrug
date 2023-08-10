package model;

import exceptions.IWouldNotRiskExpception;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import service.DrugController;

import java.util.List;

@Getter
@Setter
@ToString
public class MDMA extends Drug{

    private int highDuration;


    public MDMA(String name, List<Ingredient> ingredients, DrugQuality drugQuality, int highDuration) {
        super(name, ingredients, drugQuality);
        this.highDuration = highDuration;
    }

    @Override
    public double countPrice() {
        return 60 + (3 * getIngredients().size());
    }

    @Override
    public void checkDrug() {
        if (getDrugQuality() == DrugQuality.POOR) {
            throw new IWouldNotRiskExpception();
        } else {
            System.out.println("Go ahead!");
        }
    }
}
