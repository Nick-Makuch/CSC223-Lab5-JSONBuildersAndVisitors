package input.visitor;

import java.util.AbstractMap;

import org.json.JSONObject;

import input.components.FigureNode;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNode;
import input.components.segment.SegmentNodeDatabase;
import utilities.io.StringUtilities;

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
		// Unpack the input object containing a Stringbuilder and an indentation level
		@SuppressWarnings("unchecked")
		AbstractMap.SimpleEntry<StringBuilder, Integer> pair = (AbstractMap.SimpleEntry<StringBuilder, Integer>)(o);
		StringBuilder sb = pair.getKey();
		int level = pair.getValue();
			
		sb.append(StringUtilities.indent(level) + "{" + "\n");
		pair.setValue(pair.getValue() + 2);
				
		sb.append(StringUtilities.indent(level+1) + "Figure:\n");
		sb.append(StringUtilities.indent(level+1) +"{" + "\n");
		sb.append(StringUtilities.indent(level+2)+ "Description: " + node.getDescription() + ",\n");
		        
		node.getPointsDatabase().accept(this, o);
		node.getSegments().accept(this, o);
		        
		sb.append(StringUtilities.indent(level+1) + "}\n");
		sb.append(StringUtilities.indent(level) + "}\n");
		
		return new JSONObject(sb.toString());
		
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
