#include<bits/stdc++.h>
using namespace std;
int main(int argc,char** argv)
{

    string a,b;
     int prime = 101;
     int pow= 256;
    int  hash_text = 0;
    int hash_pat = 0;
     int total_pow_value;
   // while(getline(cin,a))
    //{
      //  getline(cin,b);
       a="GEEKS FOR GEEKS";
       b="GEEK";
        total_pow_value=1;
        cout<<b.size()<<endl;
        for(int i=0;i<b.size()-1;i++)
        {
            total_pow_value=(total_pow_value*pow)%prime;
        }

        cout<<total_pow_value<<endl;
    /// hash find
    hash_text=0;
    hash_pat=0;
    for(int i=0;i<b.size();i++)
    {
        hash_pat=(hash_pat*pow+b[i])%prime;
        hash_text=(hash_text*pow+a[i])%prime;
    }


    cout<<hash_pat<<" "<<hash_text<<endl;


    for(int i=0;i<=a.size()-b.size();i++)
    {
        if(hash_pat==hash_text)
        {
            int j=0;
            for(j=0;j<b.size();j++)
            {

                if(a[i+j]!=b[j])
                    break;
            }
            if(j==b.size())
            {
                cout<<"pattern Found "<<i<<endl;
            }

        }
        if(i<a.size()-b.size())
        {
            hash_text=(pow*(hash_text-a[i]*total_pow_value)+a[i+b.size()])%prime;
            if(hash_text<0)
            {
                cout<<hash_text<<endl;
                hash_text= hash_text+prime;
            }
        }

    }

            cout<<"Not Found"<<endl;

    //}

    return 0;
}
