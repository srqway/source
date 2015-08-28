package idv.hsiehpinghan.apachenutchgora.controller;

import java.io.IOException;

import idv.hsiehpinghan.apachenutchgora.service.WebPageService;

import org.apache.gora.query.Result;
import org.apache.nutch.storage.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/webPage")
public class WebPageController {
	@Autowired
	private WebPageService service;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() throws IOException, Exception {

		Result<String, WebPage> result = service.query("", 1000);
		while (result.next()) {
			System.err.println(result.getKey());
		}
		return "webPage/index";
	}
}
