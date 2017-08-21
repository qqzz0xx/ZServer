package com.zserver.helper;

/**
 * Created by sunqiongzai on 2017/8/22.
 */
public class ByteHelper {
    public static byte[] Int8ToBytes(byte i) {

        return new byte[]{i};

    }

    public static byte[] Int16ToBytes(short i) {
        byte a = (byte) (i & 0x0F);
        byte b = (byte) ((i >> 8) & 0x0F);
        return new byte[]{b, a};
    }

    public static byte[] Int32ToBytes(int i) {

        byte a = (byte) (i & 0x0F);
        byte b = (byte) ((i >> 8) & 0x0F);
        byte c = (byte) ((i >> 16) & 0x0F);
        byte d = (byte) ((i >> 24) & 0x0F);
        return new byte[]{d, c, b, a};
    }

    public static byte[] Int64ToBytes(long i) {

        byte a = (byte) (i & 0x0F);
        byte b = (byte) ((i >> 8) & 0x0F);
        byte c = (byte) ((i >> 16) & 0x0F);
        byte d = (byte) ((i >> 24) & 0x0F);
        byte e = (byte) ((i >> 32) & 0x0F);
        byte f = (byte) ((i >> 40) & 0x0F);
        byte g = (byte) ((i >> 48) & 0x0F);
        byte h = (byte) ((i >> 56) & 0x0F);

        return new byte[]{h, g, f, e, d, c, b, a};
    }

    public static byte[] BytesCat(byte[] b1, byte[] b2) {
        byte[] dst = new byte[b1.length + b2.length];
        System.arraycopy(b1, 0, dst, 0, b1.length);
        System.arraycopy(b2,0, dst, b1.length, b2.length);
        return  dst;
    }
}
