import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Attr;

import java.io.IOException;


public class CreateMessage {
    public static void main(String[] args) throws Exception {
        Document doc = new Document();

        DocType dtd = new DocType("message", "Message.dtd");
        doc.setDocType(dtd);

        Element message = new Element("message");
        doc.setRootElement(message);

        Attribute att = new Attribute("language", "en");
        message.setAttribute(att);

        Element greeting = new Element("greeting");
        Text gText = new Text("Hello");
        greeting.addContent(gText);
        message.addContent(greeting);

        Comment comment = new Comment("This is comment");
        message.addContent(comment);

        Element audience = new Element("audience");
        Text aText = new Text("World");
        audience.addContent(aText);
        message.addContent(audience);

        Element footer = new Element("footer");
        EntityRef ent = new EntityRef("cr");
        footer.addContent(ent);
        message.addContent(footer);

        printDoc(doc);

    }
    public static void printDoc(Document doc) throws IOException {
        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        out.output(doc, System.out);
    }
}
