package com.mohamedyusuf.assignment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.Date;

@RestController
public class IndexController {

    public String getTimeStamp() {
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());

        return timestamp2.toString();
    }

    private void updateDatabase(String timeStamp) {
        try (Connection con = DriverManager.getConnection("jdbc:sqlserver://tbr.database.windows.net:1433;database=Assignment;user=mohdgazyanii235@tbr;password=Risknrisk1;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30")) {
            con.createStatement().executeUpdate("INSERT INTO dbo.time_stamps VALUES('" + timeStamp + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/app")
    public String app() {
        updateDatabase(getTimeStamp());
        return (getTimeStamp());
    }

}
