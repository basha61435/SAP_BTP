import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 003/013 - Invoice enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500003013")
    message.setHeader("X-Correlation-ID", "Invoice-003-013")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("Invoice", "Processed 4500003013")
    return message
}
