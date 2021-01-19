#include <iostream>
#include <vector>

using namespace std;

void Input_Paper(vector<vector<int>>& v, int n);
void Clear_Paper(vector< vector<int> >& v, int n);
void Check_Paper(int index, int col_sp, int row_sp);
int Check_Execption(int n);

vector< vector<int> > paper;
int zero_num = 0, one_num = 0, minus_num = 0;

int main(void)
{
    int n, index, check;

    cin >> n;

    Input_Paper(paper, n);

    check = Check_Execption(n);
    if (check == 1)
    {
        cout << minus_num << endl;
        cout << zero_num << endl;
        cout << one_num << endl;
        return 0;
    }
    index = n / 3;

    Check_Paper(index, 0, 0);
    
    cout << minus_num << endl;
    cout << zero_num << endl;
    cout << one_num << endl;

    Clear_Paper(paper, n);

    return 0;
}

void Input_Paper(vector<vector<int>>& v, int n)
{
    for (int i = 0; i < n; i++)
    {
        vector<int> element(n);
        v.push_back(element);
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            cin >> v[i][j];
    }
}

void Clear_Paper(vector< vector<int> >& v, int n)
{
    for (int i = 0; i < n; i++)
    {
        v[i].clear();
    }
    v.clear();
}

void Check_Paper(int index, int col_sp, int row_sp)
{
    int first, count;
    int complete_cnt = 0;
    int row_cnt = 0;
    int init_row = row_sp;
    while (1)
    {
        if (complete_cnt == 9)
            return;
        count = 0;
        first = paper[col_sp][row_sp];
        for (int i = col_sp; i < col_sp + index; i++)
        {
            for (int j = row_sp; j < row_sp + index; j++)
            {
                if (paper[i][j] == first)
                    count++;
            }
        }
        if (count == index * index)
        {
            if (first == 0)
                zero_num++;
            else if (first == 1)
                one_num++;
            else if (first == -1)
                minus_num++;
        }
        else
            Check_Paper(index/3, col_sp, row_sp);
        row_sp = row_sp + index;
        row_cnt++;
        if (row_cnt >= 3)
        {
            col_sp = col_sp + index;
            row_sp = init_row;
            row_cnt = 0;
        }
        complete_cnt++;
    }
}

int Check_Execption(int n)
{
    int count = 0;
    int first = paper[0][0];
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (paper[i][j] == first)
                count++;
        }
    }
    if (count == n * n)
    {
        if (first == 0)
            zero_num++;
        else if (first == 1)
            one_num++;
        else if (first == -1)
            minus_num++;
        return 1;
    }
    else
        return 0;
}