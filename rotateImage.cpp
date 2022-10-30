class Solution {
public:
    void swape(int &a,int &b)
    {
        a=a^b;
        b=b^a;
        a=a^b;
    }
    void rotate(vector<vector<int>>& matrix) {
        for(int i=0;i<matrix.size();i++)
            for(int j=i;j<matrix.size();j++)
                if(i!=j)
                    swape(matrix[i][j],matrix[j][i]);
        for(int i=0;i<matrix.size();i++)
            for(int j=0;j<matrix.size()/2;j++)
                swape(matrix[i][j],matrix[i][matrix.size()-1-j]);
    }
};
