package com.haktanozgur.BankProject.Entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

  private String accountNo;
  private String accountName;
  private String currency;
  private double money;

  public List < Account > calculateTotalPrice(List <Account> accountList, List <Move> moveList) {

    for (int i = 0; i < moveList.size(); i++) {
    	for (int j = 0; j < accountList.size(); j++) {
      String senderAccountNo = moveList.get(i).getSenderAccountNo();
      String receiverAccountNo = moveList.get(i).getReceiverAccountNo();
      double price = moveList.get(i).getLastPrice();
      double accountPrice = moveList.get(i).getMoney();
      
        if (accountList.get(j).getAccountNo().equals(senderAccountNo)) {
          double newBalance = accountList.get(j).getMoney() - accountPrice;

          accountList.get(j).setMoney(newBalance);
        }

        if (accountList.get(j).getAccountNo().equals(receiverAccountNo)) {
          double newBalance = accountList.get(j).getMoney() + price;

          accountList.get(j).setMoney(newBalance);
        }
        
        //Bu kısımda dönen bakiye değeri DecimaFormat sınıfı objesiyle virgülden sonra kısaltma yapar ve double değeri düzenlenmiş olur
        double number = accountList.get(j).getMoney();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double newNumber = Double.parseDouble(decimalFormat.format(number));
        accountList.get(j).getCurrency();
        accountList.get(j).setMoney(newNumber);
        
      }
    }
    List < Account > finalList = new ArrayList < > ();
    for (int i = 0; i < accountList.size(); i++) {
      finalList.add(accountList.get(i));
    }

    return finalList;
  }
}