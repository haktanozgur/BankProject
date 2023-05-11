package com.haktanozgur.BankProject.helperMethods;

import com.haktanozgur.BankProject.Entity.Account;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.List;

public class PdfGenerator {
    public static void generatePDF(List<Account> accountList, String fileName) {
        try {
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 8);
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            PdfPTable table = new PdfPTable(4);
            table.setWidths(new int[] { 2, 3, 2, 2 });

            PdfPCell cell1 = new PdfPCell(new Paragraph("Hesap Numarasi" , font));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Hesap Ismi" , font));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Hesap Kuru", font));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Bakiye",font));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);

            for (Account account : accountList) {
                table.addCell(new Paragraph(account.getAccountNo(), font));
                table.addCell(new Paragraph(account.getAccountName(), font));
                table.addCell(new Paragraph(account.getCurrency(), font));
                table.addCell(new Paragraph(String.valueOf(account.getMoney()), font));
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
