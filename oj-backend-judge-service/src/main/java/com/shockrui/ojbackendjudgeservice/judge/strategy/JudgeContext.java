package com.shockrui.ojbackendjudgeservice.judge.strategy;


import com.shockrui.model.codesandbox.JudgeInfo;
import com.shockrui.model.dto.question.JudgeCase;
import com.shockrui.model.entity.Question;
import com.shockrui.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
