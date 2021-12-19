<%Cookie []co=request.getCookies();
for(Cookie each:co)
{
    response.getWriter().println(each.getName());
}
%>