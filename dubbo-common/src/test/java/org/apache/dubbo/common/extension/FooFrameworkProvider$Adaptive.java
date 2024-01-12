package org.apache.dubbo.common.extension;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.director.FooFrameworkProvider;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;

public class FooFrameworkProvider$Adaptive implements FooFrameworkProvider {
    public void process(org.apache.dubbo.common.URL arg0) {
        if (arg0 == null)
            throw new IllegalArgumentException("url == null");
        URL url = arg0;
        String extName = url.getParameter("foo.framework.provider");
        if (extName == null)
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.common.extension.director.FooFrameworkProvider) name from url (" + url.toString() + ") use keys([foo.framework.provider])");

        ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), FooFrameworkProvider.class);
        FooFrameworkProvider extension = (FooFrameworkProvider) scopeModel.getExtensionLoader(FooFrameworkProvider.class)
                .getExtension(extName);
        extension.process(arg0);
    }
}
