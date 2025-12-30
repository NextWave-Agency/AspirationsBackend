package com.AspirationsNetwork.UserData.Service;

import com.AspirationsNetwork.UserData.DTO.UserProfileCreationDTO;
import com.AspirationsNetwork.UserData.Models.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private  final Firestore firestore;
    private static final String COLLECTION_NAME = "aspirationnetworkusers";


    @Autowired
    private Firestore db;

    public User getUser(String id) throws ExecutionException, InterruptedException {
        System.out.println("Searching Firestore for UID: " + id);

        DocumentReference docRef = firestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) {
            return document.toObject(User.class);
        }
        return null;
    }
    public String createUserDetails(@NonNull UserProfileCreationDTO dto) throws ExecutionException, InterruptedException {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUid(dto.getUid());
        user.setAccountType("member");
        user.setRole("member");

        firestore.collection(COLLECTION_NAME).document(dto.getUid()).set(user).get();

        return dto.getUid();
    }


}
