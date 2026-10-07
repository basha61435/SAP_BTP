import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.XmlSlurper

// Performance test script 007/085 - GoodsReceipt enrichment
def Message processData(Message message) {
    def body = message.getBody(String)
    def xml = new XmlSlurper().parseText(body)
    message.setProperty("DocumentNumber", xml.Header.DocumentNumber.text())
    message.setHeader("SAP_ApplicationID", "4500007085")
    message.setHeader("X-Correlation-ID", "GoodsReceipt-007-085")
    def messageLog = messageLogFactory.getMessageLog(message)
    messageLog?.setStringProperty("GoodsReceipt", "Processed 4500007085")
    return message
}
