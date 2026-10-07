import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 004/085 - Delivery enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500004085")
    message.setHeader("X-Correlation-ID", "Delivery-004-085")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("Delivery", "Processed 4500004085")
    return message
}
