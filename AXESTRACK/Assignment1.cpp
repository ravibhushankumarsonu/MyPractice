
//Assignment: C / C++ Code for the Prediction Search.
//
//{HINT: U need to choose data structure N - ary Tree, to store all the respective words from the file(I am attaching 
//	the file along with this email), and after successful storing all the words in a single N - ary Tree, all the 
//	search should happen on this Tree only, and e.g if u are searching e.g something like aar, your search function should return 
//	something like
//
//aardvark
//aardvarks
//aardwolf
//
//}

//This code is written in VC++ and tested in Visual Studio 2015
#include<iostream>
#include<vector>
#include<algorithm>
#include<fstream>
#include<string>

using namespace std;

//Structure of the Node
struct node {
	char key;
	bool isLeaf;
	node *child[26];
};

//Default node structure
node *newNode(char key)
{
	node *temp = new node;
	temp->key = key;
	temp->isLeaf = false;
	for (int i = 0; i < 26; i++)
		temp->child[i] = NULL;
	return temp;
}

//To print the predicted output
void Output(node *tree, string str)
{
	if (tree->isLeaf)
		cout << str << endl;
	for (int i = 0; i < 26; i++)
	{
		string temp = str;
		if (tree->child[i] != NULL)
		{
			Output(tree->child[i], temp += tree->child[i]->key);
		}
	}
	return;
}

//Tree constructor
void Construct(node *tree, string str, int i)
{
	if (i == str.length())
	{
		tree->isLeaf = true;
		return;
	}
	//cout << str << endl;
	//locale loc;
	//tolower(str[i],loc);
	str[i] = tolower(str[i]);
	if (tree->child[str[i] - 'a'] == NULL)
	{
		tree->child[str[i] - 'a'] = newNode(str[i]);
	}
    Construct(tree->child[str[i] - 'a'], str, i + 1);
}

//Comparision algorithms
void predication(node *tree, string str,int i)
{
	if (i >= str.length())
	{
		Output(tree, str);
		return;
	}
	if (tree->child[str[i]-'a'] != NULL)
	{
		predication(tree->child[str[i] - 'a'], str, i + 1);
	}
	return;
}


int main()
{
	string words;
	ifstream dataFile;
	vector<string>vector_data;
	//Please enter the absolute path of the file of your compter
	dataFile.open("G:\\work\\Axextrack\\word_list.txt");
	if (dataFile.is_open())
	{
		while (!dataFile.eof())
		{
			getline(dataFile, words);
			//cout << words << " ";
			vector_data.push_back(words);
		}
		dataFile.close();
	}
	else {
		cout << "Error in opening the file\n";
	}
	cout << "File is loading........" << endl;
	//cout << vector_data.size() << endl;
	/*for (int i = 0; i < vector_data[1].length(); i++)
	{
		cout << (vector_data[1][i]-'a') << " ";
	}
	cout << endl;*/
	node *tree = newNode('0');
	for (int i = 0; i < vector_data.size(); i++)
	{
		Construct(tree, vector_data[i], 0);
	}
	cout << "Enter the string to be searched : \n";
	string str;
	cin >> str;
	predication(tree, str, 0);
	return 0;
}