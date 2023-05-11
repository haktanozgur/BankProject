package com.haktanozgur.BankProject.enums;

public enum CurrencyConstant {

  TL("TL", 1D), EUR("EUR", 20.50D), USD("USD", 19.80D), STE("STE", 21.60D);

  private String value;
  private double deger;

  CurrencyConstant(String value, double deger) {
    this.value = value;
    this.deger = deger;
  }
  public String getValueString() {
    return value;
  }

  public double getDeger() {
    return deger;
  }

}