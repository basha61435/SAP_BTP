import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 012/025 - PurchaseOrder enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500012025")
    message.setHeader("X-Correlation-ID", "PurchaseOrder-012-025")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("PurchaseOrder", "Processed 4500012025")
    return message
}
