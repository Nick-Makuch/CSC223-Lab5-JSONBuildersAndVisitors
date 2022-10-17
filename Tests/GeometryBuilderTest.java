import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import input.builder.GeometryBuilder;
import input.components.FigureNode;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;



class GeometryBuilderTest {

	GeometryBuilder _gb = new GeometryBuilder();
	PointNode _testNode1 = new PointNode("Node1", 1 ,1);
	PointNode _testNode2 = new PointNode("Node2" ,2 ,2);
	PointNode _testNode3 = new PointNode("Node3" ,3 ,3);
	PointNode _testNode4 = new PointNode("Node4" ,4 ,4);
	SegmentNode _testSegment1 = new SegmentNode(_testNode1 , _testNode2);
	String _description = "description";



	@Test
	void testBuildFigureNode() {

		//create a segment database
		SegmentNodeDatabase segmentDatabase = _gb.buildSegmentNodeDatabase();
		_gb.addSegmentToDatabase(segmentDatabase, _testNode2, _testNode1);

		//create a point database
		List<PointNode> points = new ArrayList<PointNode>();
		points.add(_testNode1);
		points.add(_testNode2);
		PointNodeDatabase pointNodes = _gb.buildPointDatabaseNode(points);

		FigureNode figureNode = _gb.buildFigureNode(_description,pointNodes , segmentDatabase);

		//check that the descruptiuon matches
		assertEquals(_description , figureNode.getDescription());

		assertEquals(pointNodes , figureNode.getPointsDatabase());


	}



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

		//check that node 1 string method works
		assertEquals( "(Node1)(1.0, 1.0)", segment.getPoint1().toString());

		//check that node 2 string method works
		assertEquals( "(Node2)(2.0, 2.0)", segment.getPoint2().toString());

		//do the same thing with different values
		segment = _gb.buildSegmentNode(_testNode2 , _testNode3);

		//test that there are is nothing in the database
		assertTrue(segment.getPoint1().equals(_testNode2));

		//test for the second points
		assertTrue(segment.getPoint2().equals(_testNode3));

		//check that node 1 string method works
		assertEquals( "(Node2)(2.0, 2.0)", segment.getPoint1().toString());

		//check that node 2 string method works
		assertEquals( "(Node3)(3.0, 3.0)", segment.getPoint2().toString());


	}



	@Test
	void testBuildPointNodeDatabase() {

		//create a list of points to add to the test database
		List<PointNode> points = new ArrayList<PointNode>();
		points.add(_testNode1);
		points.add(_testNode2);

		//create the database
		PointNodeDatabase pointNodes = _gb.buildPointDatabaseNode(points);

		//ensure there is no node in it
		assertTrue(pointNodes.contains(_testNode1));

		//assure the size is 0
		assertEquals(2 ,pointNodes.getSize());

		//ensure the the point exists in the database
		assertTrue(pointNodes.contains(1, 1));

		points.add(_testNode3);
		points.add(_testNode4);

		//add elements to the database
		pointNodes = _gb.buildPointDatabaseNode(points);

		//assure the size is 0
		assertTrue(pointNodes.contains(4, 4));

		//assure the size is 0
		assertEquals(4 ,pointNodes.getSize());


		assertTrue(pointNodes.contains(_testNode4));

	}



	@Test
	void testBuildPointNode() {
		PointNode point1 = _gb.buildPointNode(_description, 1, 1);

		//ensure the x and y values are correct
		assertEquals(1 ,point1.getX());
		assertEquals(1 ,point1.getY());


		//check the name of the node
		assertEquals(_description , point1.getName());


		//check the name of the node
		assertEquals(true , point1.equals(point1));


		//do the same for point 2
		PointNode point2 = _gb.buildPointNode(_description, 2, 2);

		//ensure the x and y values are correct
		assertEquals(2 ,point2.getX());
		assertEquals(2 ,point2.getY());

		//check the name of the node
		assertEquals(_description , point2.getName());


		//check the name of the node
		assertEquals(true , point2.equals(point2));
		
		//check the name of the node
		assertFalse( point2.equals(point1));

	}




}
