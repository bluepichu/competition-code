// Copyright (c) 2014 Matthew Savage
// Written by Matthew Savage as a part of the competition-code repository (github.com/BluePichu/competition-code)
// This code may be used or modified but the header and copyright must remain.

// ---------------------------------------------------------------------------

// A disjoint-set structure implementation

// ---------------------------------------------------------------------------

// The purpose of a disjoint-set structure is to allow for two basic operations - the merging of two sets and querying to
//   see if two items are in the same set.  The structure is set up like a tree, where the root of each tree acts as a
//   set representative.  Two items are thererfore in the same set if and only if their representative is the same.
// This implementation includes some optomization to reduce the functions' run times from O(log n) to O(a(n)).

// REQUIRES:
//   java.util.HashMap

public class DisjointSet{
	private HashMap<Integer, DJSNode> map;
	
	// ---------------------------------------------------------------------------
	
	// CONSTRUCTOR
	
	// Complexity: O(n)
	//   n is the length of values
	
	// Arguments:
	//   int n     - the number of sets to initialize
	public DisjointSet(){
		this(0);
	}
	
	public DisjointSet(int n){
		map = new HashMap<Integer, DJSNode>();
		for(int i = 1; i <= n; i++){
			map.put(i, new DJSNode());
		}
	}
	
	// ---------------------------------------------------------------------------
	
	// ADDSET
	
	// Complexity: O(1)
	
	// Arguments:
	//   int x     - the the item key for the new set (NOTE: if the set already exists, this will do nothing)
	public void addSet(int x){
		if(!map.keySet().contains(x)){
			map.put(x, new DJSNode());
		}
	}
	
	// ---------------------------------------------------------------------------
	
	// UNION
	
	// Complexity: O(a(n)) (ammortized)
	//   n is the total number of items
	//   a is the inverse Ackermann function (essentially a constant)
	
	// Arguments:
	//   int x     - the first item whose set must be unioned
	//   int y     - the second item whose set must be unioned
	public void union(int x, int y){
		DJSNode xRoot = find(map.get(x));
		DJSNode yRoot = find(map.get(y));
		
		if(xRoot == yRoot){
			return;
		}
		
		if(xRoot.rank < yRoot.rank){
			xRoot.parent = yRoot;
		} else if(xRoot.rank > yRoot.rank){
			yRoot.parent = xRoot;
		} else {
			yRoot.parent = xRoot;
			xRoot.rank++;
		}
	}
	
	// ---------------------------------------------------------------------------
	
	// FIND
	
	// Complexity: O(a(n)) (ammortized)
	//   n is the total number of items
	//   a is the inverse Ackermann function (essentially a constant)
	
	// Arguments:
	//   DJSNode x - the item whose parent must be found.  (Note that the item's parent
	//                 is set to the set representative if it is not already.)
	private DJSNode find(DJSNode x){
		if(x.parent != x){
			x.parent = find(x.parent);
		}
		return x.parent;
	}
	
	// ---------------------------------------------------------------------------
	
	// SAMESET
	
	// Complexity: O(a(n)) (ammortized)
	//   n is the total number of items
	//   a is the inverse Ackermann function (essentially a constant)
	
	// Arguments:
	//   int x - The first item to check
	//   int y - The second item to check
	public boolean sameSet(int x, int y){
		return find(map.get(x)) == find(map.get(y));
	}
	
	// ---------------------------------------------------------------------------
	
	private class DJSNode{
		public DJSNode parent;
		public int rank;
		
		public DJSNode(){
			parent = this;
			rank = 0;
		}
	}
}