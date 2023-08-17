package homework.model;

import static org.junit.Assert.*;

import homework.exceptions.CanNotCreateDrugFromLessThan3IngredientsException;
import homework.exceptions.IWouldNotRiskExpception;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LSDTest {

    Ingredient i1;
    Ingredient i2;
    Ingredient i3;
    LSD lsd;
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
        lsd = new LSD("TestName", list, DrugQuality.GOOD, 3);
    }

    @Test (expected = IWouldNotRiskExpception.class)
    public void shouldThrowExceptionWhenQualityOfDragIsPoor() {
        list = new ArrayList<>(Arrays.asList(i1, i2, i3));

        lsd = new LSD("TestName", list, DrugQuality.POOR, 3);
        lsd.checkDrug();
    }

    @Test
    public void shouldReturnPriceAs59WhenMadeOf3Ingredients() {
        list = new ArrayList<>(Arrays.asList(i1, i2, i3));
        lsd = new LSD("TestName", list, DrugQuality.GOOD, 3);

        assertEquals(59, lsd.countPrice(), 0.1);
    }


}