java.util.*;
public class SimplifyPath {
    public String stackapproach(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder res= new StringBuilder();
        String [] p = path.split("/");
        for(int i=0;i<p.length;i++){
            if(!stack.isEmpty() && p[i].equals("..")) stack.pop();
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            res.insert(0,stack.pop()).insert(0,"/");
        }
        return res.toString();
    }
    public String dequeapproach(String path) {
        Deque<String> deque = new LinkedList<>();
        StringBuilder res= new StringBuilder();
        String [] p = path.split("/");
        for(int i=0;i<p.length;i++){
            if(!deque.isEmpty() && p[i].equals("..")) deque.poll();
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                deque.push(p[i]);
        }
        if(deque.isEmpty()) return "/";
        while(!deque.isEmpty()){
            res.append("/").append(deque.pollLast());
        }
        return res.toString();
    }
}