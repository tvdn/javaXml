import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ReadNews {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.demorgen.be/rss.xml");
        URLConnection urlConnection = url.openConnection();
        BufferedInputStream input = new BufferedInputStream(urlConnection.getInputStream());

        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(input);

        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        //out.output(doc, System.out);
        Element root = doc.getRootElement();
        List<Element> sub = root.getChild("channel").getChildren("item");

        sub.stream().map(item -> item.getChild("title").getText()).forEach(System.out::println);
    }
}
