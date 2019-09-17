// BFS, could improve in the decoupling part
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for (String str: deadends) {
            set.add(str);
        }
        String oldstring = new String("0000");
        if(set.contains(oldstring)) return -1;
        Queue<String> q = new LinkedList<String>();
        HashSet<String> visited = new HashSet<>();
        q.offer(oldstring);
        visited.add(oldstring);
        int len = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0){
                String st = q.poll();
                char[] chars = st.toCharArray();
                for (int i = 0; i < chars.length; ++i) {
                    char ch = chars[i];
                    // convert 0
                    if(chars[i] == '0') {
                        chars[i] = '9';
                        String str = String.valueOf(chars);
                        if(!set.contains(str) && !visited.contains(str)) {
                            if (str.equals(target)) {
                                return len;
                            }
                            q.offer(str);
                            visited.add(str);
                        }
                        chars[i] = '1';
                        str = String.valueOf(chars);
                        if(!set.contains(str) && !visited.contains(str)) {
                            if (str.equals(target)) {
                                return len;
                            }
                            q.offer(str);
                            visited.add(str);
                        }
                    //convert 9
                    } else if (chars[i] == '9') {
                        chars[i] = '0';
                        String str = String.valueOf(chars);
                        if(!set.contains(str) && !visited.contains(str)) {
                            if (str.equals(target)) {
                                return len;
                            }
                            q.offer(str);
                            visited.add(str);
                        }
                        chars[i] = '8';
                        str = String.valueOf(chars);
                        if(!set.contains(str) && !visited.contains(str)) {
                            if (str.equals(target)) {
                                return len;
                            }
                            q.offer(str);
                            visited.add(str);
                        }
                    // other situations
                    }else {
                        ++chars[i];
                        String str = String.valueOf(chars);
                        if(!set.contains(str) && !visited.contains(str)) {
                            if (str.equals(target)) {
                                return len;
                            }
                            q.offer(str);
                            visited.add(str);
                        }
                        chars[i] = ch;
                        --chars[i];
                        str = String.valueOf(chars);
                        if(!set.contains(str) && !visited.contains(str)) {
                            if (str.equals(target)) {
                                return len;
                            }
                            q.offer(str);
                            visited.add(str);
                        }
                    }
                    chars[i] = ch;
                }
            }
            ++len;
        }
        return -1;
    }
}