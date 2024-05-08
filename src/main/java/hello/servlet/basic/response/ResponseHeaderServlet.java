package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServletResponse - 기본 사용법
 *
 * HTTP 응답 메시지 생성 -> HTTP 응답코드 지정 / 헤더 생성 / 바디 생성
 * 편의 기능 제공 -> Content-Type / 쿠키 / Redirect
 */

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK); //정상 접속 = 200랑 같은 의미

        // [response-headers]
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");

        // 캐시 무효화
        response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");

        // 임의의 헤더 만들기
        response.setHeader("my-header", "hello");

        // [Header 편의 메서드]
//        content(response);
//        cookie(response);
        redirect(response);


        // [message body]
        PrintWriter writer = response.getWriter();
        writer.println("안녕하세요");

    }




    /** Content 편의 메서드 */
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2

//      response.setHeader("Content-Type", "text/plain;charset=utf-8"); 와 같은 의미
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성) -> 보통 생략함.
    }

    /** Cookie 편의 메서드 */
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600; --> 직접 넣는다면.
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600"); --> 이렇게 해야함.

        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초

        response.addCookie(cookie);
    }

    /** Redirect 편의 메서드 */
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302 --> http status를 302로 설정
        //Location: /basic/hello-form.html --> 해당 경로로 보내기.


//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html"); // 위의 두줄 한번에 쳐리
    }
}
