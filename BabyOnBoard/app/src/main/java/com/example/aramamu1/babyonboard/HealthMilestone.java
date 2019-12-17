package com.example.aramamu1.babyonboard;

public class HealthMilestone {
    //fields
    private int healthID;
    private int userID;
    private String date;
    private int weight;
    private int height;
    private int headcircum;
    private int numdiapers;
    private int nummilk;
    private int numsolid;

    // constructors
    public HealthMilestone() {}
    public HealthMilestone(int userid, String date, int weight, int height, int headcircum, int numdiapers, int nummilk, int numsolid) {

        this.userID = userid;
        this.date = date;
        this.weight = weight;
        this.height = height;
        this.headcircum = headcircum;
        this.numdiapers = numdiapers;
        this.nummilk = nummilk;
        this.numsolid = numsolid;

    }
    // properties


    public void setUserID(int id) {
        this.userID = id;
    }
    public int getUserID() {
        return this.userID;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return this.date;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return this.weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return this.height;
    }

    public void setHeadCircum(int headcircum) {
        this.headcircum = headcircum;
    }
    public int getHeadCircum() {
        return this.headcircum;
    }

    public void setNumDiapers(int numdiapers) {
        this.numdiapers = numdiapers;
    }
    public int getNumDiapers() {   return this.numdiapers;    }

    public void setNumSolid(int numsolid) {
        this.numsolid = numsolid;
    }
    public int getNumSolid() {
        return this.numsolid;
    }

    public void setNumMilk(int nummilk) {
        this.nummilk = nummilk;
    }
    public int getNumMilk() {        return this.nummilk; }
}
