package com.vaisbleh.user.preparetoschoolmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.shapeQuantityBtn).setOnClickListener(this);
        findViewById(R.id.numNumBtn).setOnClickListener(this);
        findViewById(R.id.numQuantityBtn).setOnClickListener(this);
        findViewById(R.id.sequentialNumBtn).setOnClickListener(this);
        findViewById(R.id.beforeAfterBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shapeQuantityBtn:
                startActivity(new Intent(this, ShapeQuantityActivity.class));
                break;

            case  R.id.numNumBtn:
                startActivity(new Intent(this, MemoryNumNumActivity.class));
                break;

            case  R.id.numQuantityBtn:
                startActivity(new Intent(this, MemoryNumQuantityActivity.class));
                break;

            case  R.id.sequentialNumBtn:
                startActivity(new Intent(this, SequentialNumbersActivity.class));
                break;

            case  R.id.beforeAfterBtn:
                startActivity(new Intent(this, BeforeAfterActivity.class));
                break;
        }
    }
}
