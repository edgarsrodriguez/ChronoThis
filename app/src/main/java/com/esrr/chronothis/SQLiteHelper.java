package com.esrr.chronothis;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.esrr.chronothis.Data.Project;
import com.esrr.chronothis.Data.Task;
import com.esrr.chronothis.Data.User;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "XpenseDB";

    private static final String CREATE_TABLE_USERS = "CREATE TABLE Users(" +
            "UserID INTEGER PRIMARY KEY," +
            "FirstName TEXT," +
            "LastName TEXT," +
            "Email TEXT" + ")";

    private static final String CREATE_TABLE_PROJECTS = "CREATE TABLE Projects(" +
            "ProjectID INTEGER PRIMARY KEY," +
            "UserID INTEGER," +
            "Name TEXT," +
            "Description TEXT," +
            "Status INTEGER" + ")";

    private static final String CREATE_TABLE_TASKS = "CREATE TABLE Tasks(" +
            "TaskID INTEGER PRIMARY KEY," +
            "ProjectID INTEGER," +
            "Name TEXT," +
            "Status INTEGER" + ")";

    public SQLiteHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_PROJECTS);
        db.execSQL(CREATE_TABLE_TASKS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS Projects");
        db.execSQL("DROP TABLE IF EXISTS Tasks");

        onCreate(db);
    }

    void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("UserID", user.UserID);
        values.put("FirstName", user.FirstName);
        values.put("LastName", user.LastName);
        values.put("Email", user.LastName);
        db.insert("Users", null, values );
        db.close();
    }

    void deleteUser(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Users");
        db.close();
    }

    void addProject(Project project){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ProjectID", project.ProjectID);
        values.put("UserID", project.UserID);
        values.put("Name", project.Name);
        values.put("Description", project.Description);
        values.put("Status", project.Status);
        db.insert("Projects", null, values );
        db.close();
    }

    void deleteProject(int projectID){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Projects WHERE ProjectID=" + projectID);
        db.close();
    }

    void deleteAllProjects(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Projects");
        db.close();
    }

    void addTasks(Task task ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TaskID", task.TaskID);
        values.put("ProjectID", task.ProjectID);
        values.put("Name", task.Name);
        values.put("Status", task.Status);
        db.insert("Tasks", null, values );
        db.close();
    }

    void deleteTask(int taskID){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Tasks WHERE TaskID=" + taskID);
        db.close();
    }

    void deleteTaskByProjectID(int projectID){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Tasks WHERE ProjectID=" + projectID);
        db.close();
    }

    void deleteAllTasks(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Tasks");
        db.close();
    }
}
