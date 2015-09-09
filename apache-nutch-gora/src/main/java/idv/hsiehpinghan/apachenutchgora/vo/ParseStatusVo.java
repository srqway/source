package idv.hsiehpinghan.apachenutchgora.vo;

import idv.hsiehpinghan.apachenutchgora.utility.CharSequenceUtility;

import java.util.List;

import org.apache.nutch.storage.ParseStatus;

public class ParseStatusVo {
	private String majorStatus;
	private String minorStatus;
	private List<String> args;

	private ParseStatusVo() {
	}

	public static ParseStatusVo getParseStatusVo(ParseStatus parseStatus) {
		ParseStatusVo vo = new ParseStatusVo();
		vo.setMajorStatus(convertToMajorStatus(parseStatus.getMajorCode()));
		vo.setMinorStatus(convertToMinorStatus(parseStatus.getMinorCode()));
		vo.setArgs(CharSequenceUtility.convertToListString(parseStatus
				.getArgs()));
		return vo;
	}

	public String getMajorStatus() {
		return majorStatus;
	}

	public void setMajorStatus(String majorStatus) {
		this.majorStatus = majorStatus;
	}

	public String getMinorStatus() {
		return minorStatus;
	}

	public void setMinorStatus(String minorStatus) {
		this.minorStatus = minorStatus;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	private static String convertToMajorStatus(Integer majorCode) {
		switch (majorCode) {
		case 0:
			return "NOTPARSED";
		case 1:
			return "SUCCESS";
		case 2:
			return "FAILED";
		default:
			throw new RuntimeException("MajorCode(" + majorCode
					+ ") undefined !!!");
		}
	}

	private static String convertToMinorStatus(Integer minorCode) {
		switch (minorCode) {
		case 0:
			return "SUCCESS_OK";
		case 100:
			return "SUCCESS_REDIRECT";
		case 200:
			return "FAILED_EXCEPTION";
		case 202:
			return "FAILED_TRUNCATED";
		case 203:
			return "FAILED_INVALID_FORMAT";
		case 204:
			return "FAILED_MISSING_PARTS";
		case 205:
			return "FAILED_MISSING_CONTENT";
		default:
			throw new RuntimeException("MinorCode(" + minorCode
					+ ") undefined !!!");
		}
	}
}
