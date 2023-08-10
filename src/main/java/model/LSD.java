package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import service.DrugController;

import java.util.List;

@Getter
@Setter
@ToString
public class LSD extends Drug{

    private int numberOfDragons;


    public LSD(String name, List<Ingredient> ingredients, DrugController drugController, int numberOfDragons) {
        super(name, ingredients, drugController);
        this.numberOfDragons = numberOfDragons;
    }

    @Override
    public double countPrice() {
        return 50 + (3 * getIngredients().size());
    }
}
