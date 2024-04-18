package com.shockrui.ojbackendjudgeservice.judge.codesandbox;


import com.shockrui.model.codesandbox.ExecuteCodeRequest;
import com.shockrui.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
