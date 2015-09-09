package idv.hsiehpinghan.apachenutchgora.vo;

import idv.hsiehpinghan.apachenutchgora.utility.CharSequenceUtility;
import idv.hsiehpinghan.datetimeutility.utility.LocalDateTimeUtility;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.nutch.storage.ProtocolStatus;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProtocolStatusVo {
	private String status;
	private List<String> args;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime lastModified;

	private ProtocolStatusVo() {
	}

	public static ProtocolStatusVo getProtocolStatusVo(
			ProtocolStatus protocolStatus) {
		ProtocolStatusVo vo = new ProtocolStatusVo();
		vo.setStatus(convertToStatus(protocolStatus.getCode()));
		vo.setArgs(CharSequenceUtility.convertToListString(protocolStatus
				.getArgs()));
		vo.setLastModified(LocalDateTimeUtility.getLocalDateTime(protocolStatus
				.getLastModified()));
		return vo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	private static String convertToStatus(Integer code) {
		switch (code) {
		case 1:
			return "SUCCESS";
		case 2:
			return "FAILED";
		case 10:
			return "PROTO_NOT_FOUND";
		case 11:
			return "GONE";
		case 12:
			return "MOVED";
		case 13:
			return "TEMP_MOVED";
		case 14:
			return "NOTFOUND";
		case 15:
			return "RETRY";
		case 16:
			return "EXCEPTION";
		case 17:
			return "ACCESS_DENIED";
		case 18:
			return "ROBOTS_DENIED";
		case 19:
			return "REDIR_EXCEEDED";
		case 20:
			return "NOTFETCHING";
		case 21:
			return "NOTMODIFIED";
		case 22:
			return "WOULDBLOCK";
		case 23:
			return "BLOCKED";
		default:
			throw new RuntimeException("Code(" + code + ") undefined !!!");
		}
	}
}
