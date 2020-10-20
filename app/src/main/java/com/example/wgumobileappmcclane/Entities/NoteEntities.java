package com.example.wgumobileappmcclane.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class NoteEntities {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int noteId;
     private String noteTitle;
     private String noteDetail;
     private int courseId;

    public NoteEntities(int noteId, String noteTitle, String noteDetail, int courseId) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteDetail = noteDetail;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "NoteEntities{" +
                "noteId=" + noteId +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteDetail='" + noteDetail + '\'' +
                ", courseId=" + courseId +
                '}';
    }

    public int getNoteId() {return noteId;}

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteDetail() {
        return noteDetail;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }
}
