package org.apache.dubbo.common.extension;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ext3.UseProtocolKeyExt;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.rpc.model.ScopeModelUtil;

public class UseProtocolKeyExt$Adaptive implements UseProtocolKeyExt {

    public java.lang.String echo(URL arg0, java.lang.String arg1) {
        if (arg0 == null)
            throw new IllegalArgumentException("url == null");
        URL url = arg0;
        //选择拓展类名
        String extName = url.getParameter("key1", (url.getProtocol() == null ? "impl1" : url.getProtocol()));
        if (extName == null)
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.common.extension.ext3.UseProtocolKeyExt) name from url (" + url.toString() + ") use keys([key1, protocol])");
        ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), UseProtocolKeyExt.class);
        //通过拓展类名获取实例
        UseProtocolKeyExt extension = (UseProtocolKeyExt) scopeModel.getExtensionLoader(UseProtocolKeyExt.class)
            .getExtension(extName);
        return extension.echo(arg0, arg1);
    }

    public java.lang.String yell(URL arg0, java.lang.String arg1) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        URL url = arg0;
        String extName = url.getProtocol() == null ? (url.getParameter("key2", "impl1")) : url.getProtocol();
        if (extName == null)
            throw new IllegalStateException("Failed to get extension (org.apache.dubbo.common.extension.ext3.UseProtocolKeyExt) name from url (" + url.toString() + ") use keys([protocol, key2])");
        ScopeModel scopeModel = ScopeModelUtil.getOrDefault(url.getScopeModel(), org.apache.dubbo.common.extension.ext3.UseProtocolKeyExt.class);
        org.apache.dubbo.common.extension.ext3.UseProtocolKeyExt extension = (org.apache.dubbo.common.extension.ext3.UseProtocolKeyExt) scopeModel.getExtensionLoader(org.apache.dubbo.common.extension.ext3.UseProtocolKeyExt.class).getExtension(extName);
        return extension.yell(arg0, arg1);
    }
}
