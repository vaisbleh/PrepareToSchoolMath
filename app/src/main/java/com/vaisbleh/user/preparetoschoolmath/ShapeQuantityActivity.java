package com.vaisbleh.user.preparetoschoolmath;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Random;

public class ShapeQuantityActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageQuantity1, imageQuantity2, imageShape1, imageShape2, imageShapeQuantity1_1, imageShapeQuantity1_2, imageShapeQuantity2_1, imageShapeQuantity2_2;
    private int[]quantities = new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
            R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine};
    private int[]newQuantities;
    private int[]shapes = new int[]{R.drawable.one_circle, R.drawable.one_square, R.drawable.one_triangle, R.drawable.one_star};
    private int[]newShapes;
    private int[] selectedNums;
    private int[]selectedShapes;
    private int theNum;
    private int theShape;
    private int countField = 1;
    private ImageView selectedView;
    private Button newGameBtn, backBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_quantity);

        imageQuantity1 = (ImageView) findViewById(R.id.imageQuantity1);
        imageQuantity2 = (ImageView) findViewById(R.id.imageQuantity2);
        imageShape1 = (ImageView) findViewById(R.id.imageShape1);
        imageShape2 = (ImageView) findViewById(R.id.imageShape2);
        imageShapeQuantity1_1 = (ImageView) findViewById(R.id.imageShapeQuantity1_1);
        imageShapeQuantity1_2 = (ImageView) findViewById(R.id.imageShapeQuantity1_2);
        imageShapeQuantity2_1 = (ImageView) findViewById(R.id.imageShapeQuantity2_1);
        imageShapeQuantity2_2 = (ImageView) findViewById(R.id.imageShapeQuantity2_2);

        findViewById(R.id.imageOneCircle).setOnClickListener(this);
        findViewById(R.id.imageTwoCircle).setOnClickListener(this);
        findViewById(R.id.imageThreeCircle).setOnClickListener(this);
        findViewById(R.id.imageFourCircle).setOnClickListener(this);
        findViewById(R.id.imageFiveCircle).setOnClickListener(this);
        findViewById(R.id.imageSixCircle).setOnClickListener(this);
        findViewById(R.id.imageSevenCircle).setOnClickListener(this);
        findViewById(R.id.imageEightCircle).setOnClickListener(this);
        findViewById(R.id.imageNineCircle).setOnClickListener(this);

        findViewById(R.id.imageOneSquare).setOnClickListener(this);
        findViewById(R.id.imageTwoSquare).setOnClickListener(this);
        findViewById(R.id.imageThreeSquare).setOnClickListener(this);
        findViewById(R.id.imageFourSquare).setOnClickListener(this);
        findViewById(R.id.imageFiveSquare).setOnClickListener(this);
        findViewById(R.id.imageSixSquare).setOnClickListener(this);
        findViewById(R.id.imageSevenSquare).setOnClickListener(this);
        findViewById(R.id.imageEightSquare).setOnClickListener(this);
        findViewById(R.id.imageNineSquare).setOnClickListener(this);

        findViewById(R.id.imageOneTriangle).setOnClickListener(this);
        findViewById(R.id.imageTwoTriangle).setOnClickListener(this);
        findViewById(R.id.imageThreeTriangle).setOnClickListener(this);
        findViewById(R.id.imageFourTriangle).setOnClickListener(this);
        findViewById(R.id.imageFiveTriangle).setOnClickListener(this);
        findViewById(R.id.imageSixTriangle).setOnClickListener(this);
        findViewById(R.id.imageSevenTriangle).setOnClickListener(this);
        findViewById(R.id.imageEightTriangle).setOnClickListener(this);
        findViewById(R.id.imageNineTriangle).setOnClickListener(this);

        findViewById(R.id.imageOneStar).setOnClickListener(this);
        findViewById(R.id.imageTwoStar).setOnClickListener(this);
        findViewById(R.id.imageThreeStar).setOnClickListener(this);
        findViewById(R.id.imageFourStar).setOnClickListener(this);
        findViewById(R.id.imageFiveStar).setOnClickListener(this);
        findViewById(R.id.imageSixStar).setOnClickListener(this);
        findViewById(R.id.imageSevenStar).setOnClickListener(this);
        findViewById(R.id.imageEightStar).setOnClickListener(this);
        findViewById(R.id.imageNineStar).setOnClickListener(this);

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
    private void newGame(){
        countField = 0;
        newGameBtn.setVisibility(View.INVISIBLE);
        backBtn.setVisibility(View.INVISIBLE);
        imageShapeQuantity1_1.setImageDrawable(null);
        imageShapeQuantity1_2.setImageDrawable(null);
        imageShapeQuantity2_1.setImageDrawable(null);
        imageShapeQuantity2_2.setImageDrawable(null);
        countField = 1;
        setQuantities();
        setShapes();
        newRound();

    }

    private void setQuantities(){
        int rand = 0;
        int count = 0;
        newQuantities = new int[2];
        selectedNums = new int[2];

        while (count < 2){
            Random random = new Random();
            int newRand = random.nextInt(9);
            if(newRand != rand){
                newQuantities[count] = quantities[newRand];
                selectedNums[count] = newRand;
                rand = newRand;
                count++;
            }
        }
        imageQuantity1.setImageBitmap(BitmapFactory.decodeResource(getResources(), newQuantities[0]));
        imageQuantity2.setImageBitmap(BitmapFactory.decodeResource(getResources(), newQuantities[1]));
    }

    private void setShapes(){
        int rand = 0;
        int count = 0;
        newShapes = new int[2];
        selectedShapes = new int[2];
        while (count < 2){
            Random random = new Random();
            int newRand = random.nextInt(4);
            if(newRand != rand){
                newShapes[count] = shapes[newRand];
                selectedShapes[count] = newRand;
                rand = newRand;
                count++;
            }
        }

        imageShape1.setImageBitmap(BitmapFactory.decodeResource(getResources(), newShapes[0]));
        imageShape2.setImageBitmap(BitmapFactory.decodeResource(getResources(), newShapes[1]));

    }

    @Override
    public void onClick(View view) {
        int selecNum = 0;
        int selecShape = 0;
        if(countField < 5) {
            switch (view.getId()) {

                case R.id.imageOneCircle:
                case R.id.imageTwoCircle:
                case R.id.imageThreeCircle:
                case R.id.imageFourCircle:
                case R.id.imageFiveCircle:
                case R.id.imageSixCircle:
                case R.id.imageSevenCircle:
                case R.id.imageEightCircle:
                case R.id.imageNineCircle:
                    selecShape = 0;
                    break;

                case R.id.imageOneSquare:
                case R.id.imageTwoSquare:
                case R.id.imageThreeSquare:
                case R.id.imageFourSquare:
                case R.id.imageFiveSquare:
                case R.id.imageSixSquare:
                case R.id.imageSevenSquare:
                case R.id.imageEightSquare:
                case R.id.imageNineSquare:
                    selecShape = 1;
                    break;

                case R.id.imageOneTriangle:
                case R.id.imageTwoTriangle:
                case R.id.imageThreeTriangle:
                case R.id.imageFourTriangle:
                case R.id.imageFiveTriangle:
                case R.id.imageSixTriangle:
                case R.id.imageSevenTriangle:
                case R.id.imageEightTriangle:
                case R.id.imageNineTriangle:
                    selecShape = 2;
                    break;

                case R.id.imageOneStar:
                case R.id.imageTwoStar:
                case R.id.imageThreeStar:
                case R.id.imageFourStar:
                case R.id.imageFiveStar:
                case R.id.imageSixStar:
                case R.id.imageSevenStar:
                case R.id.imageEightStar:
                case R.id.imageNineStar:
                    selecShape = 3;
                    break;
            }
            switch (view.getId()) {
                case R.id.imageOneCircle:
                case R.id.imageOneSquare:
                case R.id.imageOneTriangle:
                case R.id.imageOneStar:
                    selecNum = 0;
                    break;

                case R.id.imageTwoCircle:
                case R.id.imageTwoSquare:
                case R.id.imageTwoTriangle:
                case R.id.imageTwoStar:
                    selecNum = 1;
                    break;

                case R.id.imageThreeCircle:
                case R.id.imageThreeSquare:
                case R.id.imageThreeTriangle:
                case R.id.imageThreeStar:
                    selecNum = 2;
                    break;

                case R.id.imageFourCircle:
                case R.id.imageFourSquare:
                case R.id.imageFourTriangle:
                case R.id.imageFourStar:
                    selecNum = 3;
                    break;

                case R.id.imageFiveCircle:
                case R.id.imageFiveSquare:
                case R.id.imageFiveTriangle:
                case R.id.imageFiveStar:
                    selecNum = 4;
                    break;

                case R.id.imageSixCircle:
                case R.id.imageSixSquare:
                case R.id.imageSixTriangle:
                case R.id.imageSixStar:
                    selecNum = 5;
                    break;

                case R.id.imageSevenCircle:
                case R.id.imageSevenSquare:
                case R.id.imageSevenTriangle:
                case R.id.imageSevenStar:
                    selecNum = 6;
                    break;

                case R.id.imageEightCircle:
                case R.id.imageEightSquare:
                case R.id.imageEightTriangle:
                case R.id.imageEightStar:
                    selecNum = 7;
                    break;

                case R.id.imageNineCircle:
                case R.id.imageNineSquare:
                case R.id.imageNineTriangle:
                case R.id.imageNineStar:
                    selecNum = 8;
                    break;


            }

            if (selecNum == theNum && selecShape == theShape) {
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
                selectedView.setImageBitmap(BitmapFactory.decodeResource(getResources(), getPic(theShape, theNum)));
                selectedView.setBackgroundColor(Color.WHITE);
                countField++;
            } else {
                Toast.makeText(this, "Ooops... try again", Toast.LENGTH_SHORT).show();
            }
            newRound();
        }
    }

    private void newRound(){
        switch (countField){

            case 1 :
                selectedView = imageShapeQuantity1_1;
                selectedView.setBackgroundColor(Color.RED);
                theNum = selectedNums[0];
                theShape = selectedShapes[0];
                break;

            case 2 :
                selectedView = imageShapeQuantity1_2;
                selectedView.setBackgroundColor(Color.RED);
                theNum = selectedNums[1];
                theShape = selectedShapes[0];
                break;

            case 3 :
                selectedView = imageShapeQuantity2_1;
                selectedView.setBackgroundColor(Color.RED);
                theNum = selectedNums[0];
                theShape = selectedShapes[1];
                break;

            case 4 :
                selectedView = imageShapeQuantity2_2;
                selectedView.setBackgroundColor(Color.RED);
                theNum = selectedNums[1];
                theShape = selectedShapes[1];
                break;


            default:
                Toast.makeText(this, "You win!!", Toast.LENGTH_SHORT).show();
                newGameBtn.setVisibility(View.VISIBLE);
                backBtn.setVisibility(View.VISIBLE);

        }
    }

    private int getPic (int shape, int num){
        int pic = 0;
        switch (shape){
            case 0:
                switch (num){
                    case 0:
                        pic = R.drawable.one_circle;
                        break;
                    case 1:
                        pic = R.drawable.two_circle;
                        break;
                    case 2:
                        pic = R.drawable.three_circle;
                        break;
                    case 3:
                        pic = R.drawable.four_circle;
                        break;
                    case 4:
                        pic = R.drawable.five_circle;
                        break;
                    case 5:
                        pic = R.drawable.six_circle;
                        break;
                    case 6:
                        pic = R.drawable.seven_circle;
                        break;
                    case 7:
                        pic = R.drawable.eight_circle;
                        break;
                    case 8:
                        pic = R.drawable.nine_circle;
                        break;
                }
                break;
            case 1:
                switch (num){
                    case 0:
                        pic = R.drawable.one_square;
                        break;
                    case 1:
                        pic = R.drawable.two_square;
                        break;
                    case 2:
                        pic = R.drawable.three_square;
                        break;
                    case 3:
                        pic = R.drawable.four_square;
                        break;
                    case 4:
                        pic = R.drawable.five_square;
                        break;
                    case 5:
                        pic = R.drawable.six_square;
                        break;
                    case 6:
                        pic = R.drawable.seven_square;
                        break;
                    case 7:
                        pic = R.drawable.eight_square;
                        break;
                    case 8:
                        pic = R.drawable.nine_square;
                        break;
                }
                break;
            case 2:
                switch (num){
                    case 0:
                        pic = R.drawable.one_triangle;
                        break;
                    case 1:
                        pic = R.drawable.two_triangle;
                        break;
                    case 2:
                        pic = R.drawable.three_triangle;
                        break;
                    case 3:
                        pic = R.drawable.four_triangle;
                        break;
                    case 4:
                        pic = R.drawable.five_triangle;
                        break;
                    case 5:
                        pic = R.drawable.six_triangle;
                        break;
                    case 6:
                        pic = R.drawable.seven_triangle;
                        break;
                    case 7:
                        pic = R.drawable.eight_triangle;
                        break;
                    case 8:
                        pic = R.drawable.nine_triangle;
                        break;
                }
                break;
            case 3:
                switch (num){
                    case 0:
                        pic = R.drawable.one_star;
                        break;
                    case 1:
                        pic = R.drawable.two_star;
                        break;
                    case 2:
                        pic = R.drawable.three_star;
                        break;
                    case 3:
                        pic = R.drawable.four_star;
                        break;
                    case 4:
                        pic = R.drawable.five_star;
                        break;
                    case 5:
                        pic = R.drawable.six_star;
                        break;
                    case 6:
                        pic = R.drawable.seven_star;
                        break;
                    case 7:
                        pic = R.drawable.eight_star;
                        break;
                    case 8:
                        pic = R.drawable.nine_star;
                        break;
                }
                break;
        }
     return pic;
    }

}
