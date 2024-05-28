
package servicios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicios package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GenerarCorreo_QNAME = new QName("http://servicios/", "generarCorreo");
    private final static QName _GenerarCorreoResponse_QNAME = new QName("http://servicios/", "generarCorreoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerarCorreo }
     * 
     */
    public GenerarCorreo createGenerarCorreo() {
        return new GenerarCorreo();
    }

    /**
     * Create an instance of {@link GenerarCorreoResponse }
     * 
     */
    public GenerarCorreoResponse createGenerarCorreoResponse() {
        return new GenerarCorreoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarCorreo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "generarCorreo")
    public JAXBElement<GenerarCorreo> createGenerarCorreo(GenerarCorreo value) {
        return new JAXBElement<GenerarCorreo>(_GenerarCorreo_QNAME, GenerarCorreo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarCorreoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios/", name = "generarCorreoResponse")
    public JAXBElement<GenerarCorreoResponse> createGenerarCorreoResponse(GenerarCorreoResponse value) {
        return new JAXBElement<GenerarCorreoResponse>(_GenerarCorreoResponse_QNAME, GenerarCorreoResponse.class, null, value);
    }

}
