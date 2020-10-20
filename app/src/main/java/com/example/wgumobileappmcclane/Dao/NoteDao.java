package com.example.wgumobileappmcclane.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wgumobileappmcclane.Entities.NoteEntities;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NoteEntities Note);

    @Delete
    void delete(NoteEntities Note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table WHERE courseId = :courseId ORDER BY noteId ASC")
    LiveData<List<NoteEntities>> getAllNotes(int courseId);

    @Query("SELECT * FROM note_table WHERE noteId = :NoteId ORDER BY noteId ASC")
    LiveData<List<NoteEntities>> getAllAssociatedNotes(int NoteId);
}
