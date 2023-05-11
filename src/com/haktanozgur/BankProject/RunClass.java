package com.haktanozgur.BankProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import com.haktanozgur.BankProject.Entity.Account;
import com.haktanozgur.BankProject.Entity.Move;
import com.haktanozgur.BankProject.helperMethods.ConvertData;
import com.haktanozgur.BankProject.helperMethods.PdfGenerator;
import com.haktanozgur.BankProject.helperMethods.ReaderFile;
import com.haktanozgur.BankProject.helperMethods.SelectFile;

public class RunClass {

  public static void main(String[] args) throws FileNotFoundException {

    Account accountTest = new Account();
    //Banka hesaplarının bulunduğu csv dosyası
    File bankAccountFile;
    //Banka hesap hareketlerinin bulunduğu csv dosyası
    File accountMoveFile;
    //Kullanıcı tarafından csv dosyalarınıon seçilmesi SelectFile sınıfından selectFile metodu ile yapılır.
    bankAccountFile = SelectFile.selectFile();
    accountMoveFile = SelectFile.selectFile();
    //ReaderFile sınıfından readerFile metodu ile okunurak geriye bir list döner
    List < Account > bankAccountList = ReaderFile.readerBankAccount(bankAccountFile);
    List < Move > accountMoveList = ReaderFile.readerAccountMoves(accountMoveFile);
    //ConverData sınıfında bulunan convertmoveList metodu ile geriye dönen iki liste parametre alınır ve hareketler listesine paranın girdiği ve çıktığı kaynak ve hedef değişkenleri atanır ve yeni bir liste oluşturulur.
    ConvertData.convertmoveList(accountMoveList, bankAccountList);
    //ConvertData sınıfında bulunan convertPrice ise yeni dönen liste içerisindeki hesap türleri ve para miktarları baz alınarak döviz kuruna göre hesaplanır ve hareketler listesi içerisinde lastPrice adında yeni bir değişkene atanarak yeni bir hareket listesi döner.
    ConvertData.convertPrice(accountMoveList);
    // Son olarak Bu 2 listenin son halleri Account objesi içerisinde yer alan calculateTotalPrice metoduna parametre olarak gönderilir ve hesaplama yaparak banka hesaplarının bakiyeleri güncellenir.
    List < Account > pdfList = accountTest.calculateTotalPrice(bankAccountList, accountMoveList);
    //Hesaplanarak gelen accountList son olarak PdfGenerator sınıfı içerisinde yer alan generatePDF metoduna parametre olarak gönderilir ve PDf olarak download edilir. Bu metodda yer alan diğer bir parametre ise dosyanın indireleceği dosya dizinidir.
    PdfGenerator.generatePDF(pdfList, "/Users/haktanozgur/Downloads/accountFile.pdf");

  }
}