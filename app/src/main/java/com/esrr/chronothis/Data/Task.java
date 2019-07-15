package com.esrr.chronothis.Data;

public class Task {
    public int TaskID;
    public int ProjectID;
    public String Name;
    public int Status;

    public Task(int taskID, int projectID, String name, int status) {
        TaskID = taskID;
        ProjectID = projectID;
        Name = name;
        Status = status;
    }
}
