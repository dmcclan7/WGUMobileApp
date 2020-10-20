package com.example.wgumobileappmcclane.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wgumobileappmcclane.Entities.TermEntities;

import java.util.List;

@Dao
public interface TermDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TermEntities term);

    @Delete
    void delete(TermEntities term);

    @Query("DELETE FROM term_table")
    void deleteAllTerms();

    @Query("SELECT * FROM term_table ORDER BY startYear ASC, startMonth ASC")
    LiveData<List<TermEntities>> getAllTerms();

    @Query("SELECT * FROM term_table WHERE termId = :termId ORDER BY termId ASC")
    LiveData<List<TermEntities>> getAllAssociatedTerms(int termId);


}
