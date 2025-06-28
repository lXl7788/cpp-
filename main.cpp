#include<bits/stdc++.h>
using namespace std;


//StringToVector
vector<int> STV(const string& s)//��&�����ò�����const��ֹ�������޸�
{
    vector<int> num;//���ַ�ת��Ϊ����
    for(int i=0;i<s.size();++i)
    {
        char c=s[i];
        num.push_back(c-'0');
    }
    return num;
}
//AddBigInt
vector<int> ABI(vector<int>& num1,vector<int>& num2)//��&��ֱ������num1��num2
{
    vector<int> ans;//�洢�ӷ��ĺ�
    int carry=0;//��λ��־
    int i=num1.size()-1;//������ȡ����
    int j=num2.size()-1;//������ȡ����

    while(i>=0||j>=0||carry>0)//ע����������λ��Ϊ0
    {
        int digit1=(i>=0)?num1[i--]:0;//i�Ƿ����0����->digit1=num1[i],i--;��->digit1=0
        int digit2=(j>=0)?num2[j--]:0;
        int sum=digit1+digit2+carry;
        carry=sum/10;
        ans.push_back(sum%10);
    }

    reverse(ans.begin(),ans.end());//��ת����ans���ܵõ���ȷ���
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
