/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Saxpackage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Karim
 */
public class SaxClass {
    public SaxClass(){
        try {
            SAXParserFactory sf = SAXParserFactory.newInstance();
            SAXParser pars = sf.newSAXParser();
            pars.parse("D:\\file4.xml", new MyHandler());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SaxClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SaxClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaxClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void main(String[] args){
        new SaxClass();
    }
}
