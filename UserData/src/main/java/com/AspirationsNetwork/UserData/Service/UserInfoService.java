package com.AspirationsNetwork.UserData.Service;

import com.AspirationsNetwork.UserData.Models.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private  final Firestore firestore;



    @Autowired
    private Firestore db;

    public User getUser() throws ExecutionException, InterruptedException {
        var userDoc = firestore.collection("users").document("demo");
        var future = userDoc.get();
        var snapShot = future.get();
        if(snapShot.exists()){
            return snapShot.toObject(User.class);
        }else {
            return null;
        }





    }


}
