package com.xuegao.mybatis.parsing;


import com.xuegao.mybatis.config.ConfigException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

@Data
@AllArgsConstructor
public class XPathParser {
    // javax.xml.xpath.XPath工具
    private XPath xPath;
    // 代表要解析的整个XML文档
    private final Document document;

    private void commonConstructor() {
        XPathFactory factory = XPathFactory.newInstance();
        this.xPath = factory.newXPath();
    }

    public XPathParser(InputStream inputStream) {
        commonConstructor();
        this.document = createDocument(new InputSource(inputStream));
    }

    public Document createDocument(InputSource inputSource) {
        try {
            // DOM文档创建器的工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            factory.setNamespaceAware(false);
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(false);
            factory.setCoalescing(false);
            factory.setExpandEntityReferences(true);

            // DOM文档创建器
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    throw exception;
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    throw exception;
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    exception.printStackTrace();
                }
            });
            return builder.parse(inputSource);
        } catch (Exception e) {
            throw new ConfigException("Error creating document instance.  Cause: " + e, e);
        }
    }

    // 根据表达式解析xml节点
    public Node xNode(String expression) {
        Node node = null;
        try {
            xPath.evaluate(expression, document, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return node;
    }
}
