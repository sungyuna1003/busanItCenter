package tib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class RssReadExam2 {

    //http://www.kma.go.kr/wid/queryDFS.jsp?gridx=59&gridy=125
    private String rssFeed = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=%s&gridy=%s"; //�ּ�
        
    /**
     *  �׽�Ʈ�� ���� ���θ޼ҵ�
     */
    public static void main(String[] args) {
        
        RssReadExam2 r = new RssReadExam2();
        r.getTownForecast("59","125");        
        
    }  
    
    
    /**
     *  �ش� ��ǥ�� ���� ������ ��ȯ.
     */
    public List<Map<String, String>> getTownForecast(String x, String y) {        
        
               
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
                
        try {
        
            SAXBuilder parser = new SAXBuilder();        
            parser.setIgnoringElementContentWhitespace(true);
            
            //URL url = new URL(rssFeed);
            //InputSource is = new InputSource(url.openStream());
            //Document doc = parser.build(is);
            
            String url = String.format(rssFeed, x, y);
            Document doc = parser.build(url);
            Element root = doc.getRootElement();
            
            Element channel = root.getChild("body");
            List<Element> list = channel.getChildren("data");
           
            
           
            for (int i=0; i<list.size(); i++) {
              
                Element el = (Element)list.get(i);
                
                Map<String, String> data = new LinkedHashMap<String, String>();
                
                data.put("seq", el.getAttributeValue("seq"));   //48�ð��� ���° ���� ����Ŵ
                data.put("hour",el.getChildTextTrim("hour") );     //���׿��� 3�ð� ���� 
                data.put("day",el.getChildTextTrim("day") );     //1��°�� (0: ����/1: ����/2: ��)
                data.put("temp",el.getChildTextTrim("temp") );    //���� �ð��µ�
                data.put("tmx",el.getChildTextTrim("tmx") );    //�ְ� �µ� 
                data.put("tmn",el.getChildTextTrim("tmn") );    //���� �µ�
                data.put("sky",el.getChildTextTrim("sky") );    //�ϴ� �����ڵ� (1: ����, 2: ��������, 3:��������, 4:�帲)
                data.put("pty",el.getChildTextTrim("pty") );    //���� �����ڵ� (0: ����, 1: ��, 2: ��/��, 3: ��/��, 4: ��)
                data.put("wfkor",el.getChildTextTrim("wfKor") ); //���� �ѱ���
                data.put("wfEn",el.getChildTextTrim("wfEn") );      //���� ����
                data.put("pop",el.getChildTextTrim("pop") );     //���� Ȯ��%
                data.put("r12",el.getChildTextTrim("r12") );     //12�ð� ���� ������
                data.put("s12",el.getChildTextTrim("s12") );     //12�ð� ���� ������
                data.put("ws",el.getChildTextTrim("ws") );         //ǳ��(m/s)
                data.put("wd",el.getChildTextTrim("wd") );         //ǳ�� (0~7:��, �ϵ�, ��, ����, ��, ����, ��, �ϼ�)
                data.put("wdKor",el.getChildTextTrim("wdKor") ); //ǳ�� �ѱ���
                data.put("wdEn",el.getChildTextTrim("wdEn") );     //ǳ�� ����
                data.put("reh",el.getChildTextTrim("reh") );     //���� %
                data.put("r06",el.getChildTextTrim("r06") );     //6�ð� ���� ������
                data.put("s06",el.getChildTextTrim("s06") );     //6�ð� ���� ������
                
                System.out.println(data);
                result.add(data);
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }    
}
