//C headers
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <limits.h>
#include <ctype.h>
#include <assert.h>
#include <time.h>
//cpp headers
#include <iostream>
#include <iomanip>
#include <sstream>
#include <algorithm>
#include <vector>
#include <queue>
#include <set>
#include <map>
#include <stack>
#include <deque>
#include <list>
//#include <bits/stdc++.h>
//#include <bitset>
using namespace std;
//typedefs
typedef long long ll;
typedef pair<ll, ll> pll;
typedef pair<int, int> ii;
typedef vector<int> vi;
typedef vector<ii> vii;
//some constants
const double pi = 2.0 * acos (0.0);
const double E = exp (1);
//always useful
#define csprnt printf("Case %d: ", cas++);
#define gcd(a,b) __gcd(a,b)
#define clr(a) memset(a, 0, sizeof(a))
#define mem(a,b) memset(a, b, sizeof(a))
#define REP(i, a, n) for(int i = a; i < n; ++i)
#define RREP(i, a, n) for(int i = a; i > n; --i)
#define REPE(i, a, n) for(int i = a; i <= n; ++i)
#define RREPE(i, a, n) for(int i = a; i >= n; --i)
//useful with graphs
#define fr first
#define sc second
#define pb push_back
#define pp pop_back
#define mp make_pair
#define IT iterator
#define vsort(v) v.begin(), v.end()
#define ssort(v) stable_sort(v.begin(), v.end())
#define sf scanf
#define pf printf
#define sf1(a) scanf("%d", &a)
#define sf2( a, b) scanf("%d %d", &a, &b)
#define sf3( a, b, c) scanf("%d %d %d", &a, &b, &c)
#define sf4( a, b, c, d) scanf("%d %d %d %d", &a, &b, &c, &d)
#define sf1ll(a) scanf("%lld",&a)
#define sf2ll(a,b) scanf("%lld %lld",&a,&b)
#define sf3ll(a,b,c) scanf("%lld %lld %lld", &a,&b, &c)
#define sf4ll(a,b,c, d) scanf("%lld %lld %lld %lld", &a,&b, &c, &d)
/*--------------------------------------------------------------------------------------------------*/
//ll extGcd(ll a, ll b, ll& x, ll& y){if (b == 0){x = 1;y = 0;return a;}else{int g = extGcd(b, a % b, y, x);y -= a / b * x;return g;}}
//ll modInv(ll a, ll m){ll x, y; extGcd(a, m, x, y); x %= m; while (x < 0){x += m;} return x;}
//ll bigmod(ll a,ll b,ll m){if(b == 0) return 1%m;ll x = bigmod(a,b/2,m);x = (x * x) % m;if(b % 2 == 1) x = (x * a) % m;return x;}
//ll BigMod(ll B,ll P,ll M){ ll R=1%M; while(P>0) {if(P%2==1){R=(R*B)%M;}P/=2;B=(B*B)%M;} ret urn R;} /// (B^P)%M

//template <class T> inline T gcd(T a, T b){if(b == 0) return a;return gcd(b,a%b);}
//template <class T> inline T lcm(T a, T b){return (a/gcd(a,b)) * b;}
template<class T1> void deb (T1 e)
{
    cout << e << endl;
}
template<class T1, class T2> void deb (T1 e1, T2 e2)
{
    cout << e1 << " " << e2 << endl;
}
template<class T1, class T2, class T3> void deb (T1 e1, T2 e2, T3 e3)
{
    cout << e1 << " " << e2 << " " << e3 << endl;
}
template<class T1, class T2, class T3, class T4> void deb (T1 e1, T2 e2, T3 e3, T4 e4)
{
    cout << e1 << " " << e2 << " " << e3 << " " << e4 << endl;
}
template<class T1, class T2, class T3, class T4, class T5> void deb (T1 e1, T2 e2, T3 e3, T4 e4, T5 e5)
{
    cout << e1 << " " << e2 << " " << e3 << " " << e4 << " " << e5 << endl;
}
template<class T1, class T2, class T3, class T4, class T5, class T6> void deb (T1 e1, T2 e2, T3 e3, T4 e4, T5 e5, T6 e6)
{
    cout << e1 << " " << e2 << " " << e3 << " " << e4 << " " << e5 << " " << e6 << endl;
}
///      f  u  n  c  t  i  o  n     ///

/*bool valid(int u, int v)
{
    if(u>=0 && u<r && v>=0 && v<c) return true;
    return false;
}*/
int x[] = {0,0,-1,1};//4-way
int y[] = {1,-1,0,0};//4-way
ll fx[] = {-1,-1,-1,0,0,1,1,1};//8-way
ll fy[] = {-1,0,1,-1,1,-1,0,1};//8-way
int xx[] = {-2,-1, 1, 2, 2,1,-1,-2};//Horse-move
int yy[]= {-1,-2,-2,-1, 1,2, 2, 1}; //Horse-move
#define MOD 1000000007
#define M 100010
#define oo (1<<28)
#define sz 1000010
struct data
{
    ll prop, sum;
};
data tree[3*M];
ll arr[M], n, m;
void Update( ll node, ll b, ll e, ll i, ll j, ll val)
{
    if(i>e || j<b) return;
    if(b>=i && e<=j)
    {
        tree[node].sum += ((e-b+1)*val);
        tree[node].prop += val;
        return;
    }
    ll left, right, mid;
    mid=(b+e)>>1;
    left=node<<1;
    right=left|1;
    Update( left, b, mid, i, j, val);
    Update( right, mid+1, e, i, j, val);
    tree[node].sum=tree[left].sum+tree[right].sum+(e-b+1)*tree[node].prop;
}
ll query( ll node, ll b, ll e, ll i, ll j, ll carry)
{
    if( i>e || j<b) return 0;
    if( b>=i && e<=j) return tree[node].sum+(e-b+1)*carry;
    int left, right, mid;
    mid=(b+e)>>1;
    left=node<<1;
    right=left|1;
    ll p1=query(left, b, mid, i, j, carry+tree[node].prop);
    ll p2=query(right, mid+1, e, i, j, carry+tree[node].prop);
    return p1+p2;
}
int main()
{
    #ifndef ONLINE_JUDGE
    //freopen("input.txt","r",stdin);
#endif
    ll i, j, k, t, p, v, a, b, c, ans, cas=1;
    sf1ll(t);
    while(t--)
    {
        clr(tree);
        sf2ll( n, m);
        printf("Case %lld:\n", cas++);
        for( i=1; i<=m; i++)
        {
            scanf("%lld", &p);
            if(p==0)
            {
                scanf("%lld %lld %lld", &a, &b, &c);
                Update( 1, 0, n-1, a, b, c);
            }
            else
            {
                scanf("%lld %lld", &a, &b);
                ans=query( 1, 0, n-1, a, b, 0);
                printf("%lld\n", ans);
            }
        }
    }
    return 0;
}
