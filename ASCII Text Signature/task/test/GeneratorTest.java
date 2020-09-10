import org.hyperskill.hstest.stage.StageTest;
import signature.MainKt;

public abstract class GeneratorTest<T> extends StageTest<T> {
    public GeneratorTest() {
        super(MainKt.class);
    }
}
