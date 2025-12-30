package com.AspirationsNetwork.UserData.Controller;

import com.AspirationsNetwork.UserData.Models.User;
import com.AspirationsNetwork.UserData.Service.UserInfoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoService userInfoService;

    @GetMapping("/")
    public ResponseEntity<User> getUser() throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(userInfoService.getUser());
    }
}
