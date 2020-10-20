package com.example.wgumobileappmcclane.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wgumobileappmcclane.Entities.MentorEntities;

import java.util.List;

@Dao
public interface MentorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MentorEntities mentor);

    @Delete
    void delete(MentorEntities mentor);

    @Query("DELETE FROM mentor_table")
    void deleteAllMentors();

    @Query("SELECT * FROM mentor_table ORDER BY mentorId ASC")
    LiveData<List<MentorEntities>> getAllMentors();

    @Query("SELECT * FROM mentor_table WHERE mentorId = :mentorId ORDER BY mentorId ASC")
    LiveData<List<MentorEntities>> getAllAssociatedMentors(int mentorId);

}
