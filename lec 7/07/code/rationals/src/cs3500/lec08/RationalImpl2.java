package cs3500.lec08;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Rational numbers.
 *
 * (Implementation note: Here we use a weak class invariant that the
 * denominator is non-zero.)
 */
public final class RationalImpl2 implements Rational {
  /**
   * Produces a rational number with the given numerator and denominator.
   *
   * @param numerator the numerator
   * @param denominator the denominator (non-zero)
   * @return the rational
   */
  public static RationalImpl2 create(BigInteger numerator,
                                     BigInteger denominator)
  {
    if (denominator.equals(BigInteger.ZERO)) {
      throw new IllegalArgumentException("denominator cannot be 0");
    }

    return new RationalImpl2(numerator, denominator);
  }

  /**
   * Produces a rational number with the given numerator and denominator.
   *
   * @param numerator the numerator
   * @param denominator the denominator (non-zero)
   * @return the rational
   */
  public static RationalImpl2 create(long numerator, long denominator) {
    return create(BigInteger.valueOf(numerator),
                   BigInteger.valueOf(denominator));
  }

  @Override
  public BigInteger numerator() {
    return num.divide(num.gcd(den));
  }
  private final BigInteger num;

  @Override
  public BigInteger denominator() {
    return den.divide(num.gcd(den));
  }
  private final BigInteger den;
  // INVARIANT: den != 0

  @Override
  public double doubleValue() {
    return num.doubleValue() / den.doubleValue();
  }

  @Override
  public Rational add(Rational that) {
    return new RationalImpl2(this.num.multiply(that.denominator())
                               .add(that.numerator().multiply(this.den)),
                             this.den.multiply(that.denominator()));
  }

  @Override
  public Rational multiply(Rational that) {
    return new RationalImpl2(this.num.multiply(that.numerator()),
                             this.den.multiply(that.denominator()));
  }

  @Override
  public Rational negate() {
    return new RationalImpl2(num.negate(), den);
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

    return this.num.multiply(that.denominator())
             .equals(this.den.multiply(that.numerator()));
  }

  @Override
  public int hashCode() {
    BigInteger gcd = num.gcd(den);
    return Objects.hash(num.divide(gcd), den.divide(gcd));
  }

  @Override
  public String toString() {
    BigInteger gcd = num.gcd(den);
    BigInteger numerator = num.divide(gcd);
    BigInteger denominator = den.divide(gcd);

    if (denominator.equals(BigInteger.ONE)) {
      return numerator.toString();
    } else {
      return numerator + "/" + denominator;
    }
  }

  // Unchecked internal precondition: denominator is not 0.
  private RationalImpl2(BigInteger numerator, BigInteger denominator) {
    num = numerator;
    den = denominator;
  }
}
