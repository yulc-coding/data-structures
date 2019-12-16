package org.ylc.structure.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 * <p>
 * 栈运用的样例，用于校验文本括号的合法性
 * () [] {}
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/16
 */
public class BracketChecker {

    /**
     * 左括号，需要入栈
     */
    private static final String LEFT_BRACKET = "([{";

    /**
     * 右括号，用于校验，每次遇到需要校验和出栈的左括号是否匹配
     */
    private static final String RIGHT_BRACKET = ")]}";

    /**
     * 用于匹配校验，每个右括号对应它的左括号
     */
    private static final Map<Character, Character> MATCH_MAP = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    /**
     * 要校验的文本
     */
    private String text;

    public BracketChecker(String text) {
        this.text = text;
    }

    /**
     * 执行校验
     *
     * @return boolean
     */
    public boolean check() {
        int stackSize = this.text.length();
        StackUseArray<Character> stack = new StackUseArray<>(stackSize);
        // 当前字符
        char curChar;
        for (int i = 0; i < stackSize; i++) {
            curChar = this.text.charAt(i);
            if (LEFT_BRACKET.indexOf(curChar) > -1) {
                // 左括号入栈
                stack.push(curChar);
                System.out.println("push:" + curChar);
            } else if (RIGHT_BRACKET.indexOf(curChar) > -1) {
                // 右括号，出栈匹配
                System.out.println("curChar:" + curChar + ", match:" + stack.peek());
                if (!stack.pop().equals(MATCH_MAP.get(curChar))) {
                    System.out.println("Error:" + curChar + " at " + i);
                    return false;
                }
            }
        }
        // 校验栈是否已空
        if (!stack.isEmpty()) {
            System.out.println("Error: mission " + MATCH_MAP.get(stack.peek()));
            return false;
        }
        return true;
    }

}
