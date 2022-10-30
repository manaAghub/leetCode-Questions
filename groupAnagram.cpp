class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,vector<string>> m;
        for(auto i:strs)
        {
            string tmp = i;
            sort(tmp.begin(),tmp.end());
            if(m.find(tmp)!=m.end())
            m[tmp].push_back(i);
            else
            m[tmp].push_back(i);
        }
        vector<vector<string>> ans;
        for(auto i:m)
        {
            ans.push_back(i.second);
        }
        return ans;
    }
};
