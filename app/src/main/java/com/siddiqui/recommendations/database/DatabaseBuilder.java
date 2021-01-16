package com.siddiqui.recommendations.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

    // Created by Taha Siddiqui
    // 16/01/2021
public class DatabaseBuilder {

    private FirebaseFirestore db;

    public DatabaseBuilder(Context context) {

        FirebaseApp.initializeApp(context);
        db = FirebaseFirestore.getInstance();

    }
    public void addDate(Map<String,Object> map){
//        Map<String, Object> user = new HashMap<>();
//        user.put("first", "Ada");
//        user.put("last", "Lovelace");
//        user.put("born", 1815);

        // Add a new document with a generated ID
        db.collection("users")
                .add(map)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAGG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAGG", "Error adding document", e);
                    }
                });

    }
    public void fetchData(String collectionPath) {

        //fetching data
        //before: "users"
        db.collection(collectionPath)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                                System.out.println("TAGG"+document.getData());
                            }
                        } else {
                            Log.w("TAGG", "Error getting documents.", task.getException());
                            System.out.println();
                        }
                    }
                });
    }
}
