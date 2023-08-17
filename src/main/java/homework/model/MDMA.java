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
public class MDMA extends Drug implements DrugContollerInterface {

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
