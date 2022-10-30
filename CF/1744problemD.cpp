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
 
 
 
int main(){
    fio;
    ll T=1;
    cin>>T;
    while(T--){
 
        ll n,q;
        cin>>n>>q;
 
        vector<ll> v(n);
 
        ll sum = 0;
 
        ll odds = 0;
        ll evens = 0;
 
        for(int i=0;i<n;i++){
            cin>>v[i];
            sum+=v[i];
 
            if(v[i]%2)odds++;
            else evens++;
        }
 
        vector<pair<ll,ll>> x(q);
        ll t1,t2;
        for(int i=0;i<q;i++){
            cin>>t1>>t2;
            x[i] = {t1, t2};
        }
 
        for(int i=0;i<q;i++){
 
            pair<ll,ll> ele = x[i];
 
            if(ele.first==0){
 
                if(ele.second % 2==0){
                    // even remains evens...
                    // add even times
                    sum += evens*ele.second;
                } else {
                    // evens becomes odd.
                    sum += evens*ele.second;
                    odds += evens;
                    evens = 0;
 
                }
 
            } else {
 
                if(ele.second % 2 == 0){
 
                    sum+=odds*ele.second;
 
                } else {
                    sum +=odds*ele.second;
                    evens+=odds;
                    odds = 0;
                }
            }
 
            cout<<sum<<"\n";
 
 
 
        // cout<<"\n";
    }
    
    return 0;
}
