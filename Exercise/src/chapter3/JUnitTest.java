package chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTest {
  @Test
  public void testAbs_Positive() {
    assertEquals(5, Math.abs(5));
  }

}
