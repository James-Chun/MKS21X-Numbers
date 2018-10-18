public class RationalNumber extends RealNumber{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
      super(1.0);
      numerator = nume;
      denominator = deno;
  }

  public double getValue(){
    return (double)numerator / denominator;
  }

  public int getNumerator(){
    return numerator;
  }

  public int getDenominator(){
    return denominator;
  }

  public RationalNumber reciprocal(){
      RationalNumber newN = new RationalNumber(denominator,numerator);
      return newN;
  }

  public boolean equals(RationalNumber other){
    return (this.getNumerator() == other.getNumerator() && this.getDenominator()==other.getDenominator());
  }



  public String toString(){
      if (denominator == 1) {
        return "" + numerator;
      }
      if (numerator == 0) {
          return "0";
      }
      else{
          return "" + numerator + "/"+denominator;
      }
  }



  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
      int temp = b;
      if (b!=0 || a!=0){
        if (a < b) {
            b = a;
            a = temp;
        }
        while (a%b!=0){
            b = a%temp;
            a = temp;
        }
        return b;
      }
      return 1;
  }



  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
      int gcD = gcd(numerator,denominator);
      numerator = numerator / gcD;
      denominator = denominator / gcD;
  }



  /******************Operations!!!!****************/


  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(numerator*other.numerator,denominator*other.denominator);
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber (numerator*other.denominator+other.numerator*denominator,denominator*other.denominator);
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber (numerator*other.denominator-other.numerator*denominator,denominator*other.denominator);
  }
}
