

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.auth.oauth2.GoogleCredentials;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class firebase {
    public static void inicializacion() {
        Dotenv dotenv = Dotenv.load();
        try {
            FileInputStream serviceAccount = new FileInputStream(dotenv.get("FIRABASELOGIN"));

            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(dotenv.get("FIRABASETOKEN"))
                .build();

            FirebaseApp.initializeApp(options);

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getDatabase() {
        inicializacion();
        final StringBuilder result = new StringBuilder();
        final CountDownLatch latch = new CountDownLatch(1);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                result.append(dataSnapshot.getValue().toString());
                latch.countDown();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Error: " + databaseError.getMessage());
                latch.countDown();
            }
        });

        try {
            latch.await(); // Espera a que se complete la operación de lectura
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getDatabase());
    }
}