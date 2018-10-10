package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class SendServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException,ServletException{



        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String name = URLEncoder.encode("张三", "utf-8");

        Cookie userCookie = new Cookie(name, "1234");
        userCookie. setMaxAge(60*60*24*7);
        response.addCookie(userCookie);


        PrintWriter out=response.getWriter();

        out.println("<html><title>add cookies</title>");
        out.println("<body><h2>"+
                "A cookie has been sent to brower</h2></body>");
        out.println("</html>");

        System.out.println("上传成功！");
        String decode = URLDecoder.decode(userCookie.getName(), "utf-8");
        System.out.println(decode + ":" + userCookie.getValue());



    }

}
