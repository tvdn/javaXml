import org.jdom2.*;

import javax.swing.text.html.StyleSheet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class CreateContact {
    public static void main(String[] args) throws Exception {
        Document doc = new Document();
        DocType dtd = new DocType("contact", "Contact.dtd");
        doc.setDocType(dtd);

        Map<String, String> m = new HashMap<String, String>();
        m.put("type", "text/css");
        m.put("href", "Contact.css");
        doc.addContent(1, new ProcessingInstruction("xml-stylesheet", m));

        //doc.addContent(new ProcessingInstruction("xml-stylesheet", "type='text/css' href='Contact.css'"));

        doc.addContent(new Comment("This document contains contact details"));

        Element contact = new Element("contact");
        doc.setRootElement(contact);

        Element name = new Element("name");
        Element address = new Element("address");
        Element city = new Element("city");
        Element country = new Element("country");
        Element phone = new Element("phone");
        Element notes = new Element("notes");

        name.addContent(new Text("tito toti"));
        address.addContent(new Text("zondernaamstraat 1234"));
        city.addContent(new Text("Zimbabwe"));
        country.addContent(new Text("India"));
        phone.addContent(new Text("0987654321"));
        notes.addContent(new CDATA("Try-hard and hipster"));

        phone.setAttribute(new Attribute("type","mobile"));

        contact.addContent(name);
        contact.addContent(address);
        contact.addContent(city);
        contact.addContent(country);
        contact.addContent(phone);
        contact.addContent(notes);

        CreateMessage.printDoc(doc);
    }
}
