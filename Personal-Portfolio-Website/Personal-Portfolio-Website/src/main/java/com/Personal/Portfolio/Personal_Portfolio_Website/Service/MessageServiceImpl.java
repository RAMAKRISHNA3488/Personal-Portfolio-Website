package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Message;
import com.Personal.Portfolio.Personal_Portfolio_Website.Repos.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	@Override
	public Message getMessageById(Long id) {
		return messageRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
	}

	@Override
	public Message createMessage(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public Message updateMessage(Long id, Message message) {
		Message existingMessage = getMessageById(id);
		existingMessage.setSender(message.getSender());
		existingMessage.setRecipient(message.getRecipient());
		existingMessage.setContent(message.getContent());
		existingMessage.setSendAt(message.getSendAt());
		return messageRepository.save(existingMessage);
	}

	@Override
	public void deleteMessage(Long id) {
		if (!messageRepository.existsById(id)) {
			throw new RuntimeException("Message not found with id: " + id);
		}
		messageRepository.deleteById(id);
	}

}
