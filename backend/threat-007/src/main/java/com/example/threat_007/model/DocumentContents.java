package com.example.threat_007.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class DocumentContents {
    private String id;
    private String title;
    private String product;
    private List<Page> pages;
    private Data data;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // Nested class representing a page
    public static class Page {
        private String id;
        private String title;
        private int index;
        private Items items;
        private List<CustomData> customData;
        private List<LinkedData> linkedData;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Items getItems() {
            return items;
        }

        public void setItems(Items items) {
            this.items = items;
        }

        public List<CustomData> getCustomData() {
            return customData;
        }

        public void setCustomData(List<CustomData> customData) {
            this.customData = customData;
        }

        public List<LinkedData> getLinkedData() {
            return linkedData;
        }

        public void setLinkedData(List<LinkedData> linkedData) {
            this.linkedData = linkedData;
        }
    }

    // Nested class representing items
    public static class Items {
        private List<Shape> shapes;
        private List<Line> lines;
        private List<Group> groups;
        private List<Layer> layers;

        // Getters and Setters
        public List<Shape> getShapes() {
            return shapes;
        }

        public void setShapes(List<Shape> shapes) {
            this.shapes = shapes;
        }

        public List<Line> getLines() {
            return lines;
        }

        public void setLines(List<Line> lines) {
            this.lines = lines;
        }

        public List<Group> getGroups() {
            return groups;
        }

        public void setGroups(List<Group> groups) {
            this.groups = groups;
        }

        public List<Layer> getLayers() {
            return layers;
        }

        public void setLayers(List<Layer> layers) {
            this.layers = layers;
        }
    }

    // Nested class representing a shape
    public static class Shape {
        private String id;

        @JsonProperty("class")
        private String shapeClass;

        private List<TextArea> textAreas;
        private List<CustomData> customData;
        private List<LinkedData> linkedData;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getShapeClass() {
            return shapeClass;
        }

        public void setShapeClass(String shapeClass) {
            this.shapeClass = shapeClass;
        }

        public List<TextArea> getTextAreas() {
            return textAreas;
        }

        public void setTextAreas(List<TextArea> textAreas) {
            this.textAreas = textAreas;
        }

        public List<CustomData> getCustomData() {
            return customData;
        }

        public void setCustomData(List<CustomData> customData) {
            this.customData = customData;
        }

        public List<LinkedData> getLinkedData() {
            return linkedData;
        }

        public void setLinkedData(List<LinkedData> linkedData) {
            this.linkedData = linkedData;
        }
    }

    // Nested class representing a TextArea
    public static class TextArea {
        private String label;
        private String text;

        // Getters and Setters
        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    // Nested class representing a Line
    public static class Line {
        private String id;
        private Endpoint endpoint1;
        private Endpoint endpoint2;
        private List<TextArea> textAreas;
        private List<CustomData> customData;
        private List<LinkedData> linkedData;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Endpoint getEndpoint1() {
            return endpoint1;
        }

        public void setEndpoint1(Endpoint endpoint1) {
            this.endpoint1 = endpoint1;
        }

        public Endpoint getEndpoint2() {
            return endpoint2;
        }

        public void setEndpoint2(Endpoint endpoint2) {
            this.endpoint2 = endpoint2;
        }

        public List<TextArea> getTextAreas() {
            return textAreas;
        }

        public void setTextAreas(List<TextArea> textAreas) {
            this.textAreas = textAreas;
        }

        public List<CustomData> getCustomData() {
            return customData;
        }

        public void setCustomData(List<CustomData> customData) {
            this.customData = customData;
        }

        public List<LinkedData> getLinkedData() {
            return linkedData;
        }

        public void setLinkedData(List<LinkedData> linkedData) {
            this.linkedData = linkedData;
        }
    }

    // Nested class representing an Endpoint
    public static class Endpoint {
        private String style;
        private String connectedTo;

        // Getters and Setters
        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getConnectedTo() {
            return connectedTo;
        }

        public void setConnectedTo(String connectedTo) {
            this.connectedTo = connectedTo;
        }
    }

    // Nested class representing a Group
    public static class Group {
        private String id;
        private List<String> members;
        private List<CustomData> customData;
        private List<LinkedData> linkedData;

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getMembers() {
            return members;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }

        public List<CustomData> getCustomData() {
            return customData;
        }

        public void setCustomData(List<CustomData> customData) {
            this.customData = customData;
        }

        public List<LinkedData> getLinkedData() {
            return linkedData;
        }

        public void setLinkedData(List<LinkedData> linkedData) {
            this.linkedData = linkedData;
        }
    }


    // Placeholder for Layer class
    public static class Layer {
        // Define properties as needed
    }

    // Placeholder for CustomData class
    public static class CustomData {
        // Define properties as needed
    }

    // Placeholder for LinkedData class
    public static class LinkedData {
        // Define properties as needed
    }

    // Class representing the Data field
    public static class Data {
        private List<Collection> collections;

        // Getters and Setters
        public List<Collection> getCollections() {
            return collections;
        }

        public void setCollections(List<Collection> collections) {
            this.collections = collections;
        }
    }

    // Placeholder for Collection class
    public static class Collection {
        // Define properties as needed
    }
}
