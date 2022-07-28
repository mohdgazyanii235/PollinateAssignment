package com.mohamedyusuf.assignment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.Date;

@RestController
public class IndexController {

    /**
     * A public method that returns the timestamp of the time the function was called.
     *
     * @return The Time stamp as a string
     */
    public String getTimeStamp() {
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());

        return timestamp2.toString();
    }

    /**
     * A public void function that updates the database with the value parsed to the function.
     *
     * @param timeStamp The timestamp string
     */
    private void updateDatabase(String timeStamp) {
        try (Connection con = DriverManager.getConnection("jdbc:sqlserver://tbr.database.windows.net:1433;database=Assignment;user=mohdgazyanii235@tbr;password=T3st123!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30")) {
            con.createStatement().executeUpdate("INSERT INTO dbo.time_stamps VALUES('" + timeStamp + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * A public mapping function that maps the /app directory and calls the updateDatabase function on the current timestamp.
     *
     * @return The current time stamp on the screen for the api user.
     */
    @RequestMapping(value = "/app")
    public String app() {
        String timeStamp = getTimeStamp();
        updateDatabase(timeStamp);
        return (timeStamp);
    }

}
