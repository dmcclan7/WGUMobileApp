package com.example.wgumobileappmcclane.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mentor_table")
public class MentorEntities {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int mentorId;

    private String mentorName;
    private String mentorPhone;
    private String mentorEmail;

    public MentorEntities(int mentorId, String mentorName, String mentorPhone, String mentorEmail) {
        this.mentorId = mentorId;
        this.mentorName = mentorName;
        this.mentorPhone = mentorPhone;
        this.mentorEmail = mentorEmail;
    }

    @Override
    public String toString() {
        return "MentorEntities{" +
                "mentorId=" + mentorId +
                ", mentorName='" + mentorName + '\'' +
                ", mentorPhone='" + mentorPhone + '\'' +
                ", mentorEmail='" + mentorEmail + '\'' +
                '}';
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public String getMentorName() {
        return mentorName;
    }

    public String getMentorPhone() {
        return mentorPhone;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }
}
