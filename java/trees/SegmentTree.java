// Copyright (c) 2014 Matthew Savage
// Written by Matthew Savage as a part of the competition-code repository (github.com/BluePichu/competition-code)
// This code may be used or modified but the header and copyright must remain.

// ---------------------------------------------------------------------------

// Segment Tree Implementation

// ---------------------------------------------------------------------------

// An implementation of a Segment Tree
// The default behavior uses summation as the operation.  (See op() method.)

public class SegmentTree{
	private int[] data;
	private int maxDepth;
	
	// ---------------------------------------------------------------------------
	
	// CONSTRUCTOR
	
	// Complexity: O(n)
	//   n is the length of values
	
	// Arguments:
	//   int[] values - the values from which to create the segment tree
	public SegmentTree(int[] values){
		maxDepth = (int)Math.ceil(Math.log(values.length) / Math.log(2));
		data = new int[(int)Math.pow(2, maxDepth+1)];
		int offset = (int)Math.pow(2, maxDepth);
		for(int i = 0; i < values.length; i++){
			data[offset+i] = values[i];
		}
		for(int i = offset-1; i > 0; i--){
			data[i] = op(data[2*i], data[2*i+1]);
		}
	}
	
	// ---------------------------------------------------------------------------
	
	// UPDATE
	
	// Complexity: O(lg n)
	//   n is the length of the original array
	
	// Arguments:
	//   int index    - the index of the value to change
	//   int value    - the value to insert at that index
	public void update(int index, int value){
		int i = (int)Math.pow(2, maxDepth) + index;
		data[i] = value;
		update(i/2);
	}
	
	private void update(int index){
		if(index == 0){
			return;
		}
		data[index] = op(data[2*index], data[2*index+1]);
		update(index/2);
	}
	
	// ---------------------------------------------------------------------------
	
	// QUERY
	
	// Complexity: O(lg n)
	//   n is the length of the original array
	
	// Arguments:
	//   int start    - the index of the beginning of the range to sum
	//   int end      - the index of the end of the range to sum
	
	// Returns:
	//   int          - the sum of all values in the range [start, end]
	public int query(int start, int end){
		return query(start, end, 1, 0, (int)Math.pow(2, maxDepth)-1);
	}
	
	private int query(int start, int end, int index, int istart, int iend){
		if(start == istart && end == iend){
			return data[index];
		}
		int ans = 0;
		int mid = (istart + iend) / 2;
		if(start <= mid){
			ans += query(start, Math.min(end, mid), index*2, istart, mid);
		}
		if(mid < end){
			ans += query(Math.max(start, mid+1), end, index*2 + 1, mid+1, iend);
		}
		return ans;
	}
	
	// ---------------------------------------------------------------------------
	
	// The operation to perform; change this if you need an operation other than addition.
	private int op(int a, int b){
		return a + b;
	}
}