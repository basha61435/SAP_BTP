import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 026/065 - Material enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500026065")
    message.setHeader("X-Correlation-ID", "Material-026-065")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("Material", "Processed 4500026065")
    return message
}
