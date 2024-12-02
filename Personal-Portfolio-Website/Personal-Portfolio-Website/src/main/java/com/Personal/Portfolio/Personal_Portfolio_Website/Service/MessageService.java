package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Message;

public interface MessageService {
	List<Message> getAllMessages();

	Message getMessageById(Long id);

	Message createMessage(Message message);

	Message updateMessage(Long id, Message message);

	void deleteMessage(Long id);

}
