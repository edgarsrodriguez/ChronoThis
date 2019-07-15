package com.esrr.chronothis.Data;

import java.sql.Time;
import java.util.Date;

public class Project {

    public Integer ProjectID;
    public Integer UserID;
    public String Name;
    public String Description;
    public Integer Priority;
    public Integer Status;
    public Date DueDate;
    public Time DueTime;

    public Project(Integer projectID, Integer userID, String name, String description, Integer priority, Integer status, Date dueDate, Time dueTime) {
        ProjectID = projectID;
        UserID = userID;
        Name = name;
        Description = description;
        Priority = priority;
        Status = status;
        DueDate = dueDate;
        DueTime = dueTime;
    }
}