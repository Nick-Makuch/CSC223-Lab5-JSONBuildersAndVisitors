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
	void toJSONvisitorTest() 
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
		
		ToJSONvisitor testVisitor = new ToJSONvisitor(testFigureNode);
		testVisitor.toJsonObject(testFigureNode);
		
		System.out.println(testVisitor.toString());
	}
}
