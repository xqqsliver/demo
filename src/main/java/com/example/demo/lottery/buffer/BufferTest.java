package com.example.demo.lottery.buffer;

import java.nio.IntBuffer;

public class BufferTest {
	public static void main(String[] args) {
		IntBuffer inb = IntBuffer.allocate(8);
		for (int i = 0; i < inb.capacity(); i++) {
			int j = i << 1;
			inb.put(j);

		}
		// 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0
		inb.flip();
		// 查看在当前位置和限制位置之间是否有元素
		while (inb.hasRemaining()) {
			// 读取此缓冲区当前位置的整数，然后当前位置递增
			int j = inb.get();
			System.out.print(j + "  ");
		}

	}
}
