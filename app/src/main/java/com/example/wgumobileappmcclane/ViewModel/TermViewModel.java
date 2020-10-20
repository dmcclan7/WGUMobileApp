package com.example.wgumobileappmcclane.ViewModel;

import android.app.Application;


import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wgumobileappmcclane.Database.ScheduleManagementRepository;
import com.example.wgumobileappmcclane.Entities.TermEntities;

import java.util.List;


public class TermViewModel extends AndroidViewModel {
    private ScheduleManagementRepository mRepository;
    private LiveData<List<TermEntities>> mAllTerms;

    public TermViewModel( Application application) {
        super(application);
        mRepository = new ScheduleManagementRepository(application);
        mAllTerms = mRepository.getmAllTerms();
    }

    public LiveData<List<TermEntities>> getAllTerms(){return mAllTerms;}
    public void insert(TermEntities termEntities){mRepository.insert(termEntities);}
    public void delete(TermEntities termEntities){mRepository.delete(termEntities);}
    public int lastId(){return mAllTerms.getValue().size();}
    public void addSampleData(){mRepository.addSampleData();}
}