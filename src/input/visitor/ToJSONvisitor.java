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
		_JsonObject = (JSONObject) unparser.visitFigureNode((FigureNode)node,
		 new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
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
