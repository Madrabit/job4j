package ru.job4j.magnit;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class StoreSQLTest {
    private Config conf;

    @Before
    public void initBase() {
        conf = new Config();
        conf.init();
    }

    @Test
    public void checkListReturnsSize10FromDB() {
        StoreSQL sql = new StoreSQL(conf);
        sql.generate(10);
        List<XmlUsage.Field> result = sql.getFields();
        assertThat(result.size(), is(10));
    }

    @Test
    public void xmlOutput() {
        StoreSQL sql = new StoreSQL(conf);
        sql.generate(1000000);
        List<XmlUsage.Field> result = sql.getFields();
        File xml = new File(Objects.requireNonNull(StoreSQLTest.class.getClassLoader().getResource("1.xml")).getFile());
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XmlUsage.Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(
                    new XmlUsage.Entries(result), xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void xmlToXsltThenSaxReturns1783293664() throws IOException, SAXException {
        ConvertXSQT convertXSQT = new ConvertXSQT();
        File source = new File(Objects.requireNonNull(StoreSQLTest.class.getClassLoader().getResource("1.xml")).getFile());
        File dest = new File(Objects.requireNonNull(StoreSQLTest.class.getClassLoader().getResource("2.xml")).getFile());
        File scheme = new File(Objects.requireNonNull(StoreSQLTest.class.getClassLoader().getResource("template.xml")).getFile());

        convertXSQT.convert(source, dest, scheme);
        Counter parser = new Counter();
        Counter.XMLHandler handler = new Counter.XMLHandler();
        parser.getParser().parse(dest, handler);
        System.out.println(Counter.XMLHandler.getSum());
        assertThat(Counter.XMLHandler.getSum(), is(1783293664));
    }
}
