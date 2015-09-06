package idv.hsiehpinghan.apachenutchgora.utility;

import java.nio.ByteBuffer;

public class ByteBufferUtility {

	public static String convertToString(ByteBuffer byteBuffer) {
		if (byteBuffer == null) {
			return null;
		}
		return new String(byteBuffer.array());
	}
}
