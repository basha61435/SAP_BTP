import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 009/073 - Employee enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500009073")
    message.setHeader("X-Correlation-ID", "Employee-009-073")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("Employee", "Processed 4500009073")
    return message
}
