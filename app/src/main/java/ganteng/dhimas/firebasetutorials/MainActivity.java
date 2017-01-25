package ganteng.dhimas.firebasetutorials;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button mFirebaseBtn;

    private DatabaseReference mDatabase;

    private EditText mNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseBtn = (Button) findViewById(R.id.firebase_btn);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mNameField = (EditText) findViewById(R.id.name_field);

        mFirebaseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String name = mNameField.getText().toString().trim();

                mDatabase.child("Name").setValue(name);
            }
        });
    }
}
