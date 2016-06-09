package cs3500.lec08;

import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * Created by zhaoxinhong on 5/25/16.
 */
public class TestController3 {

  @Test
  public void test() {
    StringBuilder sb = new StringBuilder();
    new Controller3(new Scanner("4 5")).go(new Calculator());
    assertEquals("9", sb.toString);

    OutputStream baos = new ByteArrayOutputStream();
    new Controller3(new Scanner("4 5"), baos).go(new Calculator());
    assertEquals("9", bao.toString);
  }
}
