import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractMap;

import org.junit.jupiter.api.Test;

import input.components.FigureNode;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;
import input.visitor.UnparseVisitor;
import utilities.io.StringUtilities;

public class UnparseVisitorTest
{
	UnparseVisitor visitor = new UnparseVisitor();
	PointNode _testNode1 = new PointNode("Node1", 1 ,1);
	PointNode _testNode2 = new PointNode("Node2" ,2 ,2);
	PointNode _testNode3 = new PointNode("Node3" ,3 ,3);
	PointNode _testNode4 = new PointNode("Node4" ,4 ,4);
	SegmentNode _testSegment1 = new SegmentNode(_testNode1 , _testNode2);
	String _description = "description";
	
	@Test
	void visitFigureNodeTest() 
	{
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
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		assertEquals("\n{\n"
				+ StringUtilities.indent(1) + "Figure:\n"
				+ StringUtilities.indent(1) + "{\n"
				+ StringUtilities.indent(2) + "Description: description,\n"
				+ StringUtilities.indent(2) + "Points:\n"
				+ StringUtilities.indent(2) + "{\n"
				+ StringUtilities.indent(3) + "Point(Node1)(1.0, 1.0)\n"
				+ StringUtilities.indent(3) + "Point(Node2)(2.0, 2.0)\n"
				+ StringUtilities.indent(3) + "Point(Node3)(3.0, 3.0)\n"
				+ StringUtilities.indent(3) + "Point(Node4)(4.0, 4.0)\n"
				+ StringUtilities.indent(2) + "}\n"
				+ StringUtilities.indent(2) + "Segments:\n"
				+ StringUtilities.indent(2) + "{\n"
				+ StringUtilities.indent(3) + "Node2 : Node1 Node3 \n"
				+ StringUtilities.indent(3) + "Node1 : Node2 Node4 \n"
				+ StringUtilities.indent(3) + "Node3 : Node2 Node4 \n"
				+ StringUtilities.indent(3) + "Node4 : Node3 Node1 \n"
				+ StringUtilities.indent(2) + "}\n"
				+ StringUtilities.indent(1) + "}\n"
				+ "}\n" , ("\n" + unparser.visitFigureNode(testFigureNode,
		new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString()));
		
//		System.out.println(unparser.visitFigureNode(testFigureNode,
//		new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)));
//		
//		Description: description
//		Points:
//		{
//		    Point(Node1)(1.0, 1.0)
//		    Point(Node2)(2.0, 2.0)
//		    Point(Node3)(3.0, 3.0)
//		    Point(Node4)(4.0, 4.0)
//		}
//		Segments:
//		{
//		    Node2 : Node1 Node3 
//		    Node1 : Node2 Node4 
//		    Node3 : Node2 Node4 
//		    Node4 : Node3 Node1 
//		}
	}
	
	@Test
	void visitSegmentNodeDatabaseTest() 
	{
		SegmentNodeDatabase testSegmentNodeDatabase = new SegmentNodeDatabase();
		testSegmentNodeDatabase.addUndirectedEdge(_testNode2, _testNode1);
		testSegmentNodeDatabase.addUndirectedEdge(_testNode3, _testNode2);
		testSegmentNodeDatabase.addUndirectedEdge(_testNode4, _testNode3);
		testSegmentNodeDatabase.addUndirectedEdge(_testNode4, _testNode1);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		assertEquals("Segments:\n"
				+ "{\n"
				+ StringUtilities.indent(1) + "Node2 : Node1 Node3 \n"
				+ StringUtilities.indent(1) + "Node1 : Node2 Node4 \n"
				+ StringUtilities.indent(1) + "Node3 : Node2 Node4 \n"
				+ StringUtilities.indent(1) + "Node4 : Node3 Node1 \n"
				+ "}\n"
				, unparser.visitSegmentDatabaseNode(testSegmentNodeDatabase,
						new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
		
//		System.out.println(unparser.visitSegmentDatabaseNode(testSegmentNodeDatabase,
//				new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)));
//		
//		Segments:
//		{
//		    Node2 : Node1 Node3 
//		    Node1 : Node2 Node4 
//		    Node3 : Node2 Node4 
//		    Node4 : Node3 Node1 
//		}

	}
	
	@Test
	void visitPointNodeDatabaseTest() 
	{
		PointNodeDatabase _testPointNodeDatabase = new PointNodeDatabase();
		_testPointNodeDatabase.put(_testNode1);
		_testPointNodeDatabase.put(_testNode2);
		_testPointNodeDatabase.put(_testNode3);
		_testPointNodeDatabase.put(_testNode4);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		assertEquals("Points:\n"
				+ "{\n"
				+ StringUtilities.indent(1) + "Point(Node1)(1.0, 1.0)\n"
				+ StringUtilities.indent(1) + "Point(Node2)(2.0, 2.0)\n"
				+ StringUtilities.indent(1) + "Point(Node3)(3.0, 3.0)\n"
				+ StringUtilities.indent(1) + "Point(Node4)(4.0, 4.0)\n"
				+ "}\n", unparser.visitPointNodeDatabase(_testPointNodeDatabase,
						new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
		
//		System.out.println(unparser.visitPointNodeDatabase(_testPointNodeDatabase,
//				new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)));
		
//		Points:
//		{
//		    Point(Node1)(1.0, 1.0)
//		    Point(Node2)(2.0, 2.0)
//		    Point(Node3)(3.0, 3.0)
//		    Point(Node4)(4.0, 4.0)
//		}
	}
	
	@Test
	void visitPointNodeTest() 
	{
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		assertEquals("(Node1)(1.0, 1.0)",
				unparser.visitPointNode(_testNode1, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
		
		sb.delete(0, sb.length());
		
		assertEquals("(Node2)(2.0, 2.0)",
				unparser.visitPointNode(_testNode2, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
		
		sb.delete(0, sb.length());
		
		assertEquals("(Node3)(3.0, 3.0)",
				unparser.visitPointNode(_testNode3, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
		
		sb.delete(0, sb.length());
		
		assertEquals("(Node4)(4.0, 4.0)",
				unparser.visitPointNode(_testNode4, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
		
	}
	
}
