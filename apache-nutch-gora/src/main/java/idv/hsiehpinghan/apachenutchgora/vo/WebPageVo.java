package idv.hsiehpinghan.apachenutchgora.vo;

import idv.hsiehpinghan.datetimeutility.utility.LocalDateTimeUtility;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Map;

import org.apache.gora.query.Result;
import org.apache.nutch.storage.WebPage;

public class WebPageVo {
	private String key;
	private CharSequence baseUrl;
	private Integer status;
	private LocalDateTime prevFetchTime;
	private LocalDateTime fetchTime;
	private Integer fetchInterval;
	private Integer retriesSinceFetch;
	private CharSequence reprUrl;
	private ByteBuffer content;
	private CharSequence contentType;
	private ProtocolStatusVo protocolStatusVo;
	private LocalDateTime modifiedTime;
	private LocalDateTime prevModifiedTime;
	private CharSequence batchId;
	private CharSequence title;
	private CharSequence text;
	private ParseStatusVo parseStatusVo;
	private ByteBuffer signature;
	private ByteBuffer prevSignature;
	private Float score;
	private Map<CharSequence, CharSequence> headers;
	private Map<CharSequence, CharSequence> inlinks;
	private Map<CharSequence, CharSequence> outlinks;
	private Map<CharSequence, ByteBuffer> metadata;
	private Map<CharSequence, CharSequence> markers;

	private WebPageVo() {
	}

	public static WebPageVo generateWebPageVo(Result<String, WebPage> result) {
		WebPageVo vo = new WebPageVo();
		vo.setKey(result.getKey());
		WebPage webPage = result.get();
		vo.setBaseUrl(webPage.getBaseUrl());
		vo.setStatus(webPage.getStatus());
		LocalDateTime localDateTime = LocalDateTimeUtility
				.getLocalDateTime(webPage.getPrevFetchTime());
		vo.setPrevFetchTime(localDateTime);
		LocalDateTime fetchTime = LocalDateTimeUtility.getLocalDateTime(webPage
				.getFetchTime());
		vo.setFetchTime(fetchTime);
		vo.setFetchInterval(webPage.getFetchInterval());
		vo.setRetriesSinceFetch(webPage.getRetriesSinceFetch());
		vo.setReprUrl(webPage.getReprUrl());
		vo.setContent(webPage.getContent());
		vo.setContentType(webPage.getContentType());
		ProtocolStatusVo protocolStatusVo = ProtocolStatusVo
				.getProtocolStatusVo(webPage.getProtocolStatus());
		vo.setProtocolStatusVo(protocolStatusVo);
		LocalDateTime modifiedTime = LocalDateTimeUtility
				.getLocalDateTime(webPage.getModifiedTime());
		vo.setModifiedTime(modifiedTime);
		LocalDateTime prevModifiedTime = LocalDateTimeUtility
				.getLocalDateTime(webPage.getPrevModifiedTime());
		vo.setPrevModifiedTime(prevModifiedTime);
		vo.setBatchId(webPage.getBatchId());
		vo.setTitle(webPage.getTitle());
		vo.setText(webPage.getText());
		ParseStatusVo parseStatusVo = ParseStatusVo.getParseStatusVo(webPage
				.getParseStatus());
		vo.setParseStatusVo(parseStatusVo);
		vo.setSignature(webPage.getSignature());
		vo.setPrevSignature(webPage.getPrevSignature());
		vo.setScore(webPage.getScore());
		vo.setHeaders(webPage.getHeaders());
		vo.setInlinks(webPage.getInlinks());
		vo.setOutlinks(webPage.getOutlinks());
		vo.setMetadata(webPage.getMetadata());
		vo.setMarkers(webPage.getMarkers());
		return vo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public CharSequence getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(CharSequence baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getPrevFetchTime() {
		return prevFetchTime;
	}

	public void setPrevFetchTime(LocalDateTime prevFetchTime) {
		this.prevFetchTime = prevFetchTime;
	}

	public LocalDateTime getFetchTime() {
		return fetchTime;
	}

	public void setFetchTime(LocalDateTime fetchTime) {
		this.fetchTime = fetchTime;
	}

	public Integer getFetchInterval() {
		return fetchInterval;
	}

	public void setFetchInterval(Integer fetchInterval) {
		this.fetchInterval = fetchInterval;
	}

	public Integer getRetriesSinceFetch() {
		return retriesSinceFetch;
	}

	public void setRetriesSinceFetch(Integer retriesSinceFetch) {
		this.retriesSinceFetch = retriesSinceFetch;
	}

	public CharSequence getReprUrl() {
		return reprUrl;
	}

	public void setReprUrl(CharSequence reprUrl) {
		this.reprUrl = reprUrl;
	}

	public ByteBuffer getContent() {
		return content;
	}

	public void setContent(ByteBuffer content) {
		this.content = content;
	}

	public CharSequence getContentType() {
		return contentType;
	}

	public void setContentType(CharSequence contentType) {
		this.contentType = contentType;
	}

	public ProtocolStatusVo getProtocolStatusVo() {
		return protocolStatusVo;
	}

	public void setProtocolStatusVo(ProtocolStatusVo protocolStatusVo) {
		this.protocolStatusVo = protocolStatusVo;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public LocalDateTime getPrevModifiedTime() {
		return prevModifiedTime;
	}

	public void setPrevModifiedTime(LocalDateTime prevModifiedTime) {
		this.prevModifiedTime = prevModifiedTime;
	}

	public CharSequence getBatchId() {
		return batchId;
	}

	public void setBatchId(CharSequence batchId) {
		this.batchId = batchId;
	}

	public CharSequence getTitle() {
		return title;
	}

	public void setTitle(CharSequence title) {
		this.title = title;
	}

	public CharSequence getText() {
		return text;
	}

	public void setText(CharSequence text) {
		this.text = text;
	}

	public ParseStatusVo getParseStatusVo() {
		return parseStatusVo;
	}

	public void setParseStatusVo(ParseStatusVo parseStatusVo) {
		this.parseStatusVo = parseStatusVo;
	}

	public ByteBuffer getSignature() {
		return signature;
	}

	public void setSignature(ByteBuffer signature) {
		this.signature = signature;
	}

	public ByteBuffer getPrevSignature() {
		return prevSignature;
	}

	public void setPrevSignature(ByteBuffer prevSignature) {
		this.prevSignature = prevSignature;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Map<CharSequence, CharSequence> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<CharSequence, CharSequence> headers) {
		this.headers = headers;
	}

	public Map<CharSequence, CharSequence> getInlinks() {
		return inlinks;
	}

	public void setInlinks(Map<CharSequence, CharSequence> inlinks) {
		this.inlinks = inlinks;
	}

	public Map<CharSequence, CharSequence> getOutlinks() {
		return outlinks;
	}

	public void setOutlinks(Map<CharSequence, CharSequence> outlinks) {
		this.outlinks = outlinks;
	}

	public Map<CharSequence, ByteBuffer> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<CharSequence, ByteBuffer> metadata) {
		this.metadata = metadata;
	}

	public Map<CharSequence, CharSequence> getMarkers() {
		return markers;
	}

	public void setMarkers(Map<CharSequence, CharSequence> markers) {
		this.markers = markers;
	}

}
