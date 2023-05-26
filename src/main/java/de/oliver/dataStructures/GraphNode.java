package de.oliver.dataStructures;

public class GraphNode<T> {

    private T value;
    private HashMap<GraphNode<T>, Float> edges; // node, weight

    public GraphNode(HashMap<GraphNode<T>, Float> edges) {
        this.edges = edges;
    }

    public GraphNode(T value) {
        this.value = value;
        this.edges = new HashMap<>();
    }

    public GraphNode withEdge(GraphNode<T> node, Float weight){
        edges.put(node, weight);
        return this;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public HashMap<GraphNode<T>, Float> getEdges() {
        return edges;
    }

    public void setEdges(HashMap<GraphNode<T>, Float> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        String str = "Value: " + value + "\nEdges:\n";

        for (int i = 0; i < edges.getKeys().getSize(); i++) {
            GraphNode<T> key = edges.getKeys().get(i);
            float value = edges.get(key);

            str += " - " + key.getValue() + " (" + value + ")\n";
        }

        str = str.substring(0, str.length() - 1);

        return str;
    }

}
