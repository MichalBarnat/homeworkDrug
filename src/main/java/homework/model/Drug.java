package homework.model;

import homework.exceptions.CanNotCreateDrugFromLessThan3IngredientsException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public abstract class Drug {

    private DrugQuality drugQuality;

    private final String name;
    private double pricePerGram;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Drug(String name, List<Ingredient> ingredients, DrugQuality drugQuality) {
        if(ingredients.size() < 3) {
            throw new CanNotCreateDrugFromLessThan3IngredientsException();
        }
        this.name = name;
        pricePerGram = countPrice();
        this.ingredients = ingredients;
        this.drugQuality = drugQuality;
    }

    public abstract double countPrice();
}
