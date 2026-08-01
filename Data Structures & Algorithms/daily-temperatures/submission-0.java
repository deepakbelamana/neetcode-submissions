class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=temperatures.length-1;i>=0;i--) {
            stack.push(temperatures[i]);
        }
        int[] result = new int[temperatures.length];
        int r = 0;
        for(int i : temperatures) {
            Deque<Integer> tempStack = new ArrayDeque<>();
            stack.pop();
            while(!stack.isEmpty()) {
                if(stack.peek()>i){
                    result[r++] = 1+tempStack.size();
                    break;
                } else {
                    tempStack.push(stack.pop());
                }
            }
            if(stack.isEmpty()) {
                result[r++]=0;
            }
            while(!tempStack.isEmpty()){
                stack.push(tempStack.pop());
            }
        }
        return result;
    }
}
