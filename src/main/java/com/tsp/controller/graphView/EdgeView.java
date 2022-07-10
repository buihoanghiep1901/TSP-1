package com.tsp.controller.graphView;

import com.tsp.graph.Edge;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class EdgeView extends Line {
    private VertexView from, to;
    private int weight;

    private Edge edge;

    private Label label = new Label("");


    public Label getLabel() {
        return label;
    }

    public EdgeView(VertexView vertexView1, VertexView vertexView2) {

        setFrom(vertexView1);
        setTo(vertexView2);

        weight = (int) Math.sqrt(
                Math.pow(getStartX() - getEndX(), 2) + Math.pow(getStartY() - getEndY(), 2));

        this.edge=new Edge(vertexView1.getV(),vertexView2.getV(), weight);

        label.setText("  " + weight + "  ");
        label.setLayoutX((getStartX() + getEndX()) / 2 - 20);
        label.setLayoutY((getStartY() + getEndY()) / 2 - 20);
        label.setViewOrder(98);
        label.setVisible(true);

        setFill(Color.BLUEVIOLET);
        setViewOrder(99);

        label.setStyle("-fx-background-radius: 20px; -fx-background-color: #ff99cc;" +
                "-fx-pref-height: 40px;-fx-pref-width: 40px;-fx-alignment: center");
    }

    public VertexView getFrom() {
        return from;
    }

    public void setFrom(VertexView from) {
        this.from = from;
        this.setStartX(this.from.getLayoutX() + 22);
        this.setStartY(this.from.getLayoutY() + 22);
    }

    public VertexView getTo() {
        return to;
    }

    public void setTo(VertexView to) {
        this.to = to;
        this.setEndY(this.to.getLayoutY() + 22);
        this.setEndX(this.to.getLayoutX() + 22);
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}