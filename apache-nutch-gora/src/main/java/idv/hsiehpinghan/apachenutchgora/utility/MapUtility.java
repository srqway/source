package idv.hsiehpinghan.apachenutchgora.utility;

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapUtility {
	public static Map<String, String> convertMapCharSequenceCharSequence(
			Map<CharSequence, CharSequence> map) {
		Map<String, String> result = new LinkedHashMap<String, String>(
				map.size());
		for (Map.Entry<CharSequence, CharSequence> ent : map.entrySet()) {
			String key = String.valueOf(ent.getKey());
			String value = String.valueOf(ent.getValue());
			result.put(key, value);
		}
		return result;
	}

	public static Map<String, String> convertMapCharSequenceByteBuffer(
			Map<CharSequence, ByteBuffer> map) {
		Map<String, String> result = new LinkedHashMap<String, String>(
				map.size());
		for (Map.Entry<CharSequence, ByteBuffer> ent : map.entrySet()) {
			String key = String.valueOf(ent.getKey());
			String value = new String(ent.getValue().array());
			result.put(key, value);
		}
		return result;
	}
}
