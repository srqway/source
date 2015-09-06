package idv.hsiehpinghan.apachenutchgora.vo;

import java.util.List;

import org.apache.nutch.storage.ParseStatus;

public class ParseStatusVo {
	private int majorCode;
	private int minorCode;
	private List<CharSequence> args;

	private ParseStatusVo() {
	}

	public static ParseStatusVo getParseStatusVo(ParseStatus parseStatus) {
		ParseStatusVo vo = new ParseStatusVo();
		vo.setMajorCode(parseStatus.getMajorCode());
		vo.setMinorCode(parseStatus.getMinorCode());
		vo.setArgs(parseStatus.getArgs());
		return vo;
	}

	public int getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(int majorCode) {
		this.majorCode = majorCode;
	}

	public int getMinorCode() {
		return minorCode;
	}

	public void setMinorCode(int minorCode) {
		this.minorCode = minorCode;
	}

	public List<CharSequence> getArgs() {
		return args;
	}

	public void setArgs(List<CharSequence> args) {
		this.args = args;
	}

}
