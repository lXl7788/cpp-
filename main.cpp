#include<bits/stdc++.h>
using namespace std;


//StringToVector
vector<int> STV(const string& s)//“&”引用参数，const防止参数被修改
{
    vector<int> num;//将字符转化为数组
    for(int i=0;i<s.size();++i)
    {
        char c=s[i];
        num.push_back(c-'0');
    }
    return num;
}
//AddBigInt
vector<int> ABI(vector<int>& num1,vector<int>& num2)//“&”直接引用num1，num2
{
    vector<int> ans;//存储加法的和
    int carry=0;//进位标志
    int i=num1.size()-1;//索引，取加数
    int j=num2.size()-1;//索引，取加数

    while(i>=0||j>=0||carry>0)//注意条件，进位不为0
    {
        int digit1=(i>=0)?num1[i--]:0;//i是否大于0，是->digit1=num1[i],i--;否->digit1=0
        int digit2=(j>=0)?num2[j--]:0;
        int sum=digit1+digit2+carry;
        carry=sum/10;
        ans.push_back(sum%10);
    }

    reverse(ans.begin(),ans.end());//反转数组ans才能得到正确结果
    return ans;

}

int main()
{
    vector<int> a1,a2,t;
    string s1,s2;
    cin>>s1>>s2;
    a1=STV(s1);
    a2=STV(s2);
    t=ABI(a1,a2);
    for(int i=0;i<t.size();++i)
    {
        cout<<t[i];
    }


}
