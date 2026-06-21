package Week1.FactoryMethodPatternExample;
// src/PdfDocumentFactory.java
public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
