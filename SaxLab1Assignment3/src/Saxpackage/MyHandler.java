/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Saxpackage;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Karim
 */
public class MyHandler extends DefaultHandler{

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println(qName);
        
    }
    @Override
    public void endElement (String uri, String localName, String qName)throws SAXException {
        //System.out.println(qName);
        
    }
    @Override
    public void characters(char [] ch,int start,int length)throws SAXException{
        
        String s =new String(ch,start,length);
        s.trim();
        System.out.println(s);
    }
    
}
