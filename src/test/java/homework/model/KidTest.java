package homework.model;

import homework.exceptions.DrugNotExistException;
import homework.exceptions.TheKidIsAlreadyDeadException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

public class KidTest {

    Kid kid;
    @Mock
    LSD lsd1;
    @Mock
    LSD lsd2;
    @Mock
    MDMA mdma1;
    @Mock
    MDMA mdma2;
    @Mock
    Mephedrone mephedrone1;
    @Mock
    Mephedrone mephedrone2;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        kid = new Kid("John", "Johnson", 14);
    }

    @Test(expected = DrugNotExistException.class)
    public void shouldThrowExceptionWhenTheDrugKidWantToTakeDoesNotExist() {
        kid.buyDrug(null);
    }

    @Test (expected = TheKidIsAlreadyDeadException.class)
    public void shouldThrowExceptionWhenTheKidTake6thDrug(){
        kid.setTakenDrugs(Arrays.asList(lsd1, lsd2, mdma1, mdma2, mephedrone1));
        kid.buyDrug(mephedrone2);
    }

}