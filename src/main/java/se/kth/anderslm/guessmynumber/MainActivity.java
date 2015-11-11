package se.kth.anderslm.guessmynumber;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditGuess;
    private Button mGuessButton;
    private TextView mOutputInfo;

    private GuessMyNumberModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEditGuess = (EditText) findViewById(R.id.editGuess);
        mGuessButton = (Button) findViewById(R.id.guessButton);
        mOutputInfo = (TextView) findViewById(R.id.outputInfo);

        mGuessButton.setOnClickListener(new GuessListener());
        mEditGuess.setOnClickListener(new GuessListener());

        model = new GuessMyNumberModel(4712);
    }

    private void handleGuess() {
        String input = mEditGuess.getText().toString();
        try {
            if(input != null && input.length() > 0) {
                int guess = Integer.parseInt(input);
                model.setGuess(guess);
                String old = mOutputInfo.getText().toString();
                String info
                        = "#" + model.getNoOfGuesses() + ": " + model.getGuess() + ", "
                        + model.compareGuessToNumberToString() + "\n";
                mOutputInfo.setText(info + old);
            }
        }
        catch(NumberFormatException ne) {
            showToast("Enter a number!");
        }
    }

    private class GuessListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            handleGuess();
        }
    }

    private void showToast(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
