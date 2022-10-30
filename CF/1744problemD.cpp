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
 
 
ll fp(ll n){
    int res = 0;
    while(n % (ll)pow(2, res) == 0){
        res++;
    }
    return res - 1;
}
 
 
 
int main(){
    fio;
    ll T=1;
    cin>>T;
    while(T--){
 
        ll n;
        cin>>n;
 
        vector<ll> v(n);
        for(int i=0;i<n;i++){
            cin>>v[i];
        }
 
        ll max2 = log2(n);
 
        ll required = n;
 
        ll present = 0;
 
        ll maxgive = 0;
 
        for(int i=0;i<n;i++){
            present += fp(v[i]);
            maxgive += fp(i+1);
        }
 
        // db1(present);
 
        required -= present;
 
        // calculate till required is not 0 or max2 is not 0;
 
        ll temp = max2;
 
        ll ans = 0;
 
        // max we can give...
 
        if(required - maxgive > 0){
            cout<<-1;
        } else {
 
            while(temp>0 && required>0){
 
                // ans++;
 
                // give maximum and subtract that from temp.
 
                // how many pow(2, temp) you can give.
 
                ll mul = n/pow(2, temp);
 
                ll xx = (mul+1)/2;
 
 
                while(xx>0  && required>0){
                    ans++;
                    xx--;
                    required -= temp;
                }
 
                temp--;
            }
 
 
 
            cout<<ans;
 
        }
        
        
 
 
 
        cout<<"\n";
    }
    
    return 0;
}
