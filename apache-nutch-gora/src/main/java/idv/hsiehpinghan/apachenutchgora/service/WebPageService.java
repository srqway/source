package idv.hsiehpinghan.apachenutchgora.service;

import idv.hsiehpinghan.apachenutchgora.repository.WebPageRepository;
import idv.hsiehpinghan.apachenutchgora.vo.WebPageVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.gora.query.Result;
import org.apache.nutch.storage.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebPageService {
	@Autowired
	private WebPageRepository repository;

	public String queryContent(String key) throws IOException, Exception {
		Set<WebPage.Field> fields = generateQueryContentFields();
		Result<String, WebPage> result = repository.query(key,
				convertToStringArray(fields));
		while (result.next()) {
			return WebPageVo.generateWebPageVo(result).getContent();
		}
		return null;
	}

	public String queryText(String key) throws IOException, Exception {
		Set<WebPage.Field> fields = generateQueryTextFields();
		Result<String, WebPage> result = repository.query(key,
				convertToStringArray(fields));
		while (result.next()) {
			return WebPageVo.generateWebPageVo(result).getText();
		}
		return null;
	}

	public List<WebPageVo> query(String startKey, long limit)
			throws IOException, Exception {
		Set<WebPage.Field> fields = generateQueryFields();
		Result<String, WebPage> result = repository.query(startKey,
				convertToStringArray(fields), limit);
		List<WebPageVo> webPageVos = new ArrayList<WebPageVo>();
		while (result.next()) {
			webPageVos.add(WebPageVo.generateWebPageVo(result));
		}
		return webPageVos;
	}

	private String[] convertToStringArray(Set<WebPage.Field> fields) {
		return fields.stream().map((t) -> {
			return t.getName();
		}).toArray((size) -> {
			return new String[size];
		});
	}

	private Set<WebPage.Field> generateQueryFields() {
		Set<WebPage.Field> fields = new HashSet<WebPage.Field>();
		fields.add(WebPage.Field.BASE_URL);
		fields.add(WebPage.Field.STATUS);
		fields.add(WebPage.Field.FETCH_TIME);
		fields.add(WebPage.Field.PREV_FETCH_TIME);
		fields.add(WebPage.Field.FETCH_INTERVAL);
		fields.add(WebPage.Field.RETRIES_SINCE_FETCH);
		fields.add(WebPage.Field.MODIFIED_TIME);
		fields.add(WebPage.Field.PREV_MODIFIED_TIME);
		fields.add(WebPage.Field.PROTOCOL_STATUS);
		fields.add(WebPage.Field.CONTENT_TYPE);
		fields.add(WebPage.Field.PREV_SIGNATURE);
		fields.add(WebPage.Field.SIGNATURE);
		fields.add(WebPage.Field.TITLE);
		fields.add(WebPage.Field.PARSE_STATUS);
		fields.add(WebPage.Field.SCORE);
		fields.add(WebPage.Field.REPR_URL);
		fields.add(WebPage.Field.HEADERS);
		fields.add(WebPage.Field.OUTLINKS);
		fields.add(WebPage.Field.INLINKS);
		fields.add(WebPage.Field.MARKERS);
		fields.add(WebPage.Field.METADATA);
		fields.add(WebPage.Field.BATCH_ID);
		return fields;
	}

	private Set<WebPage.Field> generateQueryContentFields() {
		Set<WebPage.Field> fields = new HashSet<WebPage.Field>();
		fields.add(WebPage.Field.CONTENT);
		return fields;
	}

	private Set<WebPage.Field> generateQueryTextFields() {
		Set<WebPage.Field> fields = new HashSet<WebPage.Field>();
		fields.add(WebPage.Field.TEXT);
		return fields;
	}
}
