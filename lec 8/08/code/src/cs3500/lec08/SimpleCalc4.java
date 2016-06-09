package cs3500.lec08;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by zhaoxinhong on 5/26/16.
 */
public class SimpleCalc4 {

  /**
   * Demonstrates a simple command-line-based calculator
   */
  public class SimpleCalc4 {
    public static void main(String[] args) {
      new Controller3(new Scanner(System.in), System.out).go(new Calculator());
    }
  }

  class Controller3 implements CalcController {
    private Scanner input;
    private PrintStream out; // PrintWriter/PrintStream/StringBuilder
    public Controller3(Scanner sc, PrintStream sb) {
      input = sc;
      out = new PrintStream(out);
    }
    public void go(Calculator calc) {
      Objects.requireNonNull(calc);
      int num1, num2;
      num1 = input.nextInt();
      num2 = input.nextInt();
      //System.out.printf("%d", calc.add(num1, num2));
      out.append(String.format("%d", calc.add(num1, num2)));
    }
}
