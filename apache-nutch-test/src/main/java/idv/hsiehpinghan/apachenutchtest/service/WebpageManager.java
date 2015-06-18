package idv.hsiehpinghan.apachenutchtest.service;

import idv.hsiehpinghan.apachenutchtest.dto.WebpageData;
import idv.hsiehpinghan.apachenutchtest.repository.WebpageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebpageManager {
	@Autowired
	private WebpageRepository repository;

	public WebpageData get(String rowKey) {
		try {
			return repository.get(rowKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<WebpageData> scan(String startRowKey, int pageSize) {
		try {
			return repository.scan(startRowKey, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
