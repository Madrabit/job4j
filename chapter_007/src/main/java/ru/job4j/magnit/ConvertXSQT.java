package ru.job4j.magnit;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * @author madrabit
 * Convert XML to XMLS
 */
public class ConvertXSQT {

    /**
     * Convert XML to XMLS
     *
     * @param source XML file.
     * @param dest   New XML file after convert.
     * @param scheme XLS scheme.
     */
    public void convert(File source, File dest, File scheme) {
        try (BufferedInputStream sourceIn = new BufferedInputStream(new FileInputStream(source));
             BufferedInputStream schemeIn = new BufferedInputStream(new FileInputStream(scheme))) {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(
                    new StreamSource(
                            new ByteArrayInputStream(schemeIn.readAllBytes()))
            );
            transformer.transform(new StreamSource(
                            new ByteArrayInputStream(
                                    sourceIn.readAllBytes())),
                    new StreamResult(dest)
            );
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
