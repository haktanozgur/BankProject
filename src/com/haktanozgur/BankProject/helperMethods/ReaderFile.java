package com.haktanozgur.BankProject.helperMethods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.haktanozgur.BankProject.Entity.Account;
import com.haktanozgur.BankProject.Entity.Move;

public class ReaderFile {

  public static List < Account > readerBankAccount(File accountFile) {

    List < Account > accountList = new ArrayList < > ();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(accountFile), StandardCharsets.UTF_8))) {
      br.readLine();
      String line = "";
      String cvsSplitBy = ",";
      while ((line = br.readLine()) != null) {
        String[] data = line.split(cvsSplitBy);

        String accountNumber = data[0];
        String accountName = data[1];
        String currency = data[2];
        double price = Double.parseDouble(data[3]);

        Account accountObject = new Account(accountNumber, accountName, currency, price);

        accountList.add(accountObject);

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return accountList;
  }

  public static List < Move > readerAccountMoves(File accountFile) {

    List < Move > accountMoveList = new ArrayList < > ();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(accountFile), StandardCharsets.UTF_8))) {
      br.readLine();
      String line = "";
      String cvsSplitBy = ",";
      while ((line = br.readLine()) != null) {
        String[] veri = line.split(cvsSplitBy);

        String senderAccountNo = veri[0];
        String receiverAccountNo = veri[1];
        double balance = Double.parseDouble(veri[2]);

        Move obje = new Move(senderAccountNo, receiverAccountNo, balance, null, null, 0);

        accountMoveList.add(obje);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return accountMoveList;
  }
}