package idv.hsiehpinghan.apachenutchtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/getMethod")
public class GetMethodController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "getMethod/index";
	}

	@RequestMapping(value = "/subPage/subPage1", method = RequestMethod.GET)
	public String subPageSubPage1() {
		return "getMethod/subPage/subPage1";
	}

	@RequestMapping(value = "/subPage/subPage2", method = RequestMethod.GET)
	public String subPageSubPage2() {
		return "getMethod/subPage/subPage2";
	}
	
}
