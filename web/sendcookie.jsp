
<%
 Cookie c=new Cookie("zhouwei" ,"100");
 c.setPath("/");
 c.setMaxAge(3600);
 response.addCookie(c);
%>