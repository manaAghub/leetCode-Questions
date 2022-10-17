#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll, ll> pii;
typedef vector<ll> vi;
#define ndl "\n"
const ll MAX = 1e6+10; // 100100
#define pb push_back
#define mp make_pair
#define ub upper_bound
#define lb lower_bound
#define vvi vector<vi>
#define vii vector<pii>
#define mii map<ll, ll>
#define rep(i, k, n) for (int i = k; i < n; i++)
#define rept(i, k, n) for (auto i = k; i != n; ++i)
#define drep(i, k, n) for (int i = k; i >= n; i--)
#define repeat(n) for(int _=0;_<n;_++)
#define ff first
#define ss second
#define tt third
// #define int long long
#define all(a) (a).begin(), (a).end()
#define scan(arr, n) rep(INPUT, 0, n)  cin>>arr[INPUT];
const ll MOD =  1e9+7;
vector<bool> isPrime(MAX, 1);
vi lp(MAX, 0),hp(MAX, 0),prime_factors;
void sieve(){isPrime[0] = isPrime[1] = 0;for(ll i=2;i<MAX;i++){if(isPrime[i]){lp[i]=hp[i]=i;for(ll j=2*i;j<MAX;j+=i){isPrime[j] = 0;hp[j]=i;if(lp[j]==0){lp[j]=i;}}}}}
void primeFactors(ll n){while (n>1){ll prime_factor=hp[n];while(n%prime_factor==0){n/=prime_factor;prime_factors.pb(prime_factor);}}}
string decimaltobinary(ll n){string s;while(n>0){char c = '0' + n%2;s.push_back(c);n = n / 2;}return s;}
ll power(ll a, ll b){if(b==0)return 1;if(b==1)return a;ll x = power(a, b/2);if(b%2==0){return x*x;}return a*x*x;}
ll powermod(ll a,ll b){ll res = 1;while(b > 0){if(b&1){res = res*a;}b = b / 2;a = a*a;a = a%MOD;res = res%MOD;}return res;}
struct custom_hash { static uint64_t splitmix64(uint64_t x)  { x += 0x9e3779b97f4a7c15; x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9; x = (x ^ (x >> 27)) * 0x94d049bb133111eb; return x ^ (x >> 31); } size_t operator()(uint64_t x) const { static const uint64_t FIXED_RANDOM = chrono::steady_clock::now().time_since_epoch().count(); return splitmix64(x + FIXED_RANDOM); }};
// unordered_map<int,int,custom_hash> m
class triplet{public:ll first, second, third;};
ll moddivide(ll a, ll b){return (a%MOD * power(a, MOD-2)%MOD)%MOD;}
// -------------------------------------------------------------------

void solve(){
    int n,ans=0;
    cin>>n;
    vi a(n);
    scan(a,n);
    int start=0,end=n-1;
    while(start<end){
        while(a[start]!=1&&start<end)start++;
        while(a[end]!=0&&start<end)end--;
        if(start<end){
            ans++;
            start++;
            end--;
        }
    }
    cout<<ans<<ndl;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    #ifndef ONLINE_JUDGE
	    freopen("input.txt", "r", stdin);
        freopen("output.txt", "w", stdout);
    #endif
    ll t = 1;
    cin>>t;
    while(t--)solve();
    return 0;
}