package com.vaisbleh.user.preparetoschoolmath;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class BeforeAfterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image1, image2,image3, imageView1, imageView2,
            imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10;

    private static int[] nums = new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
            R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten};
    private Button newGameBtn, backBtn;
    private ArrayList<ImageView> numbers = new ArrayList<>();
    private int count = 0;
    private int selected;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_after);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);
        imageView8.setOnClickListener(this);
        imageView9.setOnClickListener(this);
        imageView10.setOnClickListener(this);

        newGameBtn = (Button) findViewById(R.id.newGameBtn);
        backBtn = (Button) findViewById(R.id.backBtn);

        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        newGame();

    }
    private void getNumbers(){

        numbers.clear();
        ArrayList<ImageView> images = new ArrayList<>();
        images.add(imageView1);
        images.add(imageView2);
        images.add(imageView3);
        images.add(imageView4);
        images.add(imageView5);
        images.add(imageView6);
        images.add(imageView7);
        images.add(imageView8);
        images.add(imageView9);
        images.add(imageView10);

        Random random = new Random();
        for (int i = 0; i <nums.length ; i++) {
            int rand = random.nextInt(images.size());
            numbers.add(images.get(rand));
            images.remove(rand);
        }
        for (int i = 0; i < numbers.size(); i++) {
            numbers.get(i).setImageBitmap(BitmapFactory.decodeResource(getResources(), nums[i]));
        }
    }

    private void selectNum(){
        image1.setImageDrawable(null);
        image3.setImageDrawable(null);
        Random random = new Random();
        selected = (random.nextInt(8)) + 1;
        image2.setImageBitmap(BitmapFactory.decodeResource(getResources(), nums[selected]));
        image1.setBackgroundColor(Color.RED);

    }

    private void newGame() {
        imageView1.setEnabled(true);
        imageView2.setEnabled(true);
        imageView3.setEnabled(true);
        imageView4.setEnabled(true);
        imageView5.setEnabled(true);
        imageView6.setEnabled(true);
        imageView7.setEnabled(true);
        imageView8.setEnabled(true);
        imageView9.setEnabled(true);
        imageView10.setEnabled(true);
        newGameBtn.setVisibility(View.INVISIBLE);
        backBtn.setVisibility(View.INVISIBLE);
        getNumbers();
        selectNum();
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < nums.length; i++) {
            if(view.getId() == numbers.get(i).getId()){
                if(count == 0){
                    if(i == selected-1){
                        image1.setBackgroundColor(Color.WHITE);
                        image1.setImageBitmap(BitmapFactory.decodeResource(getResources(), nums[i]));
                        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
                        count++;
                        image3.setBackgroundColor(Color.RED);
                    }else {
                        Toast.makeText(this, "Ooops... try again", Toast.LENGTH_SHORT).show();
                    }
                }else {
                   if(i == selected + 1){
                       image3.setBackgroundColor(Color.WHITE);
                       image3.setImageBitmap(BitmapFactory.decodeResource(getResources(), nums[i]));
                       Toast.makeText(this, "You win!!", Toast.LENGTH_SHORT).show();
                       newGameBtn.setVisibility(View.VISIBLE);
                       backBtn.setVisibility(View.VISIBLE);
                       count = 0;
                       imageView1.setEnabled(false);
                       imageView2.setEnabled(false);
                       imageView3.setEnabled(false);
                       imageView4.setEnabled(false);
                       imageView5.setEnabled(false);
                       imageView6.setEnabled(false);
                       imageView7.setEnabled(false);
                       imageView8.setEnabled(false);
                       imageView9.setEnabled(false);
                       imageView10.setEnabled(false);
                   }else {
                       Toast.makeText(this, "Ooops... try again", Toast.LENGTH_SHORT).show();
                   }
                }
                return;
            }
        }
    }
}
