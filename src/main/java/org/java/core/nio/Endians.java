package org.java.core.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * 字节存放顺序 ByteBuffer默认的是高位优先
 * 高位优先:将最重要的字节放在地址最低的存储器单元
 * 低位优先：将最重要的字节放在地址最高的存储器单元
 * @author yinmengyu
 * @date  2016年6月25日
 */
public class Endians {
  public static void main(String[] args) {
	ByteBuffer buff=ByteBuffer.wrap(new byte[12]);
	buff.asCharBuffer().put("abcdef");
	System.out.println(Arrays.toString(buff.array()));
	buff.rewind();
	buff.order(ByteOrder.BIG_ENDIAN);
	buff.asCharBuffer().put("abcdef");
	System.out.println(Arrays.toString(buff.array()));
	buff.rewind();
	buff.order(ByteOrder.LITTLE_ENDIAN);
	buff.asCharBuffer().put("abcdef");
	System.out.println(Arrays.toString(buff.array()));
}
}
