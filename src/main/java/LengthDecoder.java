import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Created by ZZZ on 2017/8/21.
 */
public class LengthDecoder extends LengthFieldBasedFrameDecoder {

    static int MaxFrameLength = 1024;
    static int BodyLengthOffset = 0;
    static int BodyLengthSize= 4;


    public LengthDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }

    public  static LengthDecoder Default() {
        return new LengthDecoder(MaxFrameLength,BodyLengthOffset, BodyLengthSize );

    }

}
