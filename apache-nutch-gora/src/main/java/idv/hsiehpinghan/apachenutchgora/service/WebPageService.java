package idv.hsiehpinghan.apachenutchgora.service;

import idv.hsiehpinghan.apachenutchgora.repository.WebPageRepository;

import org.apache.gora.query.Result;
import org.apache.nutch.storage.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebPageService {
	@Autowired
	private WebPageRepository repository;

	public Result<String, WebPage> query(String key) {
		return repository.query(key);
	}

	public Result<String, WebPage> query(String startKey, long limit) {
		return repository.query(startKey, limit);
	}
}
