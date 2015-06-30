package idv.hsiehpinghan.apachenutchtest.controller;

import idv.hsiehpinghan.apachenutchtest.dto.WebpageData;
import idv.hsiehpinghan.apachenutchtest.service.WebpageManager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/webpageQuery")
public class WebpageQueryController {
	@Autowired
	private WebpageManager manager;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "webpageQuery/index";
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public ModelAndView get(HttpServletRequest request) {
		String rowKey = request.getParameter("rowKey");
		WebpageData entity = manager.get(rowKey);
		List<WebpageData> entities = null;
		if (entity != null) {
			entities = new ArrayList<WebpageData>(1);
			entities.add(entity);
		}
		ModelAndView model = new ModelAndView("webpageQuery/index");
		model.addObject("isQuery", Boolean.TRUE);
		model.addObject("queryType", "get");
		model.addObject("rowKey", rowKey);
		model.addObject("entities", entities);
		return model;
	}

	@RequestMapping(value = "/scan", method = RequestMethod.POST)
	public ModelAndView scan(HttpServletRequest request) {
		String startRowKey = request.getParameter("startRowKey");
		Integer pageSize = 10;
		String pageSizeStr = request.getParameter("pageSize");
		if(StringUtils.isEmpty(pageSizeStr) == false) {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		List<WebpageData> entities = manager.scan(startRowKey, pageSize);
		ModelAndView model = new ModelAndView("webpageQuery/index");
		model.addObject("isQuery", Boolean.TRUE);
		model.addObject("queryType", "scan");
		model.addObject("startRowKey", startRowKey);
		model.addObject("pageSize", pageSize);
		model.addObject("entities", entities);
		return model;
	}

	@RequestMapping(value = "/getText", method = RequestMethod.GET)
	public ModelAndView getText(@RequestParam String rowKey) {
		WebpageData entity = manager.get(rowKey);
		ModelAndView model = new ModelAndView("webpageQuery/text");
		model.addObject("entity", entity);
		return model;
	}
	
	@RequestMapping(value = "/getContent", method = RequestMethod.GET)
	public ModelAndView getContent(@RequestParam String rowKey) {
		WebpageData entity = manager.get(rowKey);
		ModelAndView model = new ModelAndView("webpageQuery/content");
		model.addObject("entity", entity);
		return model;
	}
}