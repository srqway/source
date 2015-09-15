package idv.hsiehpinghan.apachenutchgora.utility;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ByteBufferUtility {

	public static String convertToString(ByteBuffer byteBuffer) {
		if (byteBuffer == null) {
			return null;
		}
		return new String(byteBuffer.array(), Charset.forName("utf-8"));
	}
}
