import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="add",value = "/addhero")
public class addhero  extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

    {
        request.setCharacterEncoding("UTF-8");
        new herodao().add(new hero(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("hp")),
                Integer.parseInt(request.getParameter("damage")),request.getParameter("name")));
        response.sendRedirect("/herolist");
    }

}
