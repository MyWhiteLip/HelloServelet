import java.io.DataOutputStream;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
class hero
{
   public  int id;
    public String name;
    public int hp;
    public int damage;
    public hero(int id,int hp,int damage, String name)
    {this.damage=damage;
    this.hp=hp;
    this.id=id;
    this.name=name;}
    public void print()
    {
        System.out.printf("%d\t%s\t%d\t%d\n",id,name,hp,damage);
    }

}
interface dao
{
    public void add(hero anotherhero);
    public void delete(int id);
    public hero get(int id);
    public void update(hero anotherhero);
}
class herodao implements  dao {
    public herodao()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    catch (ClassNotFoundException e)
    {e.printStackTrace();}

    }
    public Connection getconnetion() throws SQLException
    {

            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
                    "qaz1527571461");

    }
    public void add(hero anotherhero)
    {
        try(Connection c=getconnetion();PreparedStatement sql=c.prepareStatement("insert into hero values(?,?,?,?)");)
    {
        sql.setInt(1,anotherhero.id);
        sql.setString(2,anotherhero.name);
        sql.setInt(3,anotherhero.hp);
        sql.setInt(4,anotherhero.damage);
        sql.execute();

    }
    catch (SQLException e)
    {e.printStackTrace();}

    }
    public void delete(int id)
    {
        try(Connection c=getconnetion();PreparedStatement sql=c.prepareStatement("delete from hero where id=?");)
        {
            sql.setInt(1,id);
            sql.execute();
        }
        catch (SQLException e)
        {e.printStackTrace();}
    }
    public void update(hero anotherhero)
    {
        try(Connection c=getconnetion();PreparedStatement sql=c.prepareStatement("update hero set name=?,hp=?,damage=? where id =?");)
        {
            sql.setString(1,anotherhero.name);
            sql.setInt(2,anotherhero.hp);
            sql.setInt(3,anotherhero.damage);
            sql.setInt(4,anotherhero.id);
        }
        catch(SQLException e)
        {e.printStackTrace();}
    }
    public hero get(int id)
    {
        try(Connection c=getconnetion();PreparedStatement sql=c.prepareStatement("select *from hero where id=?");)
        {
            sql.setInt(1,id);
            ResultSet ans=sql.executeQuery();
            ans.next();
            return new hero(ans.getInt(1),ans.getInt(3),ans.getInt(4),ans.getString(2));
        }
        catch (SQLException e)
        {

            e.printStackTrace();
            return null;
        }


    }
    public List<hero> heroList()
    {
        List<hero> a=new ArrayList<hero>();
        try(Connection c=getconnetion();PreparedStatement pr=c.prepareStatement("select *from hero limit 0,?");)
        {
            pr.setInt(1,Short.MAX_VALUE);
            ResultSet rs=pr.executeQuery();
            while(rs.next())
            {
                a.add(new hero(rs.getInt(1), rs.getInt(3), rs.getInt(4), rs.getString(2)));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return a;
    }
}
public class mysqltest
{
    public static  void main(String[] args) {
      dao p=new herodao();
      p.get(11).print();
    }
}


