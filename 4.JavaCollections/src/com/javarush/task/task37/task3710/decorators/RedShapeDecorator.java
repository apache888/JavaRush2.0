package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    private void setBorderColor(ShapeDecorator shapeDecorator) {
        System.out.println("Setting border color for " +  shapeDecorator.decoratedShape.getClass().getSimpleName() + " to red.");
    }

    @Override
    public void draw() {
        setBorderColor(this);
        super.draw();
    }
}
