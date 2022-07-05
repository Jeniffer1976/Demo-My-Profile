package sg.edu.rp.c346.id21025290.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float ftGPA = Float.parseFloat(etGPA.getText().toString());

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEdit = prefs.edit();

        prefsEdit.putString("name",strName);
        prefsEdit.putFloat("gpa",ftGPA);
        prefsEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name", "John");
        float gpa = prefs.getFloat("gpa", 0);

        etName.setText(name);
        etGPA.setText(String.valueOf(gpa));

    }
}