package course.cs246.ryanhildreth.favoritescripture;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static course.cs246.ryanhildreth.favoritescripture.R.id.bookText;
import static course.cs246.ryanhildreth.favoritescripture.R.id.chapterText;
import static course.cs246.ryanhildreth.favoritescripture.R.id.verseText;


public class FavoriteScripture extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "course.cs246.ryanhildreth.favoritescripture.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_scripture);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_favorite_scripture, menu);
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

    /** Called when the user clicks the Send button */
    public void submitMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText;
        String message = "Your favorite scripture is: \n";
        editText = (EditText) findViewById(bookText);
        message += editText.getText().toString() + " ";
        editText = (EditText) findViewById(chapterText);
        message += editText.getText().toString() + ":";
        editText = (EditText) findViewById(verseText);
        message += editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
