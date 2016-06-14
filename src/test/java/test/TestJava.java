package test;

import org.junit.Test;

/**
 * TestJava by Mislead on 2016/5/27.
 */
public class TestJava {

  @Test public void testForLoop() {
    for (int i = 0, n = getCount(5); i < n; i++) {
      System.out.println("" + i);
    }
  }

  private int getCount(int step) {
    System.out.println("get count");
    return step < 5 ? step + 1 : 5;
  }
}
