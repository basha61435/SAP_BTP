import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 012/013 - PurchaseOrder enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500012013")
    message.setHeader("X-Correlation-ID", "PurchaseOrder-012-013")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("PurchaseOrder", "Processed 4500012013")
    return message
}
