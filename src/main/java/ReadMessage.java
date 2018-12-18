import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.IOException;


public class ReadMessage {
    public static void main(String[] args) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        File file = new File("src\\main\\resources\\Contact.xml");
        Document doc = builder.build(file);
        printDoc(doc);
    }

    public static void printDoc(Document doc) throws IOException {
        //Format format = Format.getPrettyFormat();
        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        out.output(doc, System.out);
    }
}
