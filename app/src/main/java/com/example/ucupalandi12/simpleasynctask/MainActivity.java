package com.example.ucupalandi12.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ucupalandi12.simpleasynctask.R;

/**
 * The SimpleAsyncTask app contains a button that launches an AsyncTask
 * which sleeps in the asynchronous thread for a random amount of time.
 */
public class MainActivity extends AppCompatActivity {

  // Key for saving the state of the Text of the TextView
  private static final String TEXT_STATE = "currentText";

  // The TextView where we will show results
  private TextView mTextView = null;

  /**
   * Initializes the activity
   * @param savedInstanceState The current state data
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Initializes mTextView
    mTextView = (TextView) findViewById(R.id.textView1);

    // Restore TextView if there is savedInstanceState
    if (savedInstanceState != null){
      mTextView.setText(savedInstanceState.getString(TEXT_STATE));
    }
  }

  /**
   * Handles the onClick for the "Start Task" button. Launches the Async Task
   * which performs work off of the UI thread.
   *
   * @param view The view (Button) that was clicked.
   */
  public void startTask(View view) {
    // Put a message in the text view
    mTextView.setText(R.string.napping);

    // Start the Async Task.
    //The Async Task has a callback that will update the text view
    new SimpleAsyncTask(mTextView).execute();
  }

  /**
   * Saves the contents of the TextView to restore on configuration change.
   * @param outState The bundle in which the state of the activity is saved
   * when it's spontaneously destroyed
   */
  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    // Save the state of the TextView
    outState.putString(TEXT_STATE, mTextView.getText().toString());
  }
}
