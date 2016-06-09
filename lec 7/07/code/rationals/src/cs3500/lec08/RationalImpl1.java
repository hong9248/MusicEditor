package cs3500.lec08;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Rational numbers.
 */
public final class RationalImpl1 implements Rational {
  /**
   * Constructs a new rational number with the given numerator and denominator.
   *
   * @param numerator the numerator
   * @param denominator the denominator (non-zero)
   */
  public RationalImpl1(BigInteger numerator, BigInteger denominator) {
    if (denominator.equals(BigInteger.ZERO)) {
      throw new IllegalArgumentException("denominator cannot be 0");
    }

    num = numerator;
    den = denominator;
  }

  /**
   * Constructs a new rational number with the given numerator and denominator.
   *
   * @param numerator the numerator
   * @param denominator the denominator (non-zero)
   */
  public RationalImpl1(long numerator, long denominator) {
    this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
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

  @Override
  public double doubleValue() {
    return num.doubleValue() / den.doubleValue();
  }

  @Override
  public Rational add(Rational that) {
    return new RationalImpl1(this.num.multiply(that.denominator())
                               .add(that.numerator().multiply(this.den)),
                             this.den.multiply(that.denominator()));
  }

  @Override
  public Rational multiply(Rational that) {
    return new RationalImpl1(this.num.multiply(that.numerator()),
                             this.den.multiply(that.denominator()));
  }

  @Override
  public Rational negate() {
    return new RationalImpl1(num.negate(), den);
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
}
