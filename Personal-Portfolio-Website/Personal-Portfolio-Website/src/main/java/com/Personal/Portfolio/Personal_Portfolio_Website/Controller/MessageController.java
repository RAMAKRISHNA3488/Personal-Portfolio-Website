package com.Personal.Portfolio.Personal_Portfolio_Website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Message;
import com.Personal.Portfolio.Personal_Portfolio_Website.Service.MessageService;

@Controller
@RequestMapping("/api/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping
	public ResponseEntity<List<Message>> getAllMessages() {
		return ResponseEntity.ok(messageService.getAllMessages());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
		return ResponseEntity.ok(messageService.getMessageById(id));
	}

	@PostMapping
	public ResponseEntity<Message> createMessage(@RequestBody Message message) {
		return ResponseEntity.ok(messageService.createMessage(message));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message message) {
		return ResponseEntity.ok(messageService.updateMessage(id, message));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
		messageService.deleteMessage(id);
		return ResponseEntity.noContent().build();
	}

}
