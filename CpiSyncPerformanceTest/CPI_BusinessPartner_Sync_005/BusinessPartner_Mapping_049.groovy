import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 005/049 - BusinessPartner enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500005049")
    message.setHeader("X-Correlation-ID", "BusinessPartner-005-049")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("BusinessPartner", "Processed 4500005049")
    return message
}
