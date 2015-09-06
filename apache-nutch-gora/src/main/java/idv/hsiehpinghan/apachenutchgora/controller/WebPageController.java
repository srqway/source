package idv.hsiehpinghan.apachenutchgora.controller;

import idv.hsiehpinghan.apachenutchgora.service.WebPageService;
import idv.hsiehpinghan.apachenutchgora.vo.WebPageVo;

import java.io.IOException;

import org.apache.gora.query.Result;
import org.apache.nutch.storage.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/webPage")
public class WebPageController {
	@Autowired
	private WebPageService service;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "webPage/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public WebPageVo query() throws IOException, Exception {
		Result<String, WebPage> result = service.query("", 1000);
		while (result.next()) {
			return WebPageVo.generateWebPageVo(result);
		}
		return null;
	}
	
//	@RequestMapping(value = "/query", method = RequestMethod.GET)
//	public ModelAndView query() throws IOException, Exception {
//		Result<String, WebPage> result = service.query("", 1000);
//		
//		ModelAndView mv = new ModelAndView("webPage/query");
//		mv.addObject("webPages", result);
//		while (result.next()) {
//			System.err.println(result.getKey());
//		}
//		return mv;
//	}
}
