import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import input.builder.GeometryBuilder;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;

import org.junit.jupiter.api.Test;

class GeometryBuilderTest {
	
	GeometryBuilder _gb = new GeometryBuilder();
	PointNode _testNode1 = new PointNode("Node1", 1 ,1);
	PointNode _testNode2 = new PointNode("Node2" ,2 ,2);
	PointNode _testNode3 = new PointNode("Node3" ,3 ,3);
	PointNode _testNode4 = new PointNode("Node4" ,4 ,4);
	SegmentNode _testSegment1 = new SegmentNode(_testNode1 , _testNode2);
	String _description = "description";
	

	
	
	
	@Test
	void testBuildSegmentNodeDatabase() {
		
		SegmentNodeDatabase segmentDatabase = _gb.buildSegmentNodeDatabase();
		
		//test that there are is nothing in the database
		assertEquals(0 , segmentDatabase.numUndirectedEdges());
		
		//check that the database is equal to itself
		assertTrue(segmentDatabase.equals(segmentDatabase));
		
		
	}
	
	
	@Test
	void testAddToSegmentNodeDatabase() {
		
		SegmentNodeDatabase segmentDatabase = _gb.buildSegmentNodeDatabase();
		
		//test that there are is nothing in the database
		assertEquals(0 , segmentDatabase.numUndirectedEdges());
		
		//add an undirected edge using method
		_gb.addSegmentToDatabase(segmentDatabase, _testNode2, _testNode1);
		
		
		//test that there are is nothing in the database
		assertEquals(1 , segmentDatabase.numUndirectedEdges());
		
		//add an undirected edge using method
		_gb.addSegmentToDatabase(segmentDatabase, _testNode3, _testNode4);
		
		//test that there are is nothing in the database
		assertEquals(2 , segmentDatabase.numUndirectedEdges());
		
		
		
		
	}
	
	
	
	
	@Test
	void testBuildSegmentNode() {
		
		SegmentNode segment = _gb.buildSegmentNode(_testNode1 , _testNode2);
		
		//test that there are is nothing in the database
		assertTrue(segment.getPoint1().equals(_testNode1));
		
		//test for the second points
		assertTrue(segment.getPoint2().equals(_testNode2));
		
		//check that node 1 string menthod works
		assertEquals( "(Node1)(1.0, 1.0)", segment.getPoint1().toString());
		
		//check that node 2 string menthod works
		assertEquals( "(Node2)(2.0, 2.0)", segment.getPoint2().toString());
		
		
		segment = _gb.buildSegmentNode(_testNode2 , _testNode3);
		
		//test that there are is nothing in the database
		assertTrue(segment.getPoint1().equals(_testNode2));
		
		//test for the second points
		assertTrue(segment.getPoint2().equals(_testNode3));
		
		//check that node 1 string menthod works
		assertEquals( "(Node2)(2.0, 2.0)", segment.getPoint1().toString());
		
		//check that node 2 string menthod works
		assertEquals( "(Node3)(3.0, 3.0)", segment.getPoint2().toString());
		
		
	}

}
