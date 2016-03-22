#include <iostream>
#include <stdlib.h>
#include<algorithm>
using namespace std;

class tree_node {
private:
	int data;
	tree_node* left;
	tree_node* right;
public:
	tree_node() {
		left = NULL;
		right = NULL;
	}
	void set_data(int data) {
		this->data = data;
	}
	int get_data() {
		return this->data;
	}
	void set_left(tree_node * left) {
		this->left = left;
	}
	tree_node* get_left() {
		return this->left;
	}
	void set_right(tree_node * right) {
		this->right = right;
	}
	tree_node* get_right() {
		return this->right;
	}
	tree_node** get_left_ref() {
		return &(this->left);
	}
	tree_node** get_right_ref() {
		return &(this->right);
	}
};

class tree {
private:
	tree_node* root;
	int size;
	void _recursive_insert(tree_node** root_ref, int value);
	void _print_preorder(tree_node* root);
	void _print_inorder(tree_node* root);
	void _print_postorder(tree_node* root);
	int _find_size(tree_node* root);
	int _are_identical(tree_node* tn1, tree_node* tn2);
	int _find_height(tree_node* root);
	void _delete_tree(tree_node** root);
	void _mirror(tree_node* root);
	void _print_paths(tree_node* root, int* path_nodes, int next_vacant_position);
	void _print_array(int* array, int len);
	tree_node* _lowest_common_ancestor(tree_node* parent, tree_node* root, int a, int b);
	tree_node* _find_node(tree_node* root, int value);
	tree_node* _min_node(tree_node* root);
	void _print_level_order(tree_node* root);
	int _count_leaf_nodes(tree_node* root);
	int _is_bst(tree_node* root);
	int _children_sum(tree_node* root);
	void _ensure_children_sum(tree_node* root);
	int _diameter(tree_node* root);
	int _is_height_balanced(tree_node* root);
	int _leaf_path_sum(tree_node* root, int num);
	void _double_tree(tree_node* root);
	int _width(tree_node* root, int height, int level, int initialize_width_array);
	int _maximum(int array[], int len);
	void _print_k_distance_nodes(tree_node* root, int k, int distance);
	tree_node* _kth_smallest_element(tree_node* root, int k);
public:
	tree() {
		root = NULL;
		size = 0;
	}
	void insert(int value);
	void recursive_insert(int value);
	void print_preorder();
	void print_inorder();
	void print_postorder();
	int find_size();
	int get_size() {
		return this->size;
	}
	int are_identical(tree t);
	int find_height();
	void delete_tree();
	void mirror();
	void print_paths();
	tree_node* lowest_common_ancestor(int a, int b);
	tree_node* find_node(int value);
	tree_node* min_node();
	void print_level_order();
	int count_leaf_nodes();
	int is_bst();
	int children_sum();
	void ensure_children_sum();
	int diameter();
	int is_height_balanced();
	int leaf_path_sum(int num);
	void double_tree();
	int width();
	void print_k_distance_nodes(int k);
	tree_node* kth_smallest_element(int k);
};

void tree::insert(int value) {
	if (root == NULL) {
		root = new tree_node;
		root->set_data(value);
	}
	else {
		tree_node* parent = NULL;
		tree_node* current = root;
		tree_node* new_node = new tree_node;
		new_node->set_data(value);
		while (current != NULL) {
			if (value <= current->get_data()) {
				parent = current;
				current = current->get_left();
			}
			else {
				parent = current;
				current = current->get_right();
			}
		}
		if (value <= parent->get_data() && parent->get_left() == NULL) {
			parent->set_left(new_node);
		}
		else if (value>parent->get_data() && parent->get_right() == NULL) {
			parent->set_right(new_node);
		}
	}
	size++;
}

void tree::recursive_insert(int value) {
	_recursive_insert(&root, value);
	size++;
}

void tree::_recursive_insert(tree_node ** root_ref, int value) {
	if (*root_ref == NULL) {
		tree_node * new_node = new tree_node;
		new_node->set_data(value);
		*root_ref = new_node;
	}
	else {
		if (value <= (*root_ref)->get_data()) {
			_recursive_insert((*root_ref)->get_left_ref(), value);
		}
		else {
			_recursive_insert((*root_ref)->get_right_ref(), value);
		}
	}
}

void tree::print_preorder() {
	if (root == NULL) {
		return;
	}
	_print_preorder(root);
	cout << endl;
}

void tree::_print_preorder(tree_node * root) {
	if (root == NULL) {
		return;
	}
	cout << root->get_data() << " ";
	if (root->get_left() != NULL)
		_print_preorder(root->get_left());
	if (root->get_right() != NULL)
		_print_preorder(root->get_right());
}

void tree::print_inorder() {
	if (root == NULL) {
		return;
	}
	_print_inorder(root);
	cout << endl;
}

void tree::_print_inorder(tree_node * root) {
	if (root == NULL) {
		return;
	}
	if (root->get_left() != NULL)
		_print_inorder(root->get_left());
	cout << root->get_data() << " ";
	if (root->get_right() != NULL)
		_print_inorder(root->get_right());
}

void tree::print_postorder() {
	if (root == NULL) {
		return;
	}
	_print_postorder(root);
	cout << endl;
}

void tree::_print_postorder(tree_node * root) {
	if (root == NULL) {
		return;
	}
	if (root->get_left() != NULL)
		_print_postorder(root->get_left());
	if (root->get_right() != NULL)
		_print_postorder(root->get_right());
	cout << root->get_data() << " ";
}

int tree::find_size() {
	return _find_size(root);
}

int tree::_find_size(tree_node* root) {
	if (root == NULL) {
		return 0;
	}
	else {
		return 1 + _find_size(root->get_left()) + _find_size(root->get_right());
	}
}

int tree::are_identical(tree t) {
	return _are_identical(this->root, t.root);
}

int tree::_are_identical(tree_node* tn1, tree_node* tn2) {
	if (tn1 == NULL && tn2 == NULL) {
		return 1;
	}
	else if ((tn1 == NULL && tn2 != NULL) || (tn1 != NULL && tn2 == NULL) || (tn1->get_data() != tn2->get_data())) {
		return 0;
	}
	else {
		return _are_identical(tn1->get_left(), tn2->get_left()) && _are_identical(tn1->get_right(), tn2->get_right());
	}
}

int tree::find_height() {
	return _find_height(root);
}

int tree::_find_height(tree_node* root) {
	if (root == NULL) {
		return 0;
	}
	else {
		return 1 + max(_find_height(root->get_left()), _find_height(root->get_right()));
	}
}

void tree::delete_tree() {
	_delete_tree(&root);
	size = 0;
}

void tree::_delete_tree(tree_node** root) {
	if (*root == NULL) {
		return;
	}
	else {
		if ((*root)->get_left() != NULL) {
			_delete_tree((*root)->get_left_ref());
		}
		if ((*root)->get_right() != NULL) {
			_delete_tree((*root)->get_right_ref());
		}
		delete(*root);
		*root = NULL;
	}
}

/* alternate _delete_tree */
/*
void tree::_delete_tree(tree_node ** root) {
if(*root==NULL) {
return;
} else {
if((*root)->get_left()!=NULL) {
tree_node * left_ref=(*root)->get_left();
_delete_tree(&left_ref);
}
if((*root)->get_right()!=NULL) {
tree_node * right_ref=(*root)->get_right();
_delete_tree(&right_ref);
}
delete(*root);
*root=NULL;
}
}
*/

void tree::mirror() {
	_mirror(root);
}

void tree::_mirror(tree_node* root) {
	if (root == NULL) {
		return;
	}

	tree_node* temp = root->get_left();
	root->set_left(root->get_right());
	root->set_right(temp);
	_mirror(root->get_left());
	_mirror(root->get_right());
}

void tree::print_paths() {
	int max_path_length = find_height();
	int* path_nodes = (int*)calloc(sizeof(int), max_path_length);
	_print_paths(root, path_nodes, 0);
}

void tree::_print_paths(tree_node* root, int* path_nodes, int next_vacant_position) {
	if (root == NULL) {
		return;
	}
	else if (root->get_left() == NULL && root->get_right() == NULL) {
		*(path_nodes + next_vacant_position) = root->get_data();
		_print_array(path_nodes, next_vacant_position);
	}
	else {
		*(path_nodes + next_vacant_position) = root->get_data();
		_print_paths(root->get_left(), path_nodes, next_vacant_position + 1);
		_print_paths(root->get_right(), path_nodes, next_vacant_position + 1);
	}
}

void tree::_print_array(int* array, int len) {
	int i;
	for (i = 0; i <= len; i++) {
		cout << *(array + i) << " ";
	}
	cout << endl;
}

tree_node* tree::find_node(int value) {
	return _find_node(root, value);
}

tree_node* tree::_find_node(tree_node* root, int value) {
	if (root == NULL || root->get_data() == value) {
		return root;
	}
	else if (value <= root->get_data()) {
		return _find_node(root->get_left(), value);
	}
	else {
		return _find_node(root->get_right(), value);
	}
}

tree_node* tree::lowest_common_ancestor(int a, int b) {
	return _lowest_common_ancestor(NULL, root, a, b);
}

tree_node* tree::_lowest_common_ancestor(tree_node* parent, tree_node* root, int a, int b) {
	if (root == NULL) {
		return root;
	}
	else if ((root->get_data() == a && (root->get_left()->get_data() == b || root->get_right()->get_data() == b))
		|| (root->get_data() == b && (root->get_left()->get_data() == a || root->get_right()->get_data() == a))) {
		return parent;
	}
	else if ((_find_node(root->get_left(), a) != NULL && _find_node(root->get_right(), b) != NULL)
		|| (_find_node(root->get_left(), b) != NULL && _find_node(root->get_right(), a) != NULL)) {
		return root;
	}
	else if (_find_node(root->get_left(), a) != NULL && _find_node(root->get_left(), b) != NULL) {
		return _lowest_common_ancestor(root, root->get_left(), a, b);
	}
	else if (_find_node(root->get_right(), a) != NULL && _find_node(root->get_right(), b) != NULL) {
		return _lowest_common_ancestor(root, root->get_right(), a, b);
	}
	else {
		return NULL;
	}
}

tree_node* tree::min_node() {
	return _min_node(root);
}

tree_node* tree::_min_node(tree_node* root) {
	if (root == NULL || root->get_left() == NULL) {
		return root;
	}
	else {
		return _min_node(root->get_left());
	}
}

int tree::count_leaf_nodes() {
	return _count_leaf_nodes(root);
}

int tree::_count_leaf_nodes(tree_node* root) {
	if (root == NULL) {
		return 0;
	}
	else if (root->get_left() == NULL && root->get_right() == NULL) {
		return 1;
	}
	else {
		return _count_leaf_nodes(root->get_left()) + _count_leaf_nodes(root->get_right());
	}
}


int tree::is_bst() {
	return _is_bst(root);
}

int tree::_is_bst(tree_node* root) {
	static tree_node* previous = NULL;
	if (root == NULL) {
		return 1;
	}
	else {
		if (!_is_bst(root->get_left())) {
			return 0;
		}
		if (previous != NULL && (previous->get_data())>(root->get_data())) {
			return 0;
		}
		previous = root;
		if (!_is_bst(root->get_right())) {
			return 0;
		}
	}
}

int tree::children_sum() {
	return _children_sum(root);
}

int tree::_children_sum(tree_node* root) {
	if (root == NULL) {
		return 1;
	}
	if (root->get_left() == NULL && root->get_right() == NULL) {
		return 1;
	}
	else if (_children_sum(root->get_left()) && _children_sum(root->get_right())) {
		int left_data;
		int right_data;
		if (root->get_left() != NULL) {
			left_data = root->get_left()->get_data();
		}
		else {
			left_data = 0;
		}
		if (root->get_right() != NULL) {
			right_data = root->get_right()->get_data();
		}
		else {
			right_data = 0;
		}

		if (left_data + right_data == root->get_data()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	else {
		return 0;
	}
}

void tree::ensure_children_sum() {
	_ensure_children_sum(root);
}

void tree::_ensure_children_sum(tree_node* root) {
	if (root == NULL || (root->get_left() == NULL && root->get_right() == NULL)) {
		return;
	}
	else {
		_ensure_children_sum(root->get_left());
		_ensure_children_sum(root->get_right());
		int left_data;
		int right_data;
		if (root->get_left() != NULL) {
			left_data = root->get_left()->get_data();
		}
		else {
			left_data = 0;
		}
		if (root->get_right() != NULL) {
			right_data = root->get_right()->get_data();
		}
		else {
			right_data = 0;
		}
		root->set_data(left_data + right_data);
	}
}

int tree::diameter() {
	return _diameter(root);
}

int tree::_diameter(tree_node* root) {
	if (root == NULL) {
		return 0;
	}
	else {
		return max(_find_height(root->get_left()) + _find_height(root->get_right()) + 1, max(_diameter(root->get_left()), _diameter(root->get_left())));
	}
}

int tree::is_height_balanced() {
	return _is_height_balanced(root);
}

int tree::_is_height_balanced(tree_node* root) {
	if (root == NULL) {
		return 1;
	}
	else {
		int left_height = _find_height(root->get_left());
		int right_height = _find_height(root->get_right());
		if (abs(left_height - right_height) <= 1 && _is_height_balanced(root->get_left()) && _is_height_balanced(root->get_left())) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

int tree::leaf_path_sum(int sum) {
	return _leaf_path_sum(root, sum);
}

int tree::_leaf_path_sum(tree_node* root, int sum) {
	if (root == NULL) {
		return 0;
	}
	else if (root->get_data() == sum && root->get_left() == NULL && root->get_right() == NULL) {
		return 1;
	}
	else {
		return _leaf_path_sum(root->get_left(), sum - root->get_data()) || _leaf_path_sum(root->get_right(), sum - root->get_data());
	}
}

void tree::double_tree() {
	_double_tree(root);
}

void tree::_double_tree(tree_node* root) {
	if (root == NULL) {
		return;
	}
	else {
		tree_node* new_node = new tree_node;
		new_node->set_data(root->get_data());
		tree_node * root_left = root->get_left();
		root->set_left(new_node);
		new_node->set_left(root_left);
		_double_tree(root_left);
		_double_tree(root->get_right());
	}
}

int tree::width() {
	int height = find_height();
	return _width(root, height, 0, 1);
}

int tree::_width(tree_node* root, int height, int level, int initialize_width_array) {
	static int width[] = { 0 };
	if (initialize_width_array == 1) {
		int i;
		for (i = 0; i<height; i++) {
			width[i] = 0;
		}
	}
	if (root == NULL) {
		width[level] = width[level] + 0;
	}
	else {
		width[level] = width[level] + 1;
		_width(root->get_left(), height, level + 1, 0);
		_width(root->get_right(), height, level + 1, 0);
	}
	return _maximum(width, height);
}

int tree::_maximum(int array[], int len) {
	int i;
	int max = array[0];
	for (i = 1; i<len; i++) {
		if (array[i]>max) {
			max = array[i];
		}
	}
	return max;
}

void tree::print_k_distance_nodes(int k) {
	_print_k_distance_nodes(root, k, 0);
	cout << endl;
}

void tree::_print_k_distance_nodes(tree_node* root, int k, int distance) {
	if (root == NULL) {
		return;
	}
	else if (distance == k) {
		cout << root->get_data() << " ";
	}
	else {
		_print_k_distance_nodes(root->get_left(), k, distance + 1);
		_print_k_distance_nodes(root->get_right(), k, distance + 1);
	}
}

tree_node* tree::kth_smallest_element(int k) {
	return _kth_smallest_element(root, k);
}

tree_node* tree::_kth_smallest_element(tree_node* root, int k) {
	if (root == NULL) {
		return root;
	}
	else {
		int left_size = _find_size(root->get_left());
		if (left_size == k - 1) {
			return root;
		}
		else if (left_size >= k) {
			return _kth_smallest_element(root->get_left(), k);
		}
		else {
			return _kth_smallest_element(root->get_right(), k - left_size - 1);
		}
	}
}

int main() {
	tree t1;

	t1.recursive_insert(20);
	t1.recursive_insert(10);
	t1.insert(30);
	t1.insert(8);
	t1.recursive_insert(12);
	t1.recursive_insert(28);
	t1.recursive_insert(32);
	t1.recursive_insert(6);
	t1.recursive_insert(9);
	t1.recursive_insert(50);
	t1.insert(14);
	t1.insert(26);

	t1.print_inorder();

	tree_node* kth_smallest_node;

	kth_smallest_node = t1.kth_smallest_element(1);
	if (kth_smallest_node != NULL) {
		cout << "1st smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(2);
	if (kth_smallest_node != NULL) {
		cout << "2nd smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(3);
	if (kth_smallest_node != NULL) {
		cout << "3rd smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(4);
	if (kth_smallest_node != NULL) {
		cout << "4th smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(5);
	if (kth_smallest_node != NULL) {
		cout << "5th smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(6);
	if (kth_smallest_node != NULL) {
		cout << "6th smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(7);
	if (kth_smallest_node != NULL) {
		cout << "7th smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(8);
	if (kth_smallest_node != NULL) {
		cout << "8th smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(9);
	if (kth_smallest_node != NULL) {
		cout << "9th smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(10);
	if (kth_smallest_node != NULL) {
		cout << "10th smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(11);
	if (kth_smallest_node != NULL) {
		cout << "11th smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(12);
	if (kth_smallest_node != NULL) {
		cout << "12th smallest node " << kth_smallest_node->get_data() << endl;
	}
	kth_smallest_node = t1.kth_smallest_element(13);
	if (kth_smallest_node != NULL) {
		cout << "13th smallest node " << kth_smallest_node->get_data() << endl;
	}

	return 0;
}
//#include <iostream>
//#include <stdlib.h>
//using namespace std;
//
//class tree_node {
//private:
//	int data;
//	tree_node * left;
//	tree_node * right;
//public:
//	tree_node() {
//		left = NULL;
//		right = NULL;
//	}
//	void set_data(int data) {
//		this->data = data;
//	}
//	int get_data() {
//		return this->data;
//	}
//	void set_left(tree_node * left) {
//		this->left = left;
//	}
//	tree_node * get_left() {
//		return this->left;
//	}
//	void set_right(tree_node * right) {
//		this->right = right;
//	}
//	tree_node * get_right() {
//		return this->right;
//	}
//	tree_node ** get_left_ref() {
//		return &(this->left);
//	}
//	tree_node ** get_right_ref() {
//		return &(this->right);
//	}
//};
//
//class tree {
//private:
//	tree_node * root;
//	int size;
//	void _recursive_insert(tree_node ** root_ref, int value);
//	void _print_preorder(tree_node * root);
//	void _print_inorder(tree_node * root);
//	void _print_postorder(tree_node * root);
//	int _find_size(tree_node * root);
//	int _are_identical(tree_node * tn1, tree_node * tn2);
//	int _find_height(tree_node * root);
//	void _delete_tree(tree_node ** root);
//	void _mirror(tree_node * root);
//	void _print_paths(tree_node * root, int * path_nodes, int next_vacant_position);
//	void _print_array(int * array, int len);
//	tree_node * _lowest_common_ancestor(tree_node * parent, tree_node * root, int a, int b);
//	tree_node * _find_node(tree_node * root, int value);
//	tree_node * _min_node(tree_node * root);
//	void _print_level_order(tree_node * root);
//	int _count_leaf_nodes(tree_node * root);
//	int _is_bst(tree_node * root);
//	int _children_sum(tree_node * root);
//	void _ensure_children_sum(tree_node * root);
//	int _diameter(tree_node * root);
//	int _is_height_balanced(tree_node * root);
//	int _leaf_path_sum(tree_node * root, int num);
//	void _double_tree(tree_node * root);
//	int _width(tree_node * root, int height, int level, int initialize_width_array);
//	int _maximum(int array[], int len);
//	void _print_k_distance_nodes(tree_node * root, int k, int distance);
//	tree_node * _kth_smallest_element(tree_node * root, int k);
//public:
//	tree() {
//		root = NULL;
//		size = 0;
//	}
//	void insert(int value);
//	void recursive_insert(int value);
//	void print_preorder();
//	void print_inorder();
//	void print_postorder();
//	int find_size();
//	int get_size() {
//		return this->size;
//	}
//	int are_identical(tree t);
//	int find_height();
//	void delete_tree();
//	void mirror();
//	void print_paths();
//	tree_node * lowest_common_ancestor(int a, int b);
//	tree_node * find_node(int value);
//	tree_node * min_node();
//	void print_level_order();
//	int count_leaf_nodes();
//	int is_bst();
//	int children_sum();
//	void ensure_children_sum();
//	int diameter();
//	int is_height_balanced();
//	int leaf_path_sum(int num);
//	void double_tree();
//	int width();
//	void print_k_distance_nodes(int k);
//	tree_node * kth_smallest_element(int k);
//};
//
//void tree::insert(int value) {
//	if (root == NULL) {
//		root = new tree_node;
//		root->set_data(value);
//	}
//	else {
//		tree_node * parent = NULL;
//		tree_node * current = root;
//		tree_node * new_node = new tree_node;
//		new_node->set_data(value);
//		while (current != NULL) {
//			if (value <= current->get_data()) {
//				parent = current;
//				current = current->get_left();
//			}
//			else {
//				parent = current;
//				current = current->get_right();
//			}
//		}
//		if (value <= parent->get_data() && parent->get_left() == NULL) {
//			parent->set_left(new_node);
//		}
//		else if (value>parent->get_data() && parent->get_right() == NULL) {
//			parent->set_right(new_node);
//		}
//	}
//	size++;
//}
//
//void tree::recursive_insert(int value) {
//	_recursive_insert(&root, value);
//	size++;
//}
//
//void tree::_recursive_insert(tree_node ** root_ref, int value) {
//	if (*root_ref == NULL) {
//		tree_node * new_node = new tree_node;
//		new_node->set_data(value);
//		*root_ref = new_node;
//	}
//	else {
//		if (value <= (*root_ref)->get_data()) {
//			_recursive_insert((*root_ref)->get_left_ref(), value);
//		}
//		else {
//			_recursive_insert((*root_ref)->get_right_ref(), value);
//		}
//	}
//}
//
//void tree::print_preorder() {
//	if (root == NULL) {
//		return;
//	}
//	_print_preorder(root);
//	cout << endl;
//}
//
//void tree::_print_preorder(tree_node * root) {
//	if (root == NULL) {
//		return;
//	}
//	cout << root->get_data() << " ";
//	if (root->get_left() != NULL)
//		_print_preorder(root->get_left());
//	if (root->get_right() != NULL)
//		_print_preorder(root->get_right());
//}
//
//void tree::print_inorder() {
//	if (root == NULL) {
//		return;
//	}
//	_print_inorder(root);
//	cout << endl;
//}
//
//void tree::_print_inorder(tree_node * root) {
//	if (root == NULL) {
//		return;
//	}
//	if (root->get_left() != NULL)
//		_print_inorder(root->get_left());
//	cout << root->get_data() << " ";
//	if (root->get_right() != NULL)
//		_print_inorder(root->get_right());
//}
//
//void tree::print_postorder() {
//	if (root == NULL) {
//		return;
//	}
//	_print_postorder(root);
//	cout << endl;
//}
//
//void tree::_print_postorder(tree_node * root) {
//	if (root == NULL) {
//		return;
//	}
//	if (root->get_left() != NULL)
//		_print_postorder(root->get_left());
//	if (root->get_right() != NULL)
//		_print_postorder(root->get_right());
//	cout << root->get_data() << " ";
//}
//
//int tree::find_size() {
//	return _find_size(root);
//}
//
//int tree::_find_size(tree_node * root) {
//	if (root == NULL) {
//		return 0;
//	}
//	else {
//		return 1 + _find_size(root->get_left()) + _find_size(root->get_right());
//	}
//}
//
//int tree::are_identical(tree t) {
//	return _are_identical(this->root, t.root);
//}
//
//int tree::_are_identical(tree_node * tn1, tree_node * tn2) {
//	if (tn1 == NULL && tn2 == NULL) {
//		return 1;
//	}
//	else if ((tn1 == NULL && tn2 != NULL) || (tn1 != NULL && tn2 == NULL) || (tn1->get_data() != tn2->get_data())) {
//		return 0;
//	}
//	else {
//		return _are_identical(tn1->get_left(), tn2->get_left()) && _are_identical(tn1->get_right(), tn2->get_right());
//	}
//}
//
//int tree::find_height() {
//	return _find_height(root);
//}
//
//int tree::_find_height(tree_node * root) {
//	if (root == NULL) {
//		return 0;
//	}
//	else {
//		return 1 + max(_find_height(root->get_left()), _find_height(root->get_right()));
//	}
//}
//
//void tree::delete_tree() {
//	_delete_tree(&root);
//	size = 0;
//}
//
//void tree::_delete_tree(tree_node ** root) {
//	if (*root == NULL) {
//		return;
//	}
//	else {
//		if ((*root)->get_left() != NULL) {
//			_delete_tree((*root)->get_left_ref());
//		}
//		if ((*root)->get_right() != NULL) {
//			_delete_tree((*root)->get_right_ref());
//		}
//		delete(*root);
//		*root = NULL;
//	}
//}
//
///* alternate _delete_tree */
///*
//void tree::_delete_tree(tree_node ** root) {
//if(*root==NULL) {
//return;
//} else {
//if((*root)->get_left()!=NULL) {
//tree_node * left_ref=(*root)->get_left();
//_delete_tree(&left_ref);
//}
//if((*root)->get_right()!=NULL) {
//tree_node * right_ref=(*root)->get_right();
//_delete_tree(&right_ref);
//}
//delete(*root);
//*root=NULL;
//}
//}
//*/
//
//void tree::mirror() {
//	_mirror(root);
//}
//
//void tree::_mirror(tree_node * root) {
//	if (root == NULL) {
//		return;
//	}
//
//	tree_node * temp = root->get_left();
//	root->set_left(root->get_right());
//	root->set_right(temp);
//	_mirror(root->get_left());
//	_mirror(root->get_right());
//}
//
//void tree::print_paths() {
//	int max_path_length = find_height();
//	int * path_nodes = (int *)calloc(sizeof(int), max_path_length);
//	_print_paths(root, path_nodes, 0);
//}
//
//void tree::_print_paths(tree_node * root, int * path_nodes, int next_vacant_position) {
//	if (root == NULL) {
//		return;
//	}
//	else if (root->get_left() == NULL && root->get_right() == NULL) {
//		*(path_nodes + next_vacant_position) = root->get_data();
//		_print_array(path_nodes, next_vacant_position);
//	}
//	else {
//		*(path_nodes + next_vacant_position) = root->get_data();
//		_print_paths(root->get_left(), path_nodes, next_vacant_position + 1);
//		_print_paths(root->get_right(), path_nodes, next_vacant_position + 1);
//	}
//}
//
//void tree::_print_array(int * array, int len) {
//	int i;
//	for (i = 0; i <= len; i++) {
//		cout << *(array + i) << " ";
//	}
//	cout << endl;
//}
//
//tree_node * tree::find_node(int value) {
//	return _find_node(root, value);
//}
//
//tree_node * tree::_find_node(tree_node * root, int value) {
//	if (root == NULL || root->get_data() == value) {
//		return root;
//	}
//	else if (value <= root->get_data()) {
//		return _find_node(root->get_left(), value);
//	}
//	else {
//		return _find_node(root->get_right(), value);
//	}
//}
//
//tree_node * tree::lowest_common_ancestor(int a, int b) {
//	return _lowest_common_ancestor(NULL, root, a, b);
//}
//
//tree_node * tree::_lowest_common_ancestor(tree_node * parent, tree_node * root, int a, int b) {
//	if (root == NULL) {
//		return root;
//	}
//	else if ((root->get_data() == a && (root->get_left()->get_data() == b || root->get_right()->get_data() == b))
//		|| (root->get_data() == b && (root->get_left()->get_data() == a || root->get_right()->get_data() == a))) {
//		return parent;
//	}
//	else if ((_find_node(root->get_left(), a) != NULL && _find_node(root->get_right(), b) != NULL)
//		|| (_find_node(root->get_left(), b) != NULL && _find_node(root->get_right(), a) != NULL)) {
//		return root;
//	}
//	else if (_find_node(root->get_left(), a) != NULL && _find_node(root->get_left(), b) != NULL) {
//		return _lowest_common_ancestor(root, root->get_left(), a, b);
//	}
//	else if (_find_node(root->get_right(), a) != NULL && _find_node(root->get_right(), b) != NULL) {
//		return _lowest_common_ancestor(root, root->get_right(), a, b);
//	}
//	else {
//		return NULL;
//	}
//}
//
//tree_node * tree::min_node() {
//	return _min_node(root);
//}
//
//tree_node * tree::_min_node(tree_node * root) {
//	if (root == NULL || root->get_left() == NULL) {
//		return root;
//	}
//	else {
//		return _min_node(root->get_left());
//	}
//}
//
//int tree::count_leaf_nodes() {
//	return _count_leaf_nodes(root);
//}
//
//int tree::_count_leaf_nodes(tree_node * root) {
//	if (root == NULL) {
//		return 0;
//	}
//	else if (root->get_left() == NULL && root->get_right() == NULL) {
//		return 1;
//	}
//	else {
//		return _count_leaf_nodes(root->get_left()) + _count_leaf_nodes(root->get_right());
//	}
//}
//
//
//int tree::is_bst() {
//	return _is_bst(root);
//}
//
//int tree::_is_bst(tree_node * root) {
//	static tree_node * previous = NULL;
//	if (root == NULL) {
//		return 1;
//	}
//	else {
//		if (!_is_bst(root->get_left())) {
//			return 0;
//		}
//		if (previous != NULL && (previous->get_data())>(root->get_data())) {
//			return 0;
//		}
//		previous = root;
//		if (!_is_bst(root->get_right())) {
//			return 0;
//		}
//	}
//}
//
//int tree::children_sum() {
//	return _children_sum(root);
//}
//
//int tree::_children_sum(tree_node * root) {
//	if (root == NULL) {
//		return 1;
//	}
//	if (root->get_left() == NULL && root->get_right() == NULL) {
//		return 1;
//	}
//	else if (_children_sum(root->get_left()) && _children_sum(root->get_right())) {
//		int left_data;
//		int right_data;
//		if (root->get_left() != NULL) {
//			left_data = root->get_left()->get_data();
//		}
//		else {
//			left_data = 0;
//		}
//		if (root->get_right() != NULL) {
//			right_data = root->get_right()->get_data();
//		}
//		else {
//			right_data = 0;
//		}
//
//		if (left_data + right_data == root->get_data()) {
//			return 1;
//		}
//		else {
//			return 0;
//		}
//	}
//	else {
//		return 0;
//	}
//}
//
//void tree::ensure_children_sum() {
//	_ensure_children_sum(root);
//}
//
//void tree::_ensure_children_sum(tree_node * root) {
//	if (root == NULL || (root->get_left() == NULL && root->get_right() == NULL)) {
//		return;
//	}
//	else {
//		_ensure_children_sum(root->get_left());
//		_ensure_children_sum(root->get_right());
//		int left_data;
//		int right_data;
//		if (root->get_left() != NULL) {
//			left_data = root->get_left()->get_data();
//		}
//		else {
//			left_data = 0;
//		}
//		if (root->get_right() != NULL) {
//			right_data = root->get_right()->get_data();
//		}
//		else {
//			right_data = 0;
//		}
//		root->set_data(left_data + right_data);
//	}
//}
//
//int tree::diameter() {
//	return _diameter(root);
//}
//
//int tree::_diameter(tree_node * root) {
//	if (root == NULL) {
//		return 0;
//	}
//	else {
//		return max(_find_height(root->get_left()) + _find_height(root->get_right()) + 1, max(_diameter(root->get_left()), _diameter(root->get_left())));
//	}
//}
//
//int tree::is_height_balanced() {
//	return _is_height_balanced(root);
//}
//
//int tree::_is_height_balanced(tree_node * root) {
//	if (root == NULL) {
//		return 1;
//	}
//	else {
//		int left_height = _find_height(root->get_left());
//		int right_height = _find_height(root->get_right());
//		if (abs(left_height - right_height) <= 1 && _is_height_balanced(root->get_left()) && _is_height_balanced(root->get_left())) {
//			return 1;
//		}
//		else {
//			return 0;
//		}
//	}
//}
//
//int tree::leaf_path_sum(int sum) {
//	return _leaf_path_sum(root, sum);
//}
//
//int tree::_leaf_path_sum(tree_node * root, int sum) {
//	if (root == NULL) {
//		return 0;
//	}
//	else if (root->get_data() == sum && root->get_left() == NULL && root->get_right() == NULL) {
//		return 1;
//	}
//	else {
//		return _leaf_path_sum(root->get_left(), sum - root->get_data()) || _leaf_path_sum(root->get_right(), sum - root->get_data());
//	}
//}
//
//void tree::double_tree() {
//	_double_tree(root);
//}
//
//void tree::_double_tree(tree_node * root) {
//	if (root == NULL) {
//		return;
//	}
//	else {
//		tree_node * new_node = new tree_node;
//		new_node->set_data(root->get_data());
//		tree_node * root_left = root->get_left();
//		root->set_left(new_node);
//		new_node->set_left(root_left);
//		_double_tree(root_left);
//		_double_tree(root->get_right());
//	}
//}
//
//int tree::width() {
//	int height = find_height();
//	return _width(root, height, 0, 1);
//}
//
//int tree::_width(tree_node * root, int height, int level, int initialize_width_array) {
//	static int width[] = { 0 };
//	if (initialize_width_array == 1) {
//		int i;
//		for (i = 0; i<height; i++) {
//			width[i] = 0;
//		}
//	}
//	if (root == NULL) {
//		width[level] = width[level] + 0;
//	}
//	else {
//		width[level] = width[level] + 1;
//		_width(root->get_left(), height, level + 1, 0);
//		_width(root->get_right(), height, level + 1, 0);
//	}
//	return _maximum(width, height);
//}
//
//int tree::_maximum(int array[], int len) {
//	int i;
//	int max = array[0];
//	for (i = 1; i<len; i++) {
//		if (array[i]>max) {
//			max = array[i];
//		}
//	}
//	return max;
//}
//
//void tree::print_k_distance_nodes(int k) {
//	_print_k_distance_nodes(root, k, 0);
//	cout << endl;
//}
//
//void tree::_print_k_distance_nodes(tree_node * root, int k, int distance) {
//	if (root == NULL) {
//		return;
//	}
//	else if (distance == k) {
//		cout << root->get_data() << " ";
//	}
//	else {
//		_print_k_distance_nodes(root->get_left(), k, distance + 1);
//		_print_k_distance_nodes(root->get_right(), k, distance + 1);
//	}
//}
//
//tree_node * tree::kth_smallest_element(int k) {
//	return _kth_smallest_element(root, k);
//}
//
//tree_node * tree::_kth_smallest_element(tree_node * root, int k) {
//	if (root == NULL) {
//		return root;
//	}
//	else {
//		int left_size = _find_size(root->get_left());
//		if (left_size == k - 1) {
//			return root;
//		}
//		else if (left_size >= k) {
//			return _kth_smallest_element(root->get_left(), k);
//		}
//		else {
//			return _kth_smallest_element(root->get_right(), k - left_size - 1);
//		}
//	}
//}
//
//int main() {
//	tree t1;
//
//	t1.recursive_insert(20);
//	t1.recursive_insert(10);
//	t1.insert(30);
//	t1.insert(8);
//	t1.recursive_insert(12);
//	t1.recursive_insert(28);
//	t1.recursive_insert(32);
//	t1.recursive_insert(6);
//	t1.recursive_insert(9);
//	t1.recursive_insert(50);
//	t1.insert(14);
//	t1.insert(26);
//
//	t1.print_inorder();
//
//	tree_node * kth_smallest_node;
//
//	kth_smallest_node = t1.kth_smallest_element(1);
//	if (kth_smallest_node != NULL) {
//		cout << "1st smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(2);
//	if (kth_smallest_node != NULL) {
//		cout << "2nd smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(3);
//	if (kth_smallest_node != NULL) {
//		cout << "3rd smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(4);
//	if (kth_smallest_node != NULL) {
//		cout << "4th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(5);
//	if (kth_smallest_node != NULL) {
//		cout << "5th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(6);
//	if (kth_smallest_node != NULL) {
//		cout << "6th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(7);
//	if (kth_smallest_node != NULL) {
//		cout << "7th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(8);
//	if (kth_smallest_node != NULL) {
//		cout << "8th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(9);
//	if (kth_smallest_node != NULL) {
//		cout << "9th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(10);
//	if (kth_smallest_node != NULL) {
//		cout << "10th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(11);
//	if (kth_smallest_node != NULL) {
//		cout << "11th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(12);
//	if (kth_smallest_node != NULL) {
//		cout << "12th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//	kth_smallest_node = t1.kth_smallest_element(13);
//	if (kth_smallest_node != NULL) {
//		cout << "13th smallest node " << kth_smallest_node->get_data() << endl;
//	}
//
//	return 0;
//}
