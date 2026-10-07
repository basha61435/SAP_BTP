import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 011/041 - SalesOrder enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500011041")
    message.setHeader("X-Correlation-ID", "SalesOrder-011-041")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("SalesOrder", "Processed 4500011041")
    return message
}
