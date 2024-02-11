// object: 		anything that you can describe.
//
//		  	 	anything that has 	attributes	(data)
//										private		
//	  	  	  	  	  	  	  	  	  	protected	owned by one used by another
//	  	  	  	  	  	  	  	  	  	public		use whenever
//
//									behavior	(function)
//
// class: 		devides the object
// instance: 	
// 
// 1. encapsulation: data hiding
// 2. enheritence
// 3. polymorphism 

#include <iostream>
#include <ctype.h>

using namespace std;


class table { 					// Fence that holds:
	private: 
		int length, width;		// This data
	public: 

	void set_data(int l, int w){
		length = l;
		width = w;
	}
	
	table(){
		cout << "Using default constructor";
		length = 0;
		width = 0;
	}
	table (int l, int w){
		length = l;
		width = w;
	}
	int get_length(){
		return(length);
	}
	int get_width(){
		return(width);
	}
	table(){
		cout << "Destructing instance of the object\n";
	}
};
	
int main() {

	table coffee(5,2);
	table dining(10,5); 
	//table conf(9,"Lamp");		//crashes cuz 'lamp' is not a good input
	
	coffee.set_data(5,3);
	dining.set_data(10,5);
	
	cout << "Coffee table length is: " << coffee.get_length() << endl;
	cout << "Coffee table width is: " << coffee.get_width();
		
	return 0;
}


