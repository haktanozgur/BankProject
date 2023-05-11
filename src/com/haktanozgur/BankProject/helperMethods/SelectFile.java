package com.haktanozgur.BankProject.helperMethods;

import java.io.File;
import javax.swing.JFileChooser;

public class SelectFile {

  public static File selectFile() {

    JFileChooser dosyaSecici = new JFileChooser();
    int result = dosyaSecici.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = dosyaSecici.getSelectedFile();
      System.out.println(dosyaSecici.getName(selectedFile) + "  Belgesi seçildi.");
      return selectedFile;
    } else {
      System.out.println("Belge seçilmedi.");
      return null;
    }
  }
}