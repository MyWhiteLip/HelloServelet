import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    public String name;
    public String password;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            try {
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
                        "qaz1527571461");
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery("select *from userinfor ");
                //
                //
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=UTF-8");
                request.setCharacterEncoding("UTF-8");
                //
                String name = request.getParameter("name");
                String password = request.getParameter("password");
            PrintWriter pw = response.getWriter();
            while (rs.next()) {
                if (name.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    pw.println("<h1>登录成功!你的身份是"+request.getParameter("check")+"</h1>");
                    System.out.println(request.getParameter("check"));
                    return;

                }
            }
            pw.println("<h1>登录失败</h1>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


