package com.AspirationsNetwork.UserData.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Comment {

    private String commentID;      // Document ID in Firestore
    private String postID;
    private String creatorUID;  // Firebase UID of the author
    private String commenterName; // Display name fetched from UserProfile
    private String content;     // Main body text
    private Date creationTime;
}
