package com.haktanozgur.BankProject.helperMethods;


public class ReportGenerator { 
    
//    public static void generateReport(List<Account> data) throws FileNotFoundException {
//        // Style oluşturulması
//        StyleBuilder boldStyle = DynamicReports.stl.style().bold();
//        
//        // Sütunlar oluşturulması
//        TextColumnBuilder<String> accountNoColumn = Columns.column("Account No", "accountNo", DynamicReports.type.stringType());
//        TextColumnBuilder<String> accountNameColumn = Columns.column("Account Name", "accountName", DynamicReports.type.stringType());
//        TextColumnBuilder<String> currencyColumn = Columns.column("Currency", "currency", DynamicReports.type.stringType());
//
//        // Raporun oluşturulması
//        JasperReportBuilder report = DynamicReports.report();
//        
//        // Başlık ve hizalama tanımlamaları
//        TextFieldBuilder<String> title = Components.text("My Report")
//                .setStyle(boldStyle)
//                .setHorizontalAlignment(HorizontalAlignment.CENTER);
//        report.title(title);
//
//        // Sütunların rapora eklenmesi
//        report.columns(accountNoColumn, accountNameColumn, currencyColumn);
//        
//        // Verilerin eklenmesi
//        JRDataSource dataSource = new JRBeanCollectionDataSource(data);
//        report.setDataSource(dataSource);
//        
//        // PDF dosyasının oluşturulması
//        try {
//            report.toPdf(new FileOutputStream("report.pdf"));
//        } catch (DRException e) {
//            e.printStackTrace();
//        }
//    }
}
