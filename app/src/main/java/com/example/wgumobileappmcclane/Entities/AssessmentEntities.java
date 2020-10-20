package com.example.wgumobileappmcclane.Entities;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assessment_table")
public class AssessmentEntities {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int assessmentId;
    private String assessmentName;
    private int courseId;
    private String type;
    private String goalDate;

    public AssessmentEntities(int assessmentId, String assessmentName, int courseId, String type, String goalDate) {
        this.assessmentId = assessmentId;
        this.assessmentName = assessmentName;
        this.courseId = courseId;
        this.type = type;
        this.goalDate = goalDate;

    }

    @Override
    public String toString() {
        return "AssessmentEntities{" +
                "assessmentId=" + assessmentId +
                ", assessmentName='" + assessmentName + '\'' +
                ", courseId=" + courseId +
                ", type='" + type + '\'' +
                ", goalDate='" + goalDate + '\'' +
                '}';
    }

    public int getAssessmentId() {return assessmentId;}

    public String getAssessmentName() {
        return assessmentName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getType() {
        return type;
    }

    public String getGoalDate() {
        return goalDate;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }
}
