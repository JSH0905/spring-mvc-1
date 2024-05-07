package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "helloServlet", urlPatterns = "/hello") // "/hello"로 오면 실행
public class HelloServlet extends HttpServlet { //서블릿 사용을 위한 HttpServlet 상속

    @Override //서블릿 호출 시 아래 service메서드 실행
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); //인코딩은 무조건 utf-8로 할 것
        response.getWriter().write("hello " +  username);
    }
}
