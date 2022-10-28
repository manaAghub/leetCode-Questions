/*  84. Largest Rectangle in Histogram     // hard
Problem Statement: -
    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
    return the area of the largest rectangle in the histogram.

    Example 1:

    Input: heights = [2,1,5,6,2,3]
    Output: 10
    Explanation: The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.
*/

#include <bits/stdc++.h>
using namespace std;

int largestRectangleArea(vector<int> &heights)
{
    int n = heights.size();
    vector<int> sel(n);
    stack<pair<int, int>> s;
    for (int i = 0; i < n; i++)
    {
        if (s.empty())
            sel[i] = -1;
        else if (s.top().first >= heights[i])
        {
            while (!s.empty() && s.top().first >= heights[i])
                s.pop();
            if (s.empty())
                sel[i] = -1;
            else
                sel[i] = s.top().second;
        }
        else if (s.top().first < heights[i])
            sel[i] = s.top().second;
        s.push({heights[i], i});
    }

    vector<int> ler(n);
    while (!s.empty())
        s.pop();
    for (int i = n - 1; i >= 0; i--)
    {
        if (s.empty())
            ler[i] = n;
        else if (s.top().first >= heights[i])
        {
            while (!s.empty() && s.top().first >= heights[i])
                s.pop();
            if (s.empty())
                ler[i] = n;
            else
                ler[i] = s.top().second;
        }
        else if (s.top().first < heights[i])
            ler[i] = s.top().second;
        s.push({heights[i], i});
    }
    int maxArea = 0;
    for (int i = 0; i < n; i++)
    {
        int curr = (ler[i] - sel[i] - 1) * heights[i];
        maxArea = max(maxArea, curr);
    }

    return maxArea;
}

int main()
{
    int n;
    cout << "Enter the size of the heights array: ";
    cin >> n;
    vector<int> heights(n);
    cout << "\nEnter the heights array: ";
    for (int i = 0; i < n; i++)
    {
        cin >> heights[i];
    }
    cout << "The largest rectangle is of size: " << largestRectangleArea(heights) << endl;

    return 0;
}