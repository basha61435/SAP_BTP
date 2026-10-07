import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 015/085 - BusinessPartner enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500015085")
    message.setHeader("X-Correlation-ID", "BusinessPartner-015-085")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("BusinessPartner", "Processed 4500015085")
    return message
}
