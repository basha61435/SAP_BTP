import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 020/077 - Payment enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500020077")
    message.setHeader("X-Correlation-ID", "Payment-020-077")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("Payment", "Processed 4500020077")
    return message
}
