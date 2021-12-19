import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet {
    public String name;
    public String password;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {e.printStackTrace();}
        try{
            Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
                    "qaz1527571461");
            String name=request.getParameter("name");
            String password=request.getParameter("password");
            String sql="insert into userinfor values('"+name+"','"+password+"')";
            Statement st=c.createStatement();
            st.execute(sql);
            PrintWriter pw = response.getWriter();
            pw.println("<h1>注册成功！</h1>");
        ;
        }
        catch (SQLException e)
        {  PrintWriter pw = response.getWriter();
            pw.println("<h1>注册失败！</h1>");
            e.printStackTrace();}
    }
}

