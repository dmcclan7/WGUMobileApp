package com.example.wgumobileappmcclane;

import android.content.Intent;
import android.os.Bundle;

import com.example.wgumobileappmcclane.Entities.TermEntities;
import com.example.wgumobileappmcclane.Forms.NewTermForm;
import com.example.wgumobileappmcclane.ViewModel.TermViewModel;
import com.example.wgumobileappmcclane.ui.TermAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class wguTerm extends AppCompatActivity {
    private TermViewModel mTermViewModel;
    public static final int NEW_ACTIVITY_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wgu_term);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        final Button NewTermButton = findViewById(R.id.newTermBtn);
        NewTermButton.setOnClickListener(v -> {
            Intent intent = new Intent(wguTerm.this, NewTermForm.class);
            intent.putExtra("termId",mTermViewModel.lastId()+1);
            startActivityForResult(intent, NEW_ACTIVITY_REQUEST_CODE);
        });
        RecyclerView recyclerView = findViewById(R.id.termRecyclerVw);
        final TermAdapter adapter = new TermAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTermViewModel.getAllTerms().observe(this, new Observer<List<TermEntities>>() {
            @Override
            public void onChanged(List<TermEntities> termEntities) {
                adapter.setWords(termEntities);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_add_sample_data){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}