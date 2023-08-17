package homework.model;

import homework.exceptions.CanNotCreateDrugFromLessThan3IngredientsException;
import homework.exceptions.IWouldNotRiskExpception;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MephedroneTest {

    Ingredient i1;
    Ingredient i2;
    Ingredient i3;
    Mephedrone mephedrone;
    List<Ingredient> list;

    @Before
    public void init() {
        i1 = new Ingredient("AAA", 6);
        i2 = new Ingredient("BBB", 10);
        i3 = new Ingredient("CCC", 25);
    }

    @Test(expected = CanNotCreateDrugFromLessThan3IngredientsException.class)
    public void shouldThrowExceptionWhenDrugIsMadeOfLessThan3Ingredients() {
        list = new ArrayList<>(Arrays.asList(i1, i2));
        mephedrone = new Mephedrone("TestName", list, DrugQuality.GOOD, "dizzy");
    }

    @Test (expected = IWouldNotRiskExpception.class)
    public void shouldThrowExceptionWhenQualityOfDragIsPoor() {
        list = new ArrayList<>(Arrays.asList(i1, i2, i3));

        mephedrone = new Mephedrone("TestName", list, DrugQuality.POOR, "dizzy");
        mephedrone.checkDrug();
    }

    @Test
    public void shouldReturnPriceAs49WhenMadeOf3Ingredients() {
        list = new ArrayList<>(Arrays.asList(i1, i2, i3));
        mephedrone = new Mephedrone("TestName", list, DrugQuality.GOOD, "dizzy");

        assertEquals(49, mephedrone.countPrice(), 0.1);
    }

}