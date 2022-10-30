class Solution {
public:
    string oddString(vector<string>& words) {
        vector<vector<int>> vec;
        int n = words.size();
        map<vector<int>,int> m;
        map<vector<int>,int> m1;
        for(int i=0;i<n;i++)
        {
            vector<int> tmp;
            for(int j=1;j<words[i].size();j++)
            {
                tmp.push_back((words[i][j]-'a')-(words[i][j-1]-'a'));
            }
            vec.push_back(tmp);
            m[tmp]++;
            m1[tmp]=i;
        }
        string ans;
        for(auto i:m)
        {
            if(i.second==1)
            {
                ans=words[m1[i.first]];
                return ans;
            }
        }
        return ans;
    }
};
