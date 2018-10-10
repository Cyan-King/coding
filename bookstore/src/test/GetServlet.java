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

public class GetServlet extends HttpServlet {

    public void doGet(HttpServletRequest
                              request,HttpServletResponse response)
            throws IOException,ServletException{

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String cookieName = "张三";
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
            for(int i = 0;i<cookies.length;i++){
                Cookie cookie = cookies[i];
                String decode = URLDecoder.decode(cookie.getName(), "utf-8");
                if(decode.equals(cookieName))
                cookieValue = cookie.getValue();
            }
        PrintWriter out=response.getWriter();
        out.println("<html><title>get cookies</title>");
        out.println("<body><h2>A cookie has been got from brower</h2>");
        out.println("CookieName:"+cookieName+"<br>");
        out.println("CookieValue:"+cookieValue+"<br>");
        out.println("</body></html>");
    }

}
