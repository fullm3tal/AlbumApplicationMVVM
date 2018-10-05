package com.example.devtrainee.albumapplicationmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.devtrainee.albumapplicationmvvm.pojo.People;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PeopleActivity extends AppCompatActivity {

    private static final String TAG = "PeopleActivity";

    @BindView(R.id.pb_mainView)
    ProgressBar progressBar;

    @BindView(R.id.tv_message)
    TextView message;

    @BindView(R.id.fab_get_people_list)
    FloatingActionButton floatingActionButton;

    PeopleViewModel model;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        ButterKnife.bind(this);

        model = ViewModelProviders.of(this).get(PeopleViewModel.class);
        recyclerView = findViewById(R.id.rv_people);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        model.getPeopleList().observe(this, new Observer<ResPeople>() {
            @Override
            public void onChanged(@Nullable ResPeople resPeople) {
                if (resPeople != null) {
                    processChange(resPeople);
                }
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.loadPeopleList();
            }
        });

    }

    private void processChange(ResPeople resPeople) {
        switch (resPeople.status) {
            case LOADING:
                showLoading();
                break;
            case SUCCESS:
                showPeopleList(resPeople.peopleList);
                break;
            case FAILURE:
                showErrorMessage(resPeople.error);
                break;
        }
    }

    private void showErrorMessage(Throwable error) {
        progressBar.setVisibility(View.GONE);
        message.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        message.setText(error.getMessage());
        Log.v(TAG, "show Error message called.");
    }

    private void showPeopleList(List<People> peopleList) {
        Log.v(TAG, "show people list called. " + peopleList.size());
        progressBar.setVisibility(View.GONE);
        message.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        CustomPeopleAdapter customPeopleAdapter = new CustomPeopleAdapter(peopleList, this);
        recyclerView.setAdapter(customPeopleAdapter);
    }

    private void showLoading() {
        Log.v(TAG, "show loading called.");
        progressBar.setVisibility(View.VISIBLE);
        message.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
    }
}
