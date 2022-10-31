class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        if(nums.size()<4)return vector<vector<int>>{};
        vector<vector<int>> v;
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size()-3;i++)
        {
            if(i==0 || (i>0 && nums[i]!=nums[i-1]))
                for(int j=i+1;j<nums.size()-2;j++)
                {
                    if(j==i+1 || (j>i+1 && nums[j]!=nums[j-1]))
                    {
                        int lo=j+1,hi=nums.size()-1;
                        while(lo<hi)
                        {
                            if(0LL+nums[i]+nums[j]+nums[lo]+nums[hi]==1LL*target)
                            {
                                v.push_back(vector<int>{nums[i],nums[j],nums[lo],nums[hi]});
                                while(lo<hi && nums[lo]==nums[lo+1])lo++;
                                while(lo<hi && nums[hi]==nums[hi-1])hi--;
                                lo++;
                                hi--;
                            }
                            else if(0LL+nums[i]+nums[j]+nums[lo]+nums[hi]<1LL*target)lo++;
                            else hi--;
                        }
                    }
                }
        }
        return v;
    }
};
