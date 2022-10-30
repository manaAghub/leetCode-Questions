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
 
        ll n,x;
        cin>>n>>x;
 
        vector<ll> v(n);
 
        ll evens = 0;
        ll odds = 0;
 
        for(int i=0; i<n; i++){
            cin>>v[i];
            if(v[i]%2) odds++;
            else evens++;
        }
 
        if(odds==0){
            cout<<"No";
        } else if (odds==1){
            cout<<"Yes";
        } else if (evens == 0 && x%2==0){
            cout<<"No";
        } else {
            if(odds%2){
                cout<<"Yes";
            } else {
                if(odds+evens-1>=x){
                    cout<<"Yes";
                } else {
                    cout<<"No";
                }
            }
        }
 
 
 
        cout<<"\n";
    }
    
    return 0;
}
