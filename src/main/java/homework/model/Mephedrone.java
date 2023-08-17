package homework.model;

import homework.exceptions.IWouldNotRiskExpception;
import homework.interfaces.DrugContollerInterface;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

public class Mephedrone extends Drug implements DrugContollerInterface {

    private String madeFace;

    public Mephedrone(String name, List<Ingredient> ingredients, DrugQuality drugQuality, String madeFace) {
        super(name, ingredients, drugQuality);
        this.madeFace = madeFace;
    }

    @Override
    public double countPrice() {
        return 40 + (3 * getIngredients().size());
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
