package model;

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


    public MDMA(String name, List<Ingredient> ingredients, DrugController drugController, int highDuration) {
        super(name, ingredients, drugController);
        this.highDuration = highDuration;
    }
}
