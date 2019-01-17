package tiendm.codefight.challenge.y2018.oct;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExtraCreditAssignment {
  int extraCreditAssignment(String decimal, int denominator) {
    int idx = decimal.indexOf("(");
    if (idx > 0) {
      String stt = decimal.substring(0, idx);
      String repeat = decimal.substring(idx + 1, decimal.length() - 1);
      return new BigDecimal(stt + repeat).multiply(new BigDecimal(denominator))
          .setScale(0, RoundingMode.CEILING).intValue();
    }
    return new BigDecimal(decimal).multiply(new BigDecimal(denominator)).intValue();
  }

  public static void main(String[] args) {
    ExtraCreditAssignment e = new ExtraCreditAssignment();
    System.out.println(e.extraCreditAssignment("0.0(25)", 594));
  }
}
