<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response 사용 가능, 그냥 쓰면 됨.
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");


    /** request.getParameter의 값은 항상 String임 */
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age")); // 숫자로 변환 해줘야함.


    Member member1 = new Member(username, age);
    memberRepository.save(member1);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member1.getId()%></li>
    <li>username=<%=member1.getUsername()%></li>
    <li>age=<%=member1.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
