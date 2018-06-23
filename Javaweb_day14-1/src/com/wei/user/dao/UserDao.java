package com.wei.user.dao;

import com.wei.user.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Node;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * 业务数据相关的类
 */

public class UserDao {

    private String path = "G:/CodeIOImage/User/Users.xml";//依赖这个xml的数据库路径

    public User findByUsername(String username){
        /**
         * 1. 得到document
         * 2. 使用xpath查询
         * 3. 进行校验结果是否为空，如果为null的话我们就返回null
         * 4. 如果不为null的话我们就将Element封装到user当中
         */
        //1.得到解析器
        SAXReader saxReader = new SAXReader();
        try {
            //得到了document
            Document document = saxReader.read(path);
            //通过xpath查询得到element
            Element element = (Element) document.selectSingleNode("//user[@username='" + username + "']");

            //接下来就是校验了
            //查看element是否为空
            //如果为空的话我们就直接返回为空
            if (element == null){
                return null;
            }

            //将element封装到user对象中
            User user = new User();
            String name = element.attributeValue("username");//获取username元素
            String passWord = element.attributeValue("password");//获取password元素
            user.setUsername(name);//设置username
            user.setPassword(passWord);//设置password
            return user;//返回user对象
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(User user){

        /**
         * 1. 得到document对象
         *          * 2. 通过Document的根元素(root)，<users>
         *          * 3. 使用参数user,转发成为Element对象
         *          * 4. 把element添加到root元素中
         *          * 5. 保存到document中
         */

        //1.得到document对象
        SAXReader reader = new SAXReader();
        try {

            Document document = reader.read(path);
            // 得到根元素
            Element root = document.getRootElement();
            // 通过根元素创建新元素
            Element userEle = root.addElement("user");
            // 为userEle设置属性
            userEle.addAttribute("username", user.getUsername());
            userEle.addAttribute("password", user.getPassword());
            userEle.addAttribute("sex", user.getSex());
            userEle.addAttribute("love", user.getLove());

            //进行回写操作
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path), "utf-8"), format);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}