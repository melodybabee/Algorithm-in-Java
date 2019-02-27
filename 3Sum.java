注意：
1.list是一个抽象类，所以在初始化的时候需要确定是LinkedList,ArrayList,stack,vector等，queue属于LinkedList的一种
2.Arrays.List()使用该方法可以将一个变长参数或者数组转换成List

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i){
            if(i >= 1 && nums[i] == nums[i-1])continue;
            int temp = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(nums[left] + nums[right] == temp){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        ++left;
                    }
                    ++left;
                    while(left < right && nums[right] == nums[right-1]){
                        --right;
                    }
                    --right;
                }else if(nums[left] + nums[right] < temp){
                    ++left;
                }else{
                    --right;
                }
            }
        }
        return res;
    }
}