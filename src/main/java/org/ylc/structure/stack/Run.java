package org.ylc.structure.stack;

/**
 * 代码千万行，注释第一行，
 * 注释不规范，同事泪两行。
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2019/12/16
 */
public class Run {
    public static void main(String[] args) {
        //arrayStackTest();
        bracketTest("(a{b[c]d}e)");
    }

    private static void arrayStackTest() {
        StackUseArray<String> stack = new StackUseArray<>(5);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        System.out.println("查询：" + stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static void linkStackTest() {

    }

    public static void bracketTest(String text) {
        BracketChecker bracketChecker = new BracketChecker(text);
        System.out.println("验证格式：" + bracketChecker.check());
    }
}
