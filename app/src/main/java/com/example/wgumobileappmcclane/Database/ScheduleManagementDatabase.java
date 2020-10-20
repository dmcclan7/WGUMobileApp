package com.example.wgumobileappmcclane.Database;



import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.wgumobileappmcclane.Dao.AssessmentDao;
import com.example.wgumobileappmcclane.Dao.CourseDao;
import com.example.wgumobileappmcclane.Dao.MentorDao;
import com.example.wgumobileappmcclane.Dao.NoteDao;
import com.example.wgumobileappmcclane.Dao.TermDao;
import com.example.wgumobileappmcclane.Entities.AssessmentEntities;
import com.example.wgumobileappmcclane.Entities.CourseEntities;
import com.example.wgumobileappmcclane.Entities.TermEntities;
import com.example.wgumobileappmcclane.Entities.MentorEntities;
import com.example.wgumobileappmcclane.Entities.NoteEntities;



@Database(entities = {TermEntities.class, CourseEntities.class, AssessmentEntities.class, NoteEntities.class, MentorEntities.class},
        version = 1, exportSchema = false)


public abstract class ScheduleManagementDatabase extends RoomDatabase {
    public abstract AssessmentDao assessmentDao();
    public abstract CourseDao courseDao();
    public abstract MentorDao mentorDao();
    public abstract NoteDao noteDao();
    public abstract TermDao termDao();

    public static volatile ScheduleManagementDatabase INSTANCE;


    public static ScheduleManagementDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (ScheduleManagementDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ScheduleManagementDatabase.class,"schedule_management_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }

            }
        }
            return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private final AssessmentDao mAssessmentDao;
        private final CourseDao mCourseDao;
        private final MentorDao mMentorDao;
        private final NoteDao mNoteDao;
        private final TermDao mTermDao;

        PopulateDbAsync(ScheduleManagementDatabase db){
            mAssessmentDao = db.assessmentDao();
            mCourseDao = db.courseDao();
            mMentorDao = db.mentorDao();
            mNoteDao = db.noteDao();
            mTermDao = db.termDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }

}