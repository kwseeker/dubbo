package org.apache.dubbo.rpc.proxy;

import org.apache.dubbo.common.extension.AdaptiveClassCodeGenerator;
import org.apache.dubbo.rpc.ProxyFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AdaptiveProxyFactoryGenerateTest {

    @Test
    void testGenerateProxyFactory() throws IOException {
        AdaptiveClassCodeGenerator generator = new AdaptiveClassCodeGenerator(ProxyFactory.class, "proxyFactory");
        String value = generator.generate();
        System.out.println(value);
    }
}
