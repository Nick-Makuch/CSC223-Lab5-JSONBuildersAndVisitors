package input.visitor;

import java.util.AbstractMap;

import org.json.JSONObject;

import input.components.FigureNode;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;

public class ToJSONvisitor implements ComponentNodeVisitor
{
//	JSONObject _JsonObject;
//	
//	public ToJSONvisitor(FigureNode node){
//		StringBuilder sb = new StringBuilder();
//		UnparseVisitor unparser = new UnparseVisitor();
	
		//dont call unparser here
	
//		System.out.println(unparser.visitFigureNode((FigureNode)node,
//				 new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
//		_JsonObject = new JSONObject(unparser.visitFigureNode((FigureNode)node,
//		 new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
//	}
//	
//	public JSONObject toJsonObject(FigureNode node) 
//	{
//		StringBuilder sb = new StringBuilder();
//		UnparseVisitor unparser = new UnparseVisitor();
//		return (JSONObject) unparser.visitFigureNode((FigureNode)node,
//		 new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));		
//	}
//	
//	public String toString(int i) 
//	{
//		return _JsonObject.toString(i);
//	}

	@Override
	public Object visitFigureNode(FigureNode node, Object o) 
	{
		//JSONObject jSONfigureNode = new JSONObject();
		
		StringBuilder sb = new StringBuilder();
		return new JSONObject(visitFigureNode((FigureNode)node,
				 new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
		
		//return null;
	}

	@Override
	public Object visitSegmentDatabaseNode(SegmentNodeDatabase node, Object o) 
	{
		//JSONObject jSONsegNodeDatabase = new JSONObject();
		
		
		return null;
	}

	/**
	 * Method is unused
	 * */
	@Override
	public Object visitSegmentNode(SegmentNode node, Object o) {
		return null;
	}

	@Override
	public Object visitPointNode(PointNode node, Object o) 
	{
		//JSONObject jSONpointNode = new JSONObject();
		
		
		return null;
	}

	@Override
	public Object visitPointNodeDatabase(PointNodeDatabase node, Object o) 
	{
		//JSONObject jSONpointNodeDatabase = new JSONObject();
		
		
		return null;
	}
	
	public String toString(int i, JSONObject jObject) 
	{
		return jObject.toString(i);
	}

}
