package com.example.ucupalandi12.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Performs a very simple background task, in this case, just sleeps!
 */
public class SimpleAsyncTask extends AsyncTask <Void, Void, String> {

  // The TextView where we will show results
  private TextView mTextView;

  // Constructor that provides a reference to the TextView from the MainActivity
  public SimpleAsyncTask (TextView tv) {
    mTextView = tv;
  }

  /**
   * Runs on the background thread
   *
   * @param voids No parameters in this use case.
   * @return Returns the string including the amount of time that
   * the background thread slept.
   */
  @Override
  protected String doInBackground(Void... voids) {

    // Generate a random number between 0 and 10
    Random r = new Random();
    int n = r.nextInt(11);

    /* Make the task take long enough that we have
    time to rotate the phone while it is running
     */
    int s = n * 200;

    // Sleep for a random amount of time
    try{
      Thread.sleep(s);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Return a String result
    return "Awake at last after sleeping for " + s + " milliseconds!";
  }

  protected void onPostExecute(String result){
    mTextView.setText(result);
  }

}
