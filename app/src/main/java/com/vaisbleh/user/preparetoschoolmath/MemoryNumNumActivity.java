package com.vaisbleh.user.preparetoschoolmath;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MemoryNumNumActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image1, image2,image3, image4, image5, image6, image7, image8, image9, image10,image11, image12, image13, image14, image15, image16;
    private int count = 0;
    private int checkCount = 0;
    private  int checkNum1, checkNum2;
    private static int[] nums = new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
            R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine};
    private ArrayList<Integer> currentNums = new ArrayList<>();
    private ArrayList<ImageView> imageArray1 = new ArrayList<>(8);
    private ArrayList<ImageView> imageArray2 = new ArrayList<>(8);
    private ImageView prevSelected, selected;
    private Button newGameBtn, backBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_num_num);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        image6 = (ImageView) findViewById(R.id.image6);
        image7 = (ImageView) findViewById(R.id.image7);
        image8 = (ImageView) findViewById(R.id.image8);
        image9 = (ImageView) findViewById(R.id.image9);
        image10 = (ImageView) findViewById(R.id.image10);
        image11 = (ImageView) findViewById(R.id.image11);
        image12 = (ImageView) findViewById(R.id.image12);
        image13 = (ImageView) findViewById(R.id.image13);
        image14 = (ImageView) findViewById(R.id.image14);
        image15 = (ImageView) findViewById(R.id.image15);
        image16 = (ImageView) findViewById(R.id.image16);

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);
        image7.setOnClickListener(this);
        image8.setOnClickListener(this);
        image9.setOnClickListener(this);
        image10.setOnClickListener(this);
        image11.setOnClickListener(this);
        image12.setOnClickListener(this);
        image13.setOnClickListener(this);
        image14.setOnClickListener(this);
        image15.setOnClickListener(this);
        image16.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {

        for (int i = 0; i < 8; i++) {
            selected = (ImageView) view;
            if(view.getId() == imageArray1.get(i).getId() || view.getId() == imageArray2.get(i).getId()){
               if(count == 0){
                   selected.setImageBitmap(BitmapFactory.decodeResource(getResources(),currentNums.get(i)));
                   checkNum1 = i;
                   prevSelected = selected;
                   prevSelected.setEnabled(false);
                   count++;
               }else {
                   selected.setImageBitmap(BitmapFactory.decodeResource(getResources(),currentNums.get(i)));
                   checkNum2 = i;
                   count = 0;
                   if(checkNum1 == checkNum2){
                       checkCount++;
                       Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
                       selected.setEnabled(false);
                       if(checkCount == 8){
                           Toast.makeText(this, "You win!!", Toast.LENGTH_SHORT).show();
                           image1.setEnabled(false);
                           image2.setEnabled(false);
                           image3.setEnabled(false);
                           image4.setEnabled(false);
                           image5.setEnabled(false);
                           image6.setEnabled(false);
                           image7.setEnabled(false);
                           image8.setEnabled(false);
                           image9.setEnabled(false);
                           image10.setEnabled(false);
                           image11.setEnabled(false);
                           image12.setEnabled(false);
                           image13.setEnabled(false);
                           image14.setEnabled(false);
                           image15.setEnabled(false);
                           image16.setEnabled(false);
                           newGameBtn.setVisibility(View.VISIBLE);
                           backBtn.setVisibility(View.VISIBLE);
                           checkCount = 0;
                       }

                   }else {
                       Toast.makeText(this, "Ooops... try again", Toast.LENGTH_SHORT).show();
                       image1.setEnabled(false);
                       image2.setEnabled(false);
                       image3.setEnabled(false);
                       image4.setEnabled(false);
                       image5.setEnabled(false);
                       image6.setEnabled(false);
                       image7.setEnabled(false);
                       image8.setEnabled(false);
                       image9.setEnabled(false);
                       image10.setEnabled(false);
                       image11.setEnabled(false);
                       image12.setEnabled(false);
                       image13.setEnabled(false);
                       image14.setEnabled(false);
                       image15.setEnabled(false);
                       image16.setEnabled(false);

                       final Handler handler = new Handler();
                       handler.postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               selected.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
                               prevSelected.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));

                               image1.setEnabled(true);
                               image2.setEnabled(true);
                               image3.setEnabled(true);
                               image4.setEnabled(true);
                               image5.setEnabled(true);
                               image6.setEnabled(true);
                               image7.setEnabled(true);
                               image8.setEnabled(true);
                               image9.setEnabled(true);
                               image10.setEnabled(true);
                               image11.setEnabled(true);
                               image12.setEnabled(true);
                               image13.setEnabled(true);
                               image14.setEnabled(true);
                               image15.setEnabled(true);
                               image16.setEnabled(true);
                           }
                       }, 2000L);

                   }

               }
              return;
            }
        }
    }

    private void newGame(){
        newGameBtn.setVisibility(View.INVISIBLE);
        backBtn.setVisibility(View.INVISIBLE);
        getNumsArray();
        getImageArrays();
        image1.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image2.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image3.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image4.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image5.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image6.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image7.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image8.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image9.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image10.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image11.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image12.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image13.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image14.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image15.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));
        image16.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.question));

        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
        image4.setEnabled(true);
        image5.setEnabled(true);
        image6.setEnabled(true);
        image7.setEnabled(true);
        image8.setEnabled(true);
        image9.setEnabled(true);
        image10.setEnabled(true);
        image11.setEnabled(true);
        image12.setEnabled(true);
        image13.setEnabled(true);
        image14.setEnabled(true);
        image15.setEnabled(true);
        image16.setEnabled(true);
    }

    private void getNumsArray(){
        currentNums.clear();
        for (int i = 0; i <nums.length ; i++) {
            currentNums.add(nums[i]);
        }
        Random random = new Random();
        int rand = random.nextInt(9);
        currentNums.remove(rand);
    }
    
    private void getImageArrays() {
        imageArray1.clear();
        imageArray2.clear();
        Random random = new Random();
        ArrayList<ImageView> images = new ArrayList<>(16);
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);
        images.add(image9);
        images.add(image10);
        images.add(image11);
        images.add(image12);
        images.add(image13);
        images.add(image14);
        images.add(image15);
        images.add(image16);

        for (int i = 0; i < 8; i++) {
            int rand = random.nextInt(images.size());
            imageArray1.add(images.get(rand));
            images.remove(rand);
        }
        for (int i = 0; i < 8; i++) {
            int rand = random.nextInt(images.size());
            imageArray2.add(images.get(rand));
            images.remove(rand);

        }
    }
}
