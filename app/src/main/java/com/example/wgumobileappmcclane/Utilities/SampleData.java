package com.example.wgumobileappmcclane.Utilities;

import com.example.wgumobileappmcclane.Dao.TermDao;
import com.example.wgumobileappmcclane.Entities.TermEntities;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static TermEntities getTerms() {
        TermEntities terms = new TermEntities(1,"Term 1",4,2019,10,2019);
        return terms;
    }



}
