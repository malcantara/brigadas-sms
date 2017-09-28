package mx.brigadas.sms.brigadassms.api;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.brigadas.sms.brigadassms.beans.SMSMessage;
import mx.brigadas.sms.brigadassms.domain.HelpRequest;
import mx.brigadas.sms.brigadassms.repository.HelpRequestRepository;

@RestController
@RequestMapping(path = "/api")
public class APIController {

	@Resource
	private HelpRequestRepository helpRequestRepository;

	@RequestMapping(path = "/sms", method = RequestMethod.POST)
	public void processSMS(@RequestBody SMSMessage message) {
		String[] messageContent = message.getText().split(" ");

		if ("AYUDA".equalsIgnoreCase(messageContent[0])) {
			processHelpRequest(messageContent, message.getNumber());
		}
	}

	private void processHelpRequest(String[] messageContent, String number) {
		// Help request message structure
		// [0] Code
		// [1] Town name
		// [2] Municipality
		// [3] State Code

		HelpRequest helpRequest = new HelpRequest();
		helpRequest.setContactPhoneNumber(number);
		helpRequest.setMunicipality(messageContent[2]);
		helpRequest.setStatus("PENDIENTE");
		helpRequest.setState(messageContent[3]);
		helpRequest.setTown(messageContent[1]);
		// TODO Use Time API
		helpRequest.setCreatedAt(new Date());
		helpRequestRepository.save(helpRequest);
	}

	@RequestMapping(path = "/sms", method = RequestMethod.GET)
	public List<HelpRequest> getSMS() {
		return helpRequestRepository.findAll();
	}
}
