#include <iostream>
#include <vector>
#include <string>

using namespace std;

void Input_Video(int n);
void Clear_Video(int n);
void Check_Video(int index, int col_sp, int row_sp);
int Check_Exception(int n);

vector< vector<int> > video;

int main(void)
{
	int n, check, num, index;
	
	cin >> n;

	Input_Video(n);

	check = Check_Exception(n);
	if (check == 1)
	{
		if (video[0][0] == 1)
			num = 1;
		else if (video[0][0] == 0)
			num = 0;
		cout << num;
		return 0;
	}

	index = n / 2;
	Check_Video(index, 0, 0);

	Clear_Video(n);

	return 0;
}

void Input_Video(int n)
{
	vector<string> input;
	string temp;
	for (int i = 0; i < n; i++)
	{
		vector<int> element(n);
		video.push_back(element);
	}
	for (int i = 0; i < n; i++)
	{
		cin >> temp;
		input.push_back(temp);
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			video[i][j] = input[i][j] - '0';
	}
}

void Clear_Video(int n)
{
	for (int i = 0; i < n; i++)
	{
		video[i].clear();
	}
	video.clear();
}

void Check_Video(int index, int col_sp, int row_sp)
{
	int first, cur_row = row_sp;
	int count, complete_cnt = 0, row_cnt = 0;

	cout << '(';
	while (1)
	{
		count = 0;
		if (complete_cnt == 4)
		{
			cout << ')';
			return;
		}
		first = video[col_sp][row_sp];
		for (int i = col_sp; i < col_sp + index; i++)
		{
			for (int j = row_sp; j < row_sp + index; j++)
			{
				if (video[i][j] == first)
					count++;
			}
		}
		if (count == index*index)
		{
			if (first == 1)
				cout << '1';
			else if (first == 0)
				cout << '0';
		}
		else
			Check_Video(index / 2, col_sp, row_sp);
		row_sp += index;
		row_cnt++;
		if (row_cnt >= 2)
		{
			col_sp += index;
			row_sp = cur_row;
			row_cnt = 0;
		}
		complete_cnt++;
	}
}

int Check_Exception(int n)
{
	int first = video[0][0], count = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (first == video[i][j])
				count++;
		}
	}
	if (count == n*n)
		return 1;
	else
		return 0;
}