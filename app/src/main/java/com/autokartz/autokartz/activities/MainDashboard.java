package com.autokartz.autokartz.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.autokartz.autokartz.R;

public class MainDashboard extends AppCompatActivity {


    private Spinner mCarBraND;
    private Spinner mCarModel;
    private Spinner mYear;
    private EditText mCarChassis;
    private Spinner mCarCategory;
    private Button mSubmitButoon;
    private ArrayAdapter<CharSequence> carbrandadapter,caryearadapter,carcategoryadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        init();
        mCarBraND.setAdapter(carbrandadapter);
        mYear.setAdapter(caryearadapter);
        mCarCategory.setAdapter(carcategoryadapter);
    }

    private void init() {
        initViews();
        initVariables();
    }

    private void initViews() {
        mCarBraND = (Spinner) findViewById(R.id.carbrand_spinner);
        mCarModel = (Spinner) findViewById(R.id.modelcar_spinner);
        mYear = (Spinner) findViewById(R.id.year_spinner);
        mCarChassis = (EditText) findViewById(R.id.carchassis_et);
        mCarCategory = (Spinner) findViewById(R.id.carcategory_spinner);
        mSubmitButoon = (Button) findViewById(R.id.carsubmit_btn);
    }

    private void initVariables() {
        carbrandadapter = ArrayAdapter.createFromResource(this, R.array.CAR_BRAND, R.layout.spinner_item);
        caryearadapter = ArrayAdapter.createFromResource(this, R.array.CAR_YEAR, R.layout.spinner_item);
        carcategoryadapter = ArrayAdapter.createFromResource(this, R.array.CAR_CATEGORY, R.layout.spinner_item);
    }

}
