package idv.hsiehpinghan.apachenutchtest.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/resource")
public class ResourceController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "resource/index";
	}

	@RequestMapping(value = "/{classPathResource:.+}", method = RequestMethod.GET)
	@ResponseBody
	public ClassPathResource classPathResource(
			@PathVariable("classPathResource") String classPathResource) {
		return new ClassPathResource(classPathResource);
	}

}
