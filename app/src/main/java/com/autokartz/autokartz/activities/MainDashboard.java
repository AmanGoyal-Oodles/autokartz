package com.autokartz.autokartz.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.autokartz.autokartz.R;
import com.autokartz.autokartz.utils.tool;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainDashboard extends AppCompatActivity {

    @BindView(R.id.carbrand_spinner)
    Spinner mCarBraND;
    @BindView(R.id.modelcar_spinner)
    Spinner mCarModel;
    @BindView(R.id.year_spinner)
    Spinner mYear;
    @BindView(R.id.carchassis_et)
    TextView mCarChassis;
    @BindView(R.id.carcategory_spinner)
    Spinner mCarCategory;
    @BindView(R.id.carsubmit_btn)
    Button mSubmitButoon;
    private ArrayAdapter<CharSequence> carbrandadapter, caryearadapter, carcategoryadapter;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        ButterKnife.bind(this);
        context = MainDashboard.this;
        init();
        tool.getSharedPreference("Email", context);
        String Password = tool.getSharedPreference("Password", context);
       // Log.v("esh", Email);
        Log.v("psh", Password);
        mCarBraND.setAdapter(carbrandadapter);
        mYear.setAdapter(caryearadapter);
        mCarCategory.setAdapter(carcategoryadapter);
    }

    private void init() {
        //  initViews();
        initVariables();
    }


    private void initVariables() {
        carbrandadapter = ArrayAdapter.createFromResource(this, R.array.CAR_BRAND, R.layout.support_simple_spinner_dropdown_item);
        caryearadapter = ArrayAdapter.createFromResource(this, R.array.CAR_YEAR, R.layout.support_simple_spinner_dropdown_item);
        carcategoryadapter = ArrayAdapter.createFromResource(this, R.array.CAR_CATEGORY, R.layout.support_simple_spinner_dropdown_item);
    }

}
