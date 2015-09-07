package idv.hsiehpinghan.apachenutchgora.controller;

import idv.hsiehpinghan.apachenutchgora.criteria.WebPageCriteria;
import idv.hsiehpinghan.apachenutchgora.service.WebPageService;
import idv.hsiehpinghan.apachenutchgora.vo.WebPageVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.gora.query.Result;
import org.apache.nutch.storage.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public List<WebPageVo> query(
			@ModelAttribute("criteria") WebPageCriteria criteria)
			throws IOException, Exception {
		String startKey = criteria.getStartKey();
		long limit = criteria.getLimit();
		Result<String, WebPage> result = service.query(startKey, limit);
		List<WebPageVo> webPageVos = new ArrayList<WebPageVo>();
		while (result.next()) {
			webPageVos.add(WebPageVo.generateWebPageVo(result));
		}
		return webPageVos;
	}

	// @RequestMapping(value = "/query", method = RequestMethod.GET)
	// public ModelAndView query() throws IOException, Exception {
	// Result<String, WebPage> result = service.query("", 1000);
	//
	// ModelAndView mv = new ModelAndView("webPage/query");
	// mv.addObject("webPages", result);
	// while (result.next()) {
	// System.err.println(result.getKey());
	// }
	// return mv;
	// }
}
