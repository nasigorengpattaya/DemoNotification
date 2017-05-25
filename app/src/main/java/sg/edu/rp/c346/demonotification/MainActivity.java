package sg.edu.rp.c346.demonotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int requestcode = 123;
    int notificationID = 888;

    Button notify1, notify2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         notify1 = (Button)findViewById(R.id.buttonNotify1);
         notify2 = (Button)findViewById(R.id.buttonNotify2);

         notify1.setOnClickListener(new View.OnClickListener() {
             @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, MainActivity.class);
                 PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestcode, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                 Notification.Builder builder = new Notification.Builder(MainActivity.this);
                 builder.setContentTitle("Amazing Offer");
                 builder.setContentText("Subject");
                 builder.setSmallIcon(R.mipmap.ic_launcher);
                 builder.setContentIntent(pendingIntent);
                 builder.setAutoCancel(true);

                 Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                 builder.setSound(uri);
                 builder.setPriority(Notification.PRIORITY_HIGH);

                 Notification n = builder.build();
                 NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                 notificationManager.notify(notificationID, n);
                 finish();

             }
         });

        notify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, requestcode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                Notification.BigTextStyle bigText = new Notification.BigTextStyle();
                bigText.bigText("This is one big text");
                bigText.setBigContentTitle("Big Text - Long Content");
                bigText.setSummaryText("Reflection Journal?");
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Amazing Offer");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pendingIntent);
                builder.setStyle(bigText);
                builder.setAutoCancel(true);

                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(notificationID, n);
                finish();
            }
        });
    }
}
