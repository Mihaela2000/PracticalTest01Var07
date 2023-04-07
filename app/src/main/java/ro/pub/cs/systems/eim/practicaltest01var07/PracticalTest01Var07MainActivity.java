package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    Button button1;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
    private IntentFilter intentFilter = new IntentFilter();

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
            startPracticalService();
            intent.putExtra("editText2", editText2.getText().toString());
            startPracticalService();
            intent.putExtra("editText3", editText3.getText().toString());
            startPracticalService();
            intent.putExtra("editText4", editText4.getText().toString());
            startPracticalService();
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

    // servicii

    private void startPracticalService() {
        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07Service.class);
        intent.putExtra("editText1", editText1.getText().toString());
        intent.putExtra("editText2", editText2.getText().toString());
        intent.putExtra("editText3", editText3.getText().toString());
        intent.putExtra("editText4", editText4.getText().toString());

        getApplicationContext().startService(intent);
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07Service.class);
        stopService(intent);
        super.onDestroy();
    }

    private class MessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d ("[Message]", intent.getStringExtra("message"));
        }
    }

    protected void onResume() {
        super.onResume();
        registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    protected void onPause() {
        unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }


}