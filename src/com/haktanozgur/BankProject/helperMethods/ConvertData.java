package com.haktanozgur.BankProject.helperMethods;

import java.util.ArrayList;
import java.util.List;

import com.haktanozgur.BankProject.Entity.Account;
import com.haktanozgur.BankProject.Entity.Move;
import com.haktanozgur.BankProject.enums.CurrencyConstant;

public class ConvertData {
	  public static List < Move > convertmoveList(List < Move > moveList, List < Account > accountList) {

		    for (int i = 0; i < moveList.size(); i++) {
		      for (int j = 0; j < accountList.size(); j++) {

		        String gonderenNo = moveList.get(i).getSenderAccountNo();
		        String aliciNo = moveList.get(i).getReceiverAccountNo();
		        String currency = accountList.get(j).getCurrency();

		        if (accountList.get(j).getAccountNo().equals(gonderenNo)) {
		          moveList.get(i).setSource(currency);

		        }
		        if (accountList.get(j).getAccountNo().equals(aliciNo)) {
		          moveList.get(i).setTarget(currency);
		        }

		      }
		    }

		    List < Move > finalList = new ArrayList < > ();
		    //Son durum yazdırılıyor
		    for (int i = 0; i < moveList.size(); i++) {
		      finalList.add(moveList.get(i));
		    }

		    return finalList;
		  }

		  public static List < Move > convertPrice(List < Move > moveList) {
		    for (int i = 0; i < moveList.size(); i++) {
		      double price = moveList.get(i).getMoney();
		      String target = moveList.get(i).getTarget();
		      String source = moveList.get(i).getSource();
		      double sourcePrice = (price * CurrencyConstant.valueOf(source).getDeger());
		      double targetPrice = (sourcePrice / CurrencyConstant.valueOf(target).getDeger());

		      moveList.get(i).setLastPrice(targetPrice);

		    }
		    List < Move > finalList = new ArrayList < > ();
		    for (int i = 0; i < moveList.size(); i++) {
		      finalList.add(moveList.get(i));
		    }

		    return finalList;
		  }
}
