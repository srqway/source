package idv.hsiehpinghan.apachenutchgora.vo;

import idv.hsiehpinghan.apachenutchgora.utility.CharSequenceUtility;

import java.util.List;

import org.apache.nutch.storage.ParseStatus;

public class ParseStatusVo {
	private int majorCode;
	private int minorCode;
	private List<String> args;

	private ParseStatusVo() {
	}

	public static ParseStatusVo getParseStatusVo(ParseStatus parseStatus) {
		ParseStatusVo vo = new ParseStatusVo();
		vo.setMajorCode(parseStatus.getMajorCode());
		vo.setMinorCode(parseStatus.getMinorCode());
		vo.setArgs(CharSequenceUtility.convertToListString(parseStatus
				.getArgs()));
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

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

}