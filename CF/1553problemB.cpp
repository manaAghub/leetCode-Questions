#include <bits/stdc++.h>
using namespace std;
 
#define fio                  ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define ll                    long long int
#define ull                   unsigned long long int
#define nl                    "\n";
#define pb                    push_back
 
// debugging and tracing
#define db1(x)                cout<<"["<<#x<<": "<<x<<"]\n";
#define db2(x, y)             cout<<"["<<#x<<": "<<x<<" | "<<#y<<": "<<y<<"]\n";
#define db3(x, y, z)          cout<<"["<<#x<<":" <<x<<" | "<<#y<<": "<<y<<" | "<<#z<<": "<<z<<"]\n";
#define db4(a, b, c, d)       cout<<"["<<#a<<": "<<a<<" | "<<#b<<": "<<b<<" | "<<#c<<": "<<c<<" | "<<#d<<": "<<d<<"]\n";
 
 
bool checkBefore(string&s, string&t, int start, int ctr){
    int x = 0;
    while(x+ctr<t.size()){
        if(s[start-x]!=t[x+ctr]) return false;
        x++;
    }
    return true;
}
 
 
 
bool check(string &s, string &t, int start){
    // check before.. or check from next index or return false...
 
    int ctr = 0;
 
    while(ctr<t.size()){
        // move forward and check backwards as well...
        if(checkBefore(s, t, start+ctr, ctr)){
            return true;
        }
 
        if(s[start+ctr]!=t[ctr]){
            return false;
        } else {
            // cout<<"h";
            ctr++;
        }
    }
 
    return true;
}
 
int main(){
    fio;
    ll T=1;
    cin>>T;
    while(T--){
 
        string s;
        cin>>s;
 
        string t;
        cin>>t;
 
        ll n = s.size();
 
        map<char, vector<int>> m;
 
        for(int i=0; i<n; i++){
            m[s[i]].push_back(i);
        }
 
        vector<int> v = m[t[0]];
        bool flag = true;
 
        for(int i = 0; i< v.size(); i++){
 
            // start from i and see if this index is possible or not....
 
            // move right...
            if(check(s, t, v[i])){
                flag = false;
                cout<<"YES";
                break;
            }
 
        }
 
        if(flag) cout<<"NO";
 
 
 
 
        
 
 
 
        cout<<"\n";
    }
    
    return 0;
}
