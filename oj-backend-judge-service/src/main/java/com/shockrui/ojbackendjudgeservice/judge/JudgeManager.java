package com.shockrui.ojbackendjudgeservice.judge;


import com.shockrui.model.codesandbox.JudgeInfo;
import com.shockrui.model.entity.QuestionSubmit;
import com.shockrui.ojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.shockrui.ojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.shockrui.ojbackendjudgeservice.judge.strategy.JudgeContext;
import com.shockrui.ojbackendjudgeservice.judge.strategy.JudgeStrategy;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
