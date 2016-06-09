package cs3500.lec08;

import java.math.BigInteger;

/**
 * Rational numbers with {@link BigInteger} components. Instances of this
 * interface should be immutable value classes, and should interoperate.
 */
interface Rational extends Comparable<Rational> {
  /**
   * The numerator of this rational when expressed as a fraction in least terms.
   *
   * @return the numerator
   */
  BigInteger numerator();

  /**
   * The denominator of this rational when expressed as a fraction in least
   * terms.
   *
   * @return the denominator (non-zero)
   */
  BigInteger denominator();

  /**
   * This rational approximated as a floating-point value.
   */
  double doubleValue();

  /**
   * Adds two rationals.
   *
   * @param other the rational to add to this
   * @return the sum
   */
  Rational add(Rational other);

  /**
   * Multiplies two rationals.
   *
   * @param other the rational to multiply by this
   * @return the product
   */
  Rational multiply(Rational other);

  /**
   * Negates a rational.
   *
   * @return the negation of this
   */
  Rational negate();
}
