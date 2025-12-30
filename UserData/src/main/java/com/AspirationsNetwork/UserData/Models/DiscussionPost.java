package com.AspirationsNetwork.UserData.Models;

import com.google.cloud.firestore.annotation.PropertyName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DiscussionPost {
    private String postID;      // Document ID in Firestore
    private String creatorUID;  // Firebase UID of the author
    private String creatorName; // Display name fetched from UserProfile
    private String subject;     // Short summary/headline
    private String content;     // Main body text
    private String category;    // e.g., "Financial Literacy", "Career Readiness"
    private Date creationTime;

    @PropertyName("upvotes") // Forces Java to use the lowercase field from Firestore
    private int upVotes = 0;

    @PropertyName("upvotes")
    public int getUpVotes() { return upVotes; }

    @PropertyName("upvotes")
    public void setUpVotes(int upVotes) { this.upVotes = upVotes; }
}
