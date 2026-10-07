import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 020/025 - Payment enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500020025")
    message.setHeader("X-Correlation-ID", "Payment-020-025")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("Payment", "Processed 4500020025")
    return message
}
