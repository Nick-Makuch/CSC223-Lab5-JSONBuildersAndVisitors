package input.visitor;

import java.util.AbstractMap;

import org.json.JSONObject;
import org.json.JSONTokener;

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

//	@Override
//	public Object visitFigureNode(FigureNode node, Object o) 
//	{		
//		// Unpack the input object containing a Stringbuilder and an indentation level
//		@SuppressWarnings("unchecked")
//		AbstractMap.SimpleEntry<StringBuilder, Integer> pair = (AbstractMap.SimpleEntry<StringBuilder, Integer>)(o);
//		StringBuilder sb = pair.getKey();
//		int level = pair.getValue();
//		//UnparseVisitor unparser = new UnparseVisitor();
//			
//		sb.append(StringUtilities.indent(level) + "{" + "\n");
//		pair.setValue(pair.getValue() + 2);
//				
//		sb.append(StringUtilities.indent(level+1) + "Figure:\n");
//		sb.append(StringUtilities.indent(level+1) +"{" + "\n");
//		sb.append(StringUtilities.indent(level+2)+ "Description: " + node.getDescription() + ",\n");
//		        
////		node.getPointsDatabase().accept(unparser, o);
////		node.getSegments().accept(unparser, o);
////		sb.append(unparser.visitPointNodeDatabase(node.getPointsDatabase(), o));
//		        
//		sb.append(StringUtilities.indent(level+1) + "}\n");
//		sb.append(StringUtilities.indent(level) + "}\n");
//		
//		return new JSONObject(sb.toString());
//		//return new JSONObject(new JSONTokener(sb.toString()));
//		
////		return new JSONObject(node.toString());
//		
//		//return null;
//	}
	
	/**
	 * Converts provided FigureNode into a JSONobject
	 * @return object (JSONobject)
	 * */
	@Override
	public Object visitFigureNode(FigureNode node, Object o) 
	{
		
		
		return null;
	}

	/**
	 * Converts provided SegNodeDatabase into a JSONobject
	 * @return object (JSONobject)
	 * */
	@Override
	public Object visitSegmentDatabaseNode(SegmentNodeDatabase node, Object o) 
	{
		// Unpack the input object containing a Stringbuilder and an indentation level
//		@SuppressWarnings("unchecked")
//		AbstractMap.SimpleEntry<StringBuilder, Integer> pair = (AbstractMap.SimpleEntry<StringBuilder, Integer>)(o);
//		StringBuilder sb = pair.getKey();
//		int level = pair.getValue();
//		        
//		node.unparse(sb, level);
//		
//		return new JSONObject(sb.toString());
		
		JSONObject jsonSegNodeDatabase = new JSONObject();
		StringBuilder sb = new StringBuilder();
		int level = 0;
		
		sb.append(StringUtilities.indent(level) + "{" + "\n");
		
		for (PointNode key : node.get_adjLists().keySet()) 
		{
			sb.append(StringUtilities.indent(level+1) + key.getName() + " : ");
			
			for(PointNode value : node.get_adjLists().get(key)) 
				sb.append(value.getName() + " ");
			
			sb.append("\n");
		}
		
		sb.append(StringUtilities.indent(level) + "}" + "\n");
		
		return jsonSegNodeDatabase.put("Segments", sb.toString());
	}

	/**
	 * Method is unused
	 * */
	@Override
	public Object visitSegmentNode(SegmentNode node, Object o) {
		return null;
	}

	/**
	 * Converts provided PointNode into a JSONobject
	 * @return object (JSONobject)
	 * */
	@Override
	public Object visitPointNode(PointNode node, Object o) 
	{	
		JSONObject jsonPoint = new JSONObject();
		return jsonPoint.put("Point", node.toString());
	}

	/**
	 * Converts provided PointNodeDatabase into a JSONobject
	 * @return object (JSONobject)
	 * */
	@Override
	public Object visitPointNodeDatabase(PointNodeDatabase node, Object o) 
	{
		JSONObject jsonPointNodeDatabase = new JSONObject();
		StringBuilder sb = new StringBuilder();
		int level = 0;
		//node.unparse(sb, 0);
		sb.append(StringUtilities.indent(level) + "\n" + "{" + "\n");
		//add this to the string builder
		for(PointNode point : node.get_points())		
			sb.append(StringUtilities.indent(level+1) + "Point"+ point.toString() + "\n");
		return jsonPointNodeDatabase.put("Points ", sb.toString());

	}
	
	/**
	 * Converts given JSONobject into "pretty-printed" String
	 * @return String
	 * */
	public String toString(int i, JSONObject jObject) 
	{
		return jObject.toString(i);
	}

}
