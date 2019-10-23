class Solution {
    private class UnionFind{
        private int[] parent;
        private int[] size;
        private UnionFind(int len) {
            this.parent = new int[len];
            this.size = new int[len];
            
            for (int i = 0; i < len; ++i) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }
        
        private void union(int p, int q) {
            int rootP = getRoot(p);
            int rootQ = getRoot(q);
            if (size[p] < size[q]) {
                union(q, p);
            }
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        
        private int getRoot(int val) {
            int cur = val;
            while(parent[cur] != cur) {
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            parent[val] = cur;
            return cur;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        // Corner cases
        if (accounts == null | accounts.size() == 0) {
            return res;
        }
        int len = accounts.size();
        UnionFind uf = new UnionFind(len);

        // email to user, user the number to record different users
        HashMap<String, Integer> emailToUser = new HashMap<>();
        for (int i = 0 ; i < len; ++i) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); ++j) {
                String email = account.get(j);
                Integer user = emailToUser.get(email);
                // If this user is new, return; or union the cur one and the old one
                if (user == null) {
                    emailToUser.put(email, i);
                } else {
                    uf.union(user,i);
                }
            }
        }
        
        // Clarify different users, and put it to a new HashMap, key is user, value is set of email addresses
        HashMap<Integer, HashSet<String>> userToEmail = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            // should get user from the getRoot() function
            int user = uf.getRoot(i);
            if (!userToEmail.containsKey(user)) {
                userToEmail.put(user, new HashSet<String>());
            }
            // the same user will have the same toor
            for (int j = 1; j < accounts.get(i).size(); ++j) {
                userToEmail.get(user).add(accounts.get(i).get(j));
            }
        }
        
        // Library, import java.util.Map.Entry, then could use Entry directly
        for (Map.Entry<Integer, HashSet<String>> e : userToEmail.entrySet()) {
            List<String> sol = new ArrayList<>();
            sol.addAll(e.getValue());
            // Sort the value
            Collections.sort(sol);
            // Integer to String
            sol.add(0, accounts.get(e.getKey()).get(0));
            res.add(sol);
        }
        return res;
    }
}