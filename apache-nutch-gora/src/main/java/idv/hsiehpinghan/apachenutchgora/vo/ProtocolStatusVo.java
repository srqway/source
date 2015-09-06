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
	private int code;
	private List<String> args;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDateTime lastModified;

	private ProtocolStatusVo() {
	}

	public static ProtocolStatusVo getProtocolStatusVo(
			ProtocolStatus protocolStatus) {
		ProtocolStatusVo vo = new ProtocolStatusVo();
		vo.setCode(protocolStatus.getCode());
		vo.setArgs(CharSequenceUtility.convertToListString(protocolStatus
				.getArgs()));
		vo.setLastModified(LocalDateTimeUtility.getLocalDateTime(protocolStatus
				.getLastModified()));
		return vo;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

}
