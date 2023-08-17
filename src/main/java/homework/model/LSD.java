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
public class LSD extends Drug implements DrugContollerInterface {

    private int numberOfDragons;


    public LSD(String name, List<Ingredient> ingredients, DrugQuality drugQuality, int numberOfDragons) {
        super(name, ingredients, drugQuality);
        this.numberOfDragons = numberOfDragons;
    }

    @Override
    public double countPrice() {
        return 50 + (3 * getIngredients().size());
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
