package Week1.FactoryMethodPatternExample;
// src/TestFactory.java
public class TestFactory {
    public static void main(String[] args) {
        // Create different factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        // Create documents
        Document word = wordFactory.createDocument();
        Document pdf = pdfFactory.createDocument();
        Document excel = excelFactory.createDocument();
        
        // Test documents
        word.open();
        word.save();
        word.close();
        
        pdf.open();
        pdf.save();
        pdf.close();
        
        excel.open();
        excel.save();
        excel.close();
    }
}
