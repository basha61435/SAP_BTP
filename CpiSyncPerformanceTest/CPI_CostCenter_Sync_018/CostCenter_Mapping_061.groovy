import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 018/061 - CostCenter enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500018061")
    message.setHeader("X-Correlation-ID", "CostCenter-018-061")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("CostCenter", "Processed 4500018061")
    return message
}
