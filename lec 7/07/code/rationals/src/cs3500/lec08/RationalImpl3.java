package cs3500.lec08;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Rational numbers.
 *
 * (Implementation note: Here we use a stronger class invariant that the
 * fraction is in least terms as well.)
 */
public final class RationalImpl3 implements Rational {
  /**
   * Produces a rational number with the given numerator and denominator.
   *
   * @param numerator the numerator
   * @param denominator the denominator (non-zero)
   * @return the rational
   */
  public static RationalImpl3 create(BigInteger numerator,
                                     BigInteger denominator)
  {
    return check(numerator, denominator);
  }

  /**
   * Produces a rational number with the given numerator and denominator.
   *
   * @param numerator the numerator
   * @param denominator the denominator (non-zero)
   * @return the rational
   */
  public static RationalImpl3 create(long numerator, long denominator) {
    return create(BigInteger.valueOf(numerator),
                  BigInteger.valueOf(denominator));
  }

  @Override
  public BigInteger numerator() {
    return num;
  }

  @Override
  public BigInteger denominator() {
    return den;
  }

  @Override
  public double doubleValue() {
    return num.doubleValue() / den.doubleValue();
  }

  @Override
  public Rational add(Rational that) {
    return reduce(this.num.multiply(that.denominator())
                    .add(that.numerator().multiply(this.den)),
                  this.den.multiply(that.denominator()));
  }

  @Override
  public Rational multiply(Rational that) {
    return reduce(this.num.multiply(that.numerator()),
                  this.den.multiply(that.denominator()));
  }

  @Override
  public Rational negate() {
    return trust(num.negate(), den);
  }

  @Override
  public int compareTo(Rational that) {
    return this.num.multiply(that.denominator())
             .compareTo(that.numerator().multiply(this.den));
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (!(other instanceof Rational)) return false;

    Rational that = (Rational) other;

    return this.num.equals(that.numerator())
             && this.den.equals(that.denominator());
  }

  @Override
  public int hashCode() {
    return Objects.hash(num, den);
  }

  @Override
  public String toString() {
    if (den.equals(BigInteger.ONE)) {
      return num.toString();
    } else {
      return num + "/" + den;
    }
  }

  // Constructs a new rational while ensuring both invariants.
  private static RationalImpl3 check(BigInteger numerator,
                                     BigInteger denominator)
  {
    if (denominator.equals(BigInteger.ZERO)) {
      throw new IllegalArgumentException("denominator cannot be 0");
    }

    return reduce(numerator, denominator);
  }

  // Constructs a new rational, assuming that denominator is non-zero
  // (unchecked interal precondition)
  private static RationalImpl3 reduce(BigInteger numerator,
                                      BigInteger denominator)
  {
    BigInteger gcd = numerator.gcd(denominator);
    return trust(numerator.divide(gcd), denominator.divide(gcd));
  }

  // Constructs a new rational, assuming that denominator is non-zero and
  // numerator/denominator is in least terms (unchecked interal precondition)
  private static RationalImpl3 trust(BigInteger numerator,
                                     BigInteger denominator)
  {
    return new RationalImpl3(numerator, denominator);
  }

  private RationalImpl3(BigInteger numerator, BigInteger denominator) {
    num = numerator;
    den = denominator;
  }

  // INVARIANT: den != 0
  // INVARIANT: num/den is in least terms,
  //              or equivalently, num.gcd(den) == 1
  private final BigInteger num;
  private final BigInteger den;
}
