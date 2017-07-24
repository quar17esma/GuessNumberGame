import com.sergii.shutyi.InitialConstants;
import com.sergii.shutyi.Model;
import org.junit.Assert;
import org.junit.Test;

public class TestModel {

    @Test
    public void testPickSecretNumberNotIncludeFloor(){
        Model model = new Model();
        for (int i = 0; i < 5000; i++) {
            model.pickSecretNumber();
            Assert.assertFalse(model.getSecretNumber() == InitialConstants.INITIAL_BARRIER_FLOOR);
        }
    }

    @Test
    public void testPickSecretNumberNotIncludeCeil(){
        Model model = new Model();
        for (int i = 0; i < 5000; i++) {
            model.pickSecretNumber();
            Assert.assertFalse(model.getSecretNumber() == InitialConstants.INITIAL_BARRIER_CEIL);
        }
    }

    @Test
    public void testPickSecretNumberIncludeFloorPlusOne(){
        Model model = new Model();
        for (int i = 0; i < 5000; i++) {
            model.pickSecretNumber();
            if (model.getSecretNumber() == (InitialConstants.INITIAL_BARRIER_FLOOR + 1)){
                Assert.assertEquals(InitialConstants.INITIAL_BARRIER_FLOOR + 1, model.getSecretNumber());
            }

        }
    }

    @Test
    public void testPickSecretNumberIncludeCeilMinusOne(){
        Model model = new Model();
        for (int i = 0; i < 5000; i++) {
            model.pickSecretNumber();
            if (model.getSecretNumber() == (InitialConstants.INITIAL_BARRIER_CEIL - 1)){
                Assert.assertEquals(InitialConstants.INITIAL_BARRIER_CEIL - 1, model.getSecretNumber());
            }
        }
    }


}
