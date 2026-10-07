import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 021/057 - SalesOrder enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500021057")
    message.setHeader("X-Correlation-ID", "SalesOrder-021-057")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("SalesOrder", "Processed 4500021057")
    return message
}
