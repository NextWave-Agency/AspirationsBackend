package com.AspirationsNetwork.UserData.Controller;

import com.AspirationsNetwork.UserData.DTO.UserProfileCreationDTO;
import com.AspirationsNetwork.UserData.Models.Comment;
import com.AspirationsNetwork.UserData.Models.DiscussionPost;
import com.AspirationsNetwork.UserData.Models.User;
import com.AspirationsNetwork.UserData.Service.DiscussionPostService;
import com.AspirationsNetwork.UserData.Service.UserInfoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "https://aspirationnetwork-a633f.web.app"})
@RequestMapping("/api")
public class UserInfoController {
    private final UserInfoService userInfoService;
    private  final DiscussionPostService discussionPostService;

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        try {
            User user = userInfoService.getUser(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/getCommentForPost/{postID}")
    public ResponseEntity<List<Comment>> getCommentsForPost(@PathVariable String postID) throws Exception {
        try{
            List<Comment> res = discussionPostService.getCommentsForPost(postID);
            return  ResponseEntity.ok(res);
        }catch (Exception e){
            return  ResponseEntity.internalServerError().body((List<Comment>) e);
        }

    }
    @PostMapping("/upVote/{postID}")
    public ResponseEntity<List<Comment>> upVote(@PathVariable String postID) throws Exception {
        try{
         discussionPostService.upvotePost(postID);
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return  ResponseEntity.internalServerError().body((List<Comment>) e);
        }

    }


    @DeleteMapping("/deletePost/{postID}")
    public ResponseEntity<String> deletePost(@PathVariable String postID) throws Exception {
        try{
            discussionPostService.deletePost(postID);
            return  ResponseEntity.ok("Deleted");
        }catch (Exception e){
            return  ResponseEntity.internalServerError().body("Error Deleting" + e);
        }

    }



    @PostMapping("/createProfile")
    public ResponseEntity<String> createProfile(@RequestBody UserProfileCreationDTO dto) {
        try {
            String id = userInfoService.createUserDetails(dto);
            return ResponseEntity.ok("Profile created with ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/creatPost")
    public ResponseEntity<String> createPost(@RequestBody DiscussionPost discussionPost){
        try{
            String postID = discussionPostService.createDiscussionPost(discussionPost);

            return  ResponseEntity.ok(postID);
        } catch (Exception e){
            return  ResponseEntity.internalServerError().body("Couldn't make the post, got following error" + e);
        }

    }

    @PostMapping("/createComment")
    public ResponseEntity<String> createComment(@RequestBody Comment comment){
        try{
            String commentID = discussionPostService.createComment(comment);

            return  ResponseEntity.ok(commentID);
        } catch (Exception e){
            return  ResponseEntity.internalServerError().body("Couldn't make the post, got following error" + e);
        }

    }



    @GetMapping("/getallpost")
    public ResponseEntity<List<DiscussionPost>> getallPost() throws Exception {
        try{
            List<DiscussionPost> res = discussionPostService.getAllPosts();
            return  ResponseEntity.ok(res);
        }catch (Exception e){
            return  ResponseEntity.internalServerError().body((List<DiscussionPost>) e);
        }

    }





}
