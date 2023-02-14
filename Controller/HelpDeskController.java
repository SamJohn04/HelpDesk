package HelpDesk.Controller;

import HelpDesk.Model.Request;
import java.sql.*;

public class HelpDeskController {
    public static HelpDeskController helpDeskController;
    Connection con;
    Statement st;
    public HelpDeskController() {
        try {
            con = DriverManager.getConnection(/*TODO */);
            st = con.createStatement();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    } 
    public Request getRequestById(String id) {
        try{
            ResultSet rs = st.executeQuery("SELECT * FROM REQUESTS WHERE randId = "+id);
            rs.next();
            return new Request(id, rs.getString("userName"), rs.getString("userRollNum"), rs.getString("userBranch"), rs.getString("userSem"), rs.getString("requestTitle"), rs.getString("requestDescription"), rs.getString("email"), rs.getInt("userBatch"));
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public boolean postRequest(Request req) {
        try{
            st.executeUpdate("INSERT INTO REQUESTS VALUES (" + req.randId + ", '" + req.userName + "', '" + req.userRollNum + "', '" + req.userBranch + "', '" + req.userSem + "', '" + req.requestTitle + "', '" + req.requestDescription +"', '" + req.userEmail + "', " + req.userBatch + ")");
            return true;
        }
        catch(Exception e) {
            System.out.print(e);
            return false;
        }
    }
    public int getIDList(String randIds[]) {
        try{
            ResultSet rs = st.executeQuery("SELECT randId FROM REQUESTS");
            int n = 0;
            while(rs.next()) {
                randIds[n++] = String.valueOf(rs.getInt("randId"));
            }
            return n;
        }
        catch(Exception e) {
            return -1;
        }
    }
}
