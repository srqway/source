package idv.hsiehpinghan.apachenutchgora.utility;

import java.util.ArrayList;
import java.util.List;

public class CharSequenceUtility {
	public static List<String> convertToListString(List<CharSequence> list) {
		if (list == null) {
			return null;
		}
		List<String> result = new ArrayList<String>(list.size());
		for (CharSequence seq : list) {
			result.add(String.valueOf(seq));
		}
		return result;
	}

	public static String convertToString(CharSequence charSequence) {
		if (charSequence == null) {
			return null;
		}
		return String.valueOf(charSequence);
	}
}
