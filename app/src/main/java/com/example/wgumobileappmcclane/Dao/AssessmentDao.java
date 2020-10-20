package com.example.wgumobileappmcclane.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wgumobileappmcclane.Entities.AssessmentEntities;


import java.util.List;

@Dao
public interface AssessmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AssessmentEntities assessment);

    @Delete
    void delete(AssessmentEntities assessment);

    @Query("DELETE FROM assessment_table")
    void deleteAllAssessments();

    @Query("SELECT * FROM assessment_table WHERE courseId = :courseId ORDER BY assessmentId ASC")
    LiveData<List<AssessmentEntities>> getAllAssessments(int courseId);

    @Query("SELECT * FROM assessment_table WHERE assessmentId = :assessmentId ORDER BY assessmentId ASC")
    LiveData<List<AssessmentEntities>> getAllAssociatedAssessments(int assessmentId);
}
