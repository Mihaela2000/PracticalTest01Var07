package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    Button button1;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        button1 = findViewById(R.id.button1);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        button1.setOnClickListener(it -> {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
            intent.putExtra("editText1", editText1.getText().toString());
            intent.putExtra("editText2", editText2.getText().toString());
            intent.putExtra("editText3", editText3.getText().toString());
            intent.putExtra("editText4", editText4.getText().toString());
            startActivityForResult(intent, 1);

        });

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("editText1", editText1.getText().toString());
        savedInstanceState.putString("editText2", editText2.getText().toString());
        savedInstanceState.putString("editText3", editText3.getText().toString());
        savedInstanceState.putString("editText4", editText4.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("editText1")) {
            editText1.setText(savedInstanceState.getString("editText1"));
        }
        if (savedInstanceState.containsKey("editText2")) {
            editText2.setText(savedInstanceState.getString("editText2"));
        }
        if (savedInstanceState.containsKey("editText3")) {
            editText3.setText(savedInstanceState.getString("editText3"));
        }
        if (savedInstanceState.containsKey("editText4")) {
            editText4.setText(savedInstanceState.getString("editText4"));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result = intent.getStringExtra("result");
                editText1.setText(result);
            }
        }
    }
}