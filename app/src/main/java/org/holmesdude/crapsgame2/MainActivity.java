package org.holmesdude.crapsgame2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView1, imageView2;
    private TextView dice1TextView, dice2TextView, winLoseTextView, winStat, loseStat;

    int value1 = 0;
    int value2 = 0;
    int dieSum = 0;
    int rollNumber = 1;
    int[] myPoint = {0};
    int wins = 0;
    int loss = 0;


    private enum GameStatus{WON, LOST, CONTINUE};
    private final static int SEVEN = 7;
    private final static int YO_LEVEN = 11;
    private final static int SNAKE_EYES = 2;
    private final static int TREY = 3;
    private final static int BOX_CARS = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollDices = (Button) findViewById(R.id.rollDices);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        dice1TextView = (TextView) findViewById(R.id.dice1ResultTextView);
        dice2TextView = (TextView) findViewById(R.id.dice2ResultTextView);

        winLoseTextView = (TextView) findViewById(R.id.winLoseTextView);
        winStat = (TextView) findViewById(R.id.winStat);
        loseStat = (TextView) findViewById(R.id.loseStat);



        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = randomDiceValue();
                value2 = randomDiceValue();
                dieSum = value1+value2;



                int res1 = getResources().getIdentifier("dice_" + value1, "drawable", "org.holmesdude.crapsgame2");
                int res2 = getResources().getIdentifier("dice_" + value2, "drawable", "org.holmesdude.crapsgame2");

                imageView1.setImageResource(res1);
                imageView2.setImageResource(res2);

                dice1TextView.setText("DIE 1 RESULT IS " + value1);
                dice2TextView.setText("DIE 2 RESULT IS " + value2);



                if(rollNumber==1)
                {
                    if (dieSum == 7 || dieSum == 11) {
                        openDialogWin();
                        wins++;
                        winStat.setText("WINS = " + wins);
                    }//endif
                    else if (dieSum == 2 || dieSum == 3 || dieSum == 12) {
                        openDialogLose();
                        loss++;
                        loseStat.setText("LOSS = " + loss);
                    }//end elseif
                    else {
                        myPoint[0] = dieSum;
                        //myPoint[0]++;
                        winLoseTextView.setText("YOUR POINT IS " + myPoint[0]);
                        rollNumber++;
                    }//end else
                }//endif rollNumber case
                else
                {
                    if(dieSum==7){
                        openDialogLose();
                        myPoint[0]=0;
                        loss++;
                        loseStat.setText("LOSS = " + loss);
                        winLoseTextView.setText("YOUR AGAIN POINT IS " + myPoint[0]);
                        rollNumber--;
                    }
                    else if(dieSum == myPoint[0]){
                        openDialogWin();
                        myPoint[0]=0;
                        wins++;
                        winStat.setText("WINS = " + wins);
                        winLoseTextView.setText("YOUR AGAIN POINT IS " + myPoint[0]);
                        rollNumber--;
                    }

                }//end else

            }//end onclick


        });//end onclicklistener
        //winLoseTextView.setText("YOUR POINT IS " + myPoint[0]);
        /*GameStatus thisGame;
        switch(dieSum)
        {
            case SEVEN:
            case YO_LEVEN:
                thisGame = GameStatus.WON;
                openDialogWin();
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                thisGame = GameStatus.LOST;
                openDialogLose();
                break;
            default:
                thisGame = GameStatus.CONTINUE;
                myPoint = dieSum;
                winLoseTextView.setText("YOUR POINT IS " + myPoint);
                break;
        }//end switch dieRoll

        while(thisGame==GameStatus.CONTINUE)
        {
            winLoseTextView.setText("YOUR POINT IS " + myPoint);
            dieSum = value1+value2;
            if (dieSum == myPoint)
            {
                thisGame = GameStatus.WON;
            }//endif
            else
            {
                if(dieSum == SEVEN)
                {
                    thisGame = GameStatus.LOST;
                }//endif
            }//endelse
        }//end while

        if (thisGame == GameStatus.WON)
        {
            thisGame = GameStatus.WON;
        }//endif
        else
        {
            thisGame = GameStatus.LOST;
        }//endelse
        //winLoseTextView.setText("");*/
    }




    //#############DO NOT WRITE HERE


    public void openDialogWin(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "Example Dialog");
    }

    public void openDialogLose(){
        ExampleDialogLose exampleDialogLose = new ExampleDialogLose();
        exampleDialogLose.show(getSupportFragmentManager(),"Example Dialog");
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }



}