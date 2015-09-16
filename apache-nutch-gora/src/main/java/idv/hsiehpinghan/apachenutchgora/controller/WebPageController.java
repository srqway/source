package idv.hsiehpinghan.apachenutchgora.controller;

import idv.hsiehpinghan.apachenutchgora.criteria.WebPageCriteria;
import idv.hsiehpinghan.apachenutchgora.service.WebPageService;
import idv.hsiehpinghan.apachenutchgora.vo.WebPageVo;

import java.io.IOException;
import java.util.List;

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
	public List<WebPageVo> query(WebPageCriteria criteria) throws IOException,
			Exception {
		String startKey = criteria.getStartKey();
		long limit = criteria.getLimit();
		return service.query(startKey, limit);
	}

	@ResponseBody
	@RequestMapping(value = "/queryContent", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String queryContent(WebPageCriteria criteria) throws IOException,
			Exception {
		String key = criteria.getKey();
		return service.queryContent(key);	                       
	}

	@ResponseBody
	@RequestMapping(value = "/queryText", method = RequestMethod.GET)
	public String queryText(WebPageCriteria criteria) throws IOException,
			Exception {
		String key = criteria.getKey();
		return service.queryText(key);
	}

}
