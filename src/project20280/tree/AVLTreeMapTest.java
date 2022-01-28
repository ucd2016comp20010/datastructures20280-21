package project20280.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AVLTreeMapTest {

	@Test
	void testGet() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
		assertEquals("15", map.get(15));
		assertEquals("24", map.get(24));
		assertEquals(null, map.get(-1));
	}

	@Test
	void testPut() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
		
		assertEquals("[1, 2, 4, 5, 12, 15, 21, 23, 24, 26, 33, 35]", map.keySet().toString());
	}

	@Test
	void testRemoveK() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}

		assertEquals(12, map.size());
		assertEquals("26", map.remove(26));
		assertEquals(11, map.size());
	}

	@Test
	void testFirstEntry() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
		
		assertEquals(1, map.firstEntry().getKey());
	}

	@Test
	void testLastEntry() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		//java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
		
		assertEquals(35, map.lastEntry().getKey());
	}

	@Test
	void testCeilingEntry() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		//java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
		
		assertEquals(12, map.ceilingEntry(11).getKey());
		
		assertEquals(2, map.ceilingEntry(2).getKey());
	}

	@Test
	void testFloorEntry() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		//java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
		
		assertEquals(5, map.floorEntry(11).getKey());
		assertEquals(5, map.floorEntry(5).getKey());
	}

	@Test
	void testLowerEntry() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		//java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
		
		assertEquals(23, map.lowerEntry(24).getKey());
		assertEquals(26, map.lowerEntry(31).getKey());
	}

	@Test
	void testHigherEntry() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		//java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
		
		assertEquals(12, map.higherEntry(11).getKey());
	}

	@Test
	void testEntrySet() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		//java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
		assertEquals("", map.toString());
	}

	@Test
	void testSubMap() {
		AVLTreeMap<Integer, String> map = new AVLTreeMap<>();
		//java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(Integer i : arr) {
			map.put(i, Integer.toString(i));
		}
				
		assertEquals("[12, 15, 21, 23, 24, 26, 33]", map.subMap(12, 34).toString());
	}

}
