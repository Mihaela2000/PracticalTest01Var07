package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    Button sumButton;
    Button prodButton;
    EditText editText1Nav;
    EditText editText2Nav;
    EditText editText3Nav;
    EditText editText4Nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        sumButton = findViewById(R.id.sum_button);
        prodButton = findViewById(R.id.prod_button);
        editText1Nav = findViewById(R.id.editText1_nav);
        editText2Nav = findViewById(R.id.editText2_nav);
        editText3Nav = findViewById(R.id.editText3_nav);
        editText4Nav = findViewById(R.id.editText4_nav);

        sumButton.setOnClickListener(it -> {
            int sum = Integer.parseInt(editText1Nav.getText().toString()) + Integer.parseInt(editText2Nav.getText().toString()) + Integer.parseInt(editText3Nav.getText().toString()) + Integer.parseInt(editText4Nav.getText().toString());
            editText1Nav.setText(String.valueOf(sum));
            Toast toast = Toast.makeText(getApplicationContext(), "The sum is " + sum, Toast.LENGTH_LONG);
            
        });

        prodButton.setOnClickListener(it -> {
            int prod = Integer.parseInt(editText1Nav.getText().toString()) * Integer.parseInt(editText2Nav.getText().toString()) * Integer.parseInt(editText3Nav.getText().toString()) * Integer.parseInt(editText4Nav.getText().toString());
            editText1Nav.setText(String.valueOf(prod));
            Toast toast = Toast.makeText(getApplicationContext(), "The product is " + prod, Toast.LENGTH_LONG);
        });

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("editText1Nav")) {
                editText1Nav.setText(savedInstanceState.getString("editText1Nav"));
            }
            if (savedInstanceState.containsKey("editText2Nav")) {
                editText2Nav.setText(savedInstanceState.getString("editText2Nav"));
            }
            if (savedInstanceState.containsKey("editText3Nav")) {
                editText3Nav.setText(savedInstanceState.getString("editText3Nav"));
            }
            if (savedInstanceState.containsKey("editText4Nav")) {
                editText4Nav.setText(savedInstanceState.getString("editText4Nav"));
            }
        } else {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                if (extras.containsKey("editText1")) {
                    editText1Nav.setText(extras.getString("editText1"));
                }
                if (extras.containsKey("editText2")) {
                    editText2Nav.setText(extras.getString("editText2"));
                }
                if (extras.containsKey("editText3")) {
                    editText3Nav.setText(extras.getString("editText3"));
                }
                if (extras.containsKey("editText4")) {
                    editText4Nav.setText(extras.getString("editText4"));
                }
            }
        }



    }
}