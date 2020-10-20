package com.example.wgumobileappmcclane.Database;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.wgumobileappmcclane.Dao.AssessmentDao;
import com.example.wgumobileappmcclane.Dao.CourseDao;
import com.example.wgumobileappmcclane.Dao.MentorDao;
import com.example.wgumobileappmcclane.Dao.NoteDao;
import com.example.wgumobileappmcclane.Dao.TermDao;
import com.example.wgumobileappmcclane.Entities.AssessmentEntities;
import com.example.wgumobileappmcclane.Entities.CourseEntities;
import com.example.wgumobileappmcclane.Entities.MentorEntities;
import com.example.wgumobileappmcclane.Entities.NoteEntities;
import com.example.wgumobileappmcclane.Entities.TermEntities;
import com.example.wgumobileappmcclane.Utilities.SampleData;

import java.util.List;


public class ScheduleManagementRepository {
    private AssessmentDao mAssessmentDao;
    private CourseDao mCourseDao;
    private MentorDao mMentorDao;
    private NoteDao mNoteDao;
    private TermDao mTermDao;
    private LiveData<List<TermEntities>> mAllTerms;
    private LiveData<List<TermEntities>> mSelectedTerm;
    private LiveData<List<CourseEntities>> mAllCoursesTerm;
    private LiveData<List<CourseEntities>> mSelectedCourse;
    private LiveData<List<AssessmentEntities>> mAssessmentCourse;
    private LiveData<List<AssessmentEntities>> mSelectedAssessment;
    private LiveData<List<NoteEntities>> mNotesCourse;
    private LiveData<List<NoteEntities>> mSelectedNotes;
    private LiveData<List<MentorEntities>> mMentorCourse;



    private int termId;
    private int courseId;
    private int assessmentId;
    private int noteId;
    private int mentorId;

    public ScheduleManagementRepository(Application application){
        ScheduleManagementDatabase db = ScheduleManagementDatabase.getDatabase(application);
        mAssessmentDao = db.assessmentDao();
        mCourseDao = db.courseDao();
        mMentorDao = db.mentorDao();
        mNoteDao = db.noteDao();
        mTermDao = db.termDao();
        mAllTerms = mTermDao.getAllTerms();
        mSelectedTerm = mTermDao.getAllAssociatedTerms(termId);
        mAllCoursesTerm = mCourseDao.getAllCoursesForTerm(termId);
        mSelectedCourse = mCourseDao.getAllAssociatedCourses(courseId);
        mAssessmentCourse = mAssessmentDao.getAllAssessments(courseId);
        mSelectedAssessment = mAssessmentDao.getAllAssociatedAssessments(assessmentId);
        mNotesCourse = mNoteDao.getAllNotes(courseId);
        mSelectedNotes = mNoteDao.getAllAssociatedNotes(noteId);
        mMentorCourse = mMentorDao.getAllAssociatedMentors(mentorId);

    }

    public LiveData<List<AssessmentEntities>> getmAssessmentCourse(int courseId) {return mAssessmentCourse;}
    public LiveData<List<AssessmentEntities>> getmSelectedAssessment(int assessmentId) {return mSelectedAssessment;}
    public LiveData<List<CourseEntities>> getmAllCoursesTerm(int termId) {return mAllCoursesTerm;}
    public LiveData<List<CourseEntities>> getmSelectedCourse(int courseId) {return mSelectedCourse;}
    public LiveData<List<TermEntities>> getmAllTerms() {return mAllTerms;}
    public LiveData<List<TermEntities>> getmSelectedTerm(int termId) {return mSelectedTerm;}
    public LiveData<List<NoteEntities>> getmNotesCourse(int courseId) {return mNotesCourse;}
    public LiveData<List<NoteEntities>> getmSelectedNotes(int noteId) {return mSelectedNotes;}

    public void insert (AssessmentEntities assessmentEntities){
        new insertAsyncAssessmentTask(mAssessmentDao).execute(assessmentEntities);
    }

    private static class insertAsyncAssessmentTask extends AsyncTask<AssessmentEntities, Void, Void>{

        private AssessmentDao mAsyncTaskDao;

        insertAsyncAssessmentTask(AssessmentDao dao){mAsyncTaskDao = dao;}

        @Override
        protected Void doInBackground(AssessmentEntities... parms) {
            mAsyncTaskDao.insert(parms[0]);
            return null;
        }
    }

    public void insert (CourseEntities courseEntities){
        new insertAsyncCourseTask(mCourseDao).execute(courseEntities);

    }

    private static class insertAsyncCourseTask extends AsyncTask<CourseEntities, Void, Void>{
        private CourseDao mAsyncCourseDao;

        insertAsyncCourseTask(CourseDao dao){mAsyncCourseDao = dao;}

        @Override
        protected Void doInBackground(CourseEntities... parms) {
            mAsyncCourseDao.insert(parms[0]);
            return null;
        }
    }

    public void insert (TermEntities termEntities){
        new insertAsyncTermTask(mTermDao).execute(termEntities);

    }

    private static class insertAsyncTermTask extends AsyncTask<TermEntities, Void, Void>{
        private TermDao mAsyncTermDao;

        insertAsyncTermTask(TermDao dao){mAsyncTermDao = dao;}

        @Override
        protected Void doInBackground(TermEntities... parms) {
            mAsyncTermDao.insert(parms[0]);
            return null;
        }
    }

    public void insert (NoteEntities noteEntities){
        new insertAsyncNoteTask(mNoteDao).execute(noteEntities);

    }

    private static class insertAsyncNoteTask extends AsyncTask<NoteEntities, Void, Void>{
        private NoteDao mAsyncNoteDao;

        insertAsyncNoteTask(NoteDao dao){mAsyncNoteDao = dao;}

        @Override
        protected Void doInBackground(NoteEntities... parms) {
            mAsyncNoteDao.insert(parms[0]);
            return null;
        }
    }

    public void insert (MentorEntities mentorEntities){
        new insertAsyncMentorTask(mMentorDao).execute(mentorEntities);

    }

    private static class insertAsyncMentorTask extends AsyncTask<MentorEntities, Void, Void>{
        private MentorDao mAsyncMentorDao;

        insertAsyncMentorTask(MentorDao dao){mAsyncMentorDao = dao;}

        @Override
        protected Void doInBackground(MentorEntities... parms) {
            mAsyncMentorDao.insert(parms[0]);
            return null;
        }
    }

    public void delete(TermEntities termEntities){new deleteAsyncTermTask(mTermDao).execute(termEntities);}
    private static class deleteAsyncTermTask extends  AsyncTask<TermEntities,Void,Void>{
        private TermDao mAsyncTermTaskDao;

        deleteAsyncTermTask(TermDao dao){mAsyncTermTaskDao = dao;}

        @Override
        protected Void doInBackground(TermEntities... params) {
            mAsyncTermTaskDao.delete(params[0]);
            return null;
        }
    }

    public void addSampleData(){
        TermEntities term = SampleData.getTerms();
        mTermDao.insert(term);
    }


}
