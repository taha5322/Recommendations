package com.siddiqui.recommendations.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

    // Created by Taha Siddiqui
    // 16/01/2021
public class DatabaseBuilder {

    private FirebaseFirestore db;

    public DatabaseBuilder(Context context) {

        LiveData<String> data = new MutableLiveData<String>();

        FirebaseApp.initializeApp(context);
        db = FirebaseFirestore.getInstance();

        // [START set_firestore_settings]
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
        // [END set_firestore_settings]

    }
    public FirebaseFirestore getDatabase(){
        return this.db;
    }


    public void addOrUpdateData(String collection1, String doc1, String col2, String doc2,
                                String field, String value){
        //Sample input
//        DocumentReference reference = db.collection("Business").document("Barbers")
//                .collection("Magicuts").document("Magicuts");
//        reference.update("Location","Toronto", "Rating", 4)

        //Update test
        DocumentReference reference = db.collection(collection1).document(doc1)
                .collection(col2).document(doc2);
        reference.update(field,value)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("TAGG","Sucessful updaate");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("TAGG", "Epic fail", e);
            }
        });
    }

    public MutableLiveData<String> fetchData(String collection1, String doc1, String col2, String doc2) {

        //fetching data
        //before: "users"

        final MutableLiveData<String> data = new MutableLiveData<>();

        System.out.println("outer loop ran");
        DocumentReference reference = db.collection(collection1).document(doc1)
                .collection(col2).document(doc2);
        reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    System.out.println("TASK is successful ran");
                    if (document.exists()) {
                        Log.d("TAGG", "DocumentSnapshot data: " + document.getData());
                        System.out.println("DOCUMENT EXIST RAN");
                        System.out.println("Value of document "+ document.getData());
                        System.out.println("\" "+convertWithIteration(document.getData()) +" \"");
                        data.setValue(convertWithIteration(document.getData()));
                        System.out.println("This is str at 0"+ data.getValue());
                    } else {
                        Log.d("TAGG", "No such document");
                        System.out.println("DOCUMENT DOESNT EXIST RAN");
                    }
                }  else{
                    Log.d("TAGG","get failed with ",task.getException());
                    System.out.println("TASK WASNT SUCCESSFUl");
                }
            }
            });
        return data;
    }
        public String convertWithIteration(Map<String, Object> map) {
            StringBuilder mapAsString = new StringBuilder("{");
            for (String key : map.keySet()) {
                mapAsString.append(key + "=" + map.get(key) + ", ");
            }
            mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
            return mapAsString.toString();
        }
}
