package idv.hsiehpinghan.apachenutchgora.vo;

import java.util.List;

import org.apache.nutch.storage.ProtocolStatus;

public class ProtocolStatusVo {
	private int code;
	private List<CharSequence> args;
	private long lastModified;

	private ProtocolStatusVo() {
	}

	public static ProtocolStatusVo getProtocolStatusVo(
			ProtocolStatus protocolStatus) {
		ProtocolStatusVo vo = new ProtocolStatusVo();
		vo.setCode(protocolStatus.getCode());
		vo.setArgs(protocolStatus.getArgs());
		vo.setLastModified(protocolStatus.getLastModified());
		return vo;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<CharSequence> getArgs() {
		return args;
	}

	public void setArgs(List<CharSequence> args) {
		this.args = args;
	}

	public long getLastModified() {
		return lastModified;
	}

	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}

}
