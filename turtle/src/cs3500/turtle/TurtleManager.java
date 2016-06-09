package cs3500.turtle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class manages a 2D turtle and implements all
 * its associated operations
 */
public final class TurtleManager implements TurtleOperations {
    //the position of the turtle
    private Position2D position;
    //the heading of the turtle in degrees
    private double heading;
    //stacks to save and retrieve turtle states
    Stack<Position2D> stackPositions;
    Stack<Double> stackHeadings;
    //list of lines traced since this object was created
    List<Position2D> lines;

    /**
     * Resets the turtle to the default state.
     * Default state = position (0,0) and heading (0) meaning
     * looking in the +X direction.
     */
    public TurtleManager() {
        position = new Position2D(0, 0);
        heading = 0;
        stackPositions = new Stack<Position2D>();
        stackHeadings = new Stack<Double>();
        lines = new ArrayList<Position2D>();
    }

    @Override
    public void move(double distance) {
        //trigonometry to move by distance along angle
        double x = distance * Math.cos(Math.toRadians(heading));
        double y = distance * Math.sin(Math.toRadians(heading));

        position.setX(position.getX() + x);
        position.setY(position.getY() + y);
    }

    @Override
    public void trace(double distance) {
        //trigonometry to move by distance along heading
        double x = distance * Math.cos(Math.toRadians(heading));
        double y = distance * Math.sin(Math.toRadians(heading));

        lines.add(new Position2D(position));

        position.setX(position.getX() + x);
        position.setY(position.getY() + y);

        lines.add(new Position2D(position));

    }

    @Override
    public void turn(double angleDegrees) {
        heading += angleDegrees;
    }

    @Override
    public void save() {
        stackPositions.push(position);
        stackHeadings.push(heading);
    }

    @Override
    public void retrieve() {
        if ((stackPositions.isEmpty()) || (stackHeadings.isEmpty())) {
            throw new IllegalArgumentException("no state to retrieve");
        }
        position = stackPositions.peek();
        stackPositions.pop();
        heading = stackHeadings.peek();
        stackHeadings.pop();
    }

    @Override
    public Position2D getPosition() {
        return new Position2D(position);
    }

    @Override
    public List<Position2D> getLines() {
        return new ArrayList<Position2D>(lines);
    }
}
