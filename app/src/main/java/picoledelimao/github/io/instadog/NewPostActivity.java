package picoledelimao.github.io.instadog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * This activity deals with the creation of a new post
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class NewPostActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_ID = 234;

    private Bitmap mPhoto;
    private EditText mEtDescription;
    private ImageButton mBtPhotoUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEtDescription = (EditText) findViewById(R.id.etDescription);
        mBtPhotoUpload = (ImageButton) findViewById(R.id.btUploadPhoto);
        mBtPhotoUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chooseImageIntent = ImagePicker.getPickImageIntent(NewPostActivity.this);
                startActivityForResult(chooseImageIntent, PICK_IMAGE_ID);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_post) {
            String description = mEtDescription.getText().toString();
            post(mPhoto, description);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case PICK_IMAGE_ID:
                Bitmap bitmap = ImagePicker.getImageFromResult(this, resultCode, data);
                if (bitmap != null) {
                    mPhoto = bitmap;
                    mBtPhotoUpload.setImageBitmap(bitmap);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

    /**
     * This method is responsible for creating a new post
     * @param bitmap Post image
     * @param description Post description
     */
    private void post(Bitmap bitmap, String description) {
        //  TODO Insert code with correct implementation here
    }

}
