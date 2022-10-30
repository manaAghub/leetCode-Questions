class Solution {
public:
    vector<string> twoEditWords(vector<string>& que, vector<string>& dic) {
        vector<string> ans;
        for(int i=0;i<que.size();i++)
        {
            for(int j=0;j<dic.size();j++)
            {
                int cnt=0;
                for(int k=0;k<que[i].size();k++)
                {
                    if(que[i][k]!=dic[j][k])
                        cnt++;
                }
                if(cnt<=2)
                {
                    ans.push_back(que[i]);
                    break;
                }
            }
        }
        return ans;
    }
};
