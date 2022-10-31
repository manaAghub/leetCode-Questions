class UniquePaths {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        int k = m>n ? n-1 : m-1;
        for (int i=0;i<k;i++)
        {
            ans = ans*(m+n-2-i);
            ans = ans/(i+1);
        }
        return (int)ans;
    }
}