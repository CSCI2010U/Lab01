import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestTaylorSeries {

  @Test
  public void testExp() {
    // Test #1
    assertEquals(TaylorSeries.approximateExp(1, 10), 2.71828, 0.0001);

    // Test #2
    assertEquals(TaylorSeries.approximateExp(2, 10), 7.38871252, 0.0001);
  }
}
