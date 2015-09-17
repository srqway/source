package idv.hsiehpinghan.apachenutchgora.vo;

import idv.hsiehpinghan.apachenutchgora.utility.ByteBufferUtility;
import idv.hsiehpinghan.apachenutchgora.utility.CharSequenceUtility;
import idv.hsiehpinghan.apachenutchgora.utility.MapUtility;
import idv.hsiehpinghan.datetimeutility.utility.DateUtility;
import idv.hsiehpinghan.datetimeutility.utility.LocalDateTimeUtility;

import java.time.LocalDateTime;
import java.util.Map;

import org.apache.gora.query.Result;
import org.apache.nutch.storage.WebPage;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WebPageVo {
	private String key;
	private String baseUrl;
	private String crawlStatus;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime prevFetchTime;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime fetchTime;
	private String fetchInterval;
	private Integer retriesSinceFetch;
	private String reprUrl;
	private String content;
	private String contentType;
	private ProtocolStatusVo protocolStatusVo;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime modifiedTime;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime prevModifiedTime;
	private String batchId;
	private String title;
	private String text;
	private ParseStatusVo parseStatusVo;
	private String signature;
	private String prevSignature;
	private Float score;
	private Map<String, String> headers;
	private Map<String, String> inlinks;
	private Map<String, String> outlinks;
	private Map<String, String> metadata;
	private Map<String, String> markers;

	private WebPageVo() {
	}

	public static WebPageVo generateWebPageVo(Result<String, WebPage> result) {
		WebPageVo vo = new WebPageVo();
		vo.setKey(result.getKey());
		WebPage webPage = result.get();
		vo.setBaseUrl(CharSequenceUtility.convertToString(webPage.getBaseUrl()));
		vo.setCrawlStatus(convertToCrawlStatus(webPage.getStatus()));
		LocalDateTime localDateTime = LocalDateTimeUtility
				.getLocalDateTime(webPage.getPrevFetchTime());
		vo.setPrevFetchTime(localDateTime);
		LocalDateTime fetchTime = LocalDateTimeUtility.getLocalDateTime(webPage
				.getFetchTime());
		vo.setFetchTime(fetchTime);
		vo.setFetchInterval(convertToFetchInterval(webPage.getFetchInterval()));
		vo.setRetriesSinceFetch(webPage.getRetriesSinceFetch());
		vo.setReprUrl(CharSequenceUtility.convertToString(webPage.getReprUrl()));
		vo.setContent(ByteBufferUtility.convertToString(webPage.getContent()));
		vo.setContentType(CharSequenceUtility.convertToString(webPage
				.getContentType()));
		ProtocolStatusVo protocolStatusVo = ProtocolStatusVo
				.getProtocolStatusVo(webPage.getProtocolStatus());
		vo.setProtocolStatusVo(protocolStatusVo);
		LocalDateTime modifiedTime = LocalDateTimeUtility
				.getLocalDateTime(webPage.getModifiedTime());
		vo.setModifiedTime(modifiedTime);
		LocalDateTime prevModifiedTime = LocalDateTimeUtility
				.getLocalDateTime(webPage.getPrevModifiedTime());
		vo.setPrevModifiedTime(prevModifiedTime);
		vo.setBatchId(CharSequenceUtility.convertToString(webPage.getBatchId()));
		vo.setTitle(CharSequenceUtility.convertToString(webPage.getTitle()));
		vo.setText(CharSequenceUtility.convertToString(webPage.getText()));
		ParseStatusVo parseStatusVo = ParseStatusVo.getParseStatusVo(webPage
				.getParseStatus());
		vo.setParseStatusVo(parseStatusVo);
		vo.setSignature(ByteBufferUtility.convertToString(webPage
				.getSignature()));
		vo.setPrevSignature(ByteBufferUtility.convertToString(webPage
				.getPrevSignature()));
		vo.setScore(webPage.getScore());
		vo.setHeaders(MapUtility.convertMapCharSequenceCharSequence(webPage
				.getHeaders()));
		vo.setInlinks(MapUtility.convertMapCharSequenceCharSequence(webPage
				.getInlinks()));
		vo.setOutlinks(MapUtility.convertMapCharSequenceCharSequence(webPage
				.getOutlinks()));
		vo.setMetadata(MapUtility.convertMapCharSequenceByteBuffer(webPage
				.getMetadata()));
		vo.setMarkers(MapUtility.convertMapCharSequenceCharSequence(webPage
				.getMarkers()));
		return vo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getCrawlStatus() {
		return crawlStatus;
	}

	public void setCrawlStatus(String crawlStatus) {
		this.crawlStatus = crawlStatus;
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

	public String getFetchInterval() {
		return fetchInterval;
	}

	public void setFetchInterval(String fetchInterval) {
		this.fetchInterval = fetchInterval;
	}

	public Integer getRetriesSinceFetch() {
		return retriesSinceFetch;
	}

	public void setRetriesSinceFetch(Integer retriesSinceFetch) {
		this.retriesSinceFetch = retriesSinceFetch;
	}

	public String getReprUrl() {
		return reprUrl;
	}

	public void setReprUrl(String reprUrl) {
		this.reprUrl = reprUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
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

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ParseStatusVo getParseStatusVo() {
		return parseStatusVo;
	}

	public void setParseStatusVo(ParseStatusVo parseStatusVo) {
		this.parseStatusVo = parseStatusVo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getPrevSignature() {
		return prevSignature;
	}

	public void setPrevSignature(String prevSignature) {
		this.prevSignature = prevSignature;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getInlinks() {
		return inlinks;
	}

	public void setInlinks(Map<String, String> inlinks) {
		this.inlinks = inlinks;
	}

	public Map<String, String> getOutlinks() {
		return outlinks;
	}

	public void setOutlinks(Map<String, String> outlinks) {
		this.outlinks = outlinks;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public Map<String, String> getMarkers() {
		return markers;
	}

	public void setMarkers(Map<String, String> markers) {
		this.markers = markers;
	}

	private static String convertToCrawlStatus(Integer status) {
		if (status == null) {
			return null;
		}
		switch (status) {
		case 0:
			return null;
		case 0x01:
			return "STATUS_UNFETCHED";
		case 0x02:
			return "STATUS_FETCHED";
		case 0x03:
			return "STATUS_GONE";
		case 0x04:
			return "STATUS_REDIR_TEMP";
		case 0x05:
			return "STATUS_REDIR_PERM";
		case 0x22:
			return "STATUS_RETRY";
		case 0x26:
			return "STATUS_NOTMODIFIED";
		default:
			throw new RuntimeException("Status(" + status + ") undefined !!!");
		}
	}
	
	private static String convertToFetchInterval(Integer fetchInterval) {
		long remain = 0;
		long day = fetchInterval / DateUtility.DAY_SECONDS;
		remain = fetchInterval % DateUtility.DAY_SECONDS;
		long hour = remain / DateUtility.HOUR_SECONDS;
		remain = remain % DateUtility.HOUR_SECONDS;
		long minute = remain / DateUtility.MINUTE_SECONDS;
		long second = remain % DateUtility.MINUTE_SECONDS;
		return String.format("% 3d % 2d:% 2d:% 2d", day, hour, minute, second);
	}
}
