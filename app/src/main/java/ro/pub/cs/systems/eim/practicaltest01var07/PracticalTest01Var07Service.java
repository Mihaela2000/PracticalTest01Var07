package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class PracticalTest01Var07Service extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//
//
        int edit1 = intent.getIntExtra("editText1", 0);
        int edit2 = intent.getIntExtra("editText2", 0);
        int edit3 = intent.getIntExtra("editText3", 0);
        int edit4 = intent.getIntExtra("editText4", 0);

        ProcessThread processThread = new ProcessThread(this, edit1, edit2, edit3, edit4);
        processThread.start();

        return START_REDELIVER_INTENT;
    }

}
