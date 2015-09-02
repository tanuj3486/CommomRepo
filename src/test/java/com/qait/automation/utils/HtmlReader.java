
package com.qait.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.Assert;
import org.testng.Reporter;

public class HtmlReader {

	static private Document doc ; 
	
	public HtmlReader(String content){
		doc = Jsoup.parse(content) ;
	}
	
	public String getSourceOfImageTag(String source){
		String sourceValue=null ;
		int count=0;
		for (Element el : getAllImageTag()) {
			if(el.attr("src").contains(source))
				sourceValue = el.attr("src");
				count++;
		}
		if(count==1){
			Reporter.log("Image tag found having href value : "+source, 1);
		}
		else{
			Assert.fail("Either there are no image tag having src value : "+source+ " or there are more than one tag having same value");
		}
		return sourceValue;
	}
	
	public String getSourceOfAnchorTag(String value){
		String sourceValue=null ;
		int count=0;
		for (Element el : getAllAnchortags()) {
			if(el.attr("href").contains(value)){
				sourceValue = el.attr("href");
				count++;
			}
		}
		if(count==1){
		}
		else{
			Assert.fail("Either there are no anchor tag having href value : "+value+ " or there "+count+" than one tag having same value");
		}
		return sourceValue;
	}
	
	public String getInnerTextOFAnchorTag(String attributeValue){
			Elements el =getAllAnchortags();
			String text = null;
			int count=0;
			for (Element e : el) {
				if(e.attr("href").contains(attributeValue)){
					text = e.html();
					count++;
				}
			}
			if(count==1){}
			else Assert.fail("Either there are no anchor tag having href value : "+attributeValue+ " or there "+count+" than one tag having same value");
		return text;
	}
	
	public  Elements getElement(String css){
		return doc.select(css);
	}
	
	public Elements  getAllAnchortags(){
		return getElement("a[href]");
	}
	
	public void getSpecificElementUsingCSS(String CSS,String attribute){
		getElement(CSS);//a[href^='']
		
	}
	
	public List<Element> getAllImageTag(){
		return getElement("img[src]");
	}
	
	public void verifyLinkIsValid(String link){
		CustomFunctions.verifyLinkIsValid(link);
	}
	
	public String getElementByTagName(String TagName){
		Elements el = getElement (TagName);
		if(el.size()==1){
			return el.text();
		}else
			return null;
	}
	
	public static String getPageTextOfPdf(String fileURL,int pageNumber){
		PDFParser parser;
		String parsedText = null;;
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		InputStream input;
		try {
				input = new URL(fileURL).openStream();
				parser = new PDFParser(input);
				parser.parse();
				cosDoc = parser.getDocument();
				pdfStripper = new PDFTextStripper();
				pdDoc = new PDDocument(cosDoc);
				pdfStripper.setStartPage(pageNumber);
				pdfStripper.setEndPage(pageNumber);
				parsedText = pdfStripper.getText(pdDoc);
				cosDoc.close();
				parser.clearResources();
			}
			catch (MalformedURLException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return parsedText;
	}
	
}
	
