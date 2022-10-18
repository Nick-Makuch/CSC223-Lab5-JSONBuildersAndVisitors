import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractMap;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import input.components.FigureNode;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;
import input.visitor.ToJSONvisitor;

public class ToJSONvisitorTest 
{	
	@Test
	void visitFigureNodeTest() 
	{
		PointNode _testNode1 = new PointNode("Node1", 1 ,1);
		PointNode _testNode2 = new PointNode("Node2" ,2 ,2);
		PointNode _testNode3 = new PointNode("Node3" ,3 ,3);
		PointNode _testNode4 = new PointNode("Node4" ,4 ,4);
		SegmentNode _testSegment1 = new SegmentNode(_testNode1 , _testNode2);
		String _description = "description";
		
		PointNodeDatabase _testPointNodeDatabase = new PointNodeDatabase();
		_testPointNodeDatabase.put(_testNode1);
		_testPointNodeDatabase.put(_testNode2);
		_testPointNodeDatabase.put(_testNode3);
		_testPointNodeDatabase.put(_testNode4);
			
		SegmentNodeDatabase testSegmentNodeDatabase = new SegmentNodeDatabase();
		testSegmentNodeDatabase.addUndirectedEdge(_testNode2, _testNode1);
		testSegmentNodeDatabase.addUndirectedEdge(_testNode3, _testNode2);
		testSegmentNodeDatabase.addUndirectedEdge(_testNode4, _testNode3);
		testSegmentNodeDatabase.addUndirectedEdge(_testNode4, _testNode1);
			
		FigureNode testFigureNode = new FigureNode(_description, _testPointNodeDatabase, testSegmentNodeDatabase);
		
		ToJSONvisitor testVisitor = new ToJSONvisitor();
		StringBuilder sb = new StringBuilder();
		JSONObject jsonFigureNode = (JSONObject) testVisitor.visitFigureNode(testFigureNode, 
				new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		
		System.out.println(testVisitor.toString(0, jsonFigureNode));
		assertTrue(jsonFigureNode instanceof JSONObject);
	}
	
	@Test
	void visitSegNodeDatabaseTest() 
	{
		PointNode _testNode1 = new PointNode("Node1", 1 ,1);
		PointNode _testNode2 = new PointNode("Node2" ,2 ,2);
		PointNode _testNode3 = new PointNode("Node3" ,3 ,3);
		PointNode _testNode4 = new PointNode("Node4" ,4 ,4);
			
		SegmentNodeDatabase testSegmentNodeDatabase = new SegmentNodeDatabase();
		testSegmentNodeDatabase.addUndirectedEdge(_testNode2, _testNode1);
		testSegmentNodeDatabase.addUndirectedEdge(_testNode3, _testNode2);
		testSegmentNodeDatabase.addUndirectedEdge(_testNode4, _testNode3);
		testSegmentNodeDatabase.addUndirectedEdge(_testNode4, _testNode1);
		
		ToJSONvisitor testVisitor = new ToJSONvisitor();
		JSONObject jsonSegNodeDatabase = (JSONObject) testVisitor.visitSegmentDatabaseNode(testSegmentNodeDatabase, null);
		
		//System.out.println(testVisitor.toString(0, jsonSegNodeDatabase));
		assertTrue(jsonSegNodeDatabase instanceof JSONObject);
	}
	
	@Test
	void visitPointNodeDatabaseTest() 
	{
		PointNode _testNode1 = new PointNode("Node1", 1 ,1);
		PointNode _testNode2 = new PointNode("Node2" ,2 ,2);
		PointNode _testNode3 = new PointNode("Node3" ,3 ,3);
		PointNode _testNode4 = new PointNode("Node4" ,4 ,4);
		
		PointNodeDatabase _testPointNodeDatabase = new PointNodeDatabase();
		_testPointNodeDatabase.put(_testNode1);
		_testPointNodeDatabase.put(_testNode2);
		_testPointNodeDatabase.put(_testNode3);
		_testPointNodeDatabase.put(_testNode4);
		
		ToJSONvisitor testVisitor = new ToJSONvisitor();
		JSONObject jsonPNDatabase = (JSONObject) testVisitor.visitPointNodeDatabase(_testPointNodeDatabase, null);
		
//		System.out.println(testVisitor.toString(0, jsonPNDatabase));
		assertTrue(jsonPNDatabase instanceof JSONObject);
	}
	
	@Test
	void visitPointNodeTest() 
	{
		PointNode _testNode1 = new PointNode("Node1", 1 ,1);
		PointNode _testNode2 = new PointNode("Node2" ,2 ,2);
		PointNode _testNode3 = new PointNode("Node3" ,3 ,3);
		PointNode _testNode4 = new PointNode("Node4" ,4 ,4);
		
		ToJSONvisitor testVisitor = new ToJSONvisitor();
		JSONObject jsonPN1 = (JSONObject) testVisitor.visitPointNode(_testNode1, null);
		JSONObject jsonPN2 = (JSONObject) testVisitor.visitPointNode(_testNode2, null);
		JSONObject jsonPN3 = (JSONObject) testVisitor.visitPointNode(_testNode3, null);
		JSONObject jsonPN4 = (JSONObject) testVisitor.visitPointNode(_testNode4, null);
		
//		System.out.println(testVisitor.toString(0, jsonPN1));
//		System.out.println(testVisitor.toString(0, jsonPN2));
//		System.out.println(testVisitor.toString(0, jsonPN3));
//		System.out.println(testVisitor.toString(0, jsonPN4));
		
		assertTrue(jsonPN1 instanceof JSONObject);
		assertTrue(jsonPN2 instanceof JSONObject);
		assertTrue(jsonPN3 instanceof JSONObject);
		assertTrue(jsonPN4 instanceof JSONObject);
	}
	
	
}
