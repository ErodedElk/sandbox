package com.hello.sandbox.fake.service;

import black.android.os.BRServiceManager;
import black.android.view.BRIGraphicsStatsStub;
import java.lang.reflect.Method;
import com.hello.sandbox.fake.hook.BinderInvocationStub;
import com.hello.sandbox.fake.hook.MethodHook;
import com.hello.sandbox.fake.hook.ProxyMethod;
import com.hello.sandbox.utils.MethodParameterUtils;

/** Created by Milk on 4/13/21. * ∧＿∧ (`･ω･∥ 丶　つ０ しーＪ 此处无Bug */
public class IGraphicsStatsProxy extends BinderInvocationStub {

  public IGraphicsStatsProxy() {
    super(BRServiceManager.get().getService("graphicsstats"));
  }

  @Override
  protected Object getWho() {
    return BRIGraphicsStatsStub.get()
        .asInterface(BRServiceManager.get().getService("graphicsstats"));
  }

  @Override
  protected void inject(Object baseInvocation, Object proxyInvocation) {
    replaceSystemService("graphicsstats");
  }

  @Override
  public boolean isBadEnv() {
    return false;
  }

  @ProxyMethod("requestBufferForProcess")
  public static class RequestBufferForProcess extends MethodHook {
    @Override
    protected Object hook(Object who, Method method, Object[] args) throws Throwable {
      MethodParameterUtils.replaceFirstAppPkg(args);
      return method.invoke(who, args);
    }
  }
}
