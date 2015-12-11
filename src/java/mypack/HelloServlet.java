package mypack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * http://localhost:8085/TestHelloServlet/hello?clientName=Alec
 *
 * @author asus
 */
public class HelloServlet extends HttpServlet//第一步：扩展HttpServlet抽象类
{
//第二步：覆盖doGet()方法

    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
//第三步：获取HTTP请求中的参数信息
        String clientName = request.getParameter("clientName");
        if (clientName != null) {
            clientName = new String(clientName.getBytes("ISO-8859-1"), "GB2312");
        } else {
            clientName = "我的朋友";
        }
//第四步：生成HTTP响应结果
        PrintWriter out;
        String title = "HelloServlet";
        String heading1 = "HelloServlet的doGet方法的输出：";
//set content type
        response.setContentType("text/html;charset=GB2312");
//write html page
        out = response.getWriter();
        out.print("<HTML><HEAD><TITLE>" + title + "</TITLE>");
        out.print("</HEAD><BODY>");
        out.print(heading1);
        out.println("<h1><p>" + clientName + ":您好</h1>");
        out.print("</BODY></HTML>");
        out.close();
    }
}
