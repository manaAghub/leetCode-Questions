class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        int n = growTime.size();
        vector<pair<int,int>> vec(n);
        for(int i=0;i<n;i++)
        {
            vec[i]={growTime[i],plantTime[i]};
        }
        sort(vec.begin(),vec.end());
        int ans=vec[n-1].first+vec[n-1].second;
        for(int i=n-2;i>=0;i--)
        {
            ans=max(ans,vec[i].first+vec[i].second+vec[i+1].second);
            vec[i].second+=vec[i+1].second;
        }
        return ans;
    }
};
