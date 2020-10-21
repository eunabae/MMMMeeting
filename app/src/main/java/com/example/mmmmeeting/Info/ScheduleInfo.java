package com.example.mmmmeeting.Info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ScheduleInfo implements Serializable {
    private String title;
    private String meetingID;
    private ArrayList<String> contents;
    private ArrayList<String> lateComer;
    private String meetingPlace;
    private Date meetingDate;
    private Date createdAt;
    private String id;

    // 약속 첫 생성할 때 지각자, 장소, 날짜 빼고 생성하는 생성자
    public ScheduleInfo(String title, String meetingID, ArrayList<String> contents, Date createdAt, String id){
        this.title = title;
        this.meetingID = meetingID;
        this.contents = contents;
        this.createdAt = createdAt;
        this.id = id;
    }

    public ScheduleInfo(String title, String meetingID, ArrayList<String> contents, ArrayList<String> lateComer, String meetingPlace, Date meetingDate, Date createdAt){
        this.title = title;
        this.meetingID = meetingID;
        this.contents = contents;
        this.lateComer = lateComer;
        this.meetingPlace = meetingPlace;
        this.meetingDate = meetingDate;
        this.createdAt = createdAt;
    }

    public Map<String, Object> getScheduleInfo(){
        Map<String, Object> docData = new HashMap<>();
        docData.put("title", title);
        docData.put("meetingID",meetingID);
        docData.put("contents",contents);
        docData.put("lateComer",lateComer);
        docData.put("meetingPlace",meetingPlace);
        docData.put("meetingDate",meetingDate);
        docData.put("createdAt",createdAt);
        return  docData;
    }

    public String getTitle(){ return this.title; }
    public void setTitle(String title){ this.title = title; }

    public String getMeetingID(){ return this.meetingID; }
    public void setMeetingID(String title){ this.title = meetingID; }

    public ArrayList<String> getContents(){ return this.contents; }
    public void setContents(ArrayList<String> contents){ this.contents = contents; }

    public ArrayList<String> getLateComer(){ return this.lateComer; }
    public void setLateComer(ArrayList<String> lateComer){ this.lateComer = lateComer; }

    public String getMeetingPlace(){ return this.meetingPlace; }
    public void setMeetingPlace(String meetingPlace){ this.meetingPlace = meetingPlace; }

    public Date getMeetingDate(){ return this.meetingDate; }
    public void setMeetingDate(Date meetingDate){ this.meetingDate = meetingDate; }

    public Date getCreatedAt(){
        return this.createdAt;
    }
    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }


    public String getId(){ return this.id; }
    public void setId(String id){ this.id = id; }
}