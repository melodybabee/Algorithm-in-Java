注意：
1.声明为int[]的时候需要确定array的大小，每次需要new一个对象出来
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i < nums.length; ++i){
            for(int j = i+1; j < nums.length; ++j){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}

注意：
1.Map中放的是Integer对象类型，在创建的时候需要new一个HashMap,要有（）
2.Map判断key是否存在,map,containsKey()。
获取key,map.get().
插入map,map.put(key,value).

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length; ++i){
            if(map.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return result;
    }
}