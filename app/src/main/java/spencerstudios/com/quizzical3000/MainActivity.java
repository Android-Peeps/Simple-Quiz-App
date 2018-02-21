package spencerstudios.com.quizzical3000;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private int ans = QuestionFactory.ANSWERS.length;
    private RadioButton[] radioButton = new RadioButton[ans];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buildUserInterface();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void buildUserInterface() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.root_layout);
        int c = 0, d = 0;

        for (int i = 0; i < ans; i++) {
            if (i % 12 == 0) {
                TextView tvTopic = new TextView(this);
                tvTopic.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                tvTopic.setTypeface(Typeface.create("normal", Typeface.BOLD));
                tvTopic.setText(QuestionFactory.TOPICS[d]);
                ll.addView(tvTopic);
                d++;
            }
            if (i % 3 == 0) {
                TextView tvQuestion = new TextView(this);
                tvQuestion.setTypeface(Typeface.create("casual", Typeface.BOLD));
                radioGroup = new RadioGroup(this);
                tvQuestion.setText("\n".concat(QuestionFactory.QUESTIONS[c]));
                c++;
                ll.addView(tvQuestion);
                ll.addView(radioGroup);
            }
            radioButton[i] = new RadioButton(this);
            radioButton[i].setTypeface(Typeface.create("casual", Typeface.NORMAL));
            radioButton[i].setText(QuestionFactory.ANSWERS[i]);
            radioGroup.addView(radioButton[i]);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateScore();
            }
        });
    }

    private void calculateScore() {
        int score = 0;
        for (int i : QuestionFactory.CORRECT_ANSWERS_INDEX)
            if (radioButton[i].isChecked()) score++;
        displayScoreDialog(score, QuestionFactory.CORRECT_ANSWERS_INDEX.length);
    }

    private void displayScoreDialog(int score, int total) {
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.setTitle("Results");
        if (score != total)
            dialog.setMessage("You got " + score + " questions correct of " + total + "\nYou can do better, give it another go");
        else dialog.setMessage("Wow, you got all " + total + " questions correct!!!");
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
