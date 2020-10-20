package com.example.wgumobileappmcclane.Entities;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class CourseEntities {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int courseId;

    private String courseTitle;
    private String courseDate;
    private String planEndDate;
    private String status;
    private int mentorId;
    private int termId;

    public CourseEntities(int courseId, String courseTitle, String courseDate, String planEndDate, String status, int mentorId, int termId) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDate = courseDate;
        this.planEndDate = planEndDate;
        this.status = status;
        this.mentorId = mentorId;
        this.termId = termId;
    }

    @Override
    public String toString() {
        return "CourseEntites{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDate='" + courseDate + '\'' +
                ", planEndDate='" + planEndDate + '\'' +
                ", status='" + status + '\'' +
                ", mentorId=" + mentorId +
                ", termId=" + termId +
                '}';
    }

    public int getCourseId() {return courseId;}

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public String getPlanEndDate() {
        return planEndDate;
    }

    public String getStatus() {
        return status;
    }

    public int getMentorId() {
        return mentorId;
    }

    public int getTermId() {
        return termId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
