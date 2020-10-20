package com.example.wgumobileappmcclane.Entities;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "term_table" )
public class TermEntities {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int termId;

    private String termTitle;
    private int startMonth;
    private int startYear;
    private int endMonth;
    private int endYear;

    public TermEntities(int termId, String termTitle, int startMonth, int startYear, int endMonth, int endYear) {
        this.termId = termId;
        this.termTitle = termTitle;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endMonth = endMonth;
        this.endYear = endYear;
    }

    @Override
    public String toString() {
        return "TermEntities{" +
                "termId=" + termId +
                ", termTitle='" + termTitle + '\'' +
                ", startMonth=" + startMonth +
                ", startYear=" + startYear +
                ", endMonth=" + endMonth +
                ", endYear=" + endYear +
                '}';
    }


    public void setTermId(int termId) {
        this.termId = termId;
    }

    public int getTermId() {return termId;}

    public String getTermTitle() {
        return termTitle;
    }

      public int getStartMonth() {
        return startMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public int getEndYear() {
        return endYear;
    }

}
