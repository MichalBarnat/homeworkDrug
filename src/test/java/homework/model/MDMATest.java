package homework.model;

import homework.exceptions.CanNotCreateDrugFromLessThan3IngredientsException;
import homework.exceptions.IWouldNotRiskExpception;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MDMATest {

    Ingredient i1;
    Ingredient i2;
    Ingredient i3;
    MDMA mdma;
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
        mdma = new MDMA("TestName", list, DrugQuality.GOOD, 1);
    }

    @Test (expected = IWouldNotRiskExpception.class)
    public void shouldThrowExceptionWhenQualityOfDragIsPoor() {
        list = new ArrayList<>(Arrays.asList(i1, i2, i3));

        mdma = new MDMA("TestName", list, DrugQuality.POOR, 1);
        mdma.checkDrug();
    }

    @Test
    public void shouldReturnPriceAs69WhenMadeOf3Ingredients() {
        list = new ArrayList<>(Arrays.asList(i1, i2, i3));
        mdma = new MDMA("TestName", list, DrugQuality.GOOD, 1);

        assertEquals(69, mdma.countPrice(), 0.1);
    }

}