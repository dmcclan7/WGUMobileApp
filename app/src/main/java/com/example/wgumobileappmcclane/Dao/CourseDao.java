package com.example.wgumobileappmcclane.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wgumobileappmcclane.Entities.CourseEntities;

import java.util.List;

@Dao
public interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CourseEntities Course);

    @Delete
    void delete(CourseEntities Course);

    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    @Query("SELECT * FROM course_table WHERE termId = :termId ORDER BY courseId ASC")
    LiveData<List<CourseEntities>> getAllCoursesForTerm(int termId);

    @Query("SELECT * FROM course_table WHERE courseId = :courseId ORDER BY courseId ASC")
    LiveData<List<CourseEntities>> getAllAssociatedCourses(int courseId);
    
    
}
