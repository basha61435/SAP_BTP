import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 023/049 - Invoice enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500023049")
    message.setHeader("X-Correlation-ID", "Invoice-023-049")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("Invoice", "Processed 4500023049")
    return message
}
