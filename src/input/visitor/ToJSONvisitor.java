package input.visitor;

import java.util.AbstractMap;

import org.json.JSONObject;

import input.components.FigureNode;

public class ToJSONvisitor 
{
	JSONObject _JsonObject;
	
	public ToJSONvisitor(FigureNode node){
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		System.out.println(unparser.visitFigureNode((FigureNode)node,
				 new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
		_JsonObject = new JSONObject(unparser.visitFigureNode((FigureNode)node,
		 new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0)).toString());
	}
	
	public JSONObject toJsonObject(FigureNode node) 
	{
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		return (JSONObject) unparser.visitFigureNode((FigureNode)node,
		 new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));		
	}
	
	public String toString(int i) 
	{
		return _JsonObject.toString(i);
	}

}
