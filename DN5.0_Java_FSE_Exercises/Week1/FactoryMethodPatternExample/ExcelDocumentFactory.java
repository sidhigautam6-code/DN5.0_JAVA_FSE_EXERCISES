package Week1.FactoryMethodPatternExample;
// src/ExcelDocumentFactory.java
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
