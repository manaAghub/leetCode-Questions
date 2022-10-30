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
    // cin>>T;
    while(T--){
 
        ll n;
        cin>>n;
 
        vector<ll> x(n);
        ll mx = INT_MIN;
        ll sum = 0;
        multiset<ll> s;
        for(int i=0;i<n;i++){
            cin>>x[i];
            sum+=x[i];
            mx = max(x[i], mx);
            s.insert(x[i]);
        }
 
        ll m;
        cin>>m;
 
        // vector<pair<ll,ll>> d(m);
        ll d;
        ll a;
        for(int i=0; i<m; i++){
            // cin>>d[i].first>>d[i].second;
            cin>>d>>a;
 
            ll t1 = 0;
 
            ll t2 = 0;
 
            auto temp = s.lower_bound(d);
            ll ans = 0;
 
            if(temp == s.end()){
                t1 = d-mx;
                sum-=mx;
                if(sum<a){
                    t2=a-sum;
                }
                sum+=mx;
                ans = t1+t2;
            } else if (temp == s.begin()) {
                sum-=*s.begin();
                if(sum<a){
                    t2 = a-sum;
                }
                sum+=*s.begin();
                ans = t1+t2;
            } else {
 
                // check for both temp and --temp;
                ll t2a=0, t2b=0;
 
                sum-=*temp;
                if(sum<a){
                    t2a = a-sum;
                }
                sum+=*temp;
                temp--;
                sum -= *temp;
 
                if(sum<a){
                    t2b = a-sum;
                }
 
                sum += *temp;
 
                ans = min(t2a, t2b + d - *temp);
            }
 
 
 
            cout<<ans<<"\n";
 
 
        }
        continue;
 
 
 
 
 
 
        cout<<"\n";
    }
    
    return 0;
}
