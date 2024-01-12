package org.apache.dubbo.common.extension;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.Stream;

public class StreamExceptionTest {

    /**
     * Stream 并不会吞掉异常信息，
     * 调试SPI源码时发现异常不见了，并没有看到哪里有捕获异常，以为是Stream吞掉了，测试看并不是
     */
    @Test
    @Disabled
    public void testException() {
        Integer valIsNull = Stream.of(new MyIns(null), new MyIns(1))
            .map(ins -> {
                if (ins.getVal() == null) {
                    throw new IllegalArgumentException("val is null");
                } else
                    return ins.getVal();
            })
            .filter(Objects::nonNull)
            .findFirst()
            .orElse(null);
        System.out.println(valIsNull);
    }

    static class MyIns {
        private Integer val;

        public MyIns(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }
}
