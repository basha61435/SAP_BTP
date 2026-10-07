import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 019/025 - Employee enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500019025")
    message.setHeader("X-Correlation-ID", "Employee-019-025")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("Employee", "Processed 4500019025")
    return message
}
