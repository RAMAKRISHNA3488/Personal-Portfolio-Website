package com.Personal.Portfolio.Personal_Portfolio_Website.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
