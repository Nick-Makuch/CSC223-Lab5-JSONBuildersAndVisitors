package input.components;

import java.util.Set;

import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNodeDatabase;
import input.visitor.ComponentNodeVisitor;


/**
 * 
 * A basic figure consists of points, segments, and an optional description
 * 
 * Each figure has distinct points and segments (thus unique database objects). 
 * 
 * @author Nick, James, Sally
 * @Date 10-5-22
 */


public class FigureNode implements ComponentNode
{
	protected String              _description;
	protected PointNodeDatabase   _points;
	protected SegmentNodeDatabase _segments;

	public String              getDescription()    { return _description; }
	public PointNodeDatabase   getPointsDatabase() { return _points; }
	public SegmentNodeDatabase getSegments()       { return _segments; }
	
	public FigureNode(String description, PointNodeDatabase points, SegmentNodeDatabase segments)
	{
		_description = description;
		_points = points;
		_segments = segments;
	}

	

	/*
	 * 
	 * Method that will unparsed a json file. Adds the description, points, and 
	 * segments to a string builder
	 */
	
	
	
	@Override
	public void unparse(StringBuilder sb, int level)
	{
		
		//get the description
		sb.append("Description: " + _description + "\n");
		
		//Unparsed the points calling the method from point node database
		_points.unparse(sb, level);
		
		
		//Unparsed segments by calling the method from segment node database
		_segments.unparse(sb, level);
		

    }
	
	@Override
	 public Object accept(ComponentNodeVisitor visitor, Object o)
	 {
		return visitor.visitFigureNode(this, o);
	 }
	

	
	
}