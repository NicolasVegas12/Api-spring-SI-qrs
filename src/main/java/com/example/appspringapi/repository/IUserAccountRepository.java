package com.example.appspringapi.repository;

import com.example.appspringapi.webApi.models.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccountRepository  extends JpaRepository<UserAccount,Long> {
    UserAccount findUserAccountByUserAccountAndPassword(String userAccount, String password);
}
