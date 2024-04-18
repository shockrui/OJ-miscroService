package com.shockrui.ojbackendjudgeservice.judge.codesandbox.impl;


import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.shockrui.common.ErrorCode;
import com.shockrui.exception.BusinessException;
import com.shockrui.model.codesandbox.ExecuteCodeRequest;
import com.shockrui.model.codesandbox.ExecuteCodeResponse;
import com.shockrui.ojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.springframework.util.DigestUtils;

/**
 * 远程代码沙箱（实际调用接口的沙箱）
 */
public class RemoteCodeSandbox implements CodeSandbox {

    // 定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "shockRui";


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8090/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, DigestUtil.md5Hex(AUTH_REQUEST_SECRET))
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
