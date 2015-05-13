public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (String token: tokens) {
            if (isSign(token)) {
                int a, b;
                if(!stack.empty()) {
                    a = stack.pop();
                    if (!stack.empty()) {
                        b = stack.pop();
                        int c = compute(a, b, token);
                        if (c == Integer.MIN_VALUE) return c;
                        stack.push(c);
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else return Integer.MIN_VALUE;
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        if (stack.empty() || stack.size() > 1) return Integer.MIN_VALUE;
        return stack.pop();
    }
    private boolean isSign(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    private int compute(int a, int b, String sign) {
        if (sign.equals("+")) return a + b;
        else if (sign.equals("-")) return b - a;
        else if (sign.equals("*")) return a * b;
        else if (sign.equals("/") && a != 0) return b/a;
        else return Integer.MIN_VALUE;
    }
}
